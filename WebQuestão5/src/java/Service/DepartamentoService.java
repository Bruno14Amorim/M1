/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Controller.DepartamentoController;
import javax.ws.rs.Path;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import model.Departamento;

/**
 *
 * @author bruno
 */
@Path("/departamento")
public class DepartamentoService {

    static DepartamentoController Controller = new DepartamentoController();

    @GET
    @Path("/lista")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Departamento> getDepartamentos() {
        return Controller.get();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/insert")
    public Response saveJson(Departamento obj) {
        try {
            System.out.println(obj.toString());
            //obj.setId(Controller.getCarro().size()+1 );
            Controller.add(obj);

            return Response.ok((Object) obj).build();
        } catch (Exception e) {
            e.printStackTrace();
            // return 404 to allow load balancers to only send traffic to the coordinator
            return Response.status(Response.Status.NOT_FOUND).build();
        }

    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/update/{id}")
    public Response saveJsonPut(@PathParam("id") int id, Departamento obj) {
        try {
            System.out.println(obj.toString());
            if (Controller.update(id, obj)) {
                obj.setId(id);
                return Response.ok((Object) obj).build();
            } else {
                return Response.ok((Object) "Registro não encontradao.").build();
            }

        } catch (Exception e) {
            e.printStackTrace();
            // return 404 to allow load balancers to only send traffic to the coordinator
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @DELETE
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/delete/{id}")
    public Response delete(@PathParam("id") int id) {
        try {
            if (Controller.delete(id)) {
                return Response.ok().build();
            } else {
                return Response.ok((Object) "Registro não encontradao.").build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            // return 404 to allow load balancers to only send traffic to the coordinator
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

}
