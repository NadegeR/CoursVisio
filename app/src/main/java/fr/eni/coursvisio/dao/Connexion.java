package fr.eni.coursvisio.dao;

import android.content.Context;

import androidx.room.Room;

public abstract class Connexion {
    public static AppDatabase getConnexion(Context context)
    {
        return Room.databaseBuilder(context, AppDatabase.class, "articles").build();
    }
}
