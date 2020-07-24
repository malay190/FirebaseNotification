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
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.media.session.MediaSessionCompat;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.MediaController;

import static com.example.firebasenotification.App.CHANNEL_1_ID;
import static com.example.firebasenotification.App.CHANNEL_2_ID;

public class MainActivity extends AppCompatActivity {
    EditText edit_title;
    EditText edit_message;
    private NotificationManagerCompat notificationManager;
    private MediaSessionCompat mediaSessionCompat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notificationManager = NotificationManagerCompat.from(this);

        edit_title = (EditText) findViewById(R.id.edit_text_title);
        edit_title.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS);
        edit_message = (EditText) findViewById(R.id.edit_text_message);
        edit_message.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS);
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

        Notification notification = new NotificationCompat.Builder(this, CHANNEL_2_ID)
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

        notificationManager.notify(2, notification);
    }

}
