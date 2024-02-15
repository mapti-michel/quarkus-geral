package mp.br.quarkussocial.domain.dto;

import io.vertx.core.eventbus.impl.clustered.Serializer;
import lombok.*;

import javax.persistence.Column;

@Getter
@Setter
public class UserRequest {

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "idade", nullable = false)
    private int idade;


}
