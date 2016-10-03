package com.example.swathi.computersera.rest;

import com.example.swathi.computersera.model.Header;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by user on 9/30/2016.
 */
public interface ApiInterface {

    @GET("getheadings.php")
    Call<List<Header>> getHeader();
}
