package it.sapienenza.softeng.simplesoapws;

import java.util.Objects;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Director {

    private int ID;
    private String name;
    private String yearOfBirth;

    public Director() {
    }
    
    

    public Director(int ID, String name, String yearOfBirth) {
        this.ID = ID;
        this.name = name;
        this.yearOfBirth = yearOfBirth;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(String yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.ID;
        hash = 97 * hash + Objects.hashCode(this.name);
        hash = 97 * hash + Objects.hashCode(this.yearOfBirth);
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
        final Director other = (Director) obj;
        if (this.ID != other.ID) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Director{" + "ID=" + ID + ", name=" + name + ", yearOfBirth=" + yearOfBirth + '}';
    }

}
