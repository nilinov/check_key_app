#import "CheckKeyAppPlugin.h"
#if __has_include(<check_key_app/check_key_app-Swift.h>)
#import <check_key_app/check_key_app-Swift.h>
#else
// Support project import fallback if the generated compatibility header
// is not copied when this plugin is created as a library.
// https://forums.swift.org/t/swift-static-libraries-dont-copy-generated-objective-c-header/19816
#import "check_key_app-Swift.h"
#endif

@implementation CheckKeyAppPlugin
+ (void)registerWithRegistrar:(NSObject<FlutterPluginRegistrar>*)registrar {
  [SwiftCheckKeyAppPlugin registerWithRegistrar:registrar];
}
@end
