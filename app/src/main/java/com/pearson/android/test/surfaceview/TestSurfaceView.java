package com.pearson.android.test.surfaceview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by 539117 on 8/3/2016.
 */
public class TestSurfaceView extends SurfaceView implements SurfaceHolder.Callback {

    final int STROKE_WIDTH = 10;
    SurfaceHolder mHolder;

    public TestSurfaceView(Context context) {
        super(context);
        getHolder().addCallback(this);

    }

    public TestSurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        getHolder().addCallback(this);
    }

    public TestSurfaceView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        getHolder().addCallback(this);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        Canvas canvas = holder.lockCanvas();
        draw(canvas);
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setColor(Color.WHITE);
        paint.setStrokeWidth(STROKE_WIDTH);
        canvas.drawLine(canvas.getWidth(),canvas.getHeight(),0,0,paint);
        RectF rectF = new RectF(0,0,canvas.getWidth(),canvas.getHeight());
        canvas.drawLine(0,canvas.getHeight(),canvas.getWidth(),0,paint);
        canvas.drawArc(rectF,0,360,true,paint);
        getHolder().unlockCanvasAndPost(canvas);
    }
}
