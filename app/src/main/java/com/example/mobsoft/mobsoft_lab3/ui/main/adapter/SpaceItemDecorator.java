package com.example.mobsoft.mobsoft_lab3.ui.main.adapter;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.View;

public class SpaceItemDecorator extends RecyclerView.ItemDecoration {

    private int topSpaceBetweenItems;
    private int leftRightPadding;

    public SpaceItemDecorator(Context context) {
        this.topSpaceBetweenItems = Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 10, context.getResources().getDisplayMetrics()));
        this.leftRightPadding = Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 30, context.getResources().getDisplayMetrics()));
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.top = topSpaceBetweenItems;
        outRect.left = leftRightPadding;
        outRect.right = leftRightPadding;
    }
}
