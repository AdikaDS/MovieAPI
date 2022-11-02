package com.example.taskmoviesapi;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Movie {

    @SerializedName("results")
    private List<Movie> result = null;

    public List<Movie> getResult() {
        return result;
    }

    @SerializedName("poster_path")
    private String posterPath;

    @SerializedName("original_title")
    private String title;

    @SerializedName("overview")
    private String overview;

    public String getPosterPath() {
        return posterPath;
    }

    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }

}
