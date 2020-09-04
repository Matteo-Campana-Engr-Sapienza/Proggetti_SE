package it.sapienza.softeng.soap.ws;

import java.util.LinkedList;
import java.util.List;

public class SoapWebServiceImpl implements SoapWebService {

    private List<Movie> movies;
    private List<Director> directors;
    private int movieId = 0;

    public SoapWebServiceImpl() {
        movies = new LinkedList<Movie>();
        directors = new LinkedList<Director>();
        
        directors.add(new Director(0,"marco","1961"));
        directors.add(new Director(1,"maria","1983"));
        directors.add(new Director(2,"marco","1981"));
        directors.add(new Director(3,"giovanni","1961"));
        directors.add(new Director(4,"tiziano","1964"));
        
        movies.add(new Movie(0,0,"titleA","34"));
        movies.add(new Movie(1,1,"titleA","34"));
        movies.add(new Movie(2,2,"titleA","34"));
        movies.add(new Movie(3,1,"titleA","34"));
        movies.add(new Movie(4,3,"titleA","34"));
        movies.add(new Movie(5,3,"titleA","34"));
        movies.add(new Movie(6,3,"titleA","34"));
        movies.add(new Movie(7,5,"titleA","34"));
        movies.add(new Movie(8,0,"titleA","34"));
        
    }

    private Movie findMovieById(int id) {
        for (Movie m : movies) {
            if (m.getID() == id) {
                return m;
            }
        }
        return null;
    }

    private Director findDirectorById(int id) {
        for (Director d : directors) {
            if (d.getID() == id) {
                return d;
            }
        }
        return null;
    }

    @Override
    public Director getDirector(int ID) {
        return findDirectorById(ID);
    }

    @Override
    public Movie getMovie(int ID) {
        return findMovieById(ID);
    }

    @Override
    public void setMovie(int directorID, String title, String year) {
        Movie m = new Movie(this.movieId,directorID, title, year);
        movies.add(m);
        this.movieId++;
    }

    @Override
    public void setDirector(int ID, String name, String yearOfBirth) {
        Director d = new Director( ID,  name,  yearOfBirth);
        directors.add(d);
    }

    @Override
    public List<Movie> getMovies() {
        return movies;
    }

}
