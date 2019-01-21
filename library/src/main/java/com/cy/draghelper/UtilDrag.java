package com.cy.draghelper;

import android.support.v4.view.MotionEventCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.MotionEvent;

import java.util.WeakHashMap;

public class UtilDrag{
    private static WeakHashMap<ItemTouchHelperAdapter, ItemTouchHelper> kvs = new WeakHashMap<>();


    public static void doTouch(ItemTouchHelperAdapter adapter,RecyclerView.ViewHolder viewHolder, MotionEvent event){
        if (MotionEventCompat.getActionMasked(event) == MotionEvent.ACTION_DOWN) {
            kvs.get(adapter).startDrag(viewHolder);
        }
    }

    public static void attach(ItemTouchHelperAdapter adapter, RecyclerView recyclerView){

        ItemTouchHelper.Callback callback = new SimpleItemTouchHelperCallback(adapter);
        ItemTouchHelper mItemTouchHelper = new ItemTouchHelper(callback);
        mItemTouchHelper.attachToRecyclerView(recyclerView);

        kvs.put(adapter,mItemTouchHelper);
    }
}
