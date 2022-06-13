package fr.eni.coursvisio.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import fr.eni.coursvisio.contract.ArticleContract;

public class DbHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "MaBdd.db";

    //Constructeur
    public DbHelper(@Nullable Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(ArticleContract.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(ArticleContract.DROP_TABLE);
        onCreate(db);
    }
}
