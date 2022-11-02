package com.example.taskmoviesapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    public RecyclerView recyclerView;
    private MovieAdapter movieAdapt;
    private ProgressBar progressBar;

    String CATEGORY = "now_playing";
    String API_KEY = "fcecabe1d20e87fc8b84d02d1acf5659";
    String LANGUAGE = "en-US";
    int PAGE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progressBar);
        recyclerView = findViewById(R.id.rv_movie);
        recyclerView.setVisibility(View.INVISIBLE);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        getListMovie();
    }

    private void getListMovie() {

        Call<Movie> caller = RetrofitClient.getInstance().getMyAPI().getMovie(CATEGORY, API_KEY, LANGUAGE, PAGE);
        caller.enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(Call<Movie> call, Response<Movie> response) {
                List<Movie> movies = response.body().getResult();
                movieAdapt = new MovieAdapter(movies, MainActivity.this);
                recyclerView.setAdapter(movieAdapt);
                progressBar.setVisibility(View.GONE);
                recyclerView.setVisibility(View.VISIBLE);
            }

            @Override
            public void onFailure(Call<Movie> call, Throwable t) {

            }
        });
    }
}