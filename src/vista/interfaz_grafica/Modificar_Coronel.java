/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista.interfaz_grafica;

import java.util.ArrayList;

import Militar.Soldados.Soldado;

/**
 *
 * @author Miguel
 */
public class Modificar_Coronel extends javax.swing.JFrame {
    public static ArrayList<Soldado> listaSoldados = new ArrayList<>(); 
    public interfaz_principal interfaz;
    /**
     * Creates new form Modificar_Coronel
     */
    public Modificar_Coronel() {
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

        menu_panel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        boton_guardar_cambios = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        boton_volver = new javax.swing.JButton();
        boton_bajar = new javax.swing.JButton();
        entrada_estrategia = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        entrada_nombre = new javax.swing.JTextField();
        entrada_unidad = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        menu_panel.setBackground(new java.awt.Color(0, 102, 51));
        menu_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Modificar soldado");
        menu_panel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 220, -1));

        boton_guardar_cambios.setText("guardar cambios");
        boton_guardar_cambios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_guardar_cambiosActionPerformed(evt);
            }
        });
        menu_panel.add(boton_guardar_cambios, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 273, -1, 30));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("para coronel");
        menu_panel.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 260, 110));

        boton_volver.setText("volver");
        boton_volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_volverActionPerformed(evt);
            }
        });
        menu_panel.add(boton_volver, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 273, -1, 30));

        boton_bajar.setText("bajar");
        boton_bajar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_bajarActionPerformed(evt);
            }
        });
        menu_panel.add(boton_bajar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 170, 205, 37));

        entrada_estrategia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entrada_estrategiaActionPerformed(evt);
            }
        });
        menu_panel.add(entrada_estrategia, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 210, 205, 37));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Rango");
        menu_panel.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 205, 37));

        jLabel9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("estrategia");
        menu_panel.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 205, 37));

        entrada_nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entrada_nombreActionPerformed(evt);
            }
        });
        menu_panel.add(entrada_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 90, 205, 37));

        entrada_unidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entrada_unidadActionPerformed(evt);
            }
        });
        menu_panel.add(entrada_unidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 130, 205, 37));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("unidad");
        menu_panel.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 205, 37));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("nombre");
        menu_panel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 205, 37));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menu_panel, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menu_panel, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void entrada_nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entrada_nombreActionPerformed
        /*codigo aqui */
    }//GEN-LAST:event_entrada_nombreActionPerformed

    private void entrada_unidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entrada_unidadActionPerformed
        /*codigo aqui */
    }//GEN-LAST:event_entrada_unidadActionPerformed

    private void boton_bajarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_bajarActionPerformed
        this.dispose();
    }//GEN-LAST:event_boton_bajarActionPerformed

    private void entrada_estrategiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entrada_estrategiaActionPerformed
        /*codigo aqui */
    }//GEN-LAST:event_entrada_estrategiaActionPerformed

    private void boton_guardar_cambiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_guardar_cambiosActionPerformed
        /*codigo aqui */
    }//GEN-LAST:event_boton_guardar_cambiosActionPerformed

    private void boton_volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_volverActionPerformed
        /*codigo aqui */
    }//GEN-LAST:event_boton_volverActionPerformed

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
            java.util.logging.Logger.getLogger(Modificar_Coronel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Modificar_Coronel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Modificar_Coronel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Modificar_Coronel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Modificar_Coronel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton_bajar;
    private javax.swing.JButton boton_guardar_cambios;
    private javax.swing.JButton boton_volver;
    private javax.swing.JTextField entrada_estrategia;
    private javax.swing.JTextField entrada_nombre;
    private javax.swing.JTextField entrada_unidad;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel menu_panel;
    // End of variables declaration//GEN-END:variables
}
