package ru.music.appliance.ui.cards;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import ru.music.appliance.R;

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
        LinearLayout root = new LinearLayout(context);
        root.setOrientation(LinearLayout.VERTICAL);

        ImageView view = new ImageView(context);
        view.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

        Drawable drawable = context.getResources().getDrawable(R.drawable.image);
        view.setImageDrawable(drawable);
        view.setScaleType(ImageView.ScaleType.FIT_START);

        TextView textView = new TextView(context);
        textView.setText("lol");


        root.addView(view);
        root.addView(textView);

        return root;
    }
}
