package com.wt.anfs2;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/*
 *@Description: 自定义SurfaceView
 *@Author: hl
 *@Time: 2018/12/4 9:45
 */
public class CustomSurfaceView extends SurfaceView implements SurfaceHolder.Callback, Runnable {
    private static final String TAG = CustomSurfaceView.class.getName();

    private SurfaceHolder surfaceHolder;
    private boolean bDrawing = false;
    private Paint mPaint;
    private String[] colors = new String[]{"#ff4ab1", "#e84626", "#3e18e8"};

    public CustomSurfaceView(Context context) {
        super(context);
    }

    public CustomSurfaceView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomSurfaceView(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public CustomSurfaceView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.surfaceHolder = getHolder();
        this.surfaceHolder.addCallback(this);
        ///< 画布透明处理
        this.setZOrderOnTop(true);
        this.surfaceHolder.setFormat(PixelFormat.TRANSLUCENT);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.e(TAG, "onDraw");
    }

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        Log.e(TAG, "surfaceCreated");

        ///< 初始化画笔
        mPaint = new Paint();
        mPaint.setColor(Color.parseColor(colors[0]));
        mPaint.setStrokeWidth(10f);

        ///< 开启绘制
        bDrawing = true;
        new Thread(this).start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {
        Log.e(TAG, "surfaceChanged");
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        Log.e(TAG, "surfaceDestroyed");
        ///< 停止绘制
        bDrawing = false;
    }

    @Override
    public void run() {
        ///< 不停的绘制
        while (bDrawing) {
            ///< 绘制刷新处理
            drawingSomething();
            try {
                ///< 控制刷新频率
                Thread.sleep(200);
            } catch (InterruptedException e) {
            }
        }
    }

    /**
     * 绘制点东东
     */
    private void drawingSomething() {
        Canvas canvas = null;
        try {
            canvas = surfaceHolder.lockCanvas();
            if (null != canvas) {
                synchronized (surfaceHolder) {
                    ///< 清空画布-透明处理
                    canvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);

                    mPaint.setColor(Color.parseColor(colors[(int) (Math.random() * 3 + 0)]));
                    ///< 绘制点东东
                    canvas.drawRect(new Rect(0,  0, 100, 100), mPaint);
                }
            }
        } finally {
            if (null != surfaceHolder && null != canvas) {
                surfaceHolder.unlockCanvasAndPost(canvas);
            }
        }
    }
}
