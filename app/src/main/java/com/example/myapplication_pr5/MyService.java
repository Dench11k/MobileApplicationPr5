package com.example.myapplication_pr5;

import android.app.Service;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.net.Uri;
import android.os.Build;
import android.os.IBinder;
import android.provider.Settings;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;

public class MyService extends Service {
    private WindowManager windman;
    private View viewban;

    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
    @Override
    public void onCreate() {
        super.onCreate();
    }
    public int onStartCommand(Intent intent, int flags, int startId) {
        // Объект WindowManager для отображения баннера с информацией
        windman = (WindowManager) getSystemService(WINDOW_SERVICE);
        //Создание макета баннера с информацией
        viewban = LayoutInflater.from(this).inflate(R.layout.service_banner, null);
        //Настройка параметров для баннера
        final WindowManager.LayoutParams params = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                PixelFormat.TRANSLUCENT);
        params.gravity = Gravity.TOP | Gravity.CENTER_HORIZONTAL;
        params.y = 0;
        params.x = 0;
        //проверка прав на аппаратное наложение
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && !Settings.canDrawOverlays(this)) {
            Intent intent1 = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
                    Uri.parse("package:" + getPackageName()));
            intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent1);
        }
        else{windman.addView(viewban, params);}
        //привязывание к баннеру перехода обратно в приложение
        viewban.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.example.myapplication");
                if (launchIntent != null) {
                    startActivity(launchIntent);
                    onDestroy();
                }
            }
        });
        return START_STICKY;
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        //Удаление баннера после перехода обратно в приложение
        if (viewban != null) {
            windman.removeView(viewban);
        }
    }
}