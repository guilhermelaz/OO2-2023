package atividade;

public class Orcamento {
    private int OrdemDeServico;
    private double preco;
    private String descricao;

    public Orcamento(double preco, String desc) {
        this.preco = preco;
        this.descricao = desc;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getOrdemDeServico() {
        return OrdemDeServico;
    }

    public void setOrdemDeServico(int ordemDeServico) {
        OrdemDeServico = ordemDeServico;
    }
    
}
