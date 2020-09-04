
package it.sapienza.softeng.soap.ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the it.sapienza.softeng.soap.ws package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetDirectorResponse_QNAME = new QName("http://ws.soap.softeng.sapienza.it/", "getDirectorResponse");
    private final static QName _SetMovieResponse_QNAME = new QName("http://ws.soap.softeng.sapienza.it/", "setMovieResponse");
    private final static QName _GetMovie_QNAME = new QName("http://ws.soap.softeng.sapienza.it/", "getMovie");
    private final static QName _GetMoviesResponse_QNAME = new QName("http://ws.soap.softeng.sapienza.it/", "getMoviesResponse");
    private final static QName _SetDirectorResponse_QNAME = new QName("http://ws.soap.softeng.sapienza.it/", "setDirectorResponse");
    private final static QName _GetDirector_QNAME = new QName("http://ws.soap.softeng.sapienza.it/", "getDirector");
    private final static QName _GetMovieResponse_QNAME = new QName("http://ws.soap.softeng.sapienza.it/", "getMovieResponse");
    private final static QName _SetMovie_QNAME = new QName("http://ws.soap.softeng.sapienza.it/", "setMovie");
    private final static QName _SetDirector_QNAME = new QName("http://ws.soap.softeng.sapienza.it/", "setDirector");
    private final static QName _GetMovies_QNAME = new QName("http://ws.soap.softeng.sapienza.it/", "getMovies");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: it.sapienza.softeng.soap.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetMovieResponse }
     * 
     */
    public GetMovieResponse createGetMovieResponse() {
        return new GetMovieResponse();
    }

    /**
     * Create an instance of {@link SetMovie }
     * 
     */
    public SetMovie createSetMovie() {
        return new SetMovie();
    }

    /**
     * Create an instance of {@link SetDirector }
     * 
     */
    public SetDirector createSetDirector() {
        return new SetDirector();
    }

    /**
     * Create an instance of {@link GetMovies }
     * 
     */
    public GetMovies createGetMovies() {
        return new GetMovies();
    }

    /**
     * Create an instance of {@link GetMoviesResponse }
     * 
     */
    public GetMoviesResponse createGetMoviesResponse() {
        return new GetMoviesResponse();
    }

    /**
     * Create an instance of {@link SetDirectorResponse }
     * 
     */
    public SetDirectorResponse createSetDirectorResponse() {
        return new SetDirectorResponse();
    }

    /**
     * Create an instance of {@link GetDirector }
     * 
     */
    public GetDirector createGetDirector() {
        return new GetDirector();
    }

    /**
     * Create an instance of {@link GetMovie }
     * 
     */
    public GetMovie createGetMovie() {
        return new GetMovie();
    }

    /**
     * Create an instance of {@link GetDirectorResponse }
     * 
     */
    public GetDirectorResponse createGetDirectorResponse() {
        return new GetDirectorResponse();
    }

    /**
     * Create an instance of {@link SetMovieResponse }
     * 
     */
    public SetMovieResponse createSetMovieResponse() {
        return new SetMovieResponse();
    }

    /**
     * Create an instance of {@link Movie }
     * 
     */
    public Movie createMovie() {
        return new Movie();
    }

    /**
     * Create an instance of {@link Director }
     * 
     */
    public Director createDirector() {
        return new Director();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDirectorResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.soap.softeng.sapienza.it/", name = "getDirectorResponse")
    public JAXBElement<GetDirectorResponse> createGetDirectorResponse(GetDirectorResponse value) {
        return new JAXBElement<GetDirectorResponse>(_GetDirectorResponse_QNAME, GetDirectorResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetMovieResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.soap.softeng.sapienza.it/", name = "setMovieResponse")
    public JAXBElement<SetMovieResponse> createSetMovieResponse(SetMovieResponse value) {
        return new JAXBElement<SetMovieResponse>(_SetMovieResponse_QNAME, SetMovieResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMovie }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.soap.softeng.sapienza.it/", name = "getMovie")
    public JAXBElement<GetMovie> createGetMovie(GetMovie value) {
        return new JAXBElement<GetMovie>(_GetMovie_QNAME, GetMovie.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMoviesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.soap.softeng.sapienza.it/", name = "getMoviesResponse")
    public JAXBElement<GetMoviesResponse> createGetMoviesResponse(GetMoviesResponse value) {
        return new JAXBElement<GetMoviesResponse>(_GetMoviesResponse_QNAME, GetMoviesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetDirectorResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.soap.softeng.sapienza.it/", name = "setDirectorResponse")
    public JAXBElement<SetDirectorResponse> createSetDirectorResponse(SetDirectorResponse value) {
        return new JAXBElement<SetDirectorResponse>(_SetDirectorResponse_QNAME, SetDirectorResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDirector }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.soap.softeng.sapienza.it/", name = "getDirector")
    public JAXBElement<GetDirector> createGetDirector(GetDirector value) {
        return new JAXBElement<GetDirector>(_GetDirector_QNAME, GetDirector.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMovieResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.soap.softeng.sapienza.it/", name = "getMovieResponse")
    public JAXBElement<GetMovieResponse> createGetMovieResponse(GetMovieResponse value) {
        return new JAXBElement<GetMovieResponse>(_GetMovieResponse_QNAME, GetMovieResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetMovie }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.soap.softeng.sapienza.it/", name = "setMovie")
    public JAXBElement<SetMovie> createSetMovie(SetMovie value) {
        return new JAXBElement<SetMovie>(_SetMovie_QNAME, SetMovie.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetDirector }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.soap.softeng.sapienza.it/", name = "setDirector")
    public JAXBElement<SetDirector> createSetDirector(SetDirector value) {
        return new JAXBElement<SetDirector>(_SetDirector_QNAME, SetDirector.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMovies }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.soap.softeng.sapienza.it/", name = "getMovies")
    public JAXBElement<GetMovies> createGetMovies(GetMovies value) {
        return new JAXBElement<GetMovies>(_GetMovies_QNAME, GetMovies.class, null, value);
    }

}
