package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Produto;

public class produtoDAO {

    private Connection conn;
    private PreparedStatement stmt;
    private Statement st;
    private ResultSet rs;
    private ArrayList lista = new ArrayList<>();

    public produtoDAO() {
        conn = new ConnectionBase().getConnection();
    }

    public void inserir(Produto produto) {
        String sql = "INSERT INTO PRODUTO (nome_produto, codigo, preco, quantidade) VALUES (?,?,?,?)";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, produto.getNomeProduto());
            stmt.setInt(2, produto.getCod());
            stmt.setDouble(3, produto.getPrecoProduto());
            stmt.setInt(4, produto.getQuantidadeProduto());
            stmt.execute();
            stmt.close();

        } catch (Exception erro) {
            throw new RuntimeException("Erro 2 " + erro);
        }
    }

    public void alterar(Produto produto) {
        String sql = "UPDATE PRODUTO SET nome_produto = ?, codigo = ?, preco = ?, quantidade = ? WHERE id = ?";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, produto.getNomeProduto());
            stmt.setInt(2, produto.getCod());
            stmt.setDouble(3, produto.getPrecoProduto());
            stmt.setInt(4, produto.getQuantidadeProduto());
            stmt.execute();
            stmt.close();

        } catch (Exception erro) {
            throw new RuntimeException("Erro 3 " + erro);
        }
    }

    public void excluir(int valor) throws SQLException {
        String sql = "DELETE FROM produto WHERE id = " + valor;
        st = conn.createStatement();
        st.execute(sql);
        st.close();

        try {

        } catch (Exception erro) {
            throw new RuntimeException("Erro 4 " + erro);
        }
    }

    public ArrayList<Produto> listar() {
        String sql = "SELECT * FROM produto";

        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                Produto produto = new Produto();
                produto.setCod(rs.getInt("cod"));
                produto.setNomeProduto(rs.getString("nomeProduto"));
                produto.setPrecoProduto(rs.getDouble("precoProduto"));
                produto.setQuantidadeProduto(rs.getInt("quantidadeProduto"));
                lista.add(produto);
            }

        } catch (Exception erro) {
            throw new RuntimeException("Erro 5 " + erro);
        }

        return lista;
    }

    public ArrayList<Produto> listarDescricao(String valor) {
        String sql = "SELECT * FROM produto WHERE descricao LIKE '% " + valor + " %'";

        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                Produto produto = new Produto();
                produto.setCod(rs.getInt("cod"));
                produto.setNomeProduto(rs.getString("nomeProduto"));
                produto.setPrecoProduto(rs.getDouble("precoProduto"));
                produto.setQuantidadeProduto(rs.getInt("quantidadeProduto"));
                lista.add(produto);
            }

        } catch (Exception erro) {
            throw new RuntimeException("Erro 6 " + erro);
        }

        return lista;
    }
}
