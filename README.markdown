## usage

```
//1、
 ItemTouchHelper.Callback callback = new SimpleItemTouchHelperCallback(adapter);
 mItemTouchHelper = new ItemTouchHelper(callback);
 mItemTouchHelper.attachToRecyclerView(recyclerView);
//2、
 Adapter implements ItemTouchHelperAdapter {
    @Override
    public boolean onItemMove(int fromPosition, int toPosition) {
        Collections.swap(mItems, fromPosition, toPosition);
        notifyItemMoved(fromPosition, toPosition);
        return true;
    }

    @Override
    public void onBindViewHolder(final ItemViewHolder holder, int position) {

        // Start a drag whenever the handle view it touched
        holder.handleView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (MotionEventCompat.getActionMasked(event) == MotionEvent.ACTION_DOWN) {
                    mDragStartListener.onStartDrag(holder);
                }
                return false;
            }
        });
    }
 }
```

## Another drag and swipe library?

This project is an example of basic drag & drop and swipe-to-dismiss with `RecyclerView` using `ItemTouchHelper`. It corresponds with an article series found here:

[Drag and swipe with RecyclerView](https://medium.com/@ipaulpro/drag-and-swipe-with-recyclerview-b9456d2b1aaf)

The classes in [co.paulburke.android.itemtouchhelperdemo.helper](https://github.com/iPaulPro/Android-ItemTouchHelper-Demo/tree/master/app/src/main/java/co/paulburke/android/itemtouchhelperdemo/helper) can easily be used in other projects.

Download the apk from [releases](https://github.com/ipaulpro/Android-ItemTouchHelper-Demo/releases).

## Credits

Developed by Paul Burke ([iPaulPro](https://github.com/iPaulPro)) - [paulburke.co](http://paulburke.co/)

## License

    Copyright (C) 2015 Paul Burke

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.