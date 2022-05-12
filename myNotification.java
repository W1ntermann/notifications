package com.example.mynotification;

import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
   Button b1;
   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);

      b1 = (Button)findViewById(R.id.button);
      b1.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            addNotification();
         }
      });
   }

   private void addNotification() {
      NotificationCompat.Builder builder =
         new NotificationCompat.Builder(this)
         .setSmallIcon(R.drawable.abc)
         .setContentTitle("Notifications Example")
         .setContentText("This is a test notification");

      Intent notificationIntent = new Intent(this, MainActivity.class);
      PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent,
         PendingIntent.FLAG_UPDATE_CURRENT);
      builder.setContentIntent(contentIntent);

      
      NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
      manager.notify(0, builder.build());
   }
}


<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
   android:orientation="vertical"
   android:layout_width="fill_parent"
   android:layout_height="fill_parent" >
   
   <TextView
      android:layout_width="fill_parent"
      android:layout_height="400dp"
      android:text="Hi, Your Detailed notification view goes here...." />
</LinearLayout>

package com.example.notificationdemo;

import android.os.Bundle;
import android.app.Activity;

public class NotificationView extends Activity{
   @Override
   public void onCreate(Bundle savedInstanceState){
      super.onCreate(savedInstanceState);
      setContentView(R.layout.notification);
   }
}


<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
   xmlns:tools="http://schemas.android.com/tools"
   android:layout_width="match_parent"
   android:layout_height="match_parent"
   android:paddingBottom="@dimen/activity_vertical_margin"
   android:paddingLeft="@dimen/activity_horizontal_margin"
   android:paddingRight="@dimen/activity_horizontal_margin"
   android:paddingTop="@dimen/activity_vertical_margin"
   tools:context="MainActivity">
   
   <TextView
      android:id="@+id/textView1"
      android:layout_width="wrap_content"
      android:layout_height="wrap_content"
      android:text="Notification Example"
      android:layout_alignParentTop="true"
      android:layout_centerHorizontal="true"
      android:textSize="30dp" />
      
   <TextView
      android:id="@+id/textView2"
      android:layout_width="wrap_content"
      android:layout_height="wrap_content"
      android:text="Tutorials point "
      android:textColor="#ff87ff09"
      android:textSize="30dp"
      android:layout_below="@+id/textView1"
      android:layout_centerHorizontal="true"
      android:layout_marginTop="48dp" />
      
   <ImageButton
      android:layout_width="wrap_content"
      android:layout_height="wrap_content"
      android:id="@+id/imageButton"
      android:src="@drawable/abc"
      android:layout_below="@+id/textView2"
      android:layout_centerHorizontal="true"
      android:layout_marginTop="42dp" />
      
   <Button
      android:layout_width="wrap_content"
      android:layout_height="wrap_content"
      android:text="Notification"
      android:id="@+id/button"
      android:layout_marginTop="62dp"
      android:layout_below="@+id/imageButton"
      android:layout_centerHorizontal="true" />
      
</RelativeLayout>

<?xml version="1.0" encoding="utf-8"?>
<resources>
   <string name="action_settings">Settings</string>
   <string name="app_name">tutorialspoint </string>  
</resources>


<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
   package="com.example.mynotification" >
   
   <application
      android:allowBackup="true"
      android:icon="@drawable/ic_launcher"
      android:label="@string/app_name"
      android:theme="@style/AppTheme" >
      
      <activity
         android:name="com.example.mynotification.MainActivity"
         android:label="@string/app_name" >
         
         <intent-filter>
            <action android:name="android.intent.action.MAIN" />
            <category android:name="android.intent.category.LAUNCHER" />
         </intent-filter>
            
      </activity>
      
      <activity android:name=".NotificationView"
         android:label="Details of notification"
         android:parentActivityName=".MainActivity">
         <meta-data
         android:name="android.support.PARENT_ACTIVITY"
         android:value=".MainActivity"/>
      </activity>
      
   </application>
</manifest>
