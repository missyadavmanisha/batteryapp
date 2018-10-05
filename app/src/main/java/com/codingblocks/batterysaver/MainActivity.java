package com.codingblocks.batterysaver;

        import android.content.BroadcastReceiver;
        import android.content.Context;
        import android.content.Intent;
        import android.content.IntentFilter;
        import android.os.BatteryManager;
        import android.provider.Settings;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.ImageView;
        import android.widget.ProgressBar;
        import android.widget.TextView;
        import android.widget.Toast;

        import org.w3c.dom.Text;

        import static android.content.Intent.ACTION_BATTERY_CHANGED;

public class MainActivity extends AppCompatActivity {


 BroadcastReceiver  myBroadcastReceiver=new BroadcastReceiver() {
     @Override
     public void onReceive(Context context, Intent intent) {

         switch (intent.getAction()) {

             case Intent.ACTION_POWER_CONNECTED:
                 Toast.makeText(context, "Power Connected", Toast.LENGTH_SHORT).show();

                 Intent i=new Intent(context,powerconnected.class);
                  context.startActivity(i);
                  break;
             case Intent.ACTION_POWER_DISCONNECTED:
                 Toast.makeText(context, "Power Disconnected", Toast.LENGTH_SHORT).show();
                 Intent k=new Intent(context,powerdisconnected.class);
                 context.startActivity(k);
                 break;
             case Intent.ACTION_BATTERY_LOW:
                 Intent j=new Intent(Settings.ACTION_BATTERY_SAVER_SETTINGS);
                 context.startActivity(j);
                 break;
         }

//        context.startActivity(new Intent(context,MainActivity.class));
     }


 };



        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            IntentFilter inf=new IntentFilter();
            inf.addAction(Intent.ACTION_POWER_CONNECTED);
            inf.addAction(Intent.ACTION_POWER_DISCONNECTED);
            inf.addAction(Intent.ACTION_BATTERY_CHANGED);
            inf.addAction(Intent.ACTION_BATTERY_LOW);
            registerReceiver(myBroadcastReceiver,inf);

        }


    }
