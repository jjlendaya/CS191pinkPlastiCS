package com.pinkplastics.treesim;

/**
 * Created by Jeynald on 5/8/2015.
 */
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

public class UsageTrackerTextView extends TextView {

     public UsageTrackerTextView(Context context, AttributeSet attrs, int defStyle) {
          super(context, attrs, defStyle);
          init(attrs);
     }

     public UsageTrackerTextView(Context context, AttributeSet attrs) {
          super(context, attrs);
          init(attrs);

     }

     public UsageTrackerTextView(Context context) {
          super(context);
          init(null);
     }

     private void init(AttributeSet attrs) {
          if (attrs!=null) {
               TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.UsageTrackerTextView);
               String fontName = a.getString(R.styleable.UsageTrackerTextView_fontName);
               if (fontName!=null) {
                    Typeface myTypeface = Typeface.createFromAsset(getContext().getAssets(), "fonts/"+fontName);
                    setTypeface(myTypeface);
               } else {
                    Typeface heroFont = Typeface.createFromAsset(getContext().getAssets(), "fonts/hero.otf");
                    setTypeface(heroFont);
               }

               a.recycle();
          }
     }

}