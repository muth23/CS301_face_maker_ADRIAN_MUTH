package com.example.cs3;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.view.SurfaceView;

import androidx.annotation.RequiresApi;

import java.util.Random;

import static android.graphics.Color.rgb;

public class Face extends SurfaceView {
    int redValSkin;
    int greenValSkin;
    int blueValSkin;
    int redValEyes;
    int greenValEyes;
    int blueValEyes;
    int skinColor;
    int eyeColor;
    int hairColor;
    int hairStyle;
    private Paint facePaint = new Paint();
    private Paint eyePaint = new Paint();
    private Paint hairPaint = new Paint();

    // Face constructor
    Face(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.skinColor = skinColor;
        this.eyeColor = eyeColor;
        this.hairColor = hairColor;
        this.hairStyle = hairStyle;
        Face.randomize(redValSkin, greenValSkin, blueValSkin, skinColor, redValEyes, greenValEyes, blueValEyes, eyeColor, hairColor, hairStyle);
    }

    /*
External Citation
Date:  7 September 2020
Problem:   Unsure how to generate random numbers within a range.
Resource:  https://stackoverflow.com/questions/363681/how-do-i-generate-random-integers-within-a-specific-range-in-java
Solution: I used the example code as a reference.
    */
    public static void randomize(int redValSkin, int greenValSkin, int blueValSkin, int skinColor, int redValEyes, int greenValEyes, int blueValEyes, int eyeColor, int hairColor, int hairStyle) {
        Random rand = new Random();
        int maxNum = 255; // Max amount in rgb colors
        // For skin and hair, randomizes rgb values, then combines that for a final color integer
        redValSkin = rand.nextInt(maxNum + 1);
        greenValSkin = rand.nextInt(maxNum + 1);
        blueValSkin = rand.nextInt(maxNum + 1);
        skinColor = rgb(redValSkin, greenValSkin, blueValSkin);
        redValEyes = rand.nextInt(maxNum + 1);
        greenValEyes = rand.nextInt(maxNum + 1);
        blueValEyes = rand.nextInt(maxNum + 1);
        eyeColor = rgb(redValEyes, greenValEyes, blueValEyes);
        hairColor = rand.nextInt(maxNum + 1);
        hairStyle = rand.nextInt(3 + 1); // Only 3 possible hairstyles
    }

    public void drawHead(Canvas canvas, int skinColor) {
        facePaint.setColor(skinColor);
        canvas.drawCircle(100, 100, 500, facePaint);
    }

    public void drawEyes(Canvas canvas, int eyeColor) {
        eyePaint.setColor(eyeColor);
        canvas.drawCircle(150, 150, 100, eyePaint);
        canvas.drawCircle(200, 150, 100, eyePaint);
    }

    public void drawHair(Canvas canvas, int hairColor, int hairStyle) {
        hairPaint.setColor(hairColor);
        if (hairStyle == 1) {
            //Nothing happens for the bald hairstyle
        } else if (hairStyle == 2) {
            canvas.drawRect(100, 50, 600, 100, hairPaint);
        } else {
            canvas.drawRect(100, 0, 600, 100, hairPaint);
        }
    }

    public void onDraw(Canvas canvas) {
        drawHead(canvas, skinColor);
        drawEyes(canvas, eyeColor);
        drawHair(canvas, hairColor, hairStyle);
    }
}
