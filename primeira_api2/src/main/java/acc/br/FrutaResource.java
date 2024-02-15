package acc.br;

import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import acc.br.model.Fruta;

import java.util.List;

@Path("/frutas")
public class FrutaResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Fruta> list(){
        return Fruta.listAll();
    }

    @POST
    @Transactional
    public void novaFruta(){
        Fruta fruta = new Fruta();
        fruta.nome = "Maçã";
        fruta.qtd = 6;
        fruta.persist();
    }

    @DELETE
    @Transactional
    public void excluiFruta(){
        Fruta fruta = new Fruta();
        fruta.delete("nome", "Jaca");
    }

}
