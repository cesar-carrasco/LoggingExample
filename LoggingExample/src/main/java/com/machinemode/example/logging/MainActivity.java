package com.machinemode.example.logging;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.google.analytics.tracking.android.EasyTracker;
import com.google.analytics.tracking.android.MapBuilder;

import java.util.Map;


public class MainActivity extends Activity {

    private EasyTracker easyTracker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        easyTracker = EasyTracker.getInstance(this);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onStart() {
        super.onStart();
        easyTracker.activityStart(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        easyTracker.activityStop(this);
    }

    public void logClick(View view) {
        Map event = MapBuilder.createEvent("ui_action", "button_press", (String)view.getTag(), null).build();
        easyTracker.send(event);
    }
}
