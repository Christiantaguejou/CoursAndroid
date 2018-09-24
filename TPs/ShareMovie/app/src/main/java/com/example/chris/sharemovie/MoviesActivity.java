package com.example.chris.sharemovie;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.example.chris.sharemovie.adapters.MoviesAdapter;
import com.example.chris.sharemovie.models.Category;
import com.example.chris.sharemovie.models.ItemsMovieList;
import com.example.chris.sharemovie.models.LetterSeparartor;
import com.example.chris.sharemovie.models.Movie;
import com.example.chris.sharemovie.models.NumberMovies;

import java.util.ArrayList;
import java.util.List;

public class MoviesActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private int movieWithSameFirstLetter;
    private ImageView categoriesListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);

        categoriesListView = findViewById(R.id.category_list_btn);
        categoriesListView.setOnClickListener(onClickCategories);

        this.recyclerView = findViewById(R.id.movies_recycler_view);
        MoviesAdapter moviesAdapter = new MoviesAdapter();
        moviesAdapter.setItemsMovieLists(setMovies());
        this.recyclerView.setAdapter(moviesAdapter);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    View.OnClickListener onClickCategories = view -> {
        Intent intent = new Intent(MoviesActivity.this, CategoriesActivity.class);
        startActivity(intent);
    };

    public List<ItemsMovieList> setMovies() {
        List<Movie> movies = new ArrayList<>();

        movies.add(new Movie(getApplicationContext().getString(R.string.imitationTitle),
                getApplicationContext().getString(R.string.imitationOriginalTitle),
                getApplicationContext().getString(R.string.imitationDescription),
                getApplicationContext().getDrawable(R.drawable.imitation_game),
                Category.HISTORIQUE,
                getApplicationContext().getString(R.string.imitationKeyWord)));

        movies.add(new Movie(getApplicationContext().getString(R.string.djangoTitle),
                getApplicationContext().getString(R.string.djangoOriginalTitle),
                getApplicationContext().getString(R.string.djangoDescription),
                getApplicationContext().getDrawable(R.drawable.django_unchained),
                Category.ACTION,
                getApplicationContext().getString(R.string.djangoKeyword)));

        movies.add(new Movie(getApplicationContext().getString(R.string.furyTitle),
                getApplicationContext().getString(R.string.furyOriginalTitle),
                getApplicationContext().getString(R.string.furyDescription),
                getApplicationContext().getDrawable(R.drawable.fury),
                Category.GUERRE,
                getApplicationContext().getString(R.string.furyKeyword)));

        movies.add(new Movie(getApplicationContext().getString(R.string.granTorinoTitle),
                getApplicationContext().getString(R.string.granTorinoOriginalTitle),
                getApplicationContext().getString(R.string.granTorinoDescription),
                getApplicationContext().getDrawable(R.drawable.gran_torino),
                Category.DRAMATIQUE,
                getApplicationContext().getString(R.string.granTorinoKeyWord)));

        movies.add(new Movie(getApplicationContext().getString(R.string.huitSalopardsTitle),
                getApplicationContext().getString(R.string.huitSalopardsOrignalTitle),
                getApplicationContext().getString(R.string.huitSalopardsDescription),
                getApplicationContext().getDrawable(R.drawable.huit_salopards),
                Category.WESTERN,
                getApplicationContext().getString(R.string.huitSalopardsKeyword)));

        movies.add(new Movie(getApplicationContext().getString(R.string.inceptionTitle),
                getApplicationContext().getString(R.string.inceptionOrignalTitle),
                getApplicationContext().getString(R.string.inceptionDescription),
                getApplicationContext().getDrawable(R.drawable.inception),
                Category.SCIENCE_FICTION,
                getApplicationContext().getString(R.string.inceptionKeyWord)));

        movies.add(new Movie(getApplicationContext().getString(R.string.interstellarTitle),
                getApplicationContext().getString(R.string.interstellarOriginalTitle),
                getApplicationContext().getString(R.string.interstellarDescription),
                getApplicationContext().getDrawable(R.drawable.interstellar),
                Category.SCIENCE_FICTION,
                getApplicationContext().getString(R.string.interstellarKeyWord)));

        movies.add(new Movie(getApplicationContext().getString(R.string.ipManTitle),
                getApplicationContext().getString(R.string.ipManOriginalTitle),
                getApplicationContext().getString(R.string.ipManDescription),
                getApplicationContext().getDrawable(R.drawable.ip_man),
                Category.ACTION,
                getApplicationContext().getString(R.string.ipManKeyWord)));

        movies.add(new Movie(getApplicationContext().getString(R.string.missionImpossibleTitle),
                getApplicationContext().getString(R.string.missionImpossibleOriginalTitle),
                getApplicationContext().getString(R.string.missionImpossibleDescription),
                getApplicationContext().getDrawable(R.drawable.mission_impossible),
                Category.ESPIONNAGE,
                getApplicationContext().getString(R.string.missionImpossibleKeyWord)));

        movies.add(new Movie(getApplicationContext().getString(R.string.pirateDesCaraibesTitle),
                getApplicationContext().getString(R.string.pirateDesCaraibesOriginalTitle),
                getApplicationContext().getString(R.string.pirateDesCaraibesDescription),
                getApplicationContext().getDrawable(R.drawable.pirate_des_caraibes),
                Category.AVENTURE,
                getApplicationContext().getString(R.string.pirateDesCaraibesKeyWord)));

        movies.add(new Movie(getApplicationContext().getString(R.string.yourNameTitle),
                getApplicationContext().getString(R.string.yourNameOriginalTitle),
                getApplicationContext().getString(R.string.yourNameDescription),
                getApplicationContext().getDrawable(R.drawable.your_name),
                Category.ANIMATION,
                getApplicationContext().getString(R.string.yourNameKeyWord)));

        java.util.Collections.sort(movies);

        List<ItemsMovieList> itemsMovieLists = new ArrayList<>();
        itemsMovieLists.add(new LetterSeparartor(movies.get(0).getTitle().charAt(0)));
        itemsMovieLists.add(movies.get(0));
        movieWithSameFirstLetter++;

        for (int i = 1; i < movies.size(); i++) {
            if(movies.get(i).getTitle().charAt(0) - movies.get(i-1).getTitle().charAt(0) > 0) {
                itemsMovieLists.add(new NumberMovies(movieWithSameFirstLetter));
                movieWithSameFirstLetter = 1;
                itemsMovieLists.add(new LetterSeparartor(movies.get(i).getTitle().charAt(0)));
                itemsMovieLists.add(movies.get(i));

                if (i == movies.size() - 1){
                    itemsMovieLists.add(new NumberMovies(movieWithSameFirstLetter));
                }
            }
            else {
                itemsMovieLists.add(movies.get(i));
                movieWithSameFirstLetter++;
            }
        }

//        itemsMovieLists.forEach(m -> {
//            System.out.println(m.toString());
//        });

        return itemsMovieLists;
    }
}
