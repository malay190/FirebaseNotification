package com.example.firebasenotification;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import android.os.Build;

public class App extends Application {

    public static final String GROUP_1_ID = "group1";
    public static final String GROUP_2_ID = "group2";
    public static final String CHANNEL_1_ID = "channel1";
    public static final String CHANNEL_2_ID = "channel2";

    public static final String CHANNEL_3_ID = "channel3";
    public static final String CHANNEL_4_ID = "channel4";
    public static final String CHANNEL_5_ID = "channel5";
    public static final String CHANNEL_6_ID = "channel5";

    @Override
    public void onCreate() {
        super.onCreate();
        createNotificationChannel();
    }

    private void createNotificationChannel(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){

            NotificationChannelGroup group1 = new NotificationChannelGroup(
                    GROUP_1_ID,
                    "group 1"
            );

            NotificationChannelGroup group2 = new NotificationChannelGroup(
                    GROUP_2_ID,
                    "group 2"
            );


            NotificationChannel channel1 = new NotificationChannel(
                    CHANNEL_1_ID,
                    "channel 1",
                    NotificationManager.IMPORTANCE_HIGH
            );
             channel1.setDescription("This is channel");
             channel1.setGroup(GROUP_1_ID);

            NotificationChannel channel2 = new NotificationChannel(
                    CHANNEL_2_ID,
                    "channel 2",
                    NotificationManager.IMPORTANCE_HIGH
            );
            channel2.setDescription("This is channe2");
            channel2.setGroup(GROUP_1_ID);

            NotificationChannel channel3 = new NotificationChannel(
                    CHANNEL_3_ID,
                    "channel 3",
                    NotificationManager.IMPORTANCE_HIGH
            );
            channel3.setDescription("This is channe3");
            channel3.setGroup(GROUP_2_ID);

            NotificationChannel channel4 = new NotificationChannel(
                    CHANNEL_4_ID,
                    "channel 4",
                    NotificationManager.IMPORTANCE_HIGH
            );
            channel4.setDescription("This is channe4");
            channel4.setGroup(GROUP_2_ID);

            NotificationChannel channel5 = new NotificationChannel(
                    CHANNEL_5_ID,
                    "channel 5",
                    NotificationManager.IMPORTANCE_HIGH
            );
            channel5.setDescription("This is channe5");

            NotificationChannel channel6 = new NotificationChannel(
                    CHANNEL_6_ID,
                    "channel 6",
                    NotificationManager.IMPORTANCE_HIGH
            );
            channel5.setDescription("This is channe6");

            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannelGroup(group1);
            manager.createNotificationChannelGroup(group2);
            manager.createNotificationChannel(channel1);
            manager.createNotificationChannel(channel2);
            manager.createNotificationChannel(channel3);
            manager.createNotificationChannel(channel4);
            manager.createNotificationChannel(channel5);


        }
    }
}
