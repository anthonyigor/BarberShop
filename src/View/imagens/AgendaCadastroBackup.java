/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View.imagens;
import java.sql.*;
import br.com.barbearia.dal.moduloConexao;
import javax.swing.JOptionPane;
// Import para recursos da biblioteca
import net.proteanit.sql.DbUtils;
/**
 *
 * @author LegendarioP
 */
public class AgendaCadastroBackup extends javax.swing.JFrame {
    /**
     * Creates new form AgendaCadastro
     */
    public AgendaCadastroBackup() {
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

        hourDate = new javax.swing.JTextField();
        observerField = new javax.swing.JTextField();
        registerID = new javax.swing.JTextField();
        dateAgenda = new javax.swing.JTextField();
        serviceList = new javax.swing.JComboBox<>();
        barberList = new javax.swing.JComboBox<>();
        clientList = new javax.swing.JComboBox<>();
        observerFiled = new javax.swing.JLabel();
        service = new javax.swing.JLabel();
        Client = new javax.swing.JLabel();
        register = new javax.swing.JLabel();
        barber = new javax.swing.JLabel();
        dataNum = new javax.swing.JLabel();
        hourNum1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        BackgroundFaded = new javax.swing.JLabel();
        BackgroundAgenda = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        hourDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hourDateActionPerformed(evt);
            }
        });
        getContentPane().add(hourDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 230, 300, 30));

        observerField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                observerFieldActionPerformed(evt);
            }
        });
        getContentPane().add(observerField, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 310, 920, 110));

        registerID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerIDActionPerformed(evt);
            }
        });
        getContentPane().add(registerID, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 150, 300, 30));

        dateAgenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateAgendaActionPerformed(evt);
            }
        });
        getContentPane().add(dateAgenda, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 190, 300, 30));

        serviceList.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Barba", "Barba e Cabelo", "Sobrancelha", "Completo" }));
        serviceList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                serviceListActionPerformed(evt);
            }
        });
        getContentPane().add(serviceList, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 150, 300, 30));

        barberList.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cleber", "Robinho", "Pedro" }));
        barberList.setToolTipText("");
        barberList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                barberListActionPerformed(evt);
            }
        });
        getContentPane().add(barberList, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 190, 300, 30));

        clientList.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Alfredo", "Carlos", "Lucas" }));
        clientList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clientListActionPerformed(evt);
            }
        });
        getContentPane().add(clientList, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 230, 300, 30));

        observerFiled.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        observerFiled.setForeground(new java.awt.Color(255, 255, 255));
        observerFiled.setText("OBSERVAÇÃO:");
        getContentPane().add(observerFiled, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 280, -1, -1));

        service.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        service.setForeground(new java.awt.Color(255, 255, 255));
        service.setText("SERVIÇO:");
        getContentPane().add(service, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 150, -1, -1));

        Client.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Client.setForeground(new java.awt.Color(255, 255, 255));
        Client.setText("CLIENTE:");
        Client.setPreferredSize(new java.awt.Dimension(133, 29));
        getContentPane().add(Client, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 230, -1, -1));

        register.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        register.setForeground(new java.awt.Color(255, 255, 255));
        register.setText("REGISTRO: ");
        getContentPane().add(register, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, -1, -1));

        barber.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        barber.setForeground(new java.awt.Color(255, 255, 255));
        barber.setText("BARBEIRO:");
        getContentPane().add(barber, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 190, -1, -1));

        dataNum.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        dataNum.setForeground(new java.awt.Color(255, 255, 255));
        dataNum.setText("DATA:");
        getContentPane().add(dataNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 190, -1, -1));

        hourNum1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        hourNum1.setForeground(new java.awt.Color(255, 255, 255));
        hourNum1.setText("HORA:");
        getContentPane().add(hourNum1, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 230, -1, -1));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton1.setText("AGENDAR");
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 430, 190, 40));

        BackgroundFaded.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/imagens/Agenda-PainelFundo.png"))); // NOI18N
        getContentPane().add(BackgroundFaded, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        BackgroundAgenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/imagens/AgendaFundo.png"))); // NOI18N
        getContentPane().add(BackgroundAgenda, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void hourDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hourDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hourDateActionPerformed

    private void observerFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_observerFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_observerFieldActionPerformed

    private void serviceListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_serviceListActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_serviceListActionPerformed

    private void barberListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_barberListActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_barberListActionPerformed

    private void clientListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientListActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clientListActionPerformed

    private void registerIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_registerIDActionPerformed

    private void dateAgendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateAgendaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dateAgendaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AgendaCadastroBackup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgendaCadastroBackup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgendaCadastroBackup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgendaCadastroBackup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AgendaCadastroBackup().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BackgroundAgenda;
    private javax.swing.JLabel BackgroundFaded;
    private javax.swing.JLabel Client;
    private javax.swing.JLabel barber;
    private javax.swing.JComboBox<String> barberList;
    private javax.swing.JComboBox<String> clientList;
    private javax.swing.JLabel dataNum;
    private javax.swing.JTextField dateAgenda;
    private javax.swing.JTextField hourDate;
    private javax.swing.JLabel hourNum1;
    private javax.swing.JButton jButton1;
    private javax.swing.JTextField observerField;
    private javax.swing.JLabel observerFiled;
    private javax.swing.JLabel register;
    private javax.swing.JTextField registerID;
    private javax.swing.JLabel service;
    private javax.swing.JComboBox<String> serviceList;
    // End of variables declaration//GEN-END:variables
}
