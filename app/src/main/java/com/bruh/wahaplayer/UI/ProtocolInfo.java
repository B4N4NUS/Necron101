package com.bruh.wahaplayer.UI;

import static android.text.Spanned.SPAN_INCLUSIVE_INCLUSIVE;

import android.content.Context;
import android.text.Html;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bruh.wahaplayer.R;

public class ProtocolInfo extends RelativeLayout {
    public Button order;
    public Typewriter text;
    public String header, description;
    private Context context;

    private void Init(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.protocol_info, this);
        this.context = context;
        text = findViewById(R.id.protocol_text);
    }

    public ProtocolInfo(Context context) {
        super(context);
        Init(context);
    }

    public ProtocolInfo(Context context, String header, String description) {
        super(context);
        Init(context);
        this.header = header;
        this.description = description;
        text.setText(header);
        order = findViewById(R.id.protocol_order);
        Button expand = findViewById(R.id.protocol_expand);
        expand.setText(description.charAt(4)+"");

        SpannableString span3 = new SpannableString(header);
        span3.setSpan(new AbsoluteSizeSpan(50), 0, header.length(), SPAN_INCLUSIVE_INCLUSIVE);
        text.animateText(TextUtils.concat(span3));
        text.setTextColor(getResources().getColor(R.color.light_green));
        expand.setOnClickListener(e-> {
            if (text.getText().toString().equals(header)) {
                SpannableString span1 = new SpannableString(header);
                span1.setSpan(new AbsoluteSizeSpan(50), 0, header.length(), SPAN_INCLUSIVE_INCLUSIVE);

                SpannableString span2 = new SpannableString(description+"\n");
                span2.setSpan(new AbsoluteSizeSpan(35), 0, description.length(), SPAN_INCLUSIVE_INCLUSIVE);

                text.animateText(span1,span2);
            } else {
                SpannableString span1 = new SpannableString(header);
                span1.setSpan(new AbsoluteSizeSpan(50), 0, header.length(), SPAN_INCLUSIVE_INCLUSIVE);
                text.setText(TextUtils.concat(span1));
            }
        });
    }

    public ProtocolInfo(Context context, AttributeSet attrs) {
        super(context, attrs);
        Init(context);
    }

    public ProtocolInfo(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Init(context);
    }
}
