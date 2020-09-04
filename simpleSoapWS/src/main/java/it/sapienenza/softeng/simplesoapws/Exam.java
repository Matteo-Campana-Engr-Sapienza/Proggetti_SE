package it.sapienenza.softeng.simplesoapws;

import java.util.List;
import javax.jws.WebService;

@WebService
public interface Exam {

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

    public List<Integer> getMovies();
}
