package entity;
import java.util.Date;

@Entity
public class Veiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY);
    private Integer id;
    private  String marca;
    private Integer ano;
    private String descricao;
    private boolean vendido;
    private Date criado;
    private Date atualizado;

}
