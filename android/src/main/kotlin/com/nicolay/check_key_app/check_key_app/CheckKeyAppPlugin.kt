package com.nicolay.check_key_app.check_key_app

import android.content.Context
import android.util.Log
import androidx.annotation.NonNull
import io.flutter.embedding.engine.plugins.FlutterPlugin
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.MethodChannel.MethodCallHandler
import io.flutter.plugin.common.MethodChannel.Result


/** CheckKeyAppPlugin */
class CheckKeyAppPlugin : FlutterPlugin, MethodCallHandler {
    private lateinit var channel: MethodChannel
    private lateinit var context: Context

    override fun onAttachedToEngine(@NonNull flutterPluginBinding: FlutterPlugin.FlutterPluginBinding) {
        channel = MethodChannel(flutterPluginBinding.binaryMessenger, "check_key_app")
        context = flutterPluginBinding.applicationContext
        channel.setMethodCallHandler(this)
    }

    override fun onMethodCall(@NonNull call: MethodCall, @NonNull result: Result) {
        Log.i("onMethodCall", call.method)
        if (call.method == "isAppInstalled") {
            try {
                context.getPackageManager().getApplicationInfo("com.example.app_key", 0);
                Log.i("onMethodCall", "success")
                return
            } catch (e: Exception) {
                result.success("app is not install")
                Log.i("onMethodCall", e.localizedMessage)
                return;
            }
        } else if (call.method == "getPlatformVersion") {
            result.success("Android ${android.os.Build.VERSION.RELEASE}")
        } else {
            Log.i("onMethodCall", "no result")
//            result.notImplemented()
        }
    }

    override fun onDetachedFromEngine(@NonNull binding: FlutterPlugin.FlutterPluginBinding) {
        channel.setMethodCallHandler(null)
    }
}
