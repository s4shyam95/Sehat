package com.modprobe.profit;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class HistoryRecyclerViewItemSpacing extends RecyclerView.ItemDecoration {
    private int space;

    public HistoryRecyclerViewItemSpacing(int space) {
        this.space = space;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.left = space - 35;
        outRect.right = space - 35;
        outRect.bottom = space;

        // Add top margin only for the first item to avoid double space between items
        if(parent.getChildPosition(view) == 0)
            outRect.top = space;
    }
}