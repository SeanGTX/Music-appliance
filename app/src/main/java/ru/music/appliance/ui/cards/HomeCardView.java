package ru.music.appliance.ui.cards;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

public class HomeCardView extends BaseCardView{

    public HomeCardView(@NonNull Context context) {
        super(context);

        setOnCardClickListener(v -> {
            Toast.makeText(context, "lol", Toast.LENGTH_LONG).show();
        });
    }

    @Override
    View content() {
        Context context = getContext();
        LinearLayout a = new LinearLayout(context);
        a.setOrientation(LinearLayout.HORIZONTAL);



        TextView textView = new TextView(context);
        textView.setText("lol");

        a.addView(textView);

        return a;
    }
}
