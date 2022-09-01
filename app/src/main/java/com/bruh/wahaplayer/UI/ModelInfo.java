package com.bruh.wahaplayer.UI;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bruh.wahaplayer.Parser;
import com.bruh.wahaplayer.R;
import com.bruh.wahaplayer.models.Model;

import java.lang.reflect.Type;
import java.util.Objects;

public class ModelInfo extends RelativeLayout {
    private Context context;

    private void Init(Context context) {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.model_info, this);
        this.context = context;

    }

    public ModelInfo(Context context) {
        super(context);
        Init(context);
    }
    public ModelInfo(Context context, Model model) {
        super(context);
        Init(context);
        setData(model);
    }

    public ModelInfo(Context context, AttributeSet attrs) {
        super(context, attrs);
        Init(context);
    }

    public ModelInfo(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Init(context);
    }

    public void setData(Model model) {
        TextView name = findViewById(R.id.model_name);
        TextView m = findViewById(R.id.model_m);
        TextView ws = findViewById(R.id.model_ws);
        TextView bs = findViewById(R.id.model_bs);
        TextView t = findViewById(R.id.model_t);
        TextView w = findViewById(R.id.model_w);
        TextView a = findViewById(R.id.model_a);
        TextView ld = findViewById(R.id.model_ld);
        TextView sv = findViewById(R.id.model_sv);

        LinearLayout weapons = findViewById(R.id.model_weapons);
        weapons.removeAllViews();
        LinearLayout rules = findViewById(R.id.model_rules);
        rules.removeAllViews();

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            Typeface font = getResources().getFont(R.font.directive_four);
            name.setTypeface(font);
            m.setTypeface(font);
            ws.setTypeface(font);
            bs.setTypeface(font);
            t.setTypeface(font);
            w.setTypeface(font);
            a.setTypeface(font);
            ld.setTypeface(font);
            sv.setTypeface(font);
        }

        name.setText(model.name);
        m.setText(model.m);
        ws.setText(model.ws);
        bs.setText(model.bs);
        t.setText(model.t);
        w.setText(model.w);
        a.setText(model.a);
        ld.setText(model.ld);
        sv.setText(model.save);

        for(int i = 0; i < model.weapons.length; i++) {
            if (Parser.getWeapons.get(model.weapons[i]) != null) {
                weapons.addView(new WeaponInfo(context, Parser.getWeapons.get(model.weapons[i])));
            } else {
                System.out.println("CANT FIND WEAPON: "+model.weapons[i]);
            }
        }

        Typewriter text;
        for(int i = 0; i < model.rules.length; i++) {
            text = new Typewriter(context);
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                Typeface header = getResources().getFont(R.font.directive_four);
                text.setTypeface(header);
            }
            text.animateText(model.rules[i]);
            int finalI = i;
            text.setOnClickListener(e-> {
                AlertDialog alertDialog = new AlertDialog.Builder(getContext(), R.style.MyDialogTheme).create();
                alertDialog.setTitle(model.rules[finalI]);
                alertDialog.getWindow().setBackgroundDrawableResource(R.drawable.borders_with_inside);
                alertDialog.setIcon(R.drawable.borders_with_inside);
                alertDialog.setMessage(Objects.requireNonNull(Parser.getRules.get(model.rules[finalI])).description);
                alertDialog.show();
            });
            text.setTextColor(getResources().getColor(R.color.green));
            rules.addView(text);
        }
    }

}
