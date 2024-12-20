/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package interfaz_grafica;

import java.util.ArrayList;

import Militar.Soldados.Soldado;
import Militar.Soldados.SoldadoRaso;

/**
 *
 * @author Miguel
 */
public class interfaz_mostrar_informacion extends javax.swing.JFrame {
    public static ArrayList<Soldado> listaSoldados = new ArrayList<>(); 
    public interfaz_principal interfaz;
    /**
     * Creates new form interfaz_mostrar_informacion
     */
    public interfaz_mostrar_informacion() {
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

        buttonGroup2 = new javax.swing.ButtonGroup();
        Panel_menu = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        Entrada_codigo = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        Soldado_raso_radioButton = new javax.swing.JRadioButton();
        Teniente_radioButton = new javax.swing.JRadioButton();
        Capitan_radioButton = new javax.swing.JRadioButton();
        Coronel_radioButton = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setAlwaysOnTop(true);
        Panel_menu.setBackground(new java.awt.Color(0, 102, 51));
        Panel_menu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Mostrar informacion");
        Panel_menu.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 340, -1));

        jButton1.setText("Buscar soldado");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        Panel_menu.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 273, -1, 30));

        jButton2.setText("volver");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        Panel_menu.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 273, -1, 30));

        jButton4.setText("mostrar todos los registros");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        Panel_menu.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 273, 190, 30));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Filtrar rango");
        Panel_menu.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 205, 30));

        Entrada_codigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Entrada_codigoActionPerformed(evt);
            }
        });
        Panel_menu.add(Entrada_codigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, 205, 30));

        jLabel9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Codigo");
        Panel_menu.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 90, 30));

        jLabel10.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Filtrar soldado");
        Panel_menu.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 205, 30));

        buttonGroup2.add(Soldado_raso_radioButton);
        Soldado_raso_radioButton.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Soldado_raso_radioButton.setForeground(new java.awt.Color(255, 255, 255));
        Soldado_raso_radioButton.setText("SoldadoRaso");
        Soldado_raso_radioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Soldado_raso_radioButtonActionPerformed(evt);
            }
        });
        Panel_menu.add(Soldado_raso_radioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 130, 70));

        buttonGroup2.add(Teniente_radioButton);
        Teniente_radioButton.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Teniente_radioButton.setForeground(new java.awt.Color(255, 255, 255));
        Teniente_radioButton.setText("Teniente");
        Teniente_radioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Teiente_radioButtonActionPerformed(evt);
            }
        });

        Panel_menu.add(Teniente_radioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 106, 70));

        buttonGroup2.add(Capitan_radioButton);
        Capitan_radioButton.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Capitan_radioButton.setForeground(new java.awt.Color(255, 255, 255));
        Capitan_radioButton.setText("Capitan");
        Capitan_radioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Capitan_radioButtonActionPerformed(evt);
            }
        });
        Panel_menu.add(Capitan_radioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 180, 106, 70));

        buttonGroup2.add(Coronel_radioButton);
        Coronel_radioButton.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Coronel_radioButton.setForeground(new java.awt.Color(255, 255, 255));
        Coronel_radioButton.setText("Coronel");
        Coronel_radioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Coronel_radioButtonActionPerformed(evt);
            }
        });
        Panel_menu.add(Coronel_radioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 180, 106, 70));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 7, Short.MAX_VALUE)
                .addComponent(Panel_menu, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 7, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 7, Short.MAX_VALUE)
                .addComponent(Panel_menu, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 7, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Entrada_codigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Entrada_codigoActionPerformed
        /*codigo aqui */
    }//GEN-LAST:event_Entrada_codigoActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        interfaz.update();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       interfaz.mostrarsoldado(Entrada_codigo.getText().trim(), listaSoldados);

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        interfaz.update();
        this.dispose();

    }//GEN-LAST:event_jButton2ActionPerformed

    private void Soldado_raso_radioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Soldado_raso_radioButtonActionPerformed
      interfaz.update2(interfaz.filtrar(listaSoldados,1));
    }//GEN-LAST:event_Soldado_raso_radioButtonActionPerformed
    private void Teiente_radioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Soldado_raso_radioButtonActionPerformed
        interfaz.update2(interfaz.filtrar(listaSoldados,2));
      }//GEN-LAST:event_Soldado_raso_radioButtonActionPerformed
      private void Capitan_radioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Soldado_raso_radioButtonActionPerformed
        interfaz.update2(interfaz.filtrar(listaSoldados,3));
      }//GEN-LAST:event_Soldado_raso_radioButtonActionPerformed
  
    private void Coronel_radioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Coronel_radioButtonActionPerformed
        interfaz.update2(interfaz.filtrar(listaSoldados,4));
    }//GEN-LAST:event_Coronel_radioButtonActionPerformed

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
            java.util.logging.Logger.getLogger(interfaz_mostrar_informacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(interfaz_mostrar_informacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(interfaz_mostrar_informacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(interfaz_mostrar_informacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new interfaz_mostrar_informacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton Capitan_radioButton;
    private javax.swing.JRadioButton Coronel_radioButton;
    private javax.swing.JTextField Entrada_codigo;
    private javax.swing.JPanel Panel_menu;
    private javax.swing.JRadioButton Soldado_raso_radioButton;
    private javax.swing.JRadioButton Teniente_radioButton;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}
