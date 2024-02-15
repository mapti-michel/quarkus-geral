package mp.br.quarkussocial.domain.rest;

import javax.transaction.Transactional;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.GET;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import jakarta.enterprise.context.ApplicationScoped;
import mp.br.quarkussocial.domain.dto.UserRequest;
import mp.br.quarkussocial.domain.model.User;

@ApplicationScoped
@Path("/")
/*
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
*/
public class UserResource {

    public static final String USERS = "users";

/*

    @POST
    @Transactional
    public Response createUser(UserRequest request){

        User user = new User();
        user.setNome(request.getNome());
        user.setIdade(request.getIdade());

        user.persist();

        return Response.ok(user).build();
    }
*/

    @GET
        @Path("users")
        @Produces(MediaType.APPLICATION_JSON)
    public Response listAllUsers(){

        PanacheQuery<PanacheEntityBase> query = User.findAll();

        return Response.ok(query.list()).build();
    }






}
