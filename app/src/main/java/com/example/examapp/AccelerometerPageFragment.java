package com.example.examapp;

import static android.content.Context.SENSOR_SERVICE;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.examapp.databinding.FragmentAccelerometerPageBinding;

public class AccelerometerPageFragment extends Fragment implements SensorEventListener {
    private FragmentAccelerometerPageBinding binding;
    private SensorManager sensorManager;
    private Sensor sensor;
    
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentAccelerometerPageBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        binding.helpPageButton.setOnClickListener(view1 -> {
            NavHostFragment.findNavController(AccelerometerPageFragment.this)
                    .navigate(R.id.action_accelerometerPageFragment_to_HelpPageFragment);
        });

        sensorManager = (SensorManager) getActivity().getSystemService(SENSOR_SERVICE);

        if (sensorManager == null)
            return;

        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        if (sensor == null)
            return;

        sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() != Sensor.TYPE_ACCELEROMETER) {
            return;
        }

        final double x = event.values[0];
        final double y = event.values[1];
        final double z = event.values[2];

        final String value = "X: " + x + ", Y: " + y + ", Z: " + z;

        binding.textView3.setText(value);

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        
        binding = null;
        sensorManager = null;
        sensor = null;
    }
}