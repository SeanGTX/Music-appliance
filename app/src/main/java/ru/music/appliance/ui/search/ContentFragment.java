package ru.music.appliance.ui.search;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.List;

import ru.music.appliance.App;
import ru.music.appliance.ContentActivity;
import ru.music.appliance.R;
import ru.music.appliance.dao.SynthesizerDao;
import ru.music.appliance.entites.Synthesizer;

public class ContentFragment extends Fragment {

    public ContentFragment() {}


    public static ContentFragment newInstance(){
        return new ContentFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View inflate = inflater.inflate(R.layout.fragment_content, container, false);
        LinearLayout root = inflate.findViewById(R.id.scrollRoot);

        SynthesizerDao dao = App.getInstance().getDatabase().synthesizerDao();

        List<Synthesizer> all = dao.getAll();

        for (Synthesizer s: all)
            root.addView(createContentCardFrom(s));

        return inflate;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    public LinearLayout createContentCardFrom(Synthesizer synthesizer){
        Context context = getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        LinearLayout card = (LinearLayout) layoutInflater
                .inflate(R.layout.content_horizontal_card, null, false);

        ImageView image = card.findViewById(R.id.image_h);
        Drawable drawable = context.getDrawable(synthesizer.pictureId);
        image.setImageDrawable(drawable);

        TextView title = card.findViewById(R.id.card_title_h);
        title.setText(synthesizer.name);

        RatingBar ratingBar = card.findViewById(R.id.ratingBar);
        ratingBar.setRating(synthesizer.rate);

        TextView price = card.findViewById(R.id.card_price);
        price.setText("PRICE: " + synthesizer.price + "$");

        card.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), ContentActivity.class);
            intent.putExtra("ID", synthesizer._id);
            getActivity().startActivity(intent);
        });

        return card;
    }
}