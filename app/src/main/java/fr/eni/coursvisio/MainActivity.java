package fr.eni.coursvisio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import fr.eni.coursvisio.bo.Article;

public class MainActivity extends AppCompatActivity {

    Article article = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //on recupere l'article passé en paramètre dans l'intent
        article= getIntent().getParcelableExtra("article");

        TextView tvNom =  findViewById(R.id.tv_article);
        TextView tvDescription = findViewById(R.id.tvDesc);
        TextView tvPrix = findViewById(R.id.tvPrice);
        RatingBar rating = findViewById(R.id.ratingBar);
        ToggleButton toggle = findViewById(R.id.btnAchat);

        tvNom.setText(article.getNom());
        tvDescription.setText(article.getDescription());
        tvPrix.setText(String.valueOf(article.getPrix()).concat(" €"));
        rating.setRating(article.getNote());
        toggle.setChecked(article.isAchete());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_details, menu);
        return super.onCreateOptionsMenu(menu);
    }


    public void onClickUrl(View view)
    {
        Intent intent = new Intent(this, InfoUrlActivity.class);
        intent.putExtra("article", article);
        startActivity(intent);
//        Toast.makeText(this, article.getUrl(), Toast.LENGTH_LONG).show();
    }

    public void onClickAchat(View view)
    {
        article.setAchete(!article.isAchete());
    }


}