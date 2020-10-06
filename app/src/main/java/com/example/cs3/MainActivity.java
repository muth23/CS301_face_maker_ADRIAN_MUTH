/**
@author Adrian Muth
 Disclaimer: The code crashes when run on an emulator.
I am aware that there's some sort of runtime choreographer error, but I decided to turn in a buggy
 program rather than an incomplete one.
*/

package com.example.cs3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // New lister class that will listen to all elements
        Listener listener = new Listener();

        // Initializing color seekbars and setting listeners.
        SeekBar redBar = findViewById(R.id.redBar);
        SeekBar greenBar = findViewById(R.id.greenBar);
        SeekBar blueBar = findViewById(R.id.blueBar);
        redBar.setOnSeekBarChangeListener(listener);
        greenBar.setOnSeekBarChangeListener(listener);
        blueBar.setOnSeekBarChangeListener(listener);

        // Initializing radio buttons and setting listeners.
        RadioButton faceButton = findViewById(R.id.faceButton);
        RadioButton eyesButton = findViewById(R.id.eyesButton);
        RadioButton hairButton = findViewById(R.id.hairButton);
        faceButton.setOnClickListener(listener);
        eyesButton.setOnClickListener(listener);
        hairButton.setOnClickListener(listener);

        // Initializing spinner and setting listener.
        Spinner hairstyleSpinner = findViewById(R.id.hairstyleSpinner);
        hairstyleSpinner.setOnItemSelectedListener(listener);
    }

}