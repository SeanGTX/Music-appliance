package ru.music.appliance;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import java.util.Date;

import ru.music.appliance.dao.SynthesizerDao;
import ru.music.appliance.databinding.ActivityMainBinding;
import ru.music.appliance.entites.Synthesizer;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();

        SynthesizerDao dao = App.getInstance().getDatabase().synthesizerDao();

        Synthesizer synthesizer = new Synthesizer(
                "ROLAND SYSTEM-1",
                new Date(),
                R.drawable.content1,
                499,
                2,
                false
        );
        dao.insert(synthesizer);
        Synthesizer synthesizer2 = new Synthesizer(
                "ROLAND SYSTEM-2",
                new Date(),
                R.drawable.content8,
                300,
                5,
                false
        );
        dao.insert(synthesizer2);
        Synthesizer synthesizer3 = new Synthesizer(
                "MYSYN-1",
                new Date(),
                R.drawable.content4,
                199,
                5,
                false
        );
        dao.insert(synthesizer3);
        Synthesizer synthesizer4 = new Synthesizer(
                "MYSYN-4",
                new Date(),
                R.drawable.content6,
                199,
                8,
                true
        );
        dao.insert(synthesizer4);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_search, R.id.navigation_love)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);
    }

}