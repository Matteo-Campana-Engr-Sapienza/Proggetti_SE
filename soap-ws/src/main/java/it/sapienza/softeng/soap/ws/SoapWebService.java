package it.sapienza.softeng.soap.ws;

import java.util.List;
import javax.jws.WebService;


@WebService
public interface SoapWebService {

    public Director getDirector(int ID);

    public Movie getMovie(int ID);

    public void setMovie(
            int directorID,
            String title,
            String year
    );

    public void setDirector(
            int ID,
            String name,
            String yearOfBirth
    );

    public List<Movie> getMovies();
}
