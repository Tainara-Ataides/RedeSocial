/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor. Teste
 */
package redeSocialMTP;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author ifg
 */
public class AlterarUsuario extends javax.swing.JFrame {

    Usuario u;
    File arquivo = null;

    public AlterarUsuario(Usuario u) { //metodo construtor que recebe usuario (com nome u(nome do objeto)) por parametro
        initComponents();
        this.u = u;
        nome.setText(u.getNome());
        email.setText(u.getEmail());
        email.setEnabled(false);
        cidade_estado.setText(u.getCidadeEstado());
        senha.setText(u.getSenha());
        confirmar_senha.setText(u.getSenha());
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel_cadastro_de_usuario = new javax.swing.JLabel();
        jLabel_nome = new javax.swing.JLabel();
        nome = new javax.swing.JTextField();
        jLabel_email = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        jLabel_cidade_estado = new javax.swing.JLabel();
        cidade_estado = new javax.swing.JTextField();
        jLabel_senha = new javax.swing.JLabel();
        senha = new javax.swing.JPasswordField();
        jLabel_confirmar_senha = new javax.swing.JLabel();
        confirmar_senha = new javax.swing.JPasswordField();
        jButton_alterar = new javax.swing.JButton();
        jButton_cancelar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabelArquivo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Rede Social MTP");

        jLabel_cadastro_de_usuario.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel_cadastro_de_usuario.setText("Alterar cadastro");

        jLabel_nome.setText("Nome:");

        jLabel_email.setText("E-mail:");

        jLabel_cidade_estado.setText("Cidade/Estado:");

        jLabel_senha.setText("Senha:");

        senha.setPreferredSize(new java.awt.Dimension(14, 23));

        jLabel_confirmar_senha.setText("Confirmar senha:");

        confirmar_senha.setPreferredSize(new java.awt.Dimension(14, 23));

        jButton_alterar.setText("Salvar");
        jButton_alterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_alterarActionPerformed(evt);
            }
        });

        jButton_cancelar.setText("Cancelar");
        jButton_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_cancelarActionPerformed(evt);
            }
        });

        jButton1.setText("Inserir/Alterar foto");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Arquivo:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(167, 167, 167)
                        .addComponent(jLabel_cadastro_de_usuario))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel_senha)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(senha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel_cidade_estado)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cidade_estado))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel_email)
                                .addGap(9, 9, 9)
                                .addComponent(email))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel_nome)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel_confirmar_senha)
                                    .addComponent(jButton_alterar))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButton1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton_cancelar))
                                    .addComponent(confirmar_senha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelArquivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGap(0, 25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel_cadastro_de_usuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel_email, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cidade_estado, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_cidade_estado, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_senha, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(senha, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_confirmar_senha, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(confirmar_senha, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addComponent(jLabelArquivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_alterar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_cancelarActionPerformed
        new TelaPrincipal(u).setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton_cancelarActionPerformed

    private void jButton_alterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_alterarActionPerformed
        Conexao c = new Conexao();
        c.conectar();
        FileParaByte fpb = new FileParaByte();

        if (nome.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Campo nome não pode estar vazio");
            nome.requestFocus();

        } else if (new String(senha.getPassword()).trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Campo senha não pode estar vazio");
            senha.requestFocus();

        } else {
            if (new String(senha.getPassword()).equals(new String(confirmar_senha.getPassword()))) {
                String senhaCript = CriptografaSenha.critografarSenha(new String(senha.getPassword()));
                if (arquivo != null && u.getImagem() != null) {
                    try {
                        c.alterarPessoaImagem(nome.getText(), email.getText(), senhaCript, cidade_estado.getText(), arquivo);
                        JOptionPane.showMessageDialog(null, "Alteração efetuada com sucesso");
                        Usuario user = new Usuario();
                        user.setNome(nome.getText());
                        user.setEmail(email.getText());
                        user.setSenha(new String(senha.getPassword()));
                        user.setCidadeEstado(cidade_estado.getText());
                        user.setImagem(fpb.fileParaByte(arquivo));
                        new TelaPrincipal(user).setVisible(true);
                        dispose();
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(TelaCriacaoDePost.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } else {
                    c.alterar(nome.getText(), email.getText(), senhaCript, cidade_estado.getText());
                    JOptionPane.showMessageDialog(null, "Alteração efetuada com sucesso");
                    Usuario user = new Usuario();
                    user.setNome(nome.getText());
                    user.setEmail(email.getText());
                    user.setSenha(new String(senha.getPassword()));
                    user.setCidadeEstado(cidade_estado.getText());
                    user.setImagem(u.getImagem());
                    new TelaPrincipal(user).setVisible(true);
                    dispose();

                } 
                
            } else {
                JOptionPane.showMessageDialog(null, "Senhas não conferem");
                senha.requestFocus();
            }

        }


    }//GEN-LAST:event_jButton_alterarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JFileChooser fc = new JFileChooser();
        int retorno = fc.showOpenDialog(this);

        if (retorno == JFileChooser.APPROVE_OPTION) {
            arquivo = fc.getSelectedFile();
            jLabelArquivo.setText(arquivo.getName());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cidade_estado;
    private javax.swing.JPasswordField confirmar_senha;
    private javax.swing.JTextField email;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton_alterar;
    private javax.swing.JButton jButton_cancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelArquivo;
    private javax.swing.JLabel jLabel_cadastro_de_usuario;
    private javax.swing.JLabel jLabel_cidade_estado;
    private javax.swing.JLabel jLabel_confirmar_senha;
    private javax.swing.JLabel jLabel_email;
    private javax.swing.JLabel jLabel_nome;
    private javax.swing.JLabel jLabel_senha;
    private javax.swing.JTextField nome;
    private javax.swing.JPasswordField senha;
    // End of variables declaration//GEN-END:variables
}
