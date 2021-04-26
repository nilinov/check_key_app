import 'package:flutter/services.dart';
import 'package:flutter_test/flutter_test.dart';
import 'package:check_key_app/check_key_app.dart';

void main() {
  const MethodChannel channel = MethodChannel('check_key_app');

  TestWidgetsFlutterBinding.ensureInitialized();

  setUp(() {
    channel.setMockMethodCallHandler((MethodCall methodCall) async {
      return '42';
    });
  });

  tearDown(() {
    channel.setMockMethodCallHandler(null);
  });

  test('getPlatformVersion', () async {
    expect(await CheckKeyApp.platformVersion, '42');
  });
}
