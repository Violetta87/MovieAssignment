package com.example.movieworkshoptemplate.controllers;

import com.example.movieworkshoptemplate.models.Movie;
import com.example.movieworkshoptemplate.services.MovieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.util.ArrayList;

@RestController
public class MovieController {
    //Controller methods
    MovieService mS = new MovieService();
    /*3.1*/
    @GetMapping("/")
    public String index(){
        return "Hello World welcome to my application";
    }
    /*3.2*/
    @GetMapping("/first")
    public String first() throws FileNotFoundException {
        //Titel Første film
        return mS.getFirstMovieTitle();
    }
    /*3.3*/
    @GetMapping("/rand")
    public String rand() throws FileNotFoundException{
        return mS.getRandomMovieTitle();
    }
    /*3.4*/
    @GetMapping("/10randlist")
    public ArrayList<Movie> randlist() throws FileNotFoundException {
        return mS.getTenSortByPopularity();
    }
    /*3.5*/
    @GetMapping("/AwardListe")
    public int AwardList() throws FileNotFoundException {
        return mS.howManyWonAwar();
    }
    @GetMapping("/CharListN")
    public ArrayList<Movie> charListN() throws FileNotFoundException {
        return mS.charListN();
    }



}
