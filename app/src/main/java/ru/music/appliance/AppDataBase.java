package ru.music.appliance;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import ru.music.appliance.converters.DateConverter;
import ru.music.appliance.dao.SynthesizerDao;
import ru.music.appliance.entites.Synthesizer;

@Database(entities = {Synthesizer.class}, version = 1, exportSchema = false)
@TypeConverters(DateConverter.class)
public abstract class AppDataBase extends RoomDatabase {
    public abstract SynthesizerDao synthesizerDao();
}
