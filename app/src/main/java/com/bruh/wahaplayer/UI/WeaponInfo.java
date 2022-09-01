package com.bruh.wahaplayer.UI;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bruh.wahaplayer.R;
import com.bruh.wahaplayer.models.Model;
import com.bruh.wahaplayer.weapons.Weapon;

public class WeaponInfo extends RelativeLayout {
    private Context context;

    private void Init(Context context) {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.weapon_info, this);
        this.context = context;

    }

    public WeaponInfo(Context context) {
        super(context);
        Init(context);
    }
    public WeaponInfo(Context context, Weapon model) {
        super(context);
        Init(context);
        setData(model);
    }

    public WeaponInfo(Context context, AttributeSet attrs) {
        super(context, attrs);
        Init(context);
    }

    public WeaponInfo(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Init(context);
    }

    public void setData(Weapon weapon) {
        TextView name = findViewById(R.id.model_weapon_name);
        TextView m = findViewById(R.id.model_weapon_range);
        TextView ws = findViewById(R.id.model_weapon_type);
        TextView bs = findViewById(R.id.model_weapon_s);
        TextView t = findViewById(R.id.model_weapon_ap);
        TextView w = findViewById(R.id.model_weapon_d);
        TextView a = findViewById(R.id.model_weapon_abilities);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            Typeface text = getResources().getFont(R.font.directive_four);
            name.setTypeface(text);
            m.setTypeface(text);
            ws.setTypeface(text);
            bs.setTypeface(text);
            t.setTypeface(text);
            w.setTypeface(text);
            a.setTypeface(text);
        }

        name.setText(weapon.name);
        m.setText(weapon.range);
        ws.setText(weapon.type);
        bs.setText(weapon.s);
        t.setText(weapon.ap);
        w.setText(weapon.d);
        a.setText(weapon.abilities);
    }
}
