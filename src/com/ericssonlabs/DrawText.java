package com.ericssonlabs;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Typeface;

public class DrawText {
    /*  
     * 默认采用白色字体，宋体文字加粗  
     */
    public static Bitmap getImage(int width, int height, String mString, int size) {
        return getImage(width, height, mString, size, Color.GRAY, Typeface.create("宋体", Typeface.BOLD));
    }

    public static Bitmap getImage(int width, int height, String mString, int size, int color) {
        return getImage(width, height, mString, size, color, Typeface.create("宋体", Typeface.BOLD));
    }

    public static Bitmap getImage(int width, int height, String mString, int size, int color, String familyName) {
        return getImage(width, height, mString, size, color, Typeface.create(familyName, Typeface.BOLD));
    }

    public static Bitmap getImage(int width, int height, String mString, int size, int color, Typeface font) {
        int x = width;
        int y = height;

        Bitmap bmp = Bitmap.createBitmap(x, y, Bitmap.Config.ARGB_8888);
        //图象大小要根据文字大小算下,以和文本长度对应   
        Canvas canvasTemp = new Canvas(bmp);
        Paint p = new Paint();
        p.setColor(color);
        p.setTypeface(font);
        p.setAntiAlias(true);//去除锯齿  
        p.setFilterBitmap(true);//对位图进行滤波处理  
        p.setTextSize(size);
        float tX = (x - getFontlength(p, mString)) / 2;
        float tY = (y - getFontHeight(p)) / 2 + getFontLeading(p);
        canvasTemp.drawText(mString, tX, tY, p);

        return bmp;
    }


    /**
     * @return 返回指定笔和指定字符串的长度
     */
    public static float getFontlength(Paint paint, String str) {
        return paint.measureText(str);
    }

    /**
     * @return 返回指定笔的文字高度
     */
    public static float getFontHeight(Paint paint) {
        FontMetrics fm = paint.getFontMetrics();
        return fm.descent - fm.ascent;
    }

    /**
     * @return 返回指定笔离文字顶部的基准距离
     */
    public static float getFontLeading(Paint paint) {
        FontMetrics fm = paint.getFontMetrics();
        return fm.leading - fm.ascent;
    }

}  
