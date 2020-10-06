package com.example.cs3;

import android.widget.AdapterView;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.view.View;

import static android.graphics.Color.red;
import static android.graphics.Color.blue;
import static android.graphics.Color.green;
import static android.graphics.Color.rgb;

public class Listener implements SeekBar.OnSeekBarChangeListener, View.OnClickListener, AdapterView.OnItemSelectedListener {

    private Face face = null; // Instance of face
    // Booleans allow the color values to be changed accordingly
    boolean faceButtonChecked;
    boolean eyesButtonChecked;
    boolean hairButtonChecked;

    // Reports which radio buttons are checked
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.faceButton:
                faceButtonChecked = ((RadioButton) view).isChecked();
                break;
            case R.id.eyesButton:
                eyesButtonChecked = ((RadioButton) view).isChecked();
                break;
            case R.id.hairButton:
                hairButtonChecked = ((RadioButton) view).isChecked();
                break;
            default:
                break;
        }
        this.face.invalidate();
    }

    // Changed color of face, eyes, or hair depending on which radio buttons are selected and which
    // seekbar is changed
    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        if (b) { // First checks if seekbar value has changed
            switch (seekBar.getId()) { // Checks which seekbar changed
                case R.id.redBar:
                    if (faceButtonChecked) { // Checks selected radio buttons
                        face.skinColor = rgb(i, green(face.skinColor), blue(face.skinColor));
                    }
                    if (eyesButtonChecked) {
                        face.eyeColor = rgb(i, green(face.eyeColor), blue(face.eyeColor));
                    }
                    if (hairButtonChecked) {
                        face.hairColor = rgb(i, green(face.hairColor), blue(face.hairColor));
                    }
                    break;
                case R.id.greenBar:
                    if (faceButtonChecked) {
                        face.skinColor = rgb(red(face.skinColor), i, blue(face.skinColor));
                    }
                    if (eyesButtonChecked) {
                        face.eyeColor = rgb(red(face.eyeColor), i, blue(face.eyeColor));
                    }
                    if (hairButtonChecked) {
                        face.hairColor = rgb(red(face.hairColor), i, blue(face.hairColor));
                    }
                    break;
                case R.id.blueBar:
                    if (faceButtonChecked) {
                        face.skinColor = rgb(red(face.skinColor), green(face.skinColor), i);
                    }
                    if (eyesButtonChecked) {
                        face.eyeColor = rgb(red(face.eyeColor), green(face.eyeColor), i);
                    }
                    if (hairButtonChecked) {
                        face.hairColor = rgb(red(face.hairColor), green(face.hairColor), i);
                    }
                    break;
                default:
                    // Do nothing
                    break;
            }
            this.face.invalidate();
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        // Do nothing
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        // Do nothing
    }

    // Changes hairstyle based on selection in spinner menu
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        face.hairStyle = i;
        this.face.invalidate();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        // Do nothing
    }
}
