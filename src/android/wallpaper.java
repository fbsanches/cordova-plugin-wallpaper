package fc.fcstudio;

import android.app.WallpaperManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Base64;
import android.util.Log;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class wallpaper extends CordovaPlugin
{
	public Context context = null;
	private static final boolean IS_AT_LEAST_LOLLIPOP = Build.VERSION.SDK_INT >= 21;
	public static SharedPreferences saved_settings;
	
	@Override
	public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException
	{
		context = IS_AT_LEAST_LOLLIPOP ? cordova.getActivity().getWindow().getContext() : cordova.getActivity().getApplicationContext();
		String imgSrc = "";
		Boolean base64 = false;

		if (action.equals("start"))
		{
			imgSrc = args.getString(0);
			base64 = args.getBoolean(1);
			this.echo(imgSrc, base64, context);
			PluginResult pr = new PluginResult(PluginResult.Status.OK);
			pr.setKeepCallback(true);
			callbackContext.sendPluginResult(pr);
			return true;
		}
		else if (action.equals("lockscreen"))
		{
			imgSrc = args.getString(0);
			base64 = args.getBoolean(1);
			this.setlockwp(imgSrc, base64, context);
			PluginResult pr = new PluginResult(PluginResult.Status.OK);
			pr.setKeepCallback(true);
			callbackContext.sendPluginResult(pr);
			return true;
		}
		else if (action.equals("save_homescreen_wp"))
		{
			final WallpaperManager wallpaperManager = WallpaperManager.getInstance(context);
			Drawable wallpaper_profile = wallpaperManager.getDrawable();
			Bitmap bitmap_profile = ((BitmapDrawable) wallpaper_profile).getBitmap();

			ByteArrayOutputStream baos_profile = new ByteArrayOutputStream();
			bitmap_profile.compress(Bitmap.CompressFormat.JPEG, 100, baos_profile);
			final byte[][] b_profile = {baos_profile.toByteArray()};
			String encodedImage_profile = Base64.encodeToString(b_profile[0], Base64.DEFAULT);

			saved_settings = context.getSharedPreferences("WallpaperPref", Context.MODE_PRIVATE);
			SharedPreferences.Editor edit = saved_settings.edit();
			edit.putString("original_wallpaper", encodedImage_profile);
			edit.commit();
			Log.d("console", "homescreen_wallpaper saved: "+encodedImage_profile);

			PluginResult pr = new PluginResult(PluginResult.Status.OK);
			pr.setKeepCallback(true);
			callbackContext.sendPluginResult(pr);
			return true;
		}
		callbackContext.error("Set wallpaper is not a supported.");
        	return false;
	}

	public void echo(String image, Boolean base64, Context context)
	{
		try
		{
			AssetManager assetManager = context.getAssets();
			Bitmap bitmap;
			if(base64) //Base64 encoded
			{
				byte[] decoded = android.util.Base64.decode(image, android.util.Base64.DEFAULT);
				bitmap = BitmapFactory.decodeByteArray(decoded, 0, decoded.length);
			}
			else //normal path
			{
				InputStream instr = assetManager.open("www/" + image);
				bitmap = BitmapFactory.decodeStream(instr);
			}
			WallpaperManager myWallpaperManager = WallpaperManager.getInstance(context);
			myWallpaperManager.setBitmap(bitmap);
			Log.d("console", "homescreen wallpaper set");
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setlockwp(String image, Boolean base64, Context context)
	{
		try
		{
			AssetManager assetManager = context.getAssets();
			Bitmap bitmap;
			if(base64) //Base64 encoded
			{
				byte[] decoded = android.util.Base64.decode(image, android.util.Base64.DEFAULT);
				bitmap = BitmapFactory.decodeByteArray(decoded, 0, decoded.length);
			}
			else //normal path
			{
				InputStream instr = assetManager.open("www/" + image);
				bitmap = BitmapFactory.decodeStream(instr);
			}
			if (android.os.Build.VERSION.SDK_INT>=24) {
				WallpaperManager ujWallpaperManager = WallpaperManager.getInstance(context);
				ujWallpaperManager.setBitmap(bitmap, null, true, WallpaperManager.FLAG_LOCK);
				Log.d("console", "lockscreen wallpaper set");
			}
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
