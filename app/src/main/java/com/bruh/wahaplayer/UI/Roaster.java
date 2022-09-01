package com.bruh.wahaplayer.UI;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bruh.wahaplayer.Parser;
import com.bruh.wahaplayer.R;

import java.util.Locale;

public class Roaster extends Fragment {
    private LinearLayout layout;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.roaster, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        layout = view.findViewById(R.id.roaster_content);
        layout.removeAllViews();

        ButtonTypewriter button;
        for(int i = 0; i < Parser.models.size(); i++) {
            button = new ButtonTypewriter(getContext());
            button.animateText(Parser.models.get(i).name, 100);
            int finalI = i;
            ButtonTypewriter finalButton = button;
            button.setTextColor(getResources().getColor(R.color.light_green));
            button.setOnClickListener(e-> {
                Parser.models.get(finalI).enabled = !Parser.models.get(finalI).enabled;
                if (Parser.models.get(finalI).enabled) {
                    finalButton.setTextColor(getResources().getColor(R.color.green));
                } else {
                    finalButton.setTextColor(getResources().getColor(R.color.light_green));
                }
                finalButton.setChecked(Parser.models.get(finalI).enabled);
            });
            layout.addView(button);
        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

        if (layout != null && isVisibleToUser) {
            final int childCount = layout.getChildCount();
            for (int i = 0; i < childCount; i++) {
                ButtonTypewriter v = (ButtonTypewriter) layout.getChildAt(i);
                v.animateText();
            }
        }
    }
}
