package com.xiaomai.xmlibrary.widget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;

/**
 * Created by XiaoMai on 2017/7/5.
 */

public class XMImageView extends ImageView {

    public XMImageView(Context context) {
        this(context, null);
    }

    public XMImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public XMImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                setFilter();
                break;
            case MotionEvent.ACTION_UP:
                removeFilter();
                break;
            case MotionEvent.ACTION_CANCEL:
                removeFilter();
                break;
        }
        return super.onTouchEvent(event);
    }

    private void removeFilter() {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            drawable = getBackground();
        }
        if (drawable != null) {
            drawable.clearColorFilter();
        }
    }

    private void setFilter() {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            drawable = getBackground();
        }
        if (drawable != null) {
            drawable.setColorFilter(Color.GRAY, PorterDuff.Mode.MULTIPLY);
        }
    }
}
