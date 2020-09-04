
package it.sapienza.softeng.soap.ws;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.8
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "SoapWebServiceImplService", targetNamespace = "http://ws.soap.softeng.sapienza.it/", wsdlLocation = "http://localhost:8080/MovieDatabase/?wsdl")
public class SoapWebServiceImplService
    extends Service
{

    private final static URL SOAPWEBSERVICEIMPLSERVICE_WSDL_LOCATION;
    private final static WebServiceException SOAPWEBSERVICEIMPLSERVICE_EXCEPTION;
    private final static QName SOAPWEBSERVICEIMPLSERVICE_QNAME = new QName("http://ws.soap.softeng.sapienza.it/", "SoapWebServiceImplService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/MovieDatabase/?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        SOAPWEBSERVICEIMPLSERVICE_WSDL_LOCATION = url;
        SOAPWEBSERVICEIMPLSERVICE_EXCEPTION = e;
    }

    public SoapWebServiceImplService() {
        super(__getWsdlLocation(), SOAPWEBSERVICEIMPLSERVICE_QNAME);
    }

    public SoapWebServiceImplService(WebServiceFeature... features) {
        super(__getWsdlLocation(), SOAPWEBSERVICEIMPLSERVICE_QNAME, features);
    }

    public SoapWebServiceImplService(URL wsdlLocation) {
        super(wsdlLocation, SOAPWEBSERVICEIMPLSERVICE_QNAME);
    }

    public SoapWebServiceImplService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, SOAPWEBSERVICEIMPLSERVICE_QNAME, features);
    }

    public SoapWebServiceImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public SoapWebServiceImplService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns SoapWebService
     */
    @WebEndpoint(name = "SoapWebServiceImplPort")
    public SoapWebService getSoapWebServiceImplPort() {
        return super.getPort(new QName("http://ws.soap.softeng.sapienza.it/", "SoapWebServiceImplPort"), SoapWebService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns SoapWebService
     */
    @WebEndpoint(name = "SoapWebServiceImplPort")
    public SoapWebService getSoapWebServiceImplPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://ws.soap.softeng.sapienza.it/", "SoapWebServiceImplPort"), SoapWebService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (SOAPWEBSERVICEIMPLSERVICE_EXCEPTION!= null) {
            throw SOAPWEBSERVICEIMPLSERVICE_EXCEPTION;
        }
        return SOAPWEBSERVICEIMPLSERVICE_WSDL_LOCATION;
    }

}
