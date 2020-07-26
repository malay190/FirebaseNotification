package com.example.firebasenotification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.media.session.MediaSessionCompat;
import android.view.View;
import android.widget.EditText;


import static com.example.firebasenotification.App.CHANNEL_1_ID;
import static com.example.firebasenotification.App.CHANNEL_2_ID;
import static com.example.firebasenotification.App.CHANNEL_3_ID;
import static com.example.firebasenotification.App.CHANNEL_4_ID;
import static com.example.firebasenotification.App.CHANNEL_5_ID;

public class MainActivity extends AppCompatActivity {
    EditText edit_title;
    EditText edit_message;

    // Compatibility library for NotificationManager with fallbacks for older platforms.
    private NotificationManagerCompat notificationManager;
    private MediaSessionCompat mediaSessionCompat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notificationManager = NotificationManagerCompat.from(this);//Get a NotificationManagerCompat instance for a provided context.

        edit_title = (EditText) findViewById(R.id.edit_text_title);
        edit_message = (EditText) findViewById(R.id.edit_text_message);


        //Allows interaction with media controllers, volume keys, media buttons, and transport controls.
        //A MediaSession should be created when an app wants to publish media playback information or handle media keys.
        // In general an app only needs one session for all playback, though multiple sessions can be created to provide
        // finer grain controls of media.
        mediaSessionCompat = new MediaSessionCompat(this, "tag");
    }

    //Big Picture Style
    public void sendOnChannel1(View V) {
        String title = edit_title.getText().toString();
        String message = edit_message.getText().toString();

        Intent activityIntent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, activityIntent, 0);

        Intent broadcastIntent = new Intent(this, NotificationReceiver.class);
        broadcastIntent.putExtra("toastMessage", "fuck you");
        PendingIntent actonIntent = PendingIntent.getBroadcast(this, 0, broadcastIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        Bitmap largeIcon = BitmapFactory.decodeResource(getResources(), R.drawable.apple);

        // NotificationompatHelper: for accessing features in Notification.
        Notification notification = new NotificationCompat.Builder(this, CHANNEL_1_ID)
                .setSmallIcon(R.drawable.ic_call)
                .setContentTitle(title)
                .setLargeIcon(largeIcon)
                .setContentText(message)
                .setStyle(new NotificationCompat.BigPictureStyle()
                        .bigPicture(largeIcon)
                        .bigLargeIcon(null)
                        .setSummaryText("apple"))
                .setColor(Color.RED)
                .setAutoCancel(true)
                .setOnlyAlertOnce(true)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .setContentIntent(pendingIntent)
                .addAction(R.drawable.ic_cloud, "Toast", actonIntent)
                .build();

        notificationManager.notify(1, notification);
    }

    //BigText Style
    public void sendOnChannel2(View v) {
        String title = edit_title.getText().toString();
        String message = edit_message.getText().toString();

        Intent activityIntent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, activityIntent, 0);

        Intent broadcastIntent = new Intent(this, NotificationReceiver.class);
        broadcastIntent.putExtra("toastMessage", "fuck you");
        PendingIntent actonIntent = PendingIntent.getBroadcast(this, 0, broadcastIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        Bitmap largeIcon = BitmapFactory.decodeResource(getResources(), R.drawable.apple);

        Notification notification = new NotificationCompat.Builder(this, CHANNEL_2_ID)
                .setSmallIcon(R.drawable.ic_casino)
                .setLargeIcon(largeIcon)
                .setContentTitle(title)
                .setContentText(message)
                .setColor(Color.GREEN)
                .setStyle(new NotificationCompat.BigTextStyle()
                        .bigText(getString(R.string.description))
                        .setBigContentTitle("Big Content Title")
                        .setSummaryText("Summary Text"))
                .setAutoCancel(true)
                .setOnlyAlertOnce(true)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .setContentIntent(pendingIntent)
                .addAction(R.drawable.ic_cloud_off, "Toast", actonIntent)
                .addAction(R.drawable.ic_cloud_off, "Reply", actonIntent)
                .build();

        notificationManager.notify(2, notification);
    }

    //Media player notification
    public void sendOnChannel3(View v) {
        String title = edit_title.getText().toString();
        String message = edit_message.getText().toString();

        Intent activityIntent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, activityIntent, 0);

        Intent broadcastIntent = new Intent(this, NotificationReceiver.class);
        broadcastIntent.putExtra("toastMessage", "fuck you");
        PendingIntent actonIntent = PendingIntent.getBroadcast(this, 0, broadcastIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        Bitmap largeIcon = BitmapFactory.decodeResource(getResources(), R.drawable.apple);

        //Builder class for NotificationCompat objects.
        //Allows easier control over all the flags, as well as help constructing the typical notification layouts.
        Notification notification = new NotificationCompat.Builder(this, CHANNEL_3_ID)
                .setSmallIcon(R.drawable.ic_music_note_black_24dp)
                .setLargeIcon(largeIcon)
                .setContentTitle(title)
                .setContentText(message)
                .setColor(Color.GREEN)
                .addAction(R.drawable.ic_skip_previous_black_24dp, "Previous", null)
                .addAction(R.drawable.ic_pause_circle_outline_black_24dp, "pause", null)
                .addAction(R.drawable.ic_skip_next_black_24dp, "Next", null)
                .setStyle(new androidx.media.app.NotificationCompat.MediaStyle()
                        .setShowActionsInCompactView(0, 1, 2)
                        .setMediaSession(mediaSessionCompat.getSessionToken()))
                .setSubText("Hello")
                .setAutoCancel(true)
                .setOnlyAlertOnce(true)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .setContentIntent(pendingIntent)
                .build();

        notificationManager.notify(3, notification);
    }


    //RemoteInput.Builder is used to create the instance of the class RemoteInout

    //ProgressBar
    public void sendOnChannel4(View v) {

        final int progressMax = 100;
        //Builder class for NotificationCompat objects.
        //Allows easier control over all the flags, as well as help constructing the typical notification layouts.
        final NotificationCompat.Builder notification = new NotificationCompat.Builder(this, CHANNEL_4_ID)
                .setSmallIcon(R.drawable.ic_file_download)
                .setContentTitle("Download")
                .setContentText("download in progress")
                .setOngoing(true)
                .setOnlyAlertOnce(true)
                .setColor(Color.RED)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setProgress(progressMax, 0, false);

        notificationManager.notify(4, notification.build());

        new Thread(new Runnable() {
            @Override
            public void run() {
                SystemClock.sleep(1000);
                for (int progress = 0; progress < 100; progress += 10) {
                    notification.setProgress(progressMax, progress, false);
                    notificationManager.notify(4, notification.build());
                    SystemClock.sleep(200);
                }
                SystemClock.sleep(1000);
                notification.setContentText("download finished.")
                        .setProgress(0, 0, false)
                        .setOngoing(false);
                notificationManager.notify(4, notification.build());
            }
        }).start();
    }

    //Grouping of messages

    //Starting in Android 7.0 (API level 24), you can display related notifications in a group automatically
    // (previously called "bundled" notifications).
    //But
    //Group notification can also be applied to lower api level than 24
    public void sendOnChannel5(View V) {

        String title1 = "title1";
        String title2 = "title2";
        String message1 = "message1";
        String message2 = "message2";
        // NotificationompatHelper: for accessing features in Notification.
        Notification notification = new NotificationCompat.Builder(this, CHANNEL_5_ID)
                .setSmallIcon(R.drawable.ic_call)
                .setContentTitle(title1)
                .setContentText(message1)
                .setColor(Color.RED)
                .setAutoCancel(true)
                .setGroup("example_group")
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .build();

        Notification notification1 = new NotificationCompat.Builder(this, CHANNEL_5_ID)
                .setSmallIcon(R.drawable.ic_call)
                .setContentTitle(title2)
                .setContentText(message2)
                .setColor(Color.RED)
                .setAutoCancel(true)
                .setGroup("example_group")
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .build();

        Notification summaryNotification = new NotificationCompat.Builder(this, CHANNEL_5_ID)
                .setSmallIcon(R.drawable.ic_call)
                .setContentTitle(title1)
                .setContentText(message1)
                .setColor(Color.RED)
                .setStyle(new NotificationCompat.InboxStyle()
                        .addLine(title2 + " " + message2)
                        .addLine(title1 + " " + message1)
                        .setBigContentTitle("2 new messages")
                        .setSummaryText("malaykumar089@gmail.com"))
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .setAutoCancel(true)
                .setGroup("example_group")
                .setGroupSummary(true)
                .setGroupAlertBehavior(NotificationCompat.GROUP_ALERT_CHILDREN)
                .build();

        SystemClock.sleep(2000);
        notificationManager.notify(5, notification);
        SystemClock.sleep(2000);
        notificationManager.notify(6, notification1);
        SystemClock.sleep(2000);
        notificationManager.notify(7, summaryNotification);


    }

}
