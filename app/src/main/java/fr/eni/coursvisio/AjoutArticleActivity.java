package fr.eni.coursvisio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;


import fr.eni.coursvisio.bo.Article;
import fr.eni.coursvisio.dao.ArticleDAO;
import fr.eni.coursvisio.databinding.ActivityAjoutArticleBinding;

public class AjoutArticleActivity extends AppCompatActivity {

    //pour recup le biding layout
    ActivityAjoutArticleBinding amb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Article article;
        super.onCreate(savedInstanceState);
        amb = DataBindingUtil.setContentView(this, R.layout.activity_ajout_article);

        Intent intent = getIntent();

        if (intent.hasExtra("article")) {
            article = (Article) intent.getSerializableExtra("article");
        } else {
            SharedPreferences shprefs = getSharedPreferences(ConfigurationActivity.FILE, MODE_PRIVATE);
            article = new Article();
            article.setPrix(Float.parseFloat(shprefs.getString(ConfigurationActivity.CLE_PRIX, "1")));
        }
        amb.setAjout(article);

        amb.btSave.setOnClickListener(v -> {
            //recup le binding
            Article a = amb.getAjout();

            // recup données du binding
            String nom = a.getNom();
            String description = a.getDescription();
            float prix = a.getPrix();
            String url = a.getUrl();
            float note = a.getNote();

            // creation d'un objet Article
            Article newarticle = new Article(nom, description, prix, url, note);

            // enregistrement de l'article dans la base de données
            ArticleDAO articleDAO = new ArticleDAO(this);
            articleDAO.insert(newarticle);


            Article articleSave = amb.getAjout();



        });






    }
}