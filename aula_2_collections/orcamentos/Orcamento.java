import java.text.SimpleDateFormat;
import java.util.Date;

public class Orcamento {
    private int cli_id;

    private static int nextOs = 1;
    private int os;
    private String data;
    private String equipamento;
    private String descricao;
    private double preco;

    // new Orcamento(this.cli_id, )
    public Orcamento(int cli_id, String equipamento, String descricao, double preco) {
        this.cli_id = cli_id;

        this.os = Orcamento.nextOs++;

        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date dataAtual = new Date();
        String dataFormatada = formato.format(dataAtual);

        this.data = dataFormatada;
        this.equipamento = equipamento;
        this.descricao = descricao;
        this.preco = preco;
    }


    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }
    public String getEquipamento() {
        return equipamento;
    }
    public void setEquipamento(String equipamento) {
        this.equipamento = equipamento;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }
    public int getCli_id() {
        return cli_id;
    }
    public void setCli_id(int cli_id) {
        this.cli_id = cli_id;
    }
    public int getOs() {
        return os;
    }
    public void setOs(int os) {
        this.os = os;
    }
    

}
