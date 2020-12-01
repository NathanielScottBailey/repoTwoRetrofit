package com.example.versiontworetrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class joke_activity extends AppCompatActivity {

    TextView joke;
    String serverR;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_activity);
        Intent intent = getIntent();
        String chosenJoke = intent.getExtras().getString("chosenJoke");

        Call<actualJoke> actualJokeCall = ApiClient.getChoices().getActualJoke(chosenJoke);

        actualJokeCall.enqueue(new Callback<actualJoke>(){



            @Override
            public void onFailure(Call<actualJoke> call, Throwable t) {
                Log.e("Failure", t.getLocalizedMessage());
            }

            @Override
            public void onResponse(Call<actualJoke> call, Response<actualJoke> response) {
                if (response.isSuccessful()){
                    serverR = response.body().getValue();

                    Log.e("Hey here is the goods", serverR);
                    joke = (TextView) findViewById(R.id.jokeText);
                    joke.setText(serverR);

                }
            }


        });



    }
}