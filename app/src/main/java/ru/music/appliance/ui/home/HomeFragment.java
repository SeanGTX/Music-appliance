package ru.music.appliance.ui.home;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import ru.music.appliance.R;
import ru.music.appliance.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    @SuppressLint("ResourceType")
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);

        LinearLayout cardView1 = createHomeCardElement(R.drawable.image, "ELEKTRON MADE IT AGAIN!", "DIGITONE REPRESENTS OUR VISION OF HOW FM SYNTHESIS CAN BE REVITALIZED");
        binding.rootScroll.addView(cardView1);

        LinearLayout cardView2 = createHomeCardElement(R.drawable.image1, "DEPECHE MODE’S ESSENTIALS", "TOP 10 SYNTHESIZERS HIGLY RECOMMENDED BY DEPECHE MODE ");
        binding.rootScroll.addView(cardView2);

        for(int i = 0; i < 10; i++)
            binding.rootScroll.addView(inflater.inflate(R.layout.home_card, null, false));
        //Спейсер
        TextView spacer = new TextView(getContext());
        spacer.setHeight(90);
        binding.rootScroll.addView(spacer);
        View root = binding.getRoot();

        final TextView textView = new TextView(getContext());
        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


    private LinearLayout createHomeCardElement(int idDrawable, String title, String subtitle){
        LayoutInflater from = LayoutInflater.from(getContext());
        LinearLayout card = (LinearLayout) from.inflate(R.layout.home_card, null, false);

        ImageView viewById = card.findViewById(R.id.image);
        Drawable drawable = getContext().getDrawable(idDrawable);
        viewById.setImageDrawable(drawable);

        TextView cardTitle = card.findViewById(R.id.card_title);
        cardTitle.setText(title);
        TextView subTitle = card.findViewById(R.id.card_title_h);
        subTitle.setText(subtitle);

        return card;
    }
}