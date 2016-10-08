package com.example.swathi.computersera.activity;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.swathi.computersera.R;
import com.example.swathi.computersera.adapter.ArticleAdapter;
import com.example.swathi.computersera.adapter.HeaderSpinnerAdapter;
import com.example.swathi.computersera.model.Article;
import com.example.swathi.computersera.model.Header;
import com.example.swathi.computersera.model.SingleArticle;
import com.example.swathi.computersera.rest.ApiClient;
import com.example.swathi.computersera.rest.ApiInterface;

import java.net.URI;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by user on 10/3/2016.
 */
public class DetailActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.artical_detail_layout);

        int id = 11465;

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
                //setContentView(R.layout.artical_detail_layout);
                TextView titleTxt = (TextView) findViewById(R.id.detailTitleTxt);
                Log.d("clicked","title is "+title);
                // Intent intent = new Intent(getApplicationContext(),DetailActivity.class);
                //startActivity(intent);

                titleTxt.setText(title);

                TextView postedByTxt = (TextView) findViewById(R.id.detailPublishedBytxt);
                postedByTxt.setText(postedBy);

                TextView postedOnTxt = (TextView) findViewById(R.id.detailsPublishedDate);
                postedOnTxt.setText(postedOn);

                TextView descriptionTxt = (TextView) findViewById(R.id.detailDescription);
                descriptionTxt.setText(Html.fromHtml(description));

                Log.d("article image",article.get(0).getArticalPic());
                ImageView articleImg = (ImageView) findViewById(R.id.detailImage);
                articleImg.setImageURI(Uri.parse(article.get(0).getArticalPic()));
            }

            @Override
            public void onFailure(Call<List<SingleArticle>> call, Throwable t) {
                Log.e("error","failed to request");
            }
        });

        Log.d("clicked","read more");


    }
    public void ReadMore(View view) {
        Log.d("clicked","clicked11111111");
    }

}
