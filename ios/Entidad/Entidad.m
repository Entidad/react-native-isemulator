#import"Entidad.h"
#import<UIKit/UIKit.h>
@implementation Entidad
RCT_EXPORT_MODULE();
RCT_EXPORT_METHOD(isEmulator:(RCTResponseSenderBlock)callback){
	@try{
#if TARGET_IPHONE_SIMULATOR
		callback(@[[NSNull null],@true]);
#else
		callback(@[[NSNull null],@false]);
#endif
	}
	@catch(NSException *exception){
		callback(@[exception.reason,[NSNull null]]);
	}
}
@end
