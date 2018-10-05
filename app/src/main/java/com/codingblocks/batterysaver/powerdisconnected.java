package com.codingblocks.batterysaver;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class powerdisconnected  extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discharge);
        ImageView imageView = (ImageView) findViewById(R.id.discharge);
        TextView textView = (TextView) findViewById(R.id.value1);

        textView.setText("Battery level :" + Integer.toString((int) getlevel()) + "%");

    }



    public float getlevel(){

        Intent i=registerReceiver(null,new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
        int level = i.getIntExtra(BatteryManager.EXTRA_LEVEL,0);
        int scale=i.getIntExtra(BatteryManager.EXTRA_SCALE,-1);
        float c=(float) level/(float)scale*100;
        return c;


    }


}
