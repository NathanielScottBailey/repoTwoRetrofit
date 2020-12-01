package com.example.versiontworetrofit;

        import androidx.appcompat.app.AppCompatActivity;
        import androidx.recyclerview.widget.DividerItemDecoration;
        import androidx.recyclerview.widget.LinearLayoutManager;
        import androidx.recyclerview.widget.RecyclerView;

        import android.content.Intent;
        import android.os.Bundle;
        import android.util.Log;
        import android.view.View;

        import androidx.appcompat.widget.Toolbar;

        import java.util.ArrayList;

        import retrofit2.Call;
        import retrofit2.Callback;
        import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements mainAdapter.ClickedItem {

    Toolbar toolbar;
    RecyclerView recyclerView;
    mainAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolBar);
        recyclerView = findViewById(R.id.recyclerView);
        Call<ArrayList<String>> nortonJokesCall = ApiClient.getChoices().getJokeChoices();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        adapter = new mainAdapter(this::ClickedUser);

        getChoices();
    }

    public void getChoices(){
        Call<ArrayList<String>> nortonJokesCall = ApiClient.getChoices().getJokeChoices();

        nortonJokesCall.enqueue(new Callback<ArrayList<String>>(){

            @Override
            public void onResponse(Call<ArrayList<String>> call, Response<ArrayList<String>> response) {
                if (response.isSuccessful()){
                    ArrayList<String> serverR = response.body();

                    adapter.setData(serverR);
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<ArrayList<String>> call, Throwable t) {
                Log.e("Failure", t.getLocalizedMessage());
            }
        });
    }

    @Override
    public void ClickedUser(String string) {
        Log.e("Clicked User", string);
        Intent i = new Intent(this, joke_activity.class);
        i.putExtra("chosenJoke", string);
        startActivity(i);
    }
}
