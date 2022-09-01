package com.bruh.wahaplayer.UI;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.RadioButton;
import android.widget.TextView;

import com.bruh.wahaplayer.R;

@SuppressLint("AppCompatCustomView")
public class ButtonTypewriter extends RadioButton {

    private CharSequence mText;
    private int mIndex;
    private long mDelay = 10;


    public ButtonTypewriter(Context context) {
        super(context);
    }

    public ButtonTypewriter(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    private Handler mHandler = new Handler();
    private Runnable characterAdder = new Runnable() {
        @Override
        public void run() {
            setText(mText.subSequence(0, mIndex++));
            if(mIndex <= mText.length()) {
                if (mIndex == mText.length()) {
                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                        Typeface header = getResources().getFont(R.font.directive_four);
                        setTypeface(header);
                    }
                }
                mHandler.postDelayed(characterAdder, mDelay);
            }
        }
    };

    public void animateText(CharSequence text, int delay) {
        mText = text;
        mIndex = 0;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            Typeface header = getResources().getFont(R.font.necron);
            setTypeface(header);
        }
        mDelay = delay;

        setText("");
        mHandler.removeCallbacks(characterAdder);
        mHandler.postDelayed(characterAdder, mDelay);
    }

    public void animateText() {
        mIndex = 0;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            Typeface header = getResources().getFont(R.font.necron);
            setTypeface(header);
        }
        mDelay = 1000 / mText.length();

        setText("");
        mHandler.removeCallbacks(characterAdder);
        mHandler.postDelayed(characterAdder, mDelay);
    }

    public void setCharacterDelay(long millis) {
        mDelay = millis;
    }
}