package com.example.mobileprogramming;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mobileprogramming.databinding.LoginActivityBinding;
import com.example.mobileprogramming.databinding.SensorActivityBinding;

import java.util.ArrayList;

public class SensorActivity extends AppCompatActivity implements SensorEventListener {

    SensorActivityBinding binding;
    View view;

    private SensorManager sensorManager;
    private Sensor acceleroMeter;

    private long lastTime = 0;
    private ArrayList<Long> beatTime = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Initialize
        binding = SensorActivityBinding.inflate(getLayoutInflater());
        view = binding.getRoot();
        setContentView(binding.getRoot());

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        if(sensorManager != null){
            acceleroMeter = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (acceleroMeter != null){
            sensorManager.registerListener(this,acceleroMeter,SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        float x = sensorEvent.values[0];
        float y = sensorEvent.values[1];

        float z = sensorEvent.values[2];

        double magnitude = Math.sqrt(x * x + y * y + z * z);

        if (magnitude < 15){
            long now = System.currentTimeMillis();
            if (now - lastTime > 300){
                beatTime.add(now);
                lastTime = now;
            }

            if (beatTime.size() > 10 ) beatTime.remove(0);

            calculateBPM();
        }
    }

    private void calculateBPM() {
        if (beatTime.size()< 2)return;

        long totalInterval = 0;

        for (int i = 1; i < beatTime.size(); i++){
            totalInterval += (beatTime.get(i) - beatTime.get(i -1));
        }

        long avgInterval = totalInterval / (beatTime.size() - 1);
        long bpm = 60000 / avgInterval;

        binding.tvBpm.setText("BPM (simulasi) : " + bpm);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
