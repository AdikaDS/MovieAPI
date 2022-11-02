package com.example.taskmoviesapi;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {

    private List<Movie> movie;
    private Context context;

    public MovieAdapter(List<Movie> movie, Context context) {
        this.movie = movie;
        this.context = context;
    }

    @NonNull
    @Override
    public MovieAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_movie, parent, false);

        MovieAdapter.ViewHolder viewHolder = new MovieAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MovieAdapter.ViewHolder holder, int position) {
        Movie movies = movie.get(position);
        holder.txtNama.setText(movies.getTitle());
        Glide.with(holder.itemView.getContext()).
                load("https://image.tmdb.org/t/p/w185" + movies.getPosterPath()).
                into(holder.imgPict);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), DetailMovie.class);
                intent.putExtra("judul", movies.getTitle());
                intent.putExtra("desk", movies.getOverview());
                intent.putExtra("gambar", movies.getPosterPath());
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return movie.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtNama;
        ImageView imgPict;
        RelativeLayout relativeLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtNama = itemView.findViewById(R.id.judul_movie);
            imgPict = itemView.findViewById(R.id.gambar_movie);
            relativeLayout = itemView.findViewById(R.id.rv_movie);
        }
    }
}

