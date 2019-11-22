package redeSocialMTP;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
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
    private String url = "jdbc:postgresql://localhost/mtp";

    // usuário do postgres
    private String usuario = "gilberto";

    // senha do postgres
    private String senha = "123456";

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

    public void inserirPost(String texto, int pessoa_id) {
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
    
        public void alteraSenha(String email, String senhaCript) {
        try {
            PreparedStatement st = this.conn.prepareStatement("UPDATE pessoa "
                    + "SET senha = ? WHERE email = ?");
            st.setString(1, senhaCript);
            st.setString(2, email);
            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Usuario login(String email, String senha) {
        try {
            PreparedStatement ps = this.conn.prepareStatement("SELECT id, nome, "
                    + "senha, cidade_estado, email, foto  FROM pessoa WHERE email = ? "
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
                u.setImagem(rs.getBytes(6));
                u.setEmail(rs.getString(5));

                return u;

            } else {
                return null;

            }

        } catch (SQLException e) {

        }

        return null;

    }

    public Usuario buscarEmail(String email) throws SQLException {

        PreparedStatement ps = this.conn.prepareStatement("SELECT id, nome, "
                + "cidade_estado, email, foto  FROM pessoa WHERE email = ?");
        ps.setString(1, email);//atribuir String
        ResultSet rs = ps.executeQuery(); //executar consulta
        Usuario u = new Usuario();//instanciar usuario

        if (rs.next()) {// verifico se retornou algum resultado do vetor
            u.setId(rs.getInt(1));
            u.setNome(rs.getString(2));
            u.setCidadeEstado(rs.getString(3));
            u.setEmail(rs.getString(4));
            u.setImagem(rs.getBytes(5));

            return u;

        } else {
            return null;

        }

    }

    public ArrayList<Post> buscarPost(int pagina) {

        ArrayList<Post> posts = new ArrayList();
        try {
            PreparedStatement ps = this.conn.prepareStatement("SELECT post.id, texto, "
                    + "pessoa_id, imagem, data_post, nome, (select COUNT (*) from "
                    + "like_post WHERE like_post.post_id = post.id) as likes FROM post "
                    + "INNER JOIN  pessoa ON (pessoa.id = post.pessoa_id) "
                    + "ORDER BY data_post DESC limit 3 "
                    + "OFFSET ?"
            );
            ps.setInt(1, pagina);
            ResultSet rs = ps.executeQuery(); //executar consulta
            while (rs.next()) {
                Post post = new Post();//instanciar usuario
                post.setId(rs.getInt(1));//setar os usuarios
                post.setTexto(rs.getString(2));
                post.setPessoaId(rs.getInt(3));
                post.setImagem(rs.getBytes(4));
                post.setDataPost(rs.getDate(5));
                post.setNomePessoa(rs.getString(6));
                post.setQuantLike(rs.getInt(7));

                posts.add(post);
            }
            return posts;
        } catch (SQLException e) {
            e.printStackTrace();
            return posts;
        }
    }

    public ArrayList<Post> buscarPostEmail(int pessoaID) {

        ArrayList<Post> posts = new ArrayList();
        try {
            PreparedStatement ps = this.conn.prepareStatement("SELECT post.id, texto, "
                    + "pessoa_id, imagem, data_post, nome, (SELECT COUNT (*) FROM "
                    + "like_post WHERE like_post.post_id = post.id) AS likes FROM post "
                    + "INNER JOIN  pessoa ON (pessoa.id = post.pessoa_id) "
                    + "WHERE pessoa_id = ? "
                    + "ORDER BY data_post DESC LIMIT 3"
            );
            ps.setInt(1, pessoaID);
            ResultSet rs = ps.executeQuery(); //executar consulta
            while (rs.next()) {
                Post post = new Post();//instanciar usuario
                post.setId(rs.getInt(1));//setar os usuarios
                post.setTexto(rs.getString(2));
                post.setPessoaId(rs.getInt(3));
                post.setImagem(rs.getBytes(4));
                post.setDataPost(rs.getDate(5));
                post.setNomePessoa(rs.getString(6));
                post.setQuantLike(rs.getInt(7));

                posts.add(post);
            }
            return posts;
        } catch (SQLException e) {
            e.printStackTrace();
            return posts;
        }
    }

    public ArrayList<LikePost> buscarLikePost(int pessoa_id) {

        ArrayList<LikePost> likePosts = new ArrayList<LikePost>();
        try {
            PreparedStatement ps = this.conn.prepareStatement("SELECT like_post.id, "
                    + "like_post.pessoa_id, post_id, pessoa.nome FROM like_post "
                    + "INNER JOIN post ON (post.id = like_post.post_id)"
                    + "INNER JOIN pessoa ON (pessoa.id = post.pessoa_id)"
                    + "ORDER BY like_post.id DESC"
            );
            ps.setInt(1, pessoa_id);
            ResultSet rs = ps.executeQuery(); //executar consulta
            while (rs.next()) {
                LikePost likePost = new LikePost();//instanciar usuario
                likePost.setId(rs.getInt(1));//setar os usuarios
                likePost.setNomeId(rs.getInt(2));
                likePost.setPostId(rs.getInt(3));
                likePost.setNomeLike(rs.getString(4));

                likePosts.add(likePost);
            }
            return likePosts;
        } catch (SQLException e) {
            return likePosts;
        }
    }
    
        public ArrayList<Like> buscarLike(int postId) {

        ArrayList<Like> likes = new ArrayList<Like>();
        try {
            PreparedStatement ps = this.conn.prepareStatement("SELECT pessoa.nome, "
                    + "pessoa.foto, like_post.data_like FROM like_post "
                    + "INNER JOIN pessoa ON (pessoa.id = like_post.pessoa_id) "
                    + "WHERE like_post.post_id = ? "
                    + "ORDER BY like_post.id DESC"
            );
            ps.setInt(1, postId);
            ResultSet rs = ps.executeQuery(); //executar consulta
            while (rs.next()) {
                Like like = new Like();//instanciar usuario
                like.setNomePessoa(rs.getString(1));//setar os usuarios
                like.setFoto(rs.getBytes(2));
                like.setDataLike(rs.getDate(3));

                likes.add(like);
            }
            return likes;
        } catch (SQLException e) {
            return likes;
        }
    }

    public int buscarQuantLike(int postId) throws SQLException {
        PreparedStatement ps = this.conn.prepareStatement("select COUNT (*) from like_post "
                + "INNER JOIN post ON (post.id = like_post.post_id) WHERE like_post.post_id = ?");
        ps.setInt(1, postId);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            int quantLike = rs.getInt(1);
            return quantLike;
        } else {
            return 0;
        }
    }

    public boolean compararEmails(String email) throws SQLException {
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

    public void adicionarPessoaImagem(String nome, String email, String senha, String cidadeEstado, File imagem) throws SQLException, FileNotFoundException {

        FileInputStream fis = new FileInputStream(imagem);
        PreparedStatement st = this.conn.prepareStatement("INSERT INTO pessoa "
                + "(nome, email, senha, cidade_estado, foto) VALUES (?, ?, ?, ?, ?)");
        st.setString(1, nome);
        st.setString(2, email);
        st.setString(3, senha);
        st.setString(4, cidadeEstado);
        st.setBinaryStream(5, fis, imagem.length());
        st.executeUpdate();
        st.close();

    }

    public void registarLike(Integer nomeId, Integer postId) throws SQLException {

        try (PreparedStatement st = this.conn.prepareStatement("INSERT INTO like_post "
                + "(pessoa_id, post_id, data_like) VALUES (?, ?, now())")) {
            st.setInt(1, nomeId);
            st.setInt(2, postId);
            st.executeUpdate();
        }

    }

    public void deslike(int pessoaId, int postId) {

        try {
            PreparedStatement st = this.conn.prepareStatement("DELETE FROM "
                    + "like_post WHERE pessoa_id = ? AND post_id = ?");
            st.setInt(1, pessoaId);
            st.setInt(2, postId);
            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public boolean verificarLike(int pessoaId, int postId) throws SQLException {
        PreparedStatement ps = this.conn.prepareStatement("SELECT id FROM like_post"
                + " WHERE pessoa_id = ? AND post_id = ?");
        ps.setInt(1, pessoaId);
        ps.setInt(2, postId);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return true;
        } else {
            return false;
        }
    }

    public void alterar(String nome, String email, String cidadeEstado) {
        try {
            PreparedStatement st = this.conn.prepareStatement("UPDATE pessoa "
                    + "SET nome = ?, cidade_estado = ? "
                    + "WHERE email = ?");
            st.setString(1, nome);
            st.setString(2, cidadeEstado);
            st.setString(3, email);
            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void alterarPessoaImagem(String nome, String email, String cidadeEstado, File arquivo) throws FileNotFoundException {

        FileInputStream fis = new FileInputStream(arquivo);
        try {
            PreparedStatement st = this.conn.prepareStatement("UPDATE pessoa "
                    + "SET nome = ?, cidade_estado = ?, foto = ? "
                    + "WHERE email = ?");
            st.setString(1, nome);
            st.setString(2, cidadeEstado);
            st.setBinaryStream(3, fis, (int) arquivo.length());
            st.setString(4, email);
            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
