package com.bruh.wahaplayer.UI;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bruh.wahaplayer.Parser;
import com.bruh.wahaplayer.R;
import com.bruh.wahaplayer.rules.Rule;

import java.util.Objects;

public class AbilityInfo extends RelativeLayout {
    private Context context;
    public boolean visible = true;

    private void Init(Context context) {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.rule_info, this);
        this.context = context;

    }

    public AbilityInfo(Context context) {
        super(context);
        Init(context);
    }

    public AbilityInfo(Context context, Rule rule) {
        super(context);
        Init(context);
        setData(rule);
    }

    public AbilityInfo(Context context, AttributeSet attrs) {
        super(context, attrs);
        Init(context);
    }

    public AbilityInfo(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Init(context);
    }

    public void setData(Rule rule) {
        Typewriter name = findViewById(R.id.rule_name);
        Typewriter desc = findViewById(R.id.rule_desc);
        Typewriter models = findViewById(R.id.rule_models);
        LinearLayout info = findViewById(R.id.rule_info);

        name.animateText(rule.name);
        desc.animateText(rule.description);

//        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
//            Typeface header = getResources().getFont(R.font.directive_four_bold);
//            name.setTypeface(header);
//            Typeface text = getResources().getFont(R.font.directive_four);
////            desc.setTypeface(text);
//            models.setTypeface(text);
//        }

        String mods = "";
        for(int i = 0; i < rule.models.size(); i++) {
            if (Objects.requireNonNull(Parser.getModel.get(rule.models.get(i))).enabled) {
                mods += rule.models.get(i) + ", ";
            }
        }
        if (mods.length() > 0) {
            models.animateText("Models: " + mods.substring(0, mods.length() - 2));
        } else {
            visible = false;
        }
    }
}
