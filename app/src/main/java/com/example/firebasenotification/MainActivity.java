package com.example.firebasenotification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;

import static com.example.firebasenotification.App.CHANNEL_1_ID;
import static com.example.firebasenotification.App.CHANNEL_2_ID;

public class MainActivity extends AppCompatActivity {
    EditText edit_title;
    EditText edit_message;
    private NotificationManagerCompat notificationManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notificationManager = NotificationManagerCompat.from(this);

        edit_title = (EditText) findViewById(R.id.edit_text_title);
        edit_title.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS);
        edit_message = (EditText) findViewById(R.id.edit_text_message);
        edit_message.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS);
    }

    public void sendOnChannel1(View V) {
        String title = edit_title.getText().toString();
        String message = edit_message.getText().toString();

        Intent activityIntent = new Intent(this,MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,activityIntent,0);

        Intent broadcastIntent = new Intent(this,NotificationReceiver.class);
        broadcastIntent.putExtra("toastMessage","fuck you");
        PendingIntent actonIntent = PendingIntent.getBroadcast(this,0, broadcastIntent,PendingIntent.FLAG_UPDATE_CURRENT);

        Notification notification = new NotificationCompat.Builder(this, CHANNEL_1_ID)
                .setSmallIcon(R.drawable.ic_call)
                .setContentTitle(title)
                .setContentText(message)
                .setColor(Color.RED)
                .setAutoCancel(true)
                .setOnlyAlertOnce(true)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .setContentIntent(pendingIntent)
                .addAction(R.drawable.ic_cloud,"Toast",actonIntent)
                .build();

        notificationManager.notify(1, notification);
    }

    public void sendOnChannel2(View v) {
        String title = edit_title.getText().toString();
        String message = edit_message.getText().toString();

        Intent activityIntent = new Intent(this,MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,activityIntent,0);

        Intent broadcastIntent = new Intent(this,NotificationReceiver.class);
        broadcastIntent.putExtra("toastMessage","fuck you");
        PendingIntent actonIntent = PendingIntent.getBroadcast(this,0, broadcastIntent,PendingIntent.FLAG_UPDATE_CURRENT);

        Notification notification = new NotificationCompat.Builder(this, CHANNEL_2_ID)
                .setSmallIcon(R.drawable.ic_casino)
                .setContentTitle(title)
                .setContentText(message)
                .setColor(Color.GREEN)
                .setAutoCancel(true)
                .setOnlyAlertOnce(true)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .setContentIntent(pendingIntent)
                .addAction(R.drawable.ic_cloud_off,"Toast",actonIntent)
                .addAction(R.drawable.ic_cloud_off,"Reply",actonIntent)
                .build();

        notificationManager.notify(2, notification);
    }
}
