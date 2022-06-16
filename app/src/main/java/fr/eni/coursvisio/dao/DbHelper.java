package fr.eni.coursvisio.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

import fr.eni.coursvisio.bo.Article;
import fr.eni.coursvisio.contract.ArticleContract;

public class DbHelper {//extends SQLiteOpenHelper

//    private static final String DB_NAME = "MaBdd.db";
//
//    //Constructeur
//    public DbHelper(@Nullable Context context) {
//        super(context, DB_NAME, null, 1);
//    }
//
//    @Override
//    public void onCreate(SQLiteDatabase db) {
//        db.execSQL(ArticleContract.CREATE_TABLE);
//    }
//
//    @Override
//    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        db.execSQL(ArticleContract.DROP_TABLE);
//        onCreate(db);
//    }

    public static void remplirBDD(ArticleDAO articleDAO) {
        ArrayList<Article> listeArticles = new ArrayList<>();
        //Creation d'un objet ArticleDAO pour creer la base de données

        new Thread(() -> {

            Article a1 = new Article(1, "Pain au chocolat", "Viennoiserie au chocolat", "http://www.painchoco.fr", 1.10F, 4.5F, false);
            Article a2 = new Article(2, "Croissant", "Viennoiserie au beurre", "http://www.croissant.fr", 0.90F, 4F, false);
            Article a3 = new Article(3, "Pain au raisin", "Viennoiserie au raisin", "http://www.painraisin.fr", 1.20F, 3.5F, false);
            Article a4 = new Article(4, "Beignet", "Truc bien gras", "http://www.beignet.fr", 2.10F, 5F, false);
            Article a5 = new Article(5, "Croissant aux amandes", "Pur beurre et amandes", "http://www.croissantamandes.fr", 1.50F, 4F, false);
            Article a6 = new Article(6, "Tarte citron Meringuee", "Pour ceux qui aiment", "http://www.tartes.fr", 4.50F, 3F, false);
            Article a7 = new Article(7, "Tarte aux fraises", "Tartes avec des fraises", "http://www.tartesauxfruits.fr", 1.10F, 4.5F, false);
            Article a8 = new Article(8, "Muffin", "Gateau au chocolat assez gras", "http://www.muffin.fr", 2.90F, 4F, false);
            Article a9 = new Article(9, "Cookies", "Biscuit americain gras mais bon", "http://www.cookies.fr", 1.50F, 4.5F, false);
            Article a10 = new Article(10, "Flan", "flan aux oeufs", "http://www.flan.fr", 2.10F, 4.5F, false);
            Article a11 = new Article(11, "Kouign-Amann", "Truc le plus gras du monde , que du beurre et du sucre", "http://www.kouign-amann.fr", 3.00F, 4F, false);
            Article a12 = new Article(12, "Brownie", "Pas mal ca depend ce qu'il y a dedans", "http://www.brownie.fr", 2.20F, 3.5F, false);
            Article a13 = new Article(13, "Cupcake", "Cupcake au chocolat", "http://www.cupcake.fr", 1.10F, 4.5F, false);
            Article a14 = new Article(14, "Fondant au chocolat", "Cupcake au chocolat", "http://www.fondant.fr", 1.10F, 4.5F, false);
            Article a15 = new Article(15, "Eclair", "Ecalir au chocolat ou au cafe", "http://www.eclair.fr", 1.90F, 4.5F, false);

            //Pour remplir la BDD
            listeArticles.add(a1);
            listeArticles.add(a2);
            listeArticles.add(a3);
            listeArticles.add(a4);
            listeArticles.add(a5);
            listeArticles.add(a6);
            listeArticles.add(a7);
            listeArticles.add(a8);
            listeArticles.add(a9);
            listeArticles.add(a10);
            listeArticles.add(a11);
            listeArticles.add(a12);
            listeArticles.add(a13);
            listeArticles.add(a14);
            listeArticles.add(a15);

            //pour inserer les articles dans la base de données
            //on le commente pour pas ajouter a chaque lancment de l'application
            for (Article a : listeArticles) {
                articleDAO.insert(a);
            }
        }).start();
    }


}


