package fc.fcstudio;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.json.JSONArray;
import org.json.JSONException;
import android.app.WallpaperManager;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import org.apache.cordova.PluginResult;
import java.io.IOException;
import java.io.InputStream;

public class wallpaper extends CordovaPlugin
{
	public Context context = null;
	private static final boolean IS_AT_LEAST_LOLLIPOP = Build.VERSION.SDK_INT >= 21;
	
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
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
