/**
@author Adrian Muth
*/

package com.example.cs3;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public static class Face {
        int skinColor;
        int eyeColor;
        int hairColor;
        int hairStyle;

        Face(int skinColor, int eyeColor, int hairColor, int hairStyle) {
            this.skinColor = skinColor;
            this.eyeColor = eyeColor;
            this.hairColor = hairColor;
            this.hairStyle = hairStyle;
            Face.randomize(skinColor, eyeColor, hairColor, hairStyle);
        }
        /*
External Citation
Date:  7 September 2020
Problem:   Unsure how to generate random numbers within a range.
Resource:  https://stackoverflow.com/questions/363681/how-do-i-generate-random-integers-within-a-specific-range-in-java
Solution: I used the example code as a reference.
        */
        public static void randomize(int skinColor, int eyeColor, int hairColor, int hairStyle) {
            Random rand = new Random();
            skinColor = rand.nextInt(256);
            eyeColor = rand.nextInt(256);
            hairColor = rand.nextInt(256);
            hairStyle = rand.nextInt(256);
        }
    }
}