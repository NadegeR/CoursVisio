package fr.eni.coursvisio.dao;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import fr.eni.coursvisio.bo.Article;

@Database(entities = {Article.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ArticleDAO articleDAO();
}

