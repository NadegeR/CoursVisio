package fr.eni.coursvisio.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import fr.eni.coursvisio.MainActivity;
import fr.eni.coursvisio.R;
import fr.eni.coursvisio.bo.Article;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder> {

    ArrayList<Article> articles;


    public ArticleAdapter(ArrayList<Article> articles) {
        this.articles = articles;
    }

    class ArticleViewHolder extends RecyclerView.ViewHolder {
        TextView tvLigne;
        ConstraintLayout clArticle;

        //constructeur de la classe ArticleViewHolder
        public ArticleViewHolder(@NonNull View itemView) {
            super(itemView);
            tvLigne = itemView.findViewById(R.id.tv_nom);
            clArticle = itemView.findViewById(R.id.cl_ligne);
        }
    }

    private class onClickHandler implements View.OnClickListener {
        private Article article;

        public onClickHandler(Article article) {
            this.article = article;
        }

        @Override
        public void onClick(View v) {
            //Toast.makeText(v.getContext(), article.getNom(), Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(v.getContext(), MainActivity.class);
            //on defint les extra pour passer les données
            intent.putExtra("article", article);
            v.getContext().startActivity(intent);
        }
    }


    @NonNull
    @Override
    public ArticleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // transforme 1 layout en 1 vue
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.ligne_article, parent, false);
        return new ArticleViewHolder(itemView);
    }

    // va etre appeler a chq fois q'1 element de la liste est a afficher avec la "position"
    @Override
    public void onBindViewHolder(@NonNull ArticleViewHolder holder, int position) {
        Article article = articles.get(position);
        holder.tvLigne.setText(article.getNom());
        holder.clArticle.setOnClickListener(new onClickHandler(article));



    }

    @Override
    public int getItemCount() {
        return articles.size();
    }


}
