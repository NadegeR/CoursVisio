package fr.eni.coursvisio;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

import fr.eni.coursvisio.adapter.ArticleAdapter;
import fr.eni.coursvisio.bo.Article;
import fr.eni.coursvisio.dao.AppDatabase;
import fr.eni.coursvisio.dao.ArticleDAO;
import fr.eni.coursvisio.dao.Connexion;
import fr.eni.coursvisio.dao.DbHelper;

public class ListeArticlesActivity extends AppCompatActivity {

    private ArticleDAO articleDAO;

    private ArticleAdapter adapter;



    ArrayList<Article> listeArticles;
    ListHandler listHandler;

    public class ListHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            listeArticles = (ArrayList<Article>) msg.obj;
            adapter.updateList(listeArticles);
        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_articles);

        AppDatabase appDatabase = Connexion.getConnexion(this);
        articleDAO = appDatabase.articleDAO();

        //modifier avec mise en place de ROOM pour gere la bdd
//        //Creation d'un objet ArticleDAO pour creer la base de données
//        articleDAO = new ArticleDAO(this);

        listHandler = new ListHandler();
        //Pour remplir la BDD
//       DbHelper.remplirBDD(articleDAO);

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

        new Thread(() -> {

            //On recup les preferences de ConfigurationActivity
            SharedPreferences shPref = getSharedPreferences(ConfigurationActivity.FILE, MODE_PRIVATE);
            Boolean tri = shPref.getBoolean(ConfigurationActivity.CLE_TRI, false);

            //on connecte la base de données
            //Creation d'1 ArrayList de ts les Articles
            ArrayList<Article> listeArticles = (ArrayList<Article>) articleDAO.getAll(tri ? "prix" : "nom");

            Message msg = new Message();
            msg.obj = listeArticles;
            listHandler.sendMessage(msg);
        }).start();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.imAdd) {
            Intent intent = new Intent(this, AjoutArticleActivity.class);
            startActivity(intent);

        } else if (item.getItemId() == R.id.imPreferences) {
            Intent intent = new Intent(this, ConfigurationActivity.class);
            startActivity(intent);

        }
        return super.onOptionsItemSelected(item);
    }
}