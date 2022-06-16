package fr.eni.coursvisio.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.ArrayList;
import java.util.List;

import fr.eni.coursvisio.bo.Article;
import fr.eni.coursvisio.contract.ArticleContract;

@Dao
public interface ArticleDAO {
    //Modifier car mise en place de ROOM
//    private SQLiteDatabase db;
//    private DbHelper dbHelper;

//    public ArticleDAO(Context ctx) {
//        dbHelper = new DbHelper(ctx);
//        db = dbHelper.getWritableDatabase();
//    }

    @Insert
    long insert(Article a);
//    {

//        ContentValues cv = new ContentValues();//pour le nom des tables et les colonnes un peu comme PrepareStatement
//        cv.put(ArticleContract.COL_NOM, a.getNom());
//        cv.put(ArticleContract.COL_DESCRIPTION, a.getDescription());
//        cv.put(ArticleContract.COL_PRIX, a.getPrix());
//        cv.put(ArticleContract.COL_NOTE, a.getNote());
//        cv.put(ArticleContract.COL_URL, a.getUrl());
//        cv.put(ArticleContract.COL_IS_ACHAETE, a.isAchete());
//
//        return db.insert(ArticleContract.TABLE_NAME, null, cv);
//    }
    @Query("SELECT * FROM Article WHERE id = :id")
    Article getArticle(int id);
//    {
//        Article a = null;
//
//        String[] listeColonnes = {
//                ArticleContract.COL_ID,
//                ArticleContract.COL_NOM,
//                ArticleContract.COL_DESCRIPTION,
//                ArticleContract.COL_PRIX,
//                ArticleContract.COL_NOTE,
//                ArticleContract.COL_URL,
//                ArticleContract.COL_IS_ACHAETE
//        };
//        Cursor cursor = db.query(
//                ArticleContract.TABLE_NAME, //From
//                listeColonnes,
//                ArticleContract.COL_ID + " = ?", //Where
//                new String[]{String.valueOf(id)}, //WhereArgs
//                null, null, null, null);
//
//        if (cursor.moveToNext()) {
//            a = new Article();
//
//            int idColIndex = cursor.getColumnIndex(ArticleContract.COL_ID);
//            int nomColIndex = cursor.getColumnIndex(ArticleContract.COL_NOM);
//            int descriptionColIndex = cursor.getColumnIndex(ArticleContract.COL_DESCRIPTION);
//            int prixColIndex = cursor.getColumnIndex(ArticleContract.COL_PRIX);
//            int noteColIndex = cursor.getColumnIndex(ArticleContract.COL_NOTE);
//            int urlColIndex = cursor.getColumnIndex(ArticleContract.COL_URL);
//            int isAcheteColIndex = cursor.getColumnIndex(ArticleContract.COL_IS_ACHAETE);
//
//            a.setId(cursor.getInt(idColIndex));
//            a.setNom(cursor.getString(nomColIndex));
//            a.setDescription(cursor.getString(descriptionColIndex));
//            a.setPrix(cursor.getFloat(prixColIndex));
//            a.setNote(cursor.getFloat(noteColIndex));
//            a.setUrl(cursor.getString(urlColIndex));
//            a.setAchete(cursor.getInt(isAcheteColIndex) == 1);//1=true, 0=false
//        }
//        cursor.close();
//        return a;
//
//    }

    @Query("SELECT * FROM Article ORDER BY :nom")
    List<Article> getAll(String nom);
//    {
//        List<Article> listeArticles = new ArrayList<>();
//
//        String[] listeColonnes = {
//                ArticleContract.COL_ID,
//                ArticleContract.COL_NOM,
//                ArticleContract.COL_DESCRIPTION,
//                ArticleContract.COL_PRIX,
//                ArticleContract.COL_NOTE,
//                ArticleContract.COL_URL,
//                ArticleContract.COL_IS_ACHAETE
//        };
//
//        //si tri cocher on trie par prix
//        String orderBy = (tri) ? "prix" : null;
//
//        Cursor cursor = db.query(
//                ArticleContract.TABLE_NAME, //From
//                listeColonnes,
//                null,
//                null, null, null, orderBy);
//
//        while (cursor.moveToNext()) {
//
//            Article a = new Article();
//
//            int idColIndex = cursor.getColumnIndex(ArticleContract.COL_ID);
//            int nomColIndex = cursor.getColumnIndex(ArticleContract.COL_NOM);
//            int descriptionColIndex = cursor.getColumnIndex(ArticleContract.COL_DESCRIPTION);
//            int prixColIndex = cursor.getColumnIndex(ArticleContract.COL_PRIX);
//            int noteColIndex = cursor.getColumnIndex(ArticleContract.COL_NOTE);
//            int urlColIndex = cursor.getColumnIndex(ArticleContract.COL_URL);
//            int isAcheteColIndex = cursor.getColumnIndex(ArticleContract.COL_IS_ACHAETE);
//
//            a.setId(cursor.getInt(idColIndex));
//            a.setNom(cursor.getString(nomColIndex));
//            a.setDescription(cursor.getString(descriptionColIndex));
//            a.setPrix(cursor.getFloat(prixColIndex));
//            a.setNote(cursor.getFloat(noteColIndex));
//            a.setUrl(cursor.getString(urlColIndex));
//            a.setAchete(cursor.getInt(isAcheteColIndex) == 1);//1=true, 0=false
//
//            listeArticles.add(a);
//        }
//        cursor.close();
//        return listeArticles;
//    }

    @Update
    public void update(Article a);
//    {
//        ContentValues cv = new ContentValues();//pour le nom des tables et les colonnes un peu comme PrepareStatement
//        cv.put(ArticleContract.COL_NOM, a.getNom());
//        cv.put(ArticleContract.COL_DESCRIPTION, a.getDescription());
//        cv.put(ArticleContract.COL_PRIX, a.getPrix());
//        cv.put(ArticleContract.COL_NOTE, a.getNote());
//        cv.put(ArticleContract.COL_URL, a.getUrl());
//        cv.put(ArticleContract.COL_IS_ACHAETE, a.isAchete());
//
//        int result = db.update(ArticleContract.TABLE_NAME, cv, ArticleContract.COL_ID + " = ?", new String[]{String.valueOf(a.getId())});
//
//        return (result == 1);
//    }

    @Delete
    public void delete(Article a);

//    {
//        int result = db.delete(ArticleContract.TABLE_NAME, ArticleContract.COL_ID + " = ?", new String[]{String.valueOf(id)});
//        return (result == 1);
//    }
}
