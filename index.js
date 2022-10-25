import {NativeModules} from 'react-native';
export async function isEmulator(){
	return new Promise((resolve,reject)=>{
		try{
			NativeModules.MyModuleName.foo((err,val)=>{
				if(err==null)
					resolve(val);
				else
					reject(err);
			})
		}catch(e){
			reject(e.toString());
		}
	});
}
