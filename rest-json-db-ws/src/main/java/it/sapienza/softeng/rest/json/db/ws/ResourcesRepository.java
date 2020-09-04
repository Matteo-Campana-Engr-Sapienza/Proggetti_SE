package it.sapienza.softeng.rest.json.db.ws;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("atenei")
@Produces("application/json")
@Consumes("application/json")
public class ResourcesRepository {

    //"update employee set name='Michael Sam' where emp_id=1";
    //"delete from employee where emp_id=1";
    private Connection connection = null;

    public ResourcesRepository() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:/home/studente/Documents/atenei-studenti.db");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @GET
    @Path("{ateneoId}")
    public Ateneo getAteneo(@PathParam("ateneoId") String ateneoId) throws SQLException {
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement("SELECT * FROM ATENEI WHERE ID = " + ateneoId + "  ;");
            statement.setQueryTimeout(30);

            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                Ateneo a = new Ateneo(
                        rs.getInt("ID") + "",
                        rs.getString("name")
                );
                System.out.println("\n\nGET : " + a.toString() + "\n\n");
                return a;
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return null;
    }

    @GET
    @Path("{ateneoId}/studenti/{studenteId}")
    public Studente getStudente(@PathParam("ateneoId") String ateneoId, @PathParam("studenteId") String studenteId) {

        PreparedStatement statement;
        try {
            statement = connection.prepareStatement("SELECT * FROM STUDENTI WHERE ID = " + studenteId + "  ;");
            statement.setQueryTimeout(30);

            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                Studente s = new Studente(
                        rs.getInt("ID") + "",
                        rs.getString("name")
                );
                System.out.println("\n\nGET : " + s.toString() + "\n\n");
                return s;
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return null;
    }

    @POST
    @Path("/")
    public Response postAteneo(Ateneo ateneo) {
        try {
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);
            statement.executeUpdate("INSERT INTO ATENEI(name) VALUES("
                    + "'" + ateneo.getName() + "');");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            //return Response.status(Response.Status.BAD_REQUEST).build();
        }
        System.out.println("\n\nPOST : " + ateneo.toString() + "\n\n");
        return Response.ok().build();
    }

    @POST
    @Path("{ateneoId}")
    public Response postStudente(@PathParam("ateneoId") String ateneoId, Studente studente) {

        try {
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);
            statement.executeUpdate("INSERT INTO STUDENTI(ateneoId,name) VALUES( " + ateneoId + ",'" + studente.getName() + "');");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            //return Response.status(Response.Status.BAD_REQUEST).build();
        }
        System.out.println("\n\nPOST : " + studente.toString() + "\n\n");
        return Response.ok().build();
    }

    @DELETE
    @Path("{ateneoId}")
    public Response deleteAteneo(@PathParam("ateneoId") String ateneoId) {

        try {
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);
            statement.executeUpdate("delete from ATENEI where ID=  " + ateneoId + ";");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            //return Response.status(Response.Status.BAD_REQUEST).build();
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        System.out.println("\n\nDELETE : " + ateneoId + "\n\n");
        return Response.ok().build();
    }

    @DELETE
    @Path("{ateneoId}/studenti/{studenteId}")
    public Response deleteAteneo(@PathParam("ateneoId") String ateneoId, @PathParam("studenteId") String studenteId) {
        try {
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);
            statement.executeUpdate("delete from STUDENTI where ID=  " + studenteId + ";");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            //return Response.status(Response.Status.BAD_REQUEST).build();
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        System.out.println("\n\nDELETE : " + studenteId + "\n\n");
        return Response.ok().build();
    }

}
