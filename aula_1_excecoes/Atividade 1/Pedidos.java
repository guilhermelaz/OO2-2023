import java.util.Date;

public class Pedidos {
    String nome;
    Date dataLimite;



    public Pedidos(String nome, Date data){
        this.nome = nome;
        this.dataLimite = data;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Date getDataLimite() {
        return dataLimite;
    }
    public void setDataLimite(Date dataLimite) {
        this.dataLimite = dataLimite;
    }
    
}
