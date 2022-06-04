package ru.music.appliance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;

import ru.music.appliance.dao.SynthesizerDao;
import ru.music.appliance.entites.Synthesizer;

public class ContentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
        getSupportActionBar().hide();
        Intent intent = getIntent();
        if(intent != null){
            long id = intent.getLongExtra("ID", -1);
            if(id == -1) System.exit(-1);
            SynthesizerDao dao = App.getInstance().getDatabase().synthesizerDao();
            Synthesizer synthesizer = dao.getById(id);
            ImageView imageView = findViewById(R.id.imageView4);
            Drawable drawable = getResources().getDrawable(synthesizer.pictureId);
            imageView.setImageDrawable(drawable);
        }
    }
}