/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redeSocialMTP;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author ifg
 */
public class ConteudoPostEmail extends javax.swing.JPanel {
    
    Post p = null;
    Usuario u = null;

    /**
     * Creates new form ConteudoPost
     */
    public ConteudoPostEmail() {
        initComponents();
    }

    public ConteudoPostEmail(Post post, Usuario user ) {
        this.u = user;
        this.p = post;
        initComponents();
        
        SimpleDateFormat dataFormat = new SimpleDateFormat("dd/MM/yyyy");
        
        
        jLabelUsuario.setText(post.getNomePessoa());
        jLabelData.setText(dataFormat.format(post.getDataPost()));
        jTextArea.setText(post.getTexto());
        jLabel1.setText(String.valueOf(post.getQuantLike()));
        
        if(post.getImagem() != null){
        
            try {
                InputStream is = new ByteArrayInputStream(post.getImagem());
                BufferedImage imag = ImageIO.read(is);
                ImageIcon icon = new ImageIcon(imag);
                jLabelImagem.setIcon(icon);
            } catch (IOException ex) {

            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelUsuario = new javax.swing.JLabel();
        jLabelData = new javax.swing.JLabel();
        jLabelLike = new javax.swing.JLabel();
        jLabelImagem = new javax.swing.JLabel();
        jButtonCurtir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextArea = new javax.swing.JTextArea();

        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        setPreferredSize(new java.awt.Dimension(350, 259));

        jLabelUsuario.setText("Usuario");

        jLabelData.setText("Data");

        jLabelLike.setText("likes:");

        jButtonCurtir.setText("Curtir");
        jButtonCurtir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCurtirActionPerformed(evt);
            }
        });

        jTextArea.setEditable(false);
        jTextArea.setColumns(20);
        jTextArea.setRows(5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelUsuario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                        .addComponent(jLabelData)
                        .addGap(54, 54, 54)
                        .addComponent(jLabelLike)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButtonCurtir)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabelImagem, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextArea, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelData)
                        .addComponent(jLabelLike)
                        .addComponent(jLabelUsuario)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextArea, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonCurtir, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCurtirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCurtirActionPerformed
        Conexao c = new Conexao();
        try {
            c.registarLike(this.u.getId(), this.p.getId());
            jLabel1.setText(String.valueOf(c.buscarQuantLike(this.p.getId())));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível registrar seu like");
        }
    }//GEN-LAST:event_jButtonCurtirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCurtir;
    private javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabelData;
    private javax.swing.JLabel jLabelImagem;
    public javax.swing.JLabel jLabelLike;
    public javax.swing.JLabel jLabelUsuario;
    private javax.swing.JTextArea jTextArea;
    // End of variables declaration//GEN-END:variables
}
