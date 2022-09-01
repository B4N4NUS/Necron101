package com.bruh.wahaplayer.UI;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;

import com.bruh.wahaplayer.R;

@SuppressLint("AppCompatCustomView")
public class Typewriter extends TextView {

    private CharSequence mText;
    private int mIndex;
    private long mDelay = 10;


    public Typewriter(Context context) {
        super(context);
    }

    public Typewriter(Context context, AttributeSet attrs) {
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

    public void animateText(CharSequence text) {
        mText = text;
        mIndex = 0;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            Typeface header = getResources().getFont(R.font.necron);
            setTypeface(header);
        }
        mDelay = 1000 / text.length();

        setText("");
        mHandler.removeCallbacks(characterAdder);
        mHandler.postDelayed(characterAdder, mDelay);

        setOnClickListener(e-> {
            mHandler.removeCallbacks(characterAdder);
            setText(mText);
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                Typeface header = getResources().getFont(R.font.directive_four);
                setTypeface(header);
            }
        });
    }

    public void animateText(CharSequence text1, CharSequence text) {
        mText = TextUtils.concat(text1,"\n",text);
        mIndex = text1.length();
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            Typeface header = getResources().getFont(R.font.necron);
            setTypeface(header);
        }
        mDelay = 0;

        setText(text1);
        mHandler.removeCallbacks(characterAdder);
        mHandler.postDelayed(characterAdder, mDelay);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            Typeface header = getResources().getFont(R.font.directive_four);
            setTypeface(header);
        }

        setOnClickListener(e-> {
            mHandler.removeCallbacks(characterAdder);
            setText(mText);
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                Typeface header = getResources().getFont(R.font.directive_four);
                setTypeface(header);
            }
        });
    }

    public void animateText() {
//        if (mText == null) {
//            return;
//        }
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