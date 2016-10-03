package com.example.swathi.computersera.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.swathi.computersera.R;
import com.example.swathi.computersera.activity.DetailActivity;
import com.example.swathi.computersera.activity.MainActivity;
import com.example.swathi.computersera.model.Article;
import com.example.swathi.computersera.model.SingleArticle;
import com.example.swathi.computersera.rest.ApiClient;
import com.example.swathi.computersera.rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by user on 10/3/2016.
 */
public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ArticalViewHolder>{
    private List<Article> articles;
    private int rowLayout;
    private Context context;

    public ArticleAdapter(List<Article> articles, int rowLayout, Context context)
    {
        this.articles = articles;
        this.rowLayout = rowLayout;
        this.context = context;
    }
    @Override
    public ArticleAdapter.ArticalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //return null;
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout,parent,false);
        return new ArticalViewHolder(view);

    }

    @Override
    public void onBindViewHolder(ArticleAdapter.ArticalViewHolder holder, int position) {
        final int pos = position;
        holder.titleTxt.setText(articles.get(position).getTitle());
        Log.d("title",holder.titleTxt.getText().toString());
        holder.postedByTxt.setText(articles.get(position).getPostedBy());
        Log.d("by", holder.postedByTxt.getText().toString());
        holder.postedDateTxt.setText(articles.get(position).getPostedDate());
        Log.d("on",holder.postedDateTxt.getText().toString());
        holder.description.setText(Html.fromHtml(articles.get(position).getDescription()));
        Log.d("description",holder.description.getText().toString());
        /*
        holder.readMoreTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("clicked","clicked");
                int id = articles.get(pos).getId();
                MainActivity.getArticalDetails(context,id);
            }
        });
        */
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    public class ArticalViewHolder extends RecyclerView.ViewHolder {

        RelativeLayout article_layout;
        TextView titleTxt;
        TextView postedByTxt;
        TextView postedDateTxt;
        TextView description;
        TextView readMoreTxt;

        public ArticalViewHolder(View itemView) {
            super(itemView);
            article_layout = (RelativeLayout) itemView.findViewById(R.id.article_layout);
            titleTxt = (TextView) itemView.findViewById(R.id.title);
            postedByTxt = (TextView) itemView.findViewById(R.id.postedBy);
            postedDateTxt = (TextView) itemView.findViewById(R.id.postedDate);
            description = (TextView) itemView.findViewById(R.id.description);
            readMoreTxt = (TextView) itemView.findViewById(R.id.readMoreTxt);

        }
    }

    public void getArticalDetails(int id)
    {

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<List<SingleArticle>> articleDetail = apiInterface.getArticledetails(id);
        articleDetail.enqueue(new Callback<List<SingleArticle>>() {
            @Override
            public void onResponse(Call<List<SingleArticle>> call, Response<List<SingleArticle>> response) {
                //MainActivity.
                List<SingleArticle> article = response.body();
                String title = article.get(0).getTitle();
                String postedBy = article.get(0).getPostedBy();
                String postedOn = article.get(0).getPostedDate();
                String description = article.get(0).getDescription();
                String image = article.get(0).getArticalPic();
                String author = article.get(0).getAboutAuthor();

            }

            @Override
            public void onFailure(Call<List<SingleArticle>> call, Throwable t) {

            }
        });
    }
}
