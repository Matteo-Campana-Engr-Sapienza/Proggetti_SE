package it.sapienenza.softeng.simple.rest.json.ws;

import java.util.LinkedList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("resources")
public class ResourcesRepository {

    private List<Resource> resources;

    public ResourcesRepository() {
        resources = new LinkedList<>();

        resources.add(new Resource(0, "resource_0"));
        resources.add(new Resource(1, "resource_1"));
        resources.add(new Resource(2, "resource_2"));
        resources.add(new Resource(3, "resource_3"));

        resources.add(new Resource(4, "resource_4"));
        resources.add(new Resource(5, "resource_5"));
        resources.add(new Resource(6, "resource_6"));
        resources.add(new Resource(7, "resource_7"));
    }

    @GET
    @Path("{rid}")
    @Produces("application/json")
    public Response getResource(@PathParam("rid") String id) {
        for (Resource resource : resources) {
            if (resource.getId() == Integer.parseInt(id)) {
                //return resource;
                return Response.ok(resource).build();
            }
        }
        //return null;
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @GET
    @Path("")
    @Produces("application/json")
    public Response getResources() {
        return Response.ok(resources).build();
    }

    @POST
    @Path("")
    @Produces("application/json")
    @Consumes("application/json")
    public Response addRisorsa(Resource resource) {
        for (Resource r : resources) {
            if (r.equals(resource)) {
                return Response.status(Response.Status.CONFLICT).build();
            }
        }
        this.resources.add(resource);
        return Response.ok().build();
    }

    @PUT
    @Path("{rid}")
    @Produces("application/json")
    public Response updateRisorsa(@PathParam("rid") String id, Resource resource) {
        for (Resource r : resources) {
            if (r.equals(resource)) {
                if (r.equals(resource)) {
                    return Response.status(Response.Status.NOT_MODIFIED).build();
                }
                r.setName(resource.getName());
                return Response.status(Response.Status.ACCEPTED).build();
            }
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @DELETE
    @Path("{rid}")
    @Produces("application/json")
    public Response deleteResource(@PathParam("rid") String id) {
        for (Resource r : resources) {
            this.resources.remove(r);
            return Response.ok().build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

}
