package com.cicinnus.doubanplus.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.cicinnus.corelib.utils.UiUtils;

/**
 * @author zhongrongguang
 *         on 2017/11/21.
 */

public class IndicatorView extends View {


    private Paint bgPaint;
    private int smallIndicatorHeight;
    private int smallIndicatorWidth;
    private Paint textPaint;
    private int viewWidth;
    private int viewHeight;

    {
        bgPaint = new Paint();
        textPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        textPaint.setColor(Color.BLACK);
        textPaint.setTextSize(36);
        textPaint.setTextAlign(Paint.Align.CENTER);
        bgPaint.setAntiAlias(true);
        bgPaint.setColor(Color.WHITE);
        smallIndicatorHeight = UiUtils.dp2px(getContext(), 10);
        smallIndicatorWidth = UiUtils.dp2px(getContext(), 10);
    }

    public IndicatorView(Context context) {
        super(context);
    }

    public IndicatorView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        if (widthMode == MeasureSpec.EXACTLY) {
            viewWidth = MeasureSpec.getSize(widthMeasureSpec);
        }
        if (heightMode == MeasureSpec.EXACTLY) {
            viewHeight = MeasureSpec.getSize(heightMeasureSpec);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //移动圆心到view的中心
        canvas.translate(viewWidth / 2, viewHeight / 2);
        //画一个白色的圆
        canvas.drawCircle(0, 0, smallIndicatorHeight, bgPaint);
        //
        canvas.drawText("1", 0, viewHeight/4, textPaint);
    }
}
