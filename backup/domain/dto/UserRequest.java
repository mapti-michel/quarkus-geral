package mp.br.quarkussocial.domain.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequest {

    private Long id;
    private String nome;
    private int idade;

}
