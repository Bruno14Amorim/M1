/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastro;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import dao.UsuarioDAO;
import javax.ws.rs.PathParam;
import modelos.Usuario;

/**
 * REST Web Service
 *
 * @author Aluno
 */
@Path("cadastro")
public class CadastroWS {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of CadastroWS
     */
    public CadastroWS() {
    }


    @GET
    @Produces("application/json")
    @Path("Usuario/usuarios")
    public String getUsuario() throws Exception {
           List<Usuario> lista;
           
           Usuario u = new Usuario();
           
           u.setEmail("aaaaa@hotmail.com");
           u.setNome("bbbbb");
           u.setSobrenome("aaaaa");
           u.setTelefone("000000000");
           u.setSenha("12345");
           
           UsuarioDAO dao = new UsuarioDAO();
           
                
                Gson g = new Gson();
                return g.toJson(u);
        
        
    }
    
    
    
    /*@GET
    @Produces("application/json")
    @Path("Usuario/list")
    public String listUsuarios() throws Exception {
           List<Usuario> lista;
           
           UsuarioDAO dao = new UsuarioDAO();
           
           lista = dao.consulta();
                
                Gson g = new Gson();
                return g.toJson(lista);
        
        
    }*/


    @PUT
    @Consumes("application/xml")
    @Path("Usuario/inserir")
    public void putXml(String content) throws Exception {
        List<Usuario> lista;
           
           UsuarioDAO dao = new UsuarioDAO();
           Usuario u = new Usuario();
           
          
        
        
    }
}
