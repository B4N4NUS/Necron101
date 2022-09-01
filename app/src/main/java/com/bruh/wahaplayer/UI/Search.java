package com.bruh.wahaplayer.UI;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bruh.wahaplayer.Parser;
import com.bruh.wahaplayer.R;

import java.util.Locale;

public class Search extends Fragment {
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.search, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        SearchView search = view.findViewById(R.id.search_bar);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Typeface header = getResources().getFont(R.font.necron);
            int id = search.getContext().getResources().getIdentifier("android:id/search_src_text", null, null);
            TextView searchText = (TextView) search.findViewById(id);
            searchText.setTypeface(header);
            searchText.setTextColor(getResources().getColor(R.color.green));
        }
        LinearLayout layout = view.findViewById(R.id.search_models);
        layout.removeAllViews();

        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    Typeface header = getResources().getFont(R.font.directive_four_bold);
                    int id = search.getContext().getResources().getIdentifier("android:id/search_src_text", null, null);
                    TextView searchText = (TextView) search.findViewById(id);
                    searchText.setTypeface(header);
                    searchText.setTextColor(getResources().getColor(R.color.green));
                }
                layout.removeAllViews();

                boolean found = false;
                for (int i = 0; i < Parser.models.size(); i++) {
                    if (Parser.models.get(i).name.toLowerCase(Locale.ROOT).contains(s.toLowerCase(Locale.ROOT))) {
                        found = true;
                        layout.addView(new ModelInfo(getContext(), Parser.models.get(i)));

                    }
                }
                System.out.println("SEARCHED");

                if (!found) {
                    TextView notFound = new TextView(getContext());
                    notFound.setText("Necrontyr can not afford this type of warriors yet");
                    notFound.setTextColor(getResources().getColor(R.color.green));
                    layout.addView(notFound);
                } else {
                    TextView end = new TextView(getContext());
                    end.setTextColor(getResources().getColor(R.color.black));
                    end.setTextSize(80);
                    layout.addView(end);
                }
                return true;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    Typeface header = getResources().getFont(R.font.necron);
                    int id = search.getContext().getResources().getIdentifier("android:id/search_src_text", null, null);
                    TextView searchText = (TextView) search.findViewById(id);
                    searchText.setTypeface(header);
                    searchText.setTextColor(getResources().getColor(R.color.green));
                }
                return true;
            }
        });
    }
}
