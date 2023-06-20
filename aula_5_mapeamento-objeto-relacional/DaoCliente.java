import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DaoCliente {
    private Connection conn;
    private Statement st;

    private void conectar() {
        try {
            this.conn = GerenciarConexao.pegarConexao();
            st = conn.createStatement();
        } catch (ClassNotFoundException e1) {
            System.out.println(e1.getMessage());
        } catch (SQLException e2) {
            System.out.println(e2.getMessage());
        }
    }

    private void desconectar() {
        try {
            st.close();
            conn.close();
        } catch (SQLException e2) {
            System.out.println(e2.getMessage());
        }
    }

    public boolean inserir(Cliente c) {
        boolean resultado = false;
        try {
            this.conectar();
            String comando = "INSERT INTO tb_cliente VALUES(NULL, " + "'" + c.getPrimeiro_nome() + "', '" + c.getUltimo_nome() + "', '" + c.getCpf() + "', " + c.getIdade() + ");";
            System.out.println(comando);
            st.executeUpdate(comando);
            resultado = true;
        } catch (Exception e) {
            System.out.println("Erro." + e.getMessage());
        } finally {
            this.desconectar();
        }

        return resultado;
    }



    public Cliente BuscarUm(int cod) {

        Cliente c = null;

        try {
            this.conectar();
            ResultSet rs = st.executeQuery("SELECT * FROM tb_cliente WHERE codigo = " + cod + ";");

            if (rs.next()) {
                c = new Cliente();
                c.setCodigo(rs.getInt("codigo"));
                c.setPrimeiro_nome(rs.getString("primeiro_nome"));
                c.setUltimo_nome(rs.getString("ultimo_nome"));
                c.setCpf(rs.getString("cpf"));
                c.setIdade(rs.getInt("idade"));
            }

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            this.desconectar();
        }

        return c;

    }

    public boolean alterar(int codigo, Cliente c) {
        boolean resultado = false;
        try {
            this.conectar();
            String comando = "UPDATE tb_cliente SET primeiro_nome = '" + c.getPrimeiro_nome() + "', ultimo_nome = '" + c.getUltimo_nome() + "', cpf = " + c.getCpf() + ", idade = '" + c.getIdade() + "' WHERE codigo = " + codigo + ";";
            System.out.println(comando);
            st.executeUpdate(comando);
            resultado = true;
        } catch (Exception e) {
            System.out.println("Erro." + e.getMessage());
        } finally {
            this.desconectar();
        }

        return resultado;
    }

    public int excluir(int cod) {
        int resultado = 0;
        try {
            this.conectar();
            String comando = "DELETE FROM tb_cliente where codigo = " + cod + ";";
            System.out.println(comando);
            st.executeUpdate(comando);
            resultado = st.getUpdateCount();

        } catch (Exception e) {
            System.out.println("Erro." + e.getMessage());
        } finally {
            this.desconectar();
        }

        return resultado;
    }

    public ArrayList<Cliente> BuscarTodos() {
        ArrayList<Cliente> resultados = new ArrayList<Cliente>();
        try {
            this.conectar();
            ResultSet rs = st.executeQuery("SELECT * FROM tb_cliente ORDER BY codigo;");
            while (rs.next()) {
                Cliente c = new Cliente();
                c.setCodigo(rs.getInt("codigo"));
                c.setPrimeiro_nome(rs.getString("primeiro_nome"));
                c.setUltimo_nome(rs.getString("ultimo_nome"));
                c.setCpf(rs.getString("cpf"));
                c.setIdade(rs.getInt("idade"));
                resultados.add(c);
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            this.desconectar();
        }
        return resultados;

    }

}