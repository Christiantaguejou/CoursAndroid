package com.example.chris.sharemovie.models;

import android.content.Context;

import com.example.chris.sharemovie.R;

import java.util.ArrayList;
import java.util.List;

public class MoviesManager {
    private static final MoviesManager ourInstance = new MoviesManager();

    private List<Movie> movies;
    private List<ItemsMovieList> itemsMovieLists;
    private Context context;

    public synchronized static MoviesManager getInstance() {
        return ourInstance;
    }

    public void setContext(Context cxt) {
        this.context = cxt;
    }

    public synchronized int getSize() {
        if(movies == null) {
            return 0;
        } else return movies.size();
    }

    public synchronized final Movie getMovieById(int id) {
        for(Movie m : movies) {
            if(m.getId() == id)
                return m;
        }
        return null;
    }

    public synchronized final Movie getMovie(int index) {
        if((movies != null) && (index >= 0) && (index < movies.size())) {
            return movies.get(index);
        } else return null;
    }

    public synchronized final List<Movie> getMovies() {
        return movies;
    }

    public synchronized final List<ItemsMovieList> getItemMovies() {
        return itemsMovieLists;
    }

    private MoviesManager() {
        //
    }

    private synchronized void createFilmsList() {
        movies = new ArrayList<>();
        movies.add(new Movie(context.getString(R.string.imitationTitle),
                context.getString(R.string.imitationOriginalTitle),
                context.getString(R.string.imitationDescription),
                context.getDrawable(R.drawable.imitation_game),
                Category.HISTORIQUE,
                context.getString(R.string.imitationKeyWord)));

        movies.add(new Movie(context.getString(R.string.djangoTitle),
                context.getString(R.string.djangoOriginalTitle),
                context.getString(R.string.djangoDescription),
                context.getDrawable(R.drawable.django_unchained),
                Category.ACTION,
                context.getString(R.string.djangoKeyword)));

        movies.add(new Movie(context.getString(R.string.furyTitle),
                context.getString(R.string.furyOriginalTitle),
                context.getString(R.string.furyDescription),
                context.getDrawable(R.drawable.fury),
                Category.GUERRE,
                context.getString(R.string.furyKeyword)));

        movies.add(new Movie(context.getString(R.string.granTorinoTitle),
                context.getString(R.string.granTorinoOriginalTitle),
                context.getString(R.string.granTorinoDescription),
                context.getDrawable(R.drawable.gran_torino),
                Category.DRAMATIQUE,
                context.getString(R.string.granTorinoKeyWord)));

        movies.add(new Movie(context.getString(R.string.huitSalopardsTitle),
                context.getString(R.string.huitSalopardsOrignalTitle),
                context.getString(R.string.huitSalopardsDescription),
                context.getDrawable(R.drawable.huit_salopards),
                Category.WESTERN,
                context.getString(R.string.huitSalopardsKeyword)));

        movies.add(new Movie(context.getString(R.string.inceptionTitle),
                context.getString(R.string.inceptionOrignalTitle),
                context.getString(R.string.inceptionDescription),
                context.getDrawable(R.drawable.inception),
                Category.SCIENCE_FICTION,
                context.getString(R.string.inceptionKeyWord)));

        movies.add(new Movie(context.getString(R.string.interstellarTitle),
                context.getString(R.string.interstellarOriginalTitle),
                context.getString(R.string.interstellarDescription),
                context.getDrawable(R.drawable.interstellar),
                Category.SCIENCE_FICTION,
                context.getString(R.string.interstellarKeyWord)));

        movies.add(new Movie(context.getString(R.string.ipManTitle),
                context.getString(R.string.ipManOriginalTitle),
                context.getString(R.string.ipManDescription),
                context.getDrawable(R.drawable.ip_man),
                Category.ACTION,
                context.getString(R.string.ipManKeyWord)));

        movies.add(new Movie(context.getString(R.string.missionImpossibleTitle),
                context.getString(R.string.missionImpossibleOriginalTitle),
                context.getString(R.string.missionImpossibleDescription),
                context.getDrawable(R.drawable.mission_impossible),
                Category.ESPIONNAGE,
                context.getString(R.string.missionImpossibleKeyWord)));

        movies.add(new Movie(context.getString(R.string.pirateDesCaraibesTitle),
                context.getString(R.string.pirateDesCaraibesOriginalTitle),
                context.getString(R.string.pirateDesCaraibesDescription),
                context.getDrawable(R.drawable.pirate_des_caraibes),
                Category.AVENTURE,
                context.getString(R.string.pirateDesCaraibesKeyWord)));

        movies.add(new Movie(context.getString(R.string.yourNameTitle),
                context.getString(R.string.yourNameOriginalTitle),
                context.getString(R.string.yourNameDescription),
                context.getDrawable(R.drawable.your_name),
                Category.ANIMATION,
                context.getString(R.string.yourNameKeyWord)));

        java.util.Collections.sort(movies);
    }

    private synchronized void createItemMoviesList() {
        itemsMovieLists = new ArrayList<>();

        char currentLetter = movies.get(0).getFirstLetter();
        int countFirstLetter = 0;
        itemsMovieLists.add(new LetterSeparartor(currentLetter));
        itemsMovieLists.add(movies.get(0));
        countFirstLetter++;

        for (int i = 1; i < movies.size(); i++) {
            char letter = movies.get(i).getFirstLetter();
            if(letter != currentLetter) {
                //Add the number of films matching the previous first letter
                itemsMovieLists.add(new NumberMovies(countFirstLetter));
                //Change the letter and display a separator
                currentLetter = letter;
                countFirstLetter = 0;
                itemsMovieLists.add(new LetterSeparartor(currentLetter));
            }
            //Add the current film to the list
            itemsMovieLists.add(movies.get(i));
            countFirstLetter++;
        }
        itemsMovieLists.add(new NumberMovies(countFirstLetter));
    }

    /** Create all movies
     *  Variable 'context' must have been set with setContext function.
     */
    public synchronized void setup() {
        if(context == null) {
            throw new NullPointerException("Context should be set before calling this function");
        }

        createFilmsList();

        createItemMoviesList();
    }
}
