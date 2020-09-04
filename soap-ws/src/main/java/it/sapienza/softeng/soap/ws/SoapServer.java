
package it.sapienza.softeng.soap.ws;



import javax.xml.ws.Endpoint;

public class SoapServer {

    public static void main(String[] args) {
        SoapWebServiceImpl implementor = new SoapWebServiceImpl();
        String address = "http://localhost:8080/MovieDatabase";
        Endpoint.publish(address, implementor);
        System.out.println("Server ready...");
    }
}

