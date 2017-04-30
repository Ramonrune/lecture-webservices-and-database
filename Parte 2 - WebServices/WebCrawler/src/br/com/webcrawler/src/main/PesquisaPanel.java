/*
 * Direitos reservados a Ramon Lacava Gutierrez Gonçales
 * ramonrune@gmail.com
 */
package br.com.webcrawler.src.main;

import br.com.webcrawler.src.classes.Aranha;
import br.com.webcrawler.src.classes.Janela;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JScrollBar;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;

/**
 *
 * @author Usuario
 */
public class PesquisaPanel extends javax.swing.JPanel {

    public static void setEncontrado(String texto) {
        encontrado.setText(texto);
    }

    public static void setTexto(String texto) {
        log.setText(log.getText() + texto + "\n");

        scrollParaBaixo();

    }

    private static void scrollParaBaixo() {
        SwingUtilities.invokeLater(
                new Runnable() {
            public void run() {
                jScrollPane1.getVerticalScrollBar().setValue(jScrollPane1.getVerticalScrollBar().getMaximum());
            }
        });
    }

    public PesquisaPanel() {

        initComponents();
        jScrollPane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        log.setLineWrap(true);
        palavrapesquisada.setText(MainPanel.palavratext);
        emailpesquisado.setText(MainPanel.urltext);

        Runnable tarefa = () -> {
            try {
                Thread.sleep(1500);
            } catch (InterruptedException ex) {
                Logger.getLogger(PesquisaPanel.class.getName()).log(Level.SEVERE, null, ex);
            }

            Aranha aranha = new Aranha();
            StringBuilder b = new StringBuilder();
            aranha.procurar((MainPanel.urltext), (MainPanel.palavratext));
        };

        Thread t = new Thread(tarefa);
        t.start();

        Runnable tarefa2 = () -> {
            try {
                Thread.sleep(2000);

                while (t.isAlive()) {
                    Thread.sleep(2000);
                    System.err.println("runnable");
                    Thread.State state = t.getState();

                    if (state.toString().equals("RUNNABLE")) {

                        Runtime rt = Runtime.getRuntime();

                        rt.runFinalization();
                        rt.gc();
                    } else {
                        break;
                    }
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(PesquisaPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        };

        Thread t2 = new Thread(tarefa2);
        t2.start();

    }

    /**
     * Creates new form Pesquisa
     */
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        voltar = new javax.swing.JLabel();
        palavrapesquisada = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        log = new javax.swing.JTextArea();
        encontrado = new javax.swing.JLabel();
        emailpesquisado = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setFocusable(false);
        setMinimumSize(new java.awt.Dimension(602, 412));
        setPreferredSize(new java.awt.Dimension(602, 412));
        setLayout(null);

        voltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/webcrawler/images/seta.png"))); // NOI18N
        voltar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                voltarMouseClicked(evt);
            }
        });
        add(voltar);
        voltar.setBounds(22, 11, 75, 50);

        palavrapesquisada.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        palavrapesquisada.setForeground(new java.awt.Color(255, 255, 255));
        palavrapesquisada.setText("Palavra Pesquisada");
        add(palavrapesquisada);
        palavrapesquisada.setBounds(103, 11, 179, 17);

        log.setBackground(new java.awt.Color(0, 0, 0));
        log.setColumns(20);
        log.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        log.setForeground(new java.awt.Color(255, 255, 255));
        log.setRows(5);
        jScrollPane1.setViewportView(log);

        add(jScrollPane1);
        jScrollPane1.setBounds(45, 79, 510, 272);

        encontrado.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        encontrado.setForeground(new java.awt.Color(255, 255, 255));
        encontrado.setText("Por enquanto não foi encontrado.");
        add(encontrado);
        encontrado.setBounds(45, 352, 510, 30);

        emailpesquisado.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        emailpesquisado.setForeground(new java.awt.Color(255, 255, 255));
        emailpesquisado.setText("Email Pesquisado");
        add(emailpesquisado);
        emailpesquisado.setBounds(103, 34, 179, 17);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/webcrawler/images/background.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        add(jLabel1);
        jLabel1.setBounds(0, 0, 890, 480);
    }// </editor-fold>//GEN-END:initComponents

    private void voltarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_voltarMouseClicked
        MainPanel mp = new MainPanel();
        Janela.chamaPanelConteudo(mp, this);
    }//GEN-LAST:event_voltarMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel emailpesquisado;
    private static javax.swing.JLabel encontrado;
    private javax.swing.JLabel jLabel1;
    private static javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JTextArea log;
    private javax.swing.JLabel palavrapesquisada;
    private javax.swing.JLabel voltar;
    // End of variables declaration//GEN-END:variables
}