package com.cy.draghelper;

import android.support.v4.view.MotionEventCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.MotionEvent;

import java.util.WeakHashMap;

public class UtilDrag{
    private static WeakHashMap<ItemTouchHelperAdapter, DragHelperBean> kvs = new WeakHashMap<>();


    public static void doTouch(ItemTouchHelperAdapter adapter,RecyclerView.ViewHolder viewHolder, MotionEvent event){
        if (MotionEventCompat.getActionMasked(event) == MotionEvent.ACTION_DOWN) {
            kvs.get(adapter).itemTouchHelper.startDrag(viewHolder);
        }
    }

    public static void attach(ItemTouchHelperAdapter adapter, RecyclerView recyclerView){

        SimpleItemTouchHelperCallback callback = new SimpleItemTouchHelperCallback(adapter);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(callback);
        itemTouchHelper.attachToRecyclerView(recyclerView);
        DragHelperBean dragHelperBean=new DragHelperBean();
        dragHelperBean.itemTouchHelper=itemTouchHelper;
        dragHelperBean.callback=callback;
        kvs.put(adapter,dragHelperBean);
    }

    public static void enableDrag(ItemTouchHelperAdapter adapter, boolean enableDragOrNot){
        kvs.get(adapter).callback.setCanDragOrNot(enableDragOrNot);
    }

    public static void enableDrag(ItemTouchHelperAdapter adapter){
        kvs.get(adapter).callback.setCanDragOrNot(true);
    }

    public static void disableDrag(ItemTouchHelperAdapter adapter){
        kvs.get(adapter).callback.setCanDragOrNot(false);
    }

    public static boolean isDragMode(ItemTouchHelperAdapter adapter){
        return kvs.get(adapter).callback.getCanDragOrNot();
    }

    private static class DragHelperBean{
        private ItemTouchHelper itemTouchHelper;
        private SimpleItemTouchHelperCallback callback;
    }
}
