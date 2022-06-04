package ru.music.appliance.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import ru.music.appliance.entites.Synthesizer;

@Dao
public interface SynthesizerDao {

    @Query("SELECT * FROM synthesizer")
    List<Synthesizer> getAll();

    @Query("SELECT * FROM synthesizer WHERE _id = :id")
    Synthesizer getById(long id);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Synthesizer synthesizer);

    @Update
    void update(Synthesizer synthesizer);

    @Delete
    void delete(Synthesizer synthesizer);

}
