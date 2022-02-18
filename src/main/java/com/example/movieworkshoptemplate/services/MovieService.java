package com.example.movieworkshoptemplate.services;

import com.example.movieworkshoptemplate.models.Movie;
import com.example.movieworkshoptemplate.repositories.MovieDataRepository;

import java.io.FileNotFoundException;
import java.util.*;

public class MovieService {
    //Services called from controllers that returns what the client requests - definerer de metoder /opgaver
    MovieDataRepository repo = new MovieDataRepository();

    /*/3.2. /getFirst*/
    public String getFirstMovieTitle() throws FileNotFoundException {
        ArrayList<Movie> allMovies = repo.getAllMoviesFromData();
        return allMovies.get(0).getTitle();
    }
    /*3.3. Get Random*/

    public String getRandomMovieTitle() throws FileNotFoundException {
        Random ran = new Random();
        ArrayList<Movie> allMovie = repo.getAllMoviesFromData();
        int randomMovieTitle = ran.nextInt(allMovie.size());
        return allMovie.get(randomMovieTitle).getTitle();
    }

    public ArrayList<Movie> getTenSortByPopularity() throws FileNotFoundException {
        Random ran1 = new Random();
        ArrayList<Movie> allMovie = repo.getAllMoviesFromData();
        ArrayList<Movie> newlist = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int randM = ran1.nextInt(allMovie.size());
            newlist.add(allMovie.get(randM));
        }
        Collections.sort(newlist);
        return newlist;
    }

    public int howManyWonAwar() throws FileNotFoundException {
        ArrayList<Movie> allmovie = repo.getAllMoviesFromData();
        ArrayList<Movie> listMawards = new ArrayList<>();

        for (int i = 0; i < allmovie.size(); i++) {
            if (allmovie.get(i).isHasWonAward() == true) {
                listMawards.add(allmovie.get(i));
            }
        }
        System.out.println(listMawards);
        return listMawards.size();
    }

    /*3.6 - har lavet en besvarelse uden inddragelse af query String*/
    public ArrayList<Movie> charListN() throws FileNotFoundException {
        ArrayList<Movie> allMovie = repo.getAllMoviesFromData();
        ArrayList<Movie> charListN = new ArrayList<>();
        for (int i = 0; i < allMovie.size(); i++) {
            if (allMovie.get(i).getTitle().contains("nn")) {
                charListN.add(allMovie.get(i));
            }
        }
        return charListN;
    }

    /*3.7 har lavet en besvarelse uden inddragelse af query String, og har ikke lavet en færdig
    * besvarelse - håber det oki - kunne nå den sidste del, men håber du forstår tanke bag, hvordan jeg ville løse den */
    public String returnGenre() throws FileNotFoundException {
        ArrayList<Movie> allMovie = repo.getAllMoviesFromData();
        ArrayList<Movie> comedyList = new ArrayList<>();
        ArrayList<Movie> dramaList = new ArrayList<>();
        for (int i = 0; i < allMovie.size(); i++) {
            if(allMovie.get(i).getSubject()=="Comedy"){
                comedyList.add(allMovie.get(i));
            }
        }

        for(int i=0; i< allMovie.size(); i++){
            if(allMovie.get(i).getSubject()=="Drama"){
                dramaList.add(allMovie.get(i));
            }
        }
        return null;







    }
}
