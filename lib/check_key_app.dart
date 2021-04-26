
import 'dart:async';

import 'package:flutter/services.dart';

class CheckKeyApp {
  static const MethodChannel _channel =
      const MethodChannel('check_key_app');

  static Future<String> get platformVersion async {
    final String version = await _channel.invokeMethod('getPlatformVersion');
    return version;
  }

  static Future<bool> get isAppInstalled async {
    final String version = await _channel.invokeMethod('isAppInstalled');
    return version == 'success';
  }
}
