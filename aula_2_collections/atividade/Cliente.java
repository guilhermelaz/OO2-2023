package atividade;
import java.util.ArrayList;

public class Cliente {
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private ArrayList<Orcamento> listaOrcamento = new ArrayList<Orcamento>();
                            
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    public void setOrcamento(double preco, String desc) {
        Orcamento orcamento = new Orcamento(preco, desc);
        listaOrcamento.add(orcamento);
    }

    public Orcamento getOrcamento(int os) {
        for (Orcamento orcamento : listaOrcamento) {
            if (orcamento.getOrdemDeServico() == os){
                System.out.println("Orcamento encontrado!");
                
            }
        }
        return orcamento;
    }
}