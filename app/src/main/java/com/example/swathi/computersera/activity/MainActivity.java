package com.example.swathi.computersera.activity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.swathi.computersera.R;
import com.example.swathi.computersera.adapter.ArticleAdapter;
import com.example.swathi.computersera.adapter.HeaderAdapter;
import com.example.swathi.computersera.adapter.HeaderSpinnerAdapter;
import com.example.swathi.computersera.model.Article;
import com.example.swathi.computersera.model.Header;
import com.example.swathi.computersera.model.SingleArticle;
import com.example.swathi.computersera.rest.ApiClient;
import com.example.swathi.computersera.rest.ApiInterface;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import com.squareup.picasso.Picasso;



public class MainActivity extends AppCompatActivity {

    public Integer ArticleId  = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.header_recycler_view);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<List<Article>> articleCall = apiInterface.getArticle(10,1);

        articleCall.enqueue(new Callback<List<Article>>() {
            @Override
            public void onResponse(Call<List<Article>> call, Response<List<Article>> response) {
                List<Article> articles = response.body();
                //Log.d("response is",response.body().toString());
                recyclerView.setAdapter(new ArticleAdapter(articles,R.layout.article_item_layout,getApplicationContext()));

            }

            @Override
            public void onFailure(Call<List<Article>> call, Throwable t) {

            }
        });
        Call<List<Header>> call = apiInterface.getHeader();
        call.enqueue(new Callback<List<Header>>() {
            @Override
            public void onResponse(Call<List<Header>> call, Response<List<Header>> response) {

                List<Header> headers = response.body();
                String[] header_array = new String[headers.size()];
                //Log.d("response is",response.body().toString());
                Spinner spinner = (Spinner) findViewById(R.id.headerList);
                for(int i=0; i<headers.size();i++)
                {
                    header_array[i] = headers.get(i).getHeading().toString();
                }

                //spinner.setBackground(ContextCompat.getColor(getApplicationContext(),R.color.colorPrimaryDark));
                spinner.setAdapter(new HeaderSpinnerAdapter(headers,getApplicationContext()));



               // ArrayAdapter adapter = ArrayAdapter.createFromResource(getApplicationContext(),header_array,android.R.layout.simple_spinner_dropdown_item);

                //spinner.setAdapter(adapter);
                //recyclerView.setAdapter(new HeaderAdapter(headers,R.layout.list_item_view,getApplicationContext()));
                //List<Header> headers = response.toString();
            }

            @Override
            public void onFailure(Call<List<Header>> call, Throwable t) {

            }
        });
    }

    public static void getArticalDetails(final Context context, int id, View v) {
        LayoutInflater inflator = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View view = inflator.inflate(R.layout.artical_detail_layout,null,false);

        //Log.d("clicked","within function");
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

                TextView titleTxt = (TextView) view.findViewById(R.id.detailTitleTxt);
                //Log.d("clicked","title is "+title);

                titleTxt.setText(title);
            }

            @Override
            public void onFailure(Call<List<SingleArticle>> call, Throwable t) {
                //Log.e("error","failed to request");
            }
        });

    }


    public void ReadMore(View view) {

        //ImageLoader imageLoader=new  ImageLoader(activity.getApplicationContext());

        //Log.d("tag",view.getTag().toString());
        ArticleId = Integer.valueOf(view.getTag().toString());
        /*
        //Log.d("clicked","came inside function");
        try {
            Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
            startActivity(intent);
            //Log.d("clicked","in intent");

        }catch (IllegalStateException e){
            //Log.d("exception"," "+e);
        }*/

        setContentView(R.layout.artical_detail_layout);

        int id = ArticleId;

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
                //Log.d("clicked","title is "+title);
                // Intent intent = new Intent(getApplicationContext(),DetailActivity.class);
                //startActivity(intent);

                titleTxt.setText(title);

                TextView postedByTxt = (TextView) findViewById(R.id.detailPublishedBytxt);
                postedByTxt.setText(postedBy);

                TextView postedOnTxt = (TextView) findViewById(R.id.detailsPublishedDate);
                postedOnTxt.setText(postedOn);

                TextView descriptionTxt = (TextView) findViewById(R.id.detailDescription);
                descriptionTxt.setText(Html.fromHtml(description));

                Log.d("article image",image);
                ImageView articleImg = (ImageView) findViewById(R.id.detailImage);
                Picasso.with(getApplicationContext()).load(Uri.parse(article.get(0).getArticalPic())).into(articleImg);
                //articleImg.setImageURI(Uri.parse(article.get(0).getArticalPic()));
            }

            @Override
            public void onFailure(Call<List<SingleArticle>> call, Throwable t) {
               // Log.e("error","failed to request");
            }
        });

        //Log.d("clicked","read more");


    }

    public void loadHome(View view) {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);

    }
}
