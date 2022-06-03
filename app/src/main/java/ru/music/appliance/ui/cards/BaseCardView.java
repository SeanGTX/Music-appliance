package ru.music.appliance.ui.cards;

import android.content.Context;
import android.content.res.Resources;
import android.text.Layout;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import ru.music.appliance.R;

public abstract class BaseCardView extends CardView {

    public void setOnCardClickListener(OnCardClickListener listener) {
        this.listener = listener;
    }

    private int dpToPx(int dp){
        Resources r = getContext().getResources();
        return (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                dp,
                r.getDisplayMetrics()
        );
    }

    private OnCardClickListener listener = null;

    public BaseCardView(@NonNull Context context) {
        super(context);
        ConstraintLayout.LayoutParams params = new ConstraintLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
                );
        params.setMargins(30, 15, 30, 15);

        setLayoutParams(params);
        setRadius(16);
        int color = getResources().getColor(R.color.card);
        setBackgroundColor(color);
        setOnClickListener(listener);
        addView(content());
    }

    abstract View content();

}
