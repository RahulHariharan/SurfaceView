package com.pearson.android.test.surfaceview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by 539117 on 8/3/2016.
 */
public class TestSurfaceView extends SurfaceView implements SurfaceHolder.Callback {

    final int STROKE_WIDTH = 10;
    SurfaceHolder mHolder;
    Timer mTimer;
    Random mRandom;
    int Y_COORDINATE = 0;
    int VERTICAL_MOTION_CONSTANT = 100;
    int X_COORDINATE = 0;
    int HORIZONTAL_MOTION_CONSTANT = 50;

    public TestSurfaceView(Context context) {
        super(context);
        getHolder().addCallback(this);
        initData();

    }

    public TestSurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        getHolder().addCallback(this);
        initData();
    }

    public TestSurfaceView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        getHolder().addCallback(this);
        initData();
    }

    private void initData(){

        mTimer = new Timer();
        mRandom = new Random();
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        moveCircle(holder);
        //testDraw(holder);
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }

    private void moveCircle(final SurfaceHolder holder){

        mTimer.scheduleAtFixedRate(new TimerTask(){

            @Override
            public void run() {

                Canvas canvas = holder.lockCanvas();
                drawOnCanvas4(canvas);
                holder.unlockCanvasAndPost(canvas);
            }
        },0,1000);
    }

    private void testDraw(SurfaceHolder holder){

        Canvas canvas = holder.lockCanvas();
        drawOnCanvas(canvas);
        holder.unlockCanvasAndPost(canvas);
    }

    /*
    draws a circle at a random position in the canvas
     */
    private void drawOnCanvas(Canvas canvas){

        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setColor(Color.BLACK);
        RectF rectF = new RectF(0,0,canvas.getWidth(),canvas.getHeight());
        canvas.drawRect(rectF,paint);

        paint = new Paint();
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setColor(Color.WHITE);
        paint.setStrokeWidth(STROKE_WIDTH);
        int x_coord = mRandom.nextInt(canvas.getWidth());
        int y_coord = mRandom.nextInt(canvas.getHeight());
        canvas.drawCircle(x_coord,y_coord,100,paint);
    }

    /*
    draws a circle with a fixed x coordinate at the halfway point of the page
     */
    private void drawOnCanvas2(Canvas canvas){

        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setColor(Color.BLACK);
        RectF rectF = new RectF(0,0,canvas.getWidth(),canvas.getHeight());
        canvas.drawRect(rectF,paint);

        paint = new Paint();
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(STROKE_WIDTH);
        int y_coord = mRandom.nextInt(canvas.getHeight());
        canvas.drawCircle(canvas.getWidth()/2,y_coord,100,paint);
    }

    /*
    draws a circle with a fixed x coordinate at the halfway point of the page and increases the y coordinate gradually
     */
    private void drawOnCanvas3(Canvas canvas){

        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setColor(Color.BLACK);
        RectF rectF = new RectF(0,0,canvas.getWidth(),canvas.getHeight());
        canvas.drawRect(rectF,paint);

        paint = new Paint();
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(STROKE_WIDTH);
        if(Y_COORDINATE + VERTICAL_MOTION_CONSTANT <= canvas.getHeight())
            Y_COORDINATE += VERTICAL_MOTION_CONSTANT;
        else
            Y_COORDINATE = 0;

        canvas.drawCircle(canvas.getWidth()/2, Y_COORDINATE, 100, paint);
    }


    /*
    draws two circles, one moving horizontally, one moving vertically
     */
    private void drawOnCanvas4(Canvas canvas){

        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setColor(Color.BLACK);
        RectF rectF = new RectF(0,0,canvas.getWidth(),canvas.getHeight());
        canvas.drawRect(rectF,paint);

        paint = new Paint();
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(STROKE_WIDTH);
        if(Y_COORDINATE + VERTICAL_MOTION_CONSTANT <= canvas.getHeight())
            Y_COORDINATE += VERTICAL_MOTION_CONSTANT;
        else
            Y_COORDINATE = 0;
        canvas.drawCircle(canvas.getWidth()/2, Y_COORDINATE, 100, paint);

        paint = new Paint();
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setColor(Color.GREEN);
        paint.setStrokeWidth(STROKE_WIDTH);
        if(X_COORDINATE + HORIZONTAL_MOTION_CONSTANT <= canvas.getWidth())
            X_COORDINATE += HORIZONTAL_MOTION_CONSTANT;
        else
            X_COORDINATE = 0;

        canvas.drawCircle(X_COORDINATE, canvas.getHeight()/2, 100, paint);
    }




}
