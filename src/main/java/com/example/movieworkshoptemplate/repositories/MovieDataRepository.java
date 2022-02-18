package com.example.movieworkshoptemplate.repositories;

import com.example.movieworkshoptemplate.models.Movie;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MovieDataRepository {
    //Methods to get data from file

    public ArrayList<Movie> getAllMoviesFromData() throws FileNotFoundException {
        ArrayList<Movie> allMovies= new ArrayList<Movie>();
        File dataFile = new File("resources/imdb-data.csv");
        Scanner scan = new Scanner(dataFile);
        scan.nextLine();
        while(scan.hasNextLine()){
            String [] array= scan.nextLine().split(";");/*vi laver et String array til alle atributerne*/
            Movie thisMovie= new Movie( Integer.parseInt(array[0]),
                    Integer.parseInt(array[1]), array[2], array[3], Integer.parseInt(array[4]),array[5]);
            allMovies.add(thisMovie);
        }
        return allMovies;
    }
}
