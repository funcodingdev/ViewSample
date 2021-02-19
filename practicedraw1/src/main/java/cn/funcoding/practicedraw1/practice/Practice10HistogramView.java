package cn.funcoding.practicedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;

import androidx.annotation.Nullable;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class Practice10HistogramView extends View {
    private Paint mPaint = new Paint();
    private List<RectModel> rectModels = new ArrayList<>();
    private int rectWidth = 50;
    private int space = 20;

    {
        rectModels.add(new RectModel("Froyo", 1));
        rectModels.add(new RectModel("GB", 10));
        rectModels.add(new RectModel("ICS", 10));
        rectModels.add(new RectModel("JB", 100));
        rectModels.add(new RectModel("KitKat", 200));
    }

    public Practice10HistogramView(Context context) {
        super(context);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画直方图
        canvas.drawColor(Color.BLACK);

        int startX = 50;
        int startY = 100;
        int lineX = 1000;
        int lineY = 800;

        // 绘制坐标系
        mPaint.setColor(Color.WHITE);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(2);
        canvas.drawLine(startX, startY, startX, lineY + startY, mPaint);
        canvas.drawLine(startX, startY + lineY, startX + lineX, startY + lineY, mPaint);

        // 绘制柱体
        for (int i = 0; i < rectModels.size(); i++) {
            RectModel rectModel = rectModels.get(i);
            int left = startX + space * (i + 1) + i * rectWidth;
            int top = rectModel.value > lineY ? lineY : (lineY - rectModel.value + startY);
            mPaint.setColor(Color.GREEN);
            mPaint.setStyle(Paint.Style.FILL);
            canvas.drawRect(left, top, left + rectWidth, top + rectModel.value, mPaint);

            mPaint.setColor(Color.WHITE);
            mPaint.setTextSize(10);
            Rect rect = new Rect();
            mPaint.getTextBounds(rectModel.name,0, rectModel.name.length(), rect);
            canvas.drawText(rectModel.name, left + rectWidth / 2, startY + lineY - rect.top, mPaint);
        }

        // 绘制文字

    }

    private static class RectModel {
        String name;
        int value;

        public RectModel(String name, int value) {
            this.name = name;
            this.value = value;
        }
    }
}
