package com.javier_apesteguia.listaelementos;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ItemDecor extends RecyclerView.ItemDecoration {
    private Paint shadowPaint;
    private int shadowSize;

    public ItemDecor(int shadowSize){
        this.shadowSize = shadowSize;

        shadowPaint = new Paint();
        shadowPaint.setColor(Color.BLACK);
        shadowPaint.setStyle(Paint.Style.FILL);
        shadowPaint.setShadowLayer(10f, 0f, 10f, Color.GRAY);// Sombra (radio, desplazamientoX, desplazamientoY, color)
    }

    /*
    * Para pintar la sombra
    * */
    @Override
    public void onDraw(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.onDraw(c, parent, state);


        for (int i = 0; i < parent.getChildCount(); i++){
            View child = parent.getChildAt(i);

            int left = child.getLeft();//Devuelve un entero que representa el extremo izquierdo de este view en pixels.
            int right = child.getRight();
            int top = child.getTop();
            int bottom = child.getBottom();

            c.drawRect(left - shadowSize, top - shadowSize, right + shadowSize, bottom + shadowSize, shadowPaint);
        }
    }

}
