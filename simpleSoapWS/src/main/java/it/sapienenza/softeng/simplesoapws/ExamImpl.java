package it.sapienenza.softeng.simplesoapws;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;

@WebService(endpointInterface = "it.sapienenza.softeng.simplesoapws.Exam")
public class ExamImpl implements Exam {

    private Connection connection = null;

    public ExamImpl() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:/home/studente/NetBeansProjects/msecs-1-se-2019_07.db");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public Director getDirector(int ID) {
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement("SELECT * FROM DIRECTORS WHERE ID = ?;");
            statement.setInt(1, ID);
            statement.setQueryTimeout(30);

            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return new Director(rs.getInt("ID"),
                        rs.getString("name"),
                        rs.getString("yearOfBirth"));
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return null;

    }

    @Override
    public Movie getMovie(int ID) {
        try {
            PreparedStatement statement;
            statement = connection.prepareStatement("SELECT * FROM MOVIES WHERE ID =?;");
            statement.setInt(1, ID);
            statement.setQueryTimeout(30);

            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return new Movie(rs.getInt("ID"),
                        rs.getInt("directorID"),
                        rs.getString("title"),
                        rs.getString("year"));
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return null;
    }

    @Override
    public List<Integer> getMovies() {

        ArrayList<Integer> movies = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);
            ResultSet rs = statement.executeQuery("SELECT ID FROM MOVIES;");
            while (rs.next()) {
                movies.add(rs.getInt("ID"));
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return movies;
    }

    public void close() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
            }
        }
    }

    @Override
    public void setMovie(int directorID, String title, String year) {
        try {
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);
            statement.executeUpdate("INSERT INTO MOVIES(directorID, title, year) VALUES("
                    + directorID + ", "
                    + "'" + title + "', "
                    + "'" + year + "');");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public void setDirector(int ID, String name, String yearOfBirth) {
        try {
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);
            statement.executeUpdate("INSERT INTO DIRECTORS VALUES("
                    + ID + ","
                    + "'" + name + "' , "
                    + "'" + yearOfBirth + "');");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

}
