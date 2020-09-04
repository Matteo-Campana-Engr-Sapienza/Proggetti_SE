package it.sapienenza.softeng.simplesoapws;

import javax.xml.ws.Endpoint;

public class SoapServer {

    public static void main(String[] args) {
        ExamImpl implementor = new ExamImpl();
        String address = "http://localhost:8080/MovieDatabase";
        Endpoint.publish(address, implementor);
        System.out.println("Server ready...");
    }
}
