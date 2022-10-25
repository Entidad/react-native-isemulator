package io.entidad;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import android.os.Build;
public class EntidadModule extends ReactContextBaseJavaModule{
	public EntidadModule(ReactApplicationContext reactContext){
		super(reactContext);
	}
	@Override
	public String getName(){
		return"Entidad";
	}
	@ReactMethod
	public void isEmulator(Callback cb){
		try{
			boolean isEmulator=(Build.MANUFACTURER.contains("Genymotion") 
				||Build.MODEL.contains("google_sdk")
				||Build.MODEL.toLowerCase().contains("droid4x")
				||Build.MODEL.contains("Emulator")
				||Build.MODEL.contains("Android SDK built for x86")
				||Build.HARDWARE=="goldfish"
				||Build.HARDWARE=="vbox86"
				||Build.HARDWARE.toLowerCase().contains("nox")
				||Build.FINGERPRINT.startsWith("generic")
				||Build.PRODUCT=="sdk"
				||Build.PRODUCT=="google_sdk"
				||Build.PRODUCT=="sdk_x86"
				||Build.PRODUCT=="vbox86p"
				||Build.PRODUCT.toLowerCase().contains("nox")
				||Build.BOARD.toLowerCase().contains("nox")
				||(Build.BRAND.startsWith("generic")&&Build.DEVICE.startsWith("generic"))
			);
			isEmulator=isEmulator||this.isBlueStacks();
			cb.invoke(null,isEmulator);
		}catch(Exception e){
			cb.invoke(e.toString(),null);
		}
	}

   boolean checkFilesExist(java.util.ArrayList<String>files){
	for(int i=0;i<files.size();i++){
            java.io.File file=new java.io.File(files.get(i));
            if(file.exists()){
                return true;
            }
	}
        return false;
    }
    
    boolean isBlueStacks(){
        java.util.ArrayList<String>BLUE_STACKS_FILES =new java.util.ArrayList<String>();
	BLUE_STACKS_FILES.add(
            "/mnt/windows/BstSharedFolder"
        );
        return this.checkFilesExist(BLUE_STACKS_FILES);
    }
}




