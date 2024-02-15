package mp.br.quarkussocial.rest;


import io.quarkus.hibernate.orm.panache.PanacheQuery;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Validator;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import mp.br.quarkussocial.domain.dto.UserRequest;
import mp.br.quarkussocial.domain.model.User;
import mp.br.quarkussocial.domain.repository.UserRepository;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {

    private UserRepository userRepository;
    private Validator validator;

    @Inject
    public UserResource(UserRepository userRepository, Validator validator){
        this.userRepository = userRepository;
        this.validator = validator;
    }

    @POST
    @Transactional
    public Response createUser(UserRequest request){
        User user = new User();

        user.setNome(request.getNome());
        user.setIdade(request.getIdade());
        userRepository.persist(user);

        return Response.ok(user).build();
    }

    @GET
    public Response listAllUsers(){
        PanacheQuery<User> query = userRepository.findAll();
        return Response.ok(query.list()).build();
    }

    @GET
    @Path("{idEspecif}")
    public Response listUser(@PathParam("idEspecif") Long idEspecoif){
        User user = userRepository.findById(idEspecoif);
        if(user != null){
            return Response.ok().build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @DELETE
    @Path("{id}")
    @Transactional
    public Response deleteUser(@PathParam("id") Long id){
        User user = userRepository.findById(id);

        if(user != null){
            userRepository.delete(user);
            return Response.ok().build();
        }

        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @PUT
    @Path("{id}")
    @Transactional
    public Response updateUser(@PathParam("id") Long id, UserRequest userData){
        User user = userRepository.findById(id);

        if(user != null){
            user.setNome(userData.getNome());
            user.setIdade(userData.getIdade());
            return Response.ok().build();
        }

        return Response.status(Response.Status.NOT_FOUND).build();
    }
}
