package redeSocialMTP;

import com.sun.org.apache.xalan.internal.xsltc.dom.BitArray;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

public class Conexao {

    // string URL padrão
    // endereço: localhost
    // base de dados: mtp
    private String url = "jdbc:postgresql://localhost/Mtp";

    // usuário do postgres
    private String usuario = "postgres";

    // senha do postgres
    private String senha = "ifg";

    // variável que guarda a conexão
    private Connection conn;

    /**
     * Método construtor.
     *
     * Toda vez que instanciar essa classe, a conexão é automaticamente feita
     */
    public Conexao() {
        conectar();
    }

    /**
     * Método para conexão com o banco de dados.
     *
     * Carrega o driver e cria a conexão com o BD.
     */
    public void conectar() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }

        Properties props = new Properties();
        props.setProperty("user", this.usuario);
        props.setProperty("password", this.senha);

        try {
            this.conn = DriverManager.getConnection(this.url, props);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * Método que retorna a conexão feita com o BD
     *
     * @return um objeto Connection que é a conexão feita com o BD
     */
    public Connection getConnection() {
        return this.conn;
    }

    /**
     * Método que insere uma pessoa no banco de dados
     *
     * Por enquanto, a pessoa está fixa!
     */
    public void inserir() {
        try {
            PreparedStatement st = this.conn.prepareStatement("INSERT INTO "
                    + "pessoa (nome) VALUES (?)");
            st.setString(1, "Thiago");
            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void inserir_post(String texto, int pessoa_id) {
        try {
            PreparedStatement st = this.conn.prepareStatement("INSERT INTO "
                    + "post (texto, pessoa_id, data_post) VALUES (?, ?, now())");
            st.setString(1, texto);
            st.setInt(2, pessoa_id);
            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
     public void inserirPostImagem(String texto, int pessoa_id, File arquivo) throws FileNotFoundException {
         FileInputStream fis = new FileInputStream(arquivo);
        try {
            PreparedStatement st = this.conn.prepareStatement("INSERT INTO "
                    + "post (texto, pessoa_id, data_post, imagem) VALUES (?, ?, now(), ?)");
            st.setString(1, texto);
            st.setInt(2, pessoa_id);
            st.setBinaryStream(3, fis, (int) arquivo.length());
            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método que atualiza todos os nomes do banco de dados
     *
     * E se for necessário alterar para uma pessoa só? O que muda?
     */
    public void atualizar() {
        try {
            PreparedStatement st = this.conn.prepareStatement("UPDATE pessoa "
                    + "SET nome = ?");
            st.setString(1, "Thiago 2");
            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método que exclui uma determinada pessoa do banco de dados
     *
     * Está sempre excluindo a mesma pessoa! A que tem ID = 1!
     */
    public void excluir() {

        try {
            PreparedStatement st = this.conn.prepareStatement("DELETE FROM "
                    + "pessoa WHERE id = ?");
            st.setInt(1, 1);
            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public Usuario login(String email, String senha) {
        try {
            PreparedStatement ps = this.conn.prepareStatement("SELECT id, nome, "
                    + "senha, cidade_estado, email  FROM pessoa WHERE email = ? "
                    + "AND senha = ?");
            ps.setString(1, email);//atribuir String
            ps.setString(2, senha);
            ResultSet rs = ps.executeQuery(); //executar consulta
            if (rs.next()) {// verifico se retornou algum resultado do vetor
                Usuario u = new Usuario();//instanciar usuario
                u.setId(rs.getInt(1));//setar os usuarios
                u.setNome(rs.getString(2));
                u.setSenha(rs.getString(3));
                u.setCidadeEstado(rs.getString(4));
                u.setEmail(rs.getString(5));

                return u;

            } else {
                return null;

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }

        public ArrayList<Post> buscarPost() {
        
        ArrayList<Post> posts = new ArrayList();
        try {
            PreparedStatement ps = this.conn.prepareStatement("SELECT id, texto, "
                    + "pessoa_id, imagem, data_post, nome FROM post INNER JOIN  pessoa ON (pessoa.id = post.pessoa_id)"
            );
            ResultSet rs = ps.executeQuery(); //executar consulta
            while(rs.next()){
                Post post = new Post();//instanciar usuario
                post.setId(rs.getInt(1));//setar os usuarios
                post.setTexto(rs.getString(2));
                post.setPessoaId(rs.getInt(3));
                post.setImagem(rs.getBytes(4));
                post.setDataPost(rs.getDate(5));
                post.setNomePessoa(rs.getString(6));

                posts.add(post);
            }
            return posts;
        } catch (SQLException e) { 
            return null;
        }
    }

    public boolean comparar_emails(String email) throws SQLException {
        PreparedStatement ps = this.conn.prepareStatement("SELECT id FROM pessoa"
                + " WHERE email = ?");
        ps.setString(1, email);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return true;
        } else {
            return false;
        }
    }

    public void adicionarPessoa(String nome, String email, String senha, String cidadeEstado) throws SQLException {

        PreparedStatement st = this.conn.prepareStatement("INSERT INTO pessoa "
                + "(nome, email, senha, cidade_estado) VALUES (?, ?, ?, ?)");
        st.setString(1, nome);
        st.setString(2, email);
        st.setString(3, senha);
        st.setString(4, cidadeEstado);
        st.executeUpdate();
        st.close();

    }

    
    
    public void alterar(String nome, String email, String senha, String cidadeEstado) {
        try {
            PreparedStatement st = this.conn.prepareStatement("UPDATE pessoa "
                    + "SET nome = ?, senha = ?, cidade_estado = ? "
                    + "WHERE email = ?");
            st.setString(1, nome);
            st.setString(2, senha);
            st.setString(3, cidadeEstado);
            st.setString(4, email);
            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}