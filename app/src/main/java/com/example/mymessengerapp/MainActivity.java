package com.example.mymessengerapp;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private  static  final String CHANNEL_ID = "Message Channel";
    private static final int NOTIFICATION_ID = 1000;
    private static final int REQ_CODE = 100;
    TabLayout tab;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main);

         tab= findViewById(R.id.tab);
         viewPager = findViewById(R.id.viewPager);

         ViewPagerMessengerAdapter adapter = new ViewPagerMessengerAdapter(getSupportFragmentManager());
         viewPager.setAdapter(adapter);

         tab.setupWithViewPager(viewPager);

         // for Notification

      Drawable drawable = ResourcesCompat.getDrawable(getResources(),R.drawable.a, null);
      BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
      Bitmap largeIcon = bitmapDrawable.getBitmap();

      NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
      Notification notification;

     // Intent iNotify = new Intent(getApplicationContext(), ChatActivity.class);
      //   iNotify.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

     //   PendingIntent pi = PendingIntent.getActivity(this,REQ_CODE,iNotify,PendingIntent.FLAG_UPDATE_CURRENT);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
          notification = new Notification.Builder(this)
                    .setLargeIcon(largeIcon)
                    .setSmallIcon(R.drawable.m)
                    .setContentText("New Message")
                    .setSubText("New Message from A")
      //           .setContentIntent(pi)
                    .setChannelId(CHANNEL_ID)
                    .build();
          nm.createNotificationChannel(new NotificationChannel(CHANNEL_ID,"New Channel",NotificationManager.IMPORTANCE_HIGH));
        }else{
            notification = new Notification.Builder(this)
                    .setLargeIcon(largeIcon)
                    .setSmallIcon(R.drawable.a)
                    .setContentText("New Message")
                    .setSubText("New Message from A")
      //              .setContentIntent(pi)
                    .build();

        }
        nm.notify(NOTIFICATION_ID, notification);

    }
}