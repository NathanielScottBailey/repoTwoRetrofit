package com.example.versiontworetrofit;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface nortonJokeService {

    @GET("jokes/categories")
    Call<ArrayList<String>> getJokeChoices();


    @GET("jokes/random")
    public Call<actualJoke> getActualJoke(@Query("category") String jokeContent);

}
