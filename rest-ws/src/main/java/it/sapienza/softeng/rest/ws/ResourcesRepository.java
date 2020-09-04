package it.sapienza.softeng.rest.ws;

import java.util.LinkedList;
import java.util.List;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("atenei")
@Produces("text/xml")
public class ResourcesRepository {

    private List<Ateneo> resources;

    public ResourcesRepository() {
        resources = new LinkedList<Ateneo>();

        Ateneo sapienza = new Ateneo("0", "Sapienza");
        Ateneo roma3 = new Ateneo("1", "Roma3");
        Ateneo torvergata = new Ateneo("2", "TorVergata");

        sapienza.addStudente(new Studente("0", "studente_0"));
        sapienza.addStudente(new Studente("1", "studente_1"));
        sapienza.addStudente(new Studente("2", "studente_2"));
        sapienza.addStudente(new Studente("3", "studente_3"));

        roma3.addStudente(new Studente("4", "studente_4"));
        roma3.addStudente(new Studente("5", "studente_5"));
        roma3.addStudente(new Studente("6", "studente_6"));
        roma3.addStudente(new Studente("7", "studente_7"));

        torvergata.addStudente(new Studente("8", "studente_8"));
        torvergata.addStudente(new Studente("9", "studente_9"));
        torvergata.addStudente(new Studente("10", "studente_10"));
        torvergata.addStudente(new Studente("11", "studente_11"));

        resources.add(sapienza);
        resources.add(roma3);
        resources.add(torvergata);
        System.out.println("\n\n");
        for (Ateneo a : resources) {
            System.out.println(a);
        }
        System.out.println("\n\n");
    }

    @GET
    @Path("{ateneoId}")
    public Ateneo getAteneo(@PathParam("ateneoId") String ateneoId) {
        for (Ateneo ateneo : resources) {
            if (ateneo.getId().equals(ateneoId)) {
                return ateneo;
            }
        }
        return null;
    }

    @GET
    @Path("{ateneoId}/studenti/{studenteId}")
    public Studente getStudente(@PathParam("ateneoId") String ateneoId, @PathParam("studenteId") String studenteId) {
        for (Ateneo ateneo : resources) {
            if (ateneo.getId().equals(ateneoId)) {
                for (Studente studente : ateneo.getStudenti()) {
                    if (studente.getId().equals(studenteId)) {
                        return studente;
                    }
                }
            }
        }
        return null;
    }
    
    private Integer ateneo_id_counter = 3;
    
    @POST
    @Path("/")
    public Response postAteneo(Ateneo ateneo) {
        ateneo.setId(ateneo_id_counter.toString());
        this.ateneo_id_counter++;
        resources.add(ateneo);
        return Response.ok().build();
    }
    
    private Integer studente_id_counter = 12;

    @POST
    @Path("{ateneoId}")
    public Response postStudente(@PathParam("ateneoId") String ateneoId, Studente studente) {
        for (Ateneo ateneo : resources) {
            if (ateneo.getId().equals(ateneoId)) {
                studente.setId(studente_id_counter.toString());
                this.ateneo_id_counter++;
                ateneo.addStudente(studente);
                return Response.ok().build();
            }
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @DELETE
    @Path("{ateneoId}")
    public Response deleteAteneo(@PathParam("ateneoId") String ateneoId) {
        for (Ateneo ateneo : resources) {
            if (ateneo.getId().equals(ateneoId)) {
                resources.remove(ateneo);
                return Response.ok().build();
            }
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @DELETE
    @Path("{ateneoId}/studenti/{studenteId}")
    public Response deleteAteneo(@PathParam("ateneoId") String ateneoId, @PathParam("studenteId") String studenteId) {
        for (Ateneo ateneo : resources) {
            if (ateneo.getId().equals(ateneoId)) {
                if (ateneo.removeStudente(studenteId)) {
                    return Response.ok().build();
                }
            }
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

}
