/*
 * Direitos reservados a Ramon Lacava Gutierrez Gonçales
 * ramonrune@gmail.com
 */
package br.com.webcrawler.src.main;

import br.com.webcrawler.src.classes.PernaDaAranha;
import br.com.webcrawler.src.classes.Janela;
import java.awt.Color;

import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class MainPanel extends javax.swing.JPanel {

    public static String urltext;
    public static String palavratext;

    /**
     * Creates new form MainPanel
     */
    public MainPanel() {
        initComponents();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        palavra = new javax.swing.JTextField();
        pesquisar = new javax.swing.JButton();
        url = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(602, 412));
        setLayout(null);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/webcrawler/images/web-crawler.png"))); // NOI18N
        add(jLabel2);
        jLabel2.setBounds(168, 25, 257, 150);

        palavra.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        palavra.setForeground(new java.awt.Color(204, 204, 204));
        palavra.setText("Palavra");
        palavra.setToolTipText("Digite a palavra que deseja pesquisar.");
        palavra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                palavraMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                palavraMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                palavraMouseExited(evt);
            }
        });
        add(palavra);
        palavra.setBounds(168, 193, 266, 39);

        pesquisar.setBackground(new java.awt.Color(255, 255, 255));
        pesquisar.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        pesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/webcrawler/images/search.png"))); // NOI18N
        pesquisar.setText("Pesquisar");
        pesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesquisarActionPerformed(evt);
            }
        });
        add(pesquisar);
        pesquisar.setBounds(170, 300, 260, 50);

        url.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        url.setForeground(new java.awt.Color(204, 204, 204));
        url.setText("http://www.site.com");
        url.setToolTipText("Digite a URL no seguinte Formato:\nhttp://www.seusite.com");
        url.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                urlMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                urlMouseEntered(evt);
            }
        });
        add(url);
        url.setBounds(168, 238, 266, 39);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/webcrawler/images/background.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        jLabel1.setPreferredSize(new java.awt.Dimension(602, 412));
        add(jLabel1);
        jLabel1.setBounds(0, -20, 680, 510);
    }// </editor-fold>//GEN-END:initComponents

    private void pesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisarActionPerformed

        if (url.getText().contains("http://") || url.getText().contains(".")) {
            PernaDaAranha pernaAranha = new PernaDaAranha();
            
            if (pernaAranha.testaConexao((url.getText()))) {
                this.palavratext = palavra.getText();
                this.urltext = url.getText();
                PesquisaPanel p = new PesquisaPanel();
                Janela.chamaPanelConteudo(p, this);
            }
            else{
                JOptionPane.showMessageDialog(null, "Por favor, insira a url corretamente");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Por favor, insira a palavra e a url corretamente");
        }


    }//GEN-LAST:event_pesquisarActionPerformed

    private void palavraMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_palavraMouseEntered

    }//GEN-LAST:event_palavraMouseEntered

    private void palavraMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_palavraMouseExited

    }//GEN-LAST:event_palavraMouseExited

    private void urlMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_urlMouseEntered

    }//GEN-LAST:event_urlMouseEntered

    private void palavraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_palavraMouseClicked
        palavra.setText("");
        palavra.setForeground(Color.BLACK);
    }//GEN-LAST:event_palavraMouseClicked

    private void urlMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_urlMouseClicked
        url.setText("");
        url.setForeground(Color.BLACK);
    }//GEN-LAST:event_urlMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField palavra;
    private javax.swing.JButton pesquisar;
    private javax.swing.JTextField url;
    // End of variables declaration//GEN-END:variables
}
