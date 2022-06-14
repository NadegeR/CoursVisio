package fr.eni.coursvisio;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

import fr.eni.coursvisio.adapter.ArticleAdapter;
import fr.eni.coursvisio.bo.Article;
import fr.eni.coursvisio.dao.ArticleDAO;
import fr.eni.coursvisio.dao.DbHelper;

public class ListeArticlesActivity extends AppCompatActivity {

    private ArticleDAO articleDAO;

    private ArticleAdapter adapter;

//    Article a1 = new Article(1,"Pain au chocolat",  "Viennoiserie au chocolat", "http://www.painchoco.fr",1.10F, 4.5F,false);
//    Article a2 = new Article(2,"Croissant",  "Viennoiserie au beurre", "http://www.croissant.fr",0.90F, 4F,false);
//    Article a3 = new Article(3,"Pain au raisin",  "Viennoiserie au raisin", "http://www.painraisin.fr",1.20F, 3.5F,false);
//    Article a4 = new Article(4,"Beignet",  "Truc bien gras", "http://www.beignet.fr",2.10F, 5F,false);
//    Article a5 = new Article(5,"Croissant aux amandes",  "Pur beurre et amandes", "http://www.croissantamandes.fr",1.50F, 4F,false);
//    Article a6 = new Article(6,"Tarte citron Meringuee",  "Pour ceux qui aiment", "http://www.tartes.fr",4.50F, 3F,false);
//    Article a7 = new Article(7,"Tarte aux fraises",  "Tartes avec des fraises", "http://www.tartesauxfruits.fr",1.10F, 4.5F,false);
//    Article a8 = new Article(8,"Muffin",  "Gateau au chocolat assez gras", "http://www.muffin.fr",2.90F, 4F,false);
//    Article a9 = new Article(9,"Cookies",  "Biscuit americain gras mais bon", "http://www.cookies.fr",1.50F, 4.5F,false);
//    Article a10 = new Article(10,"Flan",  "flan aux oeufs", "http://www.flan.fr",2.10F, 4.5F,false);
//    Article a11 = new Article(11,"Kouign-Amann",  "Truc le plus gras du monde , que du beurre et du sucre", "http://www.kouign-amann.fr",3.00F, 4F,false);
//    Article a12 = new Article(12,"Brownie",  "Pas mal ca depend ce qu'il y a dedans", "http://www.brownie.fr",2.20F, 3.5F,false);
//    Article a13 = new Article(13,"Cupcake",  "Cupcake au chocolat", "http://www.cupcake.fr",1.10F, 4.5F,false);
//    Article a14 = new Article(14,"Fondant au chocolat",  "Cupcake au chocolat", "http://www.fondant.fr",1.10F, 4.5F,false);
//    Article a15 = new Article(15,"Eclair",  "Ecalir au chocolat ou au cafe", "http://www.eclair.fr",1.90F, 4.5F,false);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_articles);

        //passer dans onResume()
//        //On recup les preferences de ConfigurationActivity
//        SharedPreferences shPref = getSharedPreferences(ConfigurationActivity.FILE, MODE_PRIVATE);
//        Boolean tri = shPref.getBoolean(ConfigurationActivity.CLE_TRI, false);

        //Creation d'un objet ArticleDAO pour creer la base de données
        articleDAO = new ArticleDAO(this);

        //passer dans onResume()
//        //on connecte la base de données
//        listeArticles = (ArrayList<Article>) articleDAO.getAll(tri);
//
        //Pour remplir la BDD
//        DbHelper.remplirBDD(articleDAO);

        RecyclerView recyclerView = findViewById(R.id.rv_listeA);

        //Creation d'un Adapter
        adapter = new ArticleAdapter(new ArrayList<Article>());

        //Attribution de l'Adapter au RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // mettre l'Adapter dans le RecyclerView
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();

        //On recup les preferences de ConfigurationActivity
        SharedPreferences shPref = getSharedPreferences(ConfigurationActivity.FILE, MODE_PRIVATE);
        Boolean tri = shPref.getBoolean(ConfigurationActivity.CLE_TRI, false);

        //on connecte la base de données
        //Creation d'1 ArrayList de 3 Articles
        ArrayList<Article> listeArticles = (ArrayList<Article>) articleDAO.getAll(tri);

        adapter.updateList(listeArticles);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.imAdd) {

        } else if (item.getItemId() == R.id.imPreferences) {
            Intent intent = new Intent(this, ConfigurationActivity.class);
            startActivity(intent);

        }
        return super.onOptionsItemSelected(item);
    }
}