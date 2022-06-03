package ru.music.appliance;

import androidx.room.Database;
import androidx.room.Entity;
import androidx.room.RoomDatabase;

@Database(entities = Entity.class, version = 1)
public abstract class AppDataBase extends RoomDatabase {
    public abstract int employeeDao();
}
