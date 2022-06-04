package ru.music.appliance.ui.search;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;

import ru.music.appliance.R;
import ru.music.appliance.databinding.FragmentSearchBinding;
import ru.music.appliance.ui.cards.OnCardClickListener;

public class SearchFragment extends Fragment {

    private FragmentSearchBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SearchViewModel searchViewModel =
                new ViewModelProvider(this).get(SearchViewModel.class);

        binding = FragmentSearchBinding.inflate(inflater, container, false);
        binding.rootScroll.addView(createSearchCardElement(R.drawable.syn, "SYNTHESIZERS", v -> {
            Toast.makeText(getContext(), "lol", Toast.LENGTH_LONG).show();
            ContentFragment contentFragment = ContentFragment.newInstance();

            FragmentActivity activity = getActivity();

            activity
                    .getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.nav_host_fragment_activity_main, contentFragment)
                    .commit();

        }));
        binding.rootScroll.addView(createSearchCardElement(R.drawable.midi, "MIDI CONTROLLERS", v -> {}));
        binding.rootScroll.addView(createSearchCardElement(R.drawable.headphones, "HEADPHONES", v -> {}));
        View root = binding.getRoot();

        final TextView textView = new TextView(this.getContext());
        searchViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private LinearLayout createSearchCardElement(int idDrawable, String title, OnCardClickListener listener){
        LayoutInflater from = LayoutInflater.from(getContext());
        LinearLayout card = (LinearLayout) from.inflate(R.layout.search_card, null, false);

        ImageView viewById = card.findViewById(R.id.image);
        Drawable drawable = getContext().getDrawable(idDrawable);
        viewById.setImageDrawable(drawable);
        TextView cardTitle = card.findViewById(R.id.card_title);
        cardTitle.setText(title);

        CardView c = card.findViewById(R.id.main_card);

        c.setOnClickListener(listener);

        return card;
    }
}