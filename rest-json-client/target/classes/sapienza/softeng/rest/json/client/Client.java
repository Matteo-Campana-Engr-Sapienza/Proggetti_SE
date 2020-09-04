package it.sapienza.softeng.rest.json.client;

import com.google.gson.Gson;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.charset.StandardCharsets;
import javax.xml.bind.JAXBException;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class Client {

    private static final String BASE_URL = "http://localhost:8080/atenei/";
    private static CloseableHttpClient client;

    public static void createClient() {
        client = HttpClients.createDefault();
    }

    public static void closeClient() throws IOException {
        client.close();
    }

    public static void main(String[] args) throws IOException, JAXBException, MalformedURLException {

        /*
        JSON MESSAGES
         */
        createClient();

        getAteneo("0");

        System.out.println("\n\n");

        getStudente("0", "1");

        System.out.println("\n\n");

        postAteneo("Bicocca");
        System.out.println("\n");
        getAteneo("3");

        System.out.println("\n\n");

        postStudente("0", "Gianfranco");
        
        System.out.println("\n\n");
        
        deleteAteneo("3");
        getAteneo("3");
        
        System.out.println("\n\n");
        
        deleteStudente("0","12");
        getStudente("0", "12");

    }

    private static Ateneo getAteneo(String ateneoId) throws IOException {
        HttpResponse response;
        Gson gson = new Gson();

        // GET
        HttpGet httpGet = new HttpGet(BASE_URL + ateneoId);
        httpGet.setHeader("Content-Type", "application/json");
        httpGet.setHeader("Accept", "application/json");
        response = client.execute(httpGet);
        if (response.getEntity() == null) {
            System.out.println("Resource not found");
        } else {
            System.out.print(
                    "\nGet effettuata.\n"
                    + "Content Type Risposta:\n" + response.getEntity().getContentType()
                    + "\nResponse Entity:\t" + response.getEntity().getContent().toString()
            );
            Ateneo resJSON = (Ateneo) gson.fromJson(EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8), Ateneo.class);
            if (resJSON == null) {
                System.out.println("\n\nResource not found");
                return null;
            } else {
                System.out.print("\n\nrisorsa JSON:\t" + resJSON.toString());
                return resJSON;
            }
        }
        return null;
    }

    private static Studente getStudente(String ateneoId, String studenteId) throws IOException {
        HttpResponse response;
        Gson gson = new Gson();

        // GET
        HttpGet httpGet = new HttpGet(BASE_URL + ateneoId + "/studenti/" + studenteId);
        httpGet.setHeader("Content-Type", "application/json");
        httpGet.setHeader("Accept", "application/json");
        response = client.execute(httpGet);
        if (response.getEntity() == null) {
            System.out.println("Resource not found");
        } else {
            System.out.print(
                    "\nGet effettuata.\n"
                    + "Content Type Risposta:\n" + response.getEntity().getContentType()
                    + "\nResponse Entity:\t" + response.getEntity().getContent().toString()
            );
            Studente resJSON = (Studente) gson.fromJson(EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8), Studente.class);
            if (resJSON == null) {
                System.out.println("\n\nResource not found");
                return null;
            } else {
                System.out.print("\n\nrisorsa JSON:\t" + resJSON.toString());
                return resJSON;
            }
        }
        return null;
    }

    private static void postAteneo(String name) throws IOException {
        HttpResponse response;
        Gson gson = new Gson();
        HttpGet httpGet = new HttpGet(BASE_URL);

        Ateneo ateneo = new Ateneo();
        ateneo.setName(name);

        HttpPost httpPost = new HttpPost(BASE_URL);
        //creazione dummy file
        BufferedWriter writer = new BufferedWriter(new FileWriter("ateneo.json"));
        writer.write(gson.toJson(ateneo));
        writer.close();

        File file = new File("ateneo.json");
        FileInputStream targetStream = new FileInputStream(file);
        httpPost.setEntity(new InputStreamEntity(targetStream));

        httpPost.setHeader("Content-Type", "application/json");
        httpGet.setHeader("Accept", "application/json");
        response = client.execute(httpPost);
        System.out.print("\nPost con risorsa:\n" + ateneo.toString() + "\neseguita con esito:\t" + response.getStatusLine());
    }

    private static void postStudente(String ateneoId, String name) throws IOException {
        HttpResponse response;
        Gson gson = new Gson();
        HttpGet httpGet = new HttpGet(BASE_URL + ateneoId);

        Studente studente = new Studente();
        studente.setName(name);

        HttpPost httpPost = new HttpPost(BASE_URL + ateneoId);
        //creazione dummy file
        BufferedWriter writer = new BufferedWriter(new FileWriter("studente.json"));
        writer.write(gson.toJson(studente));
        writer.close();

        File file = new File("studente.json");
        FileInputStream targetStream = new FileInputStream(file);
        httpPost.setEntity(new InputStreamEntity(targetStream));

        httpPost.setHeader("Content-Type", "application/json");
        httpGet.setHeader("Accept", "application/json");
        response = client.execute(httpPost);
        System.out.print("\nPost con risorsa:\n" + studente.toString() + "\neseguita con esito:\t" + response.getStatusLine());
    }

    private static void deleteAteneo(String Id) throws IOException {
        HttpDelete httpDelete = new HttpDelete(BASE_URL + Id);
        HttpResponse response = client.execute(httpDelete);
    }
    
        private static void deleteStudente(String ateneoId,String StudenteId) throws IOException {
        HttpDelete httpDelete = new HttpDelete(BASE_URL + ateneoId+"/studenti/"+StudenteId);
        HttpResponse response = client.execute(httpDelete);
    }

}
