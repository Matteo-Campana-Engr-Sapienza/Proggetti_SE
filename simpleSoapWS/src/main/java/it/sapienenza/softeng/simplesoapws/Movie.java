package it.sapienenza.softeng.simplesoapws;

import java.util.Objects;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Movie {

    private int ID;
    private int directorID;
    private String title;
    private String year;

    public Movie() {
    }

    public Movie(int ID, int directorID, String title, String year) {
        this.ID = ID;
        this.directorID = directorID;
        this.title = title;
        this.year = year;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getDirectorID() {
        return directorID;
    }

    public void setDirectorID(int directorID) {
        this.directorID = directorID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 43 * hash + this.ID;
        hash = 43 * hash + this.directorID;
        hash = 43 * hash + Objects.hashCode(this.title);
        hash = 43 * hash + Objects.hashCode(this.year);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Movie other = (Movie) obj;
        if (this.ID != other.ID) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Movie{" + "ID=" + ID + ", directorID=" + directorID + ", title=" + title + ", year=" + year + '}';
    }

}
