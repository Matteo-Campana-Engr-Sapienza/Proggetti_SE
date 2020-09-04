package it.sapienza.softeng.rest.xml.db.ws;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.MediaType;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.lifecycle.SingletonResourceProvider;
import org.apache.cxf.jaxrs.provider.JAXBElementProvider;

public class RestServer {

    public static void main(String[] args) {

        JAXRSServerFactoryBean factoryBean = new JAXRSServerFactoryBean();
        factoryBean.setResourceClasses(ResourcesRepository.class);
        factoryBean.setResourceProvider(
                new SingletonResourceProvider(new ResourcesRepository())
        );

        Map<Object, Object> extensionMappings = new HashMap<Object, Object>();
        extensionMappings.put("xml", MediaType.APPLICATION_XML);
        factoryBean.setExtensionMappings(extensionMappings);

        List<Object> providers = new ArrayList<Object>();
        providers.add(new JAXBElementProvider());
        factoryBean.setProviders(providers);

        factoryBean.setAddress("http://localhost:8080/");

        org.apache.cxf.endpoint.Server server = factoryBean.create();
        System.out.println("Server up and running");

    }

}
