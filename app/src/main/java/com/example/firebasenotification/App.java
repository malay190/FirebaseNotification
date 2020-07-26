package com.example.firebasenotification;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

public class App extends Application {
    public static final String CHANNEL_1_ID = "channel1";
    public static final String CHANNEL_2_ID = "channel2";

    public static final String CHANNEL_3_ID = "channel3";
    public static final String CHANNEL_4_ID = "channel4";
    public static final String CHANNEL_5_ID = "channel5";

    @Override
    public void onCreate() {
        super.onCreate();
        createNotificationChannel();
    }

    private void createNotificationChannel(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel1 = new NotificationChannel(
                    CHANNEL_1_ID,
                    "channel 1",
                    NotificationManager.IMPORTANCE_HIGH
            );
             channel1.setDescription("This is channel");

            NotificationChannel channel2 = new NotificationChannel(
                    CHANNEL_2_ID,
                    "channel 2",
                    NotificationManager.IMPORTANCE_HIGH
            );
            channel2.setDescription("This is channe2");

            NotificationChannel channel3 = new NotificationChannel(
                    CHANNEL_3_ID,
                    "channel 3",
                    NotificationManager.IMPORTANCE_HIGH
            );
            channel3.setDescription("This is channe3");

            NotificationChannel channel4 = new NotificationChannel(
                    CHANNEL_4_ID,
                    "channel 4",
                    NotificationManager.IMPORTANCE_HIGH
            );
            channel4.setDescription("This is channe4");

            NotificationChannel channel5 = new NotificationChannel(
                    CHANNEL_5_ID,
                    "channel 5",
                    NotificationManager.IMPORTANCE_HIGH
            );
            channel5.setDescription("This is channe5");

            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel1);
            manager.createNotificationChannel(channel2);
            manager.createNotificationChannel(channel3);
            manager.createNotificationChannel(channel4);
            manager.createNotificationChannel(channel5);


        }
    }
}
