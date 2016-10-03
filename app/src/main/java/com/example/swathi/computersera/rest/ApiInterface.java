package com.example.swathi.computersera.rest;

import com.example.swathi.computersera.model.Article;
import com.example.swathi.computersera.model.Header;
import com.example.swathi.computersera.model.SingleArticle;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by user on 9/30/2016.
 */
public interface ApiInterface {

    @GET("getheadings.php")
    Call<List<Header>> getHeader();

    @GET("getarticles.php")
    Call<List<Article>> getArticle(@Query("id") int id, @Query("page") int page );

    @GET("getarticledetails.php")
    Call<List<SingleArticle>> getArticledetails(@Query("id") int id);
}