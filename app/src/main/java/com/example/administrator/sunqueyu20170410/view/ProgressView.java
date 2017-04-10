package com.example.administrator.sunqueyu20170410.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * 类的用途：自定义进度条
 * Created by ${孙鹊禹}
 * on 2017/4/10 9:05
 */

public class ProgressView extends View {
    int progress = 0;
    private String text = "0%";
    private int max = 100;

    public ProgressView(Context context) {
        super(context);
    }

    public ProgressView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ProgressView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        // 设置抗锯齿
        paint.setAntiAlias(true);
        // 三种样式--Stroke 只要描边 Fill 填充  FILL_AND_STROKE和既有描边又有填充
        paint.setStyle(Paint.Style.STROKE);
        //设置描边宽度
        paint.setStrokeWidth(30);
        //定义外圈员的颜色
        paint.setColor(Color.GRAY);
        //绘制圆形进度条--获取当前控件多大，正好让进度条在这个控件区间内
        canvas.drawCircle(getMeasuredWidth() / 2, getMeasuredWidth() / 2, getMeasuredWidth() / 2, paint);
        //重新设置描边宽度，这个宽度最好能完全盖过圆形
        paint.setStrokeWidth(30);
        //定义限制圆弧的矩形，当前这样定义正好让圆弧和圆重合
        RectF oval = new RectF(0, 0, getMeasuredWidth(), getMeasuredWidth());
        //设置进度条（圆弧的颜色）
        paint.setColor(Color.BLACK);
        //绘制，设置进度条的度数从0开始，结束值是个变量，可以自己自由设置，来设置进度
        //true和false 代表是否使用中心点，如果true，代表连接中心点，会出现扇形的效果
        canvas.drawArc(oval, 0, 360 * progress / max, true, paint);
        //文字的绘制
        paint.setTextSize(40);
        //设置文字宽度
        paint.setStrokeWidth(1.0f);
        //测量文字大小-提前准备个矩形
        Rect bounds = new Rect();
        //测量文字的宽和高，测量的值可以根据矩形获取
        paint.getTextBounds(text, 0, text.length(), bounds);
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        //绘制文字，计算文字的宽高进行设置
        canvas.drawText(text, getMeasuredWidth() / 2 - bounds.width() / 2,
                getMeasuredWidth() / 2 + bounds.height() / 2, paint);
    }

    public void setMax(int max) {
        this.max = max;
    }

    public void setProgressAndText(int progress, String text) {
        this.progress = progress;
        this.text = text;
        //重新绘制
        postInvalidate();
    }
}

