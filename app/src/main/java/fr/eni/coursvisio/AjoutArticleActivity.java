package fr.eni.coursvisio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;


import fr.eni.coursvisio.bo.Article;
import fr.eni.coursvisio.dao.ArticleDAO;
import fr.eni.coursvisio.dao.Connexion;
import fr.eni.coursvisio.databinding.ActivityAjoutArticleBinding;

public class AjoutArticleActivity extends AppCompatActivity {

    //pour recup le biding layout
    ActivityAjoutArticleBinding amb;

    Article a;

    private class AjoutArticleHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {

            Intent newIntent;
            super.handleMessage(msg);

            if (a.getId() == 0) {
                newIntent = new Intent(AjoutArticleActivity.this, ListeArticlesActivity.class);
            } else {
                newIntent = new Intent(AjoutArticleActivity.this, MainActivity.class);
                newIntent.putExtra("article", a);
            }
            startActivity(newIntent);
            finish();
        }
    }

        @Override
        protected void onCreate(Bundle savedInstanceState) {

            Article article;
            AjoutArticleHandler ajoutArticleHandler = new AjoutArticleHandler();

            super.onCreate(savedInstanceState);
            amb = DataBindingUtil.setContentView(this, R.layout.activity_ajout_article);

            Intent intent = getIntent();

            if (intent.hasExtra("article")) {
                article = (Article) intent.getExtras().get("article");
            } else {
                SharedPreferences shprefs = getSharedPreferences(ConfigurationActivity.FILE, MODE_PRIVATE);
                article = new Article();
                article.setPrix(Float.parseFloat(shprefs.getString(ConfigurationActivity.CLE_PRIX, "1")));
            }
            amb.setAjout(article);

            amb.btSave.setOnClickListener(v -> {

                //recup le binding
                 a = amb.getAjout();

                new Thread(() -> {
                    // creation d'un objet ArticleDAO pour creer la base de données
                    ArticleDAO articleDAO = Connexion.getConnexion(AjoutArticleActivity.this).articleDAO();

                    if (a.getId() == 0) {
                        articleDAO.insert(a);
                    } else {
                        articleDAO.update(a);
                    }
                    ajoutArticleHandler.sendMessage(new Message());
                }).start();

            });
        }
    }
