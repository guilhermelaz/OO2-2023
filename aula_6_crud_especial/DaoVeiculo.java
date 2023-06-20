import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DaoVeiculo {
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

    public boolean inserir(Veiculo v) {
        boolean resultado = false;
        try {
            this.conectar();
            String comando = "INSERT INTO tb_veiculos VALUES(NULL," + "'" + v.getMarca() + "', '" + v.getModelo()
                    + "', '" + v.getChassi() + "', " + v.getAno() + ");";
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

    public ArrayList<Veiculo> BuscarTodos() {
        ArrayList<Veiculo> resultados = new ArrayList<Veiculo>();
        try {
            this.conectar();
            ResultSet rs = st.executeQuery("SELECT * FROM tb_veiculos ORDER BY codigo;");
            while (rs.next()) {
                Veiculo v = new Veiculo();
                v.setCodigo(rs.getInt("codigo"));
                v.setMarca(rs.getString("marca"));
                v.setModelo(rs.getString("modelo"));
                v.setChassi(rs.getString("chassi"));
                v.setAno(rs.getInt("ano"));
                resultados.add(v);
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            this.desconectar();
        }
        return resultados;

    }

    public int excluir(int cod) {
        int resultado = 0;
        try {
            this.conectar();
            String comando = "DELETE FROM tb_veiculos where codigo = " + cod + ";";
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

    public Veiculo BuscarUm(int cod) {

        Veiculo v = null;

        try {
            this.conectar();
            ResultSet rs = st.executeQuery("SELECT * FROM tb_veiculos WHERE codigo = " + cod + ";");

            if (rs.next()) {
                v = new Veiculo();
                v.setCodigo(rs.getInt("codigo"));
                v.setMarca(rs.getString("marca"));
                v.setModelo(rs.getString("modelo"));
                v.setChassi(rs.getString("chassi"));
                v.setAno(rs.getInt("ano"));
            }

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            this.desconectar();
        }

        return v;

    }

    public boolean alterar(int codigo, Veiculo v) {
        boolean resultado = false;
        try {
            this.conectar();
            String comando = "UPDATE tb_veiculos SET marca = '" + v.getMarca() + "', modelo = '" + v.getModelo() + "', ano = " + v.getAno() + ", chassi = '" + v.getChassi() + "' WHERE codigo = " + codigo + ";";
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

}
