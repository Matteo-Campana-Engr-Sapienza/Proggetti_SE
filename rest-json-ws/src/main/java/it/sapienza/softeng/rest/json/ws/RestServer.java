package it.sapienza.softeng.rest.json.ws;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.MediaType;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.lifecycle.SingletonResourceProvider;


public class RestServer {

    public static void main(String[] args) {
        JAXRSServerFactoryBean factoryBean = new JAXRSServerFactoryBean();
        factoryBean.setResourceClasses(ResourcesRepository.class);
        factoryBean.setResourceProvider(
                new SingletonResourceProvider(new ResourcesRepository())
        );

        Map<Object, Object> extensionMappings = new HashMap<Object, Object>();
        extensionMappings.put("json", MediaType.APPLICATION_JSON);
        factoryBean.setExtensionMappings(extensionMappings);

        List<Object> providers = new ArrayList<Object>();
        providers.add(new JacksonJsonProvider());
        factoryBean.setProviders(providers);

        // If you want to run the server normally
        factoryBean.setAddress("http://localhost:8080/");

        // If you want to run the server with Docker
        //factoryBean.setAddress("http://0.0.0.0:7777/");
        org.apache.cxf.endpoint.Server server = factoryBean.create();
        System.out.println("Server up and running");
    }
}
