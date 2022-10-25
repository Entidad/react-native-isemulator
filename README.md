# React Native IsEmulator
Tests if an iOS or Android application is running under emulation or on a real device

## Installation

```
npm install git+http://github.com/entidad/react-native-isemulator.git
```

## iOS Configuration
```
pod install
```

## Android Configuration
Usual configuration

## Using in Mendix
Create a javascript action returning a `boolean` as follows:

```
import { Big } from "big.js";
import {NativeModules} from 'react-native';
// BEGIN EXTRA CODE
// END EXTRA CODE
/**
 * @returns {Promise.<boolean>}
 */
export async function jsa_entidad_isemulator() {
	// BEGIN USER CODE
	return new Promise((resolve,reject)=>{
		try{
			NativeModules.Entidad.isEmulator((err,emu)=>{
				if(err==null)
					resolve(emu);
				else
					reject(err);
			})
		}catch(e){
			reject(e.toString());
		}
	});
	// END USER CODE
}
```

## References
Todo...
