import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DaoClientePJ {
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

    public boolean inserir(ClientePJ c) {
        boolean resultado = false;
        try {
            this.conectar();
            
            PreparedStatement pst = conn.prepareStatement(
                "INSERT INTO tb_clientes_pj (cod_cli_pj, nome, cnpj)" + "VALUES (NULL, ?, ?);",
                Statement.RETURN_GENERATED_KEYS //RETORNA AS CHAVES GERADAS NO SQL, POR EXEMPLO ID
            );

            pst.setString(1, c.getNome());
            pst.setString(2, c.getCnpj());

            pst.executeUpdate();

            ResultSet rs =  pst.getGeneratedKeys();
            int idCliente = 0;
            if (rs.next()){
                idCliente = rs.getInt(1);

                PreparedStatement pstEnd = conn.prepareStatement(
                    "INSERT INTO tb_enderecos_pj (cod_end, cod_cli_pj, rua, numero, bairro, cep)" + "VALUES (NULL, ?, ?, ?, ?, ?);"
                );

                pstEnd.setInt(1, idCliente);
                pstEnd.setString(2, c.getEnderecoPJ().getRua());
                pstEnd.setInt(3, c.getEnderecoPJ().getNumero());
                pstEnd.setString(4, c.getEnderecoPJ().getBairro());
                pstEnd.setString(5, c.getEnderecoPJ().getCep());

                pstEnd.executeUpdate();
                resultado = true;
            }

        } catch (Exception e) {
            System.out.println("Erro." + e.getMessage());
        } finally {
            this.desconectar();
        }

        return resultado;
    }



    public ClientePJ BuscarUm(int cod) {

        ClientePJ c = null;

        try {
            this.conectar();
            ResultSet rs = st.executeQuery(
                "SELECT * FROM tb_clientes_pj as c, tb_enderecos_pj as e WHERE c.cod_cli_pj = e.cod_cli_pj AND c.cod_cli_pj = " + cod + ";");

            if (rs.next()) {
                c = new ClientePJ();

                c.setCodigoclientepj(rs.getInt("cod_cli_pj"));
                c.setCnpj(rs.getString("cnpj"));
                c.setNome(rs.getString("nome"));

                EnderecoPJ cEn = new EnderecoPJ();

                cEn.setCodigoenderecopj(rs.getInt("cod_end"));
                cEn.setRua(rs.getString("rua"));
                cEn.setNumero(rs.getInt("numero"));
                cEn.setBairro(rs.getString("bairro"));
                cEn.setCep(rs.getString("cep"));

                c.setEnderecoPJ(cEn);
                
            }

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            this.desconectar();
        }

        return c;

    }

    public boolean alterar(ClientePJ c) {
        boolean resultado = false;
        try {
            this.conectar();
            
            PreparedStatement pst = conn.prepareStatement(
                "UPDATE tb_clientes_pj SET nome = ?, cnpj = ? WHERE cod_cli_pj = ?;"
            );
            
            pst.setString(1, c.getNome());
            pst.setString(2, c.getCnpj());
            pst.setInt(3, c.getCodigoclientepj());
            pst.executeUpdate();

            PreparedStatement pstEnd = conn.prepareStatement(
                "UPDATE tb_enderecos_pj SET rua = ?, numero = ?, bairro = ?, cep = ? WHERE cod_cli_pj = ?;"
            );

            pstEnd.setString(1, c.getEnderecoPJ().getRua());
            pstEnd.setInt(2, c.getEnderecoPJ().getNumero());
            pstEnd.setString(3, c.getEnderecoPJ().getBairro());
            pstEnd.setString(4, c.getEnderecoPJ().getCep());
            pstEnd.setInt(5, c.getCodigoclientepj());
            pstEnd.executeUpdate();

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

            PreparedStatement pstend = conn.prepareStatement(
                "DELETE FROM tb_enderecos_pj WHERE cod_cli_pj = ?",
                Statement.RETURN_GENERATED_KEYS
            );
            pstend.setInt(1, cod);
            pstend.executeUpdate();


            PreparedStatement pstcli = conn.prepareStatement(
                "DELETE FROM tb_clientes_pj WHERE cod_cli_pj = ?",
                Statement.RETURN_GENERATED_KEYS
            );
            pstcli.setInt(1, cod);
            pstcli.executeUpdate();
            
            resultado = pstcli.getUpdateCount();

        } catch (Exception e) {
            System.out.println("Erro." + e.getMessage());
        } finally {
            this.desconectar();
        }

        return resultado;
    }


    public ArrayList<ClientePJ> BuscarTodos() {

        ArrayList<ClientePJ> resultados = new ArrayList<ClientePJ>();

        try {
            this.conectar();
            ResultSet rs = st.executeQuery("SELECT * FROM tb_clientes_pj as c, tb_enderecos_pj as e where c.cod_cli_pj = e.cod_cli_pj order by c.nome;");

            while (rs.next()) {
                ClientePJ c = new ClientePJ();

                c.setCodigoclientepj(rs.getInt("cod_cli_pj"));

                c.setCnpj(rs.getString("cnpj"));

                c.setNome(rs.getString("nome"));

                EnderecoPJ cEn = new EnderecoPJ();

                cEn.setCodigoenderecopj(rs.getInt("cod_end"));
                cEn.setRua(rs.getString("rua"));
                cEn.setNumero(rs.getInt("numero"));
                cEn.setBairro(rs.getString("bairro"));
                cEn.setCep(rs.getString("cep"));

                c.setEnderecoPJ(cEn);

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