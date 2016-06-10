package fc.fcstudio;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.app.WallpaperManager;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import org.apache.cordova.PluginResult;
import java.io.IOException;
import java.io.InputStream;

/**
 * This class called from JavaScript.
 */
public class wallpaper extends CordovaPlugin {

	public Context context = null;
	private static final boolean IS_AT_LEAST_LOLLIPOP = Build.VERSION.SDK_INT >= 21;
	
    @Override
    public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
		
		context = IS_AT_LEAST_LOLLIPOP ? cordova.getActivity().getWindow().getContext() : cordova.getActivity().getApplicationContext();
		String imgSrc = "";
		
        if (action.equals("start")) {
			for (int i = 0; i < args.length(); i++) {
				JSONObject jsonobject = args.getJSONObject(i);
				imgSrc = jsonobject.getString("image");
			}
            this.echo(imgSrc, context);
			PluginResult pr = new PluginResult(PluginResult.Status.OK);
          	pr.setKeepCallback(true);
          	callbackContext.sendPluginResult(pr);
           	return true;
        }
		
		callbackContext.error("Set wallpaper is not a supported.");
        return false;
    }

    public void echo(String image, Context context) {
		try {
			AssetManager assetManager = context.getAssets();
			InputStream instr = assetManager.open("www/" + image);
			Bitmap bitmap = BitmapFactory.decodeStream(instr);
			WallpaperManager myWallpaperManager	= WallpaperManager.getInstance(context);
			myWallpaperManager.setBitmap(bitmap);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}