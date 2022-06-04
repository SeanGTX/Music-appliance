package ru.music.appliance.entites;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity
public class Synthesizer {
    @PrimaryKey(autoGenerate = true)
    public long _id;
    public String name;
    public Date date;
    public int pictureId; //DrawableID
    public int price;
    public int rate;
    public boolean isLiked;

    public Synthesizer(String name, Date date, int pictureId, int price, int rate, boolean isLiked) {
        this.name = name;
        this.date = date;
        this.pictureId = pictureId;
        this.price = price;
        this.rate = rate;
        this.isLiked = isLiked;
    }
}
