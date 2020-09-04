package it.sapienza.softeng.rest.client;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class Client {

    private static final String BASE_URL = "http://localhost:8080/atenei/";
    private static CloseableHttpClient client;

    public static void createClient() {
        client = HttpClients.createDefault();
    }

    public static void closeClient() throws IOException {
        client.close();
    }

    public static void main(String[] args) throws IOException, JAXBException {
        /*
        XML MESSAGES
         */
        createClient();

        Ateneo sapienza = getAteneo("0");
        if (sapienza != null) {
            System.out.print(sapienza.toString() + "\n\n");
        }
        //System.out.print("get studente ateneoId : 1 , studenteId : 4");
        Studente studente_0 = getStudente("1", "4");
        if (studente_0 != null) {
            System.out.print(studente_0.toString() + "\n\n");
        }
        
        System.out.println("\nPost Bicocca\n\n");
        postAteneo("Bicocca");

        Ateneo Bicocca = getAteneo("3");
        if (Bicocca != null) {
            System.out.println("\n" + Bicocca.toString() + "\n\n");
        }
        
        System.out.println("\nPost PierGiorgio\n\n");
        postStudente("2", "PierGiorgio");

        Studente studente_9 = getStudente("2", "12");
        if (studente_9 != null) {
            System.out.print(studente_9.toString() + "\n\n");
        }
        
        System.out.println("\nDelete Ateneo 3 \n\n");
        deleteAteneo("3");

        Bicocca = getAteneo("3");
        if (Bicocca != null) {
            System.out.println("\n\n" + Bicocca.toString() + "\n\n");
        }

    }

    private static Ateneo getAteneo(String ID) throws IOException {

        HttpGet httpGet = new HttpGet(BASE_URL + ID);
        httpGet.setHeader("Content-Type", "text/xml");

        HttpResponse response = client.execute(httpGet);
        if (response.getEntity() == null) {
            System.out.println("\nResource not found : AteneoId = "+ID);
            return null;
        } else {
            //System.out.print("\nGet effettuata.\nRisposta:\n" + response.toString() + "\nResponse Entity:\t" + response.getEntity().getContent().toString());
            Ateneo resFromGet = JAXB.unmarshal(response.getEntity().getContent(), Ateneo.class);
            //System.out.print("\n\nUnmarshall:\t" + resFromGet.toString() + "\n\n");
            return resFromGet;
        }

    }

    private static Studente getStudente(String atenoId, String studenteId) throws IOException {
        /*
        try {
            final URL url = new URL(BASE_URL + atenoId + "/studenti/" + studenteId);
            final InputStream input = url.openStream();
            InputStreamReader isr = new InputStreamReader(input);
            
            JAXBContext jaxbContext = JAXBContext.newInstance(Studente.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Studente studente = (Studente) jaxbUnmarshaller.unmarshal(isr);
            return studente;
        } catch (MalformedURLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JAXBException ex) {
            System.out.println("\nrisorsa non trovata\n");
            return null;
        } catch (IOException ex) {
            System.out.println("\nrisorsa non trovata\n");
            return null;
        }
        return null;
         */

        HttpGet httpGet = new HttpGet(BASE_URL + atenoId + "/studenti/" + studenteId);
        httpGet.setHeader("Content-Type", "text/xml");

        HttpResponse response = client.execute(httpGet);
        if (response.getEntity() == null) {
            System.out.println("\nResource not found : studenteId = "+studenteId);
            return null;
        } else {
            //System.out.print("\nGet effettuata.\nRisposta:\n" + response.toString() + "\nResponse Entity:\t" + response.getEntity().getContent().toString());
            Studente resFromGet = JAXB.unmarshal(response.getEntity().getContent(), Studente.class);
            //System.out.print("\n\nUnmarshall:\t" + resFromGet.toString() + "\n\n");
            return resFromGet;
        }
    }

    private int ateneo_id_counter = 2;

    private static void postAteneo(String name) throws JAXBException, FileNotFoundException, IOException {

        Ateneo ateneo = new Ateneo();
        ateneo.setName(name);

        HttpPost httpPost = new HttpPost(BASE_URL);

        JAXBContext jaxbContext = JAXBContext.newInstance(Ateneo.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.marshal(ateneo, new File("ateneo.xml"));
        File file = new File("ateneo.xml");
        InputStream targetStream = new FileInputStream(file);

        httpPost.setEntity(new InputStreamEntity(targetStream));

        httpPost.setHeader("Content-Type", "text/xml");
        HttpResponse response = client.execute(httpPost);
        //System.out.print("\nPost con risorsa:\n" + ateneo.toString() + "\neseguita con esito:\t" + response.getStatusLine());
    }

    private static void postStudente(String ateneoId, String name) throws JAXBException, FileNotFoundException, IOException {

        Studente studente = new Studente();
        studente.setName(name);

        HttpPost httpPost = new HttpPost(BASE_URL + ateneoId);

        JAXBContext jaxbContext = JAXBContext.newInstance(Studente.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.marshal(studente, new File("studente.xml"));
        File file = new File("studente.xml");
        InputStream targetStream = new FileInputStream(file);

        httpPost.setEntity(new InputStreamEntity(targetStream));

        httpPost.setHeader("Content-Type", "text/xml");
        HttpResponse response = client.execute(httpPost);
        //System.out.print("\nPost con risorsa:\n" + studente.toString() + "\neseguita con esito:\t" + response.getStatusLine());
    }

    private static void deleteAteneo(String Id) throws IOException {
        HttpDelete httpDelete = new HttpDelete(BASE_URL + Id);
        HttpResponse response = client.execute(httpDelete);
        //System.out.print("\nDelete con risorsa:\n" + Id + "\neseguita con esito:\t" + response.getStatusLine());
    }

}
