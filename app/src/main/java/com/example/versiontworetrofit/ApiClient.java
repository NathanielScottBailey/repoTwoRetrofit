package com.example.versiontworetrofit;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static Retrofit getRetrofit(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.chucknorris.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;
    }
    public static nortonJokeService  getChoices(){
        nortonJokeService jokeService = getRetrofit().create(nortonJokeService.class);
        return jokeService;
    }
}
