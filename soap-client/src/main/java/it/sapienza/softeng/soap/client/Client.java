package it.sapienza.softeng.soap.client;

import it.sapienza.softeng.soap.ws.*;
import java.util.List;

public class Client {

    public Client() {
        SoapWebServiceImplService sis = new SoapWebServiceImplService();
        SoapWebService port = sis.getSoapWebServiceImplPort();

        List<Movie> movies = port.getMovies();

        for (Movie m : movies) {
            System.out.println(m.getTitle());
        }
    }
    
    public static void main(String[] args) {
        Client c = new Client();
    }

}
