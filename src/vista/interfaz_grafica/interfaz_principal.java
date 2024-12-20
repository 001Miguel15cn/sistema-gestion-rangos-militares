/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista.interfaz_grafica;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.AbstractListModel;
import javax.swing.JOptionPane;

import Militar.Soldados.Capitan;
import Militar.Soldados.Coronel;
import Militar.Soldados.Soldado;
import Militar.Soldados.SoldadoRaso;
import Militar.Soldados.Teniente;

import java.awt.Color;
import java.util.ArrayList;


/**
 *
 * @author Miguel
 */
public class interfaz_principal extends javax.swing.JFrame {
    //los control se usan para controlar que solo una interfaz auxiliar este abierta
    boolean control = true;
    boolean control2 = true;
    boolean control3 = true;
    boolean control4 = true;
    boolean control5 = true;
    public static ArrayList<Soldado> listaSoldados = new ArrayList<>(); 
    public static ArrayList<Soldado> listaSoldadosDefecto = new ArrayList<>();
    /**
     * Creates new form interfaz_principal
     */
    public interfaz_principal() {
        try {
        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
                javax.swing.UIManager.setLookAndFeel(info.getClassName());
                break;
            }
        }
        } catch (Exception ex) {
            ex.printStackTrace();
        } 
    initComponents();
    
    
    }

        public void update(){
        int index = 0; 
        String[] string = new String[listaSoldados.size()];
        Soldados_rasos_totales.setText("" + SoldadoRaso.cantidad);
        Tenientes_totales.setText("" + Teniente.cantidad);
        Capitanes_totales.setText("" + Capitan.cantidad);
        Coroneles_totales.setText("" + Coronel.cantidad);

        Soldados_rasos_totales.repaint();
        Tenientes_totales.repaint();
        Capitanes_totales.repaint();
        Coroneles_totales.repaint();

        for (Soldado soldado : listaSoldados) {
           string[index] = soldado.mostrarInformacion();
           index++;
        }
        lista_de_soldado.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = string;
 
 
             
             public int getSize() { return strings.length; }
             public String getElementAt(int i) { return strings[i]; }
         });

         
        lista_de_soldado.repaint();

    }
    public void mostrarsoldado(String Id,ArrayList<Soldado> lista){
        int index = 0; 
        String[] string = new String[listaSoldados.size()];
        boolean control = false;
        int count = 0;

        for (Soldado soldado : lista) {
            if (soldado.getId().equalsIgnoreCase(Id)){
            string[index] = soldado.mostrarInformacion();
            control = true;
            break;}
             else{
                count++;
             }
         }

        if (count == lista.size()){
             JOptionPane.showMessageDialog(this, "No se encontró el soldado.");  
        }
        if (control){
         lista_de_soldado.setModel(new javax.swing.AbstractListModel<String>() {
             String[] strings = string;
  
  
              
              public int getSize() { return strings.length; }
              public String getElementAt(int i) { return strings[i]; }
          });
 
       
            lista_de_soldado.repaint();
         }

    }
    public void update2(ArrayList<Soldado> lista){
        int index = 0; 
        String[] string = new String[listaSoldados.size()];

        for (Soldado soldado : lista) {
            string[index] = soldado.mostrarInformacion();
            index++;
         }
         lista_de_soldado.setModel(new javax.swing.AbstractListModel<String>() {
             String[] strings = string;
  
  
              
              public int getSize() { return strings.length; }
              public String getElementAt(int i) { return strings[i]; }
          });
 
          
         lista_de_soldado.repaint();
 

    }

    public static ArrayList<Soldado> filtrar(ArrayList<Soldado> lista, int valor){
         ArrayList<Soldado> listaretorno = new ArrayList<>(); 
         for (Soldado soldado : lista) {
            switch(valor){
             case 1: if (soldado instanceof SoldadoRaso){ listaretorno.add(soldado);}
                     break;
             case 2: if (soldado instanceof Teniente) { listaretorno.add(soldado);}
                     break;
             case 3: if (soldado instanceof Capitan){ listaretorno.add(soldado);}
                    break;
             case 4: if (soldado instanceof Coronel) { listaretorno.add(soldado);}
                    break;
            default:
                  break;
        }
    }
        
        return (ArrayList<Soldado>) listaretorno;
    }

    public static void setListaSoldados(ArrayList<Soldado> lista) {
        for (Soldado soldado : lista) {
            listaSoldados.add(soldado);

        }
    }


    public static void setListaSoldadosDefecto(ArrayList<Soldado> lista) {
        for (Soldado soldado : lista) {
            listaSoldadosDefecto.add(soldado);

        }

        }

        public static <T> ArrayList<T> obtenerDiferencia(ArrayList<T> lista1, ArrayList<T> lista2) {
            ArrayList<T> diferencia = new ArrayList<>(lista1);
            diferencia.removeAll(lista2);
            return diferencia;
        }

    public void defecto(){
        for (Soldado soldado : obtenerDiferencia(listaSoldados,listaSoldadosDefecto)) {
            if (soldado instanceof SoldadoRaso) {
                ((SoldadoRaso)soldado).remove();
                }
            if (soldado instanceof Teniente) {
                ((Teniente)soldado).remove();
                }
            if (soldado instanceof Capitan) {
                 ((Capitan)soldado).remove();
                }
            if (soldado instanceof Coronel) {
                  ((Coronel)soldado).remove();
                }
        }
        listaSoldados.clear();
        listaSoldados.addAll(listaSoldadosDefecto);
        System.gc();
    }



    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        titulo = new javax.swing.JLabel();
        Panel_de_menus = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        panel_menu_de_gestion = new javax.swing.JPanel();
        Boton_patrullar = new javax.swing.JButton();
        Boton_saludar = new javax.swing.JButton();
        Boton_regañar_soldado = new javax.swing.JButton();
        Boton_reportar_estado = new javax.swing.JButton();
        Boton_relizar_accion = new javax.swing.JButton();
        Boton_asignar_mision = new javax.swing.JButton();
        panel_mision_y_codigo = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        entrada_mision = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        entrada_codigo = new javax.swing.JTextField();
        panel_menu_de_edicion = new javax.swing.JPanel();
        boton_crear_soldado = new javax.swing.JButton();
        boton_editar_soldado = new javax.swing.JButton();
        boton_mostrar_informacion = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        panel_total_de_registros = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        Soldados_rasos_totales = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        Tenientes_totales = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        Capitanes_totales = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        Coroneles_totales = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        panel_principal_de_lista = new javax.swing.JPanel();
        boton_resetear = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        panel_de_Lista = new javax.swing.JScrollPane();
        lista_de_soldado = new javax.swing.JList<>();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        nimbus = new javax.swing.JRadioButtonMenuItem();
        metal = new javax.swing.JRadioButtonMenuItem();
        CDE = new javax.swing.JRadioButtonMenuItem();
        Windows_classic = new javax.swing.JRadioButtonMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("sistema de gestion de rangos militares");
        setBackground(new java.awt.Color(255, 255, 255));
        setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        setMinimumSize(new java.awt.Dimension(840, 537));
        setPreferredSize(new java.awt.Dimension(585, 525));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titulo.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        titulo.setForeground(new java.awt.Color(102, 102, 102));
        titulo.setText("Sistema de gestion de rangos militares");
        getContentPane().add(titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 378, 20));

        jPanel1.setBackground(new java.awt.Color(0, 102, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_menu_de_gestion.setBackground(new java.awt.Color(0, 102, 51));
        panel_menu_de_gestion.setLayout(new java.awt.GridLayout(0, 2));

        Boton_patrullar.setText("patrullar");
        Boton_patrullar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton_patrullarActionPerformed(evt);
            }
        });
        panel_menu_de_gestion.add(Boton_patrullar);

        Boton_saludar.setText("saludar");
        Boton_saludar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton_saludarActionPerformed(evt);
            }
        });
        panel_menu_de_gestion.add(Boton_saludar);

        Boton_regañar_soldado.setText("regañar soldado");
        panel_menu_de_gestion.add(Boton_regañar_soldado);

        Boton_reportar_estado.setText("reportarEstado");
        Boton_reportar_estado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton_reportar_estadoActionPerformed(evt);
            }
        });
        panel_menu_de_gestion.add(Boton_reportar_estado);

        Boton_relizar_accion.setText("realizar accion");
        panel_menu_de_gestion.add(Boton_relizar_accion);

        Boton_asignar_mision.setText("Asignar mision");
        Boton_asignar_mision.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton_asignar_misionActionPerformed(evt);
            }
        });

        
        panel_menu_de_gestion.add(Boton_asignar_mision);

        jPanel1.add(panel_menu_de_gestion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 270, 90));

        panel_mision_y_codigo.setBackground(new java.awt.Color(0, 102, 51));
        panel_mision_y_codigo.setLayout(new java.awt.GridLayout(0, 1));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("campo de mision");
        panel_mision_y_codigo.add(jLabel4);

        entrada_mision.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entrada_misionActionPerformed(evt);
            }
        });
        panel_mision_y_codigo.add(entrada_mision);

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("codigo de soldado");
        panel_mision_y_codigo.add(jLabel3);

        entrada_codigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entrada_codigoActionPerformed(evt);
            }
        });
        panel_mision_y_codigo.add(entrada_codigo);

        jPanel1.add(panel_mision_y_codigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 150, 160, 90));

        panel_menu_de_edicion.setBackground(new java.awt.Color(0, 102, 51));
        panel_menu_de_edicion.setLayout(new java.awt.GridLayout(1, 0));

        boton_crear_soldado.setText("crear soldado");
        boton_crear_soldado.setToolTipText("");
        boton_crear_soldado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_crear_soldadoActionPerformed(evt);
            }
        });
        panel_menu_de_edicion.add(boton_crear_soldado);

        boton_editar_soldado.setText("editar soldados");
        boton_editar_soldado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_editar_soldadoActionPerformed(evt);
            }
        });
        panel_menu_de_edicion.add(boton_editar_soldado);

        boton_mostrar_informacion.setLabel("ver informacion");
        boton_mostrar_informacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_mostrar_informacionActionPerformed(evt);
            }
        });
        panel_menu_de_edicion.add(boton_mostrar_informacion);

        jPanel1.add(panel_menu_de_edicion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 440, 30));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("total de registros");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 260, -1, -1));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("menu de edicion");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, -1, -1));

        panel_total_de_registros.setBackground(new java.awt.Color(0, 102, 51));
        panel_total_de_registros.setLayout(new java.awt.GridLayout(0, 2));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("            soldados rasos :");
        panel_total_de_registros.add(jLabel7);

        Soldados_rasos_totales.setEditable(false);
        Soldados_rasos_totales.setBackground(new java.awt.Color(0, 102, 51));
        Soldados_rasos_totales.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Soldados_rasos_totales.setForeground(new java.awt.Color(255, 255, 255));
        Soldados_rasos_totales.setText("" + SoldadoRaso.cantidad);
        Soldados_rasos_totales.setBorder(null);
        Soldados_rasos_totales.setCaretColor(new java.awt.Color(255, 255, 255));
        Soldados_rasos_totales.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        Soldados_rasos_totales.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        Soldados_rasos_totales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Soldados_rasos_totalesActionPerformed(evt);
            }
        });
        panel_total_de_registros.add(Soldados_rasos_totales);

        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("                      tenientes :");
        panel_total_de_registros.add(jLabel8);

        Tenientes_totales.setEditable(false);
        Tenientes_totales.setBackground(new java.awt.Color(0, 102, 51));
        Tenientes_totales.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Tenientes_totales.setForeground(new java.awt.Color(255, 255, 255));
        Tenientes_totales.setText("" + Teniente.cantidad);
        Tenientes_totales.setBorder(null);
        Tenientes_totales.setCaretColor(new java.awt.Color(255, 255, 255));
        Tenientes_totales.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        Tenientes_totales.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        Tenientes_totales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tenientes_totalesActionPerformed(evt);
            }
        });
        panel_total_de_registros.add(Tenientes_totales);

        jLabel9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("                      capitanes :");
        panel_total_de_registros.add(jLabel9);

        Capitanes_totales.setEditable(false);
        Capitanes_totales.setBackground(new java.awt.Color(0, 102, 51));
        Capitanes_totales.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Capitanes_totales.setForeground(new java.awt.Color(255, 255, 255));
        Capitanes_totales.setText("" + Capitan.cantidad);
        Capitanes_totales.setBorder(null);
        Capitanes_totales.setCaretColor(new java.awt.Color(255, 255, 255));
        Capitanes_totales.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        Capitanes_totales.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        Capitanes_totales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Capitanes_totalesActionPerformed(evt);
            }
        });
        panel_total_de_registros.add(Capitanes_totales);

        jLabel10.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("                     coroneles :");
        panel_total_de_registros.add(jLabel10);

        Coroneles_totales.setEditable(false);
        Coroneles_totales.setBackground(new java.awt.Color(0, 102, 51));
        Coroneles_totales.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Coroneles_totales.setForeground(new java.awt.Color(255, 255, 255));
        Coroneles_totales.setText("" + Coronel.cantidad);
        Coroneles_totales.setBorder(null);
        Coroneles_totales.setCaretColor(new java.awt.Color(255, 255, 255));
        Coroneles_totales.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        Coroneles_totales.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        Coroneles_totales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Coroneles_totalesActionPerformed(evt);
            }
        });
        panel_total_de_registros.add(Coroneles_totales);

        jPanel1.add(panel_total_de_registros, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 300, 350, 70));

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("menu de gestion");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, -1, -1));

        Panel_de_menus.setViewportView(jPanel1);

        getContentPane().add(Panel_de_menus, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 490, 420));

        panel_principal_de_lista.setBackground(new java.awt.Color(51, 102, 0));
        panel_principal_de_lista.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        boton_resetear.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        boton_resetear.setText("reset aplicación");
        boton_resetear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_resetearActionPerformed(evt);
            }
        });
        panel_principal_de_lista.add(boton_resetear, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 380, -1, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Lista de soldados");
        panel_principal_de_lista.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 37, 127, -1));

        lista_de_soldado.setModel(new javax.swing.AbstractListModel<String>() {
           // String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
           String[] strings = new String[listaSoldados.size()];


            
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });

        panel_de_Lista.setViewportView(lista_de_soldado);

        panel_principal_de_lista.add(panel_de_Lista, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 72, 230, 280));

        getContentPane().add(panel_principal_de_lista, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 0, 300, 520));

        jMenu2.setText("cambiar estilo de ventana");

        buttonGroup2.add(nimbus);
        nimbus.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        nimbus.setSelected(true);
        nimbus.setText("nimbus");
        nimbus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nimbusActionPerformed(evt);
            }
        });
        jMenu2.add(nimbus);

        buttonGroup2.add(metal);
        metal.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        metal.setText("metal");
        metal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                metalActionPerformed(evt);
            }
        });
        jMenu2.add(metal);

        buttonGroup2.add(CDE);
        CDE.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        CDE.setText("CDE/Motif");
        CDE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CDEActionPerformed(evt);
            }
        });
        jMenu2.add(CDE);

        buttonGroup2.add(Windows_classic);
        Windows_classic.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        Windows_classic.setText("Windows Classic");
        Windows_classic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Windows_classicActionPerformed(evt);
            }
        });
        jMenu2.add(Windows_classic);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boton_resetearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_resetearActionPerformed
        defecto();
        update();
    }//GEN-LAST:event_boton_resetearActionPerformed

    private void entrada_codigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entrada_codigoActionPerformed
        /*codigo aqui */
    }//GEN-LAST:event_entrada_codigoActionPerformed

    private void boton_mostrar_informacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_mostrar_informacionActionPerformed
                      // Crear una nueva instancia de la interfaz Modificar_soldado
        if(control3){
         interfaz_mostrar_informacion ventanaMostrarSoldado = new interfaz_mostrar_informacion();
         ventanaMostrarSoldado.listaSoldados = listaSoldados;
         ventanaMostrarSoldado.interfaz = this;
            
          //escuchar cuando la ventana se cierre para establecer en true la variable de control
         ventanaMostrarSoldado.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e) {
                control3 = true; // Cambiar control a true cuando la ventana sea cerrada
            }
        });
    // Hacer visible la nueva ventana
    ventanaMostrarSoldado.setVisible(true);
        control3 = false;
        }
    }//GEN-LAST:event_boton_mostrar_informacionActionPerformed

    private void Boton_asignar_misionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton_asignar_misionActionPerformed
        buscar(listaSoldados);
    }//GEN-LAST:event_Boton_asignar_misionActionPerformed

    void buscar(ArrayList<Soldado> listaSoldados1){
            String idSoldado = entrada_codigo.getText().trim();
            String mision = entrada_mision.getText().trim();
                for(Soldado i:listaSoldados1){
                    String idDelSoldado = i.getId();
                    if(idDelSoldado.equals(idSoldado)){
                        //esta linea retorna error con los nueos cambios, 
                        //para las misiones es necesario añadir un jcombobox
          JOptionPane.showMessageDialog(this, i.asignarMision(mision), "Mision asignada al militar buscado", JOptionPane.INFORMATION_MESSAGE);
                    }
                 }
        }

    private void entrada_misionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entrada_misionActionPerformed
        /*codigo aqui */
    }//GEN-LAST:event_entrada_misionActionPerformed

    private void Boton_reportar_estadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton_reportar_estadoActionPerformed
        buscar1(listaSoldados);}
    //GEN-LAST:event_Boton_reportar_estadoActionPerformed

    void buscar1(ArrayList<Soldado> listaSoldados1){
        if (control5){
        String idSoldado = entrada_codigo.getText().trim();
            for(Soldado i:listaSoldados1){
                String idDelSoldado = i.getId();
                String Rango = i.getRango();
                if(idDelSoldado.equals(idSoldado)){
                    if (Rango.equals("Coronel")) {
                        ReportarEstadoCoronel reportarestadocoronel = new ReportarEstadoCoronel();
                        reportarestadocoronel.interfaz = this;
                        //escuchar cuando la ventana se cierre para establecer en true la variable de control
                        reportarestadocoronel.addWindowListener(new java.awt.event.WindowAdapter() {
                        @Override
                        public void windowClosed(java.awt.event.WindowEvent e) {
                        control5 = true; // Cambiar control a true cuando la ventana sea cerrada
                    }
                    });
    
                        reportarestadocoronel.setVisible(true);
                        control5 = false;}

                    else if (Rango.equals("Capitan")) {
                        ReportarEstadoCapitan_Interfaz reportarestadocapitaninterfaz = new ReportarEstadoCapitan_Interfaz();
                        reportarestadocapitaninterfaz.interfaz = this;
                        //escuchar cuando la ventana se cierre para establecer en true la variable de control
                        reportarestadocapitaninterfaz.addWindowListener(new java.awt.event.WindowAdapter() {
                        @Override
                        public void windowClosed(java.awt.event.WindowEvent e) {
                        control5 = true; // Cambiar control a true cuando la ventana sea cerrada
                    }
                    });
    
                        reportarestadocapitaninterfaz.setVisible(true);
                        control5 = false;}

                    else if(Rango.equals("Teniente")){
                        ReportarEstadoTeniente_Interfaz reportarestadotenienteinterfaz = new ReportarEstadoTeniente_Interfaz();
                        reportarestadotenienteinterfaz.interfaz = this;
                        //escuchar cuando la ventana se cierre para establecer en true la variable de control
                        reportarestadotenienteinterfaz.addWindowListener(new java.awt.event.WindowAdapter() {
                        @Override
                        public void windowClosed(java.awt.event.WindowEvent e){
                            control5 = true;
                        }
                        });
                        
                        reportarestadotenienteinterfaz.setVisible(true);
                        control5 = false;}

                    else if(Rango.equals("Soldado Raso")){
                        ReportarEstadoSoldadoRaso_Interfaz reportarestadosoldadorasointerfaz = new ReportarEstadoSoldadoRaso_Interfaz();
                        reportarestadosoldadorasointerfaz.interfaz = this;
                        //escuchar cuando la ventana se cierre para establecer en true la variable de control
                        reportarestadosoldadorasointerfaz.addWindowListener(new java.awt.event.WindowAdapter() {
                        @Override
                        public void windowClosed(java.awt.event.WindowEvent e){
                            control5 = true;
                        }
                        });
                            
                        reportarestadosoldadorasointerfaz.setVisible(true);
                        control5 = false;}    
                }
            }
        }}

    private void Boton_saludarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton_reportar_estadoActionPerformed
        if (control4){
            Saludar_Interfaz saludar_Interfaz = new Saludar_Interfaz();
            saludar_Interfaz.listaSoldados1 = listaSoldados;
            saludar_Interfaz.interfaz = this;
             //escuchar cuando la ventana se cierre para establecer en true la variable de control
             saludar_Interfaz.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosed(java.awt.event.WindowEvent e) {
                    control4 = true; // Cambiar control a true cuando la ventana sea cerrada
                }
            });
    
            saludar_Interfaz.setVisible(true);
            control4 = false;}
        }
    //GEN-LAST:event_Boton_reportar_estadoActionPerformed

    private void boton_crear_soldadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_crear_soldadoActionPerformed
        if (control) {
            interfaz_crear_soldado ventanaCrearSoldado = new interfaz_crear_soldado();
            ventanaCrearSoldado.listaSoldados = listaSoldados;
            ventanaCrearSoldado.interfaz = this;
            
             //escuchar cuando la ventana se cierre para establecer en true la variable de control
            ventanaCrearSoldado.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosed(java.awt.event.WindowEvent e) {
                    control = true; // Cambiar control a true cuando la ventana sea cerrada
                }
            });
    
            ventanaCrearSoldado.setVisible(true);
            control = false;
        }

    // Hacer visible la nueva ventana
 
    }//GEN-LAST:event_boton_crear_soldadoActionPerformed

    private void boton_editar_soldadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_editar_soldadoActionPerformed
            // Crear una nueva instancia de la interfaz Modificar_soldado
            if (control2){
            Ingresar_modificar_soldado ventanaModificarSoldado = new Ingresar_modificar_soldado();
            //escuchar cuando la ventana se cierre para establecer en true la variable de control
            ventanaModificarSoldado.listaSoldados = listaSoldados;
            ventanaModificarSoldado.interfaz = this;
            ventanaModificarSoldado.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosed(java.awt.event.WindowEvent e) {
                    control2 = true; // Cambiar control a true cuando la ventana sea cerrada
                }
            });
    // Hacer visible la nueva ventana
    ventanaModificarSoldado.setVisible(true);
    control2 = false;
            }

    }//GEN-LAST:event_boton_editar_soldadoActionPerformed

    private void Soldados_rasos_totalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Soldados_rasos_totalesActionPerformed
        /*codigo aqui */
    }//GEN-LAST:event_Soldados_rasos_totalesActionPerformed

    private void Tenientes_totalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Tenientes_totalesActionPerformed
        /*codigo aqui */
    }//GEN-LAST:event_Tenientes_totalesActionPerformed

    private void Coroneles_totalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Coroneles_totalesActionPerformed
        /*codigo aqui */
    }//GEN-LAST:event_Coroneles_totalesActionPerformed

    private void Capitanes_totalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Capitanes_totalesActionPerformed
        /*codigo aqui */
    }//GEN-LAST:event_Capitanes_totalesActionPerformed

    private void Boton_patrullarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton_patrullarActionPerformed
        /*codigo aqui */
    }//GEN-LAST:event_Boton_patrullarActionPerformed

    private void CDEActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            // Cambiar al Look and Feel CDE/Motif
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
            UIManager.put("RadioButton.background", new Color(0, 102, 51)); // Fondo verde oscuro
            SwingUtilities.updateComponentTreeUI(this); // Actualiza la interfaz para aplicar el Look and Feel
        } catch (Exception e) {
            e.printStackTrace(); // Manejo de errores si no se puede aplicar el Look and Feel
        }
    }

    private void metalActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            // Cambiar al Look and Feel Metal
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
            UIManager.put("RadioButton.background", new Color(0, 102, 51)); // Fondo verde oscuro
            SwingUtilities.updateComponentTreeUI(this); // Actualiza la interfaz
        } catch (Exception e) {
            e.printStackTrace(); // Manejo de errores
        }
    }
    private void Windows_classicActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            // Cambiar al Look and Feel Windows Classic
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
            UIManager.put("RadioButton.background", new Color(0, 102, 51)); // Fondo verde oscuro
            SwingUtilities.updateComponentTreeUI(this); // Actualiza la interfaz
        } catch (Exception e) {
            e.printStackTrace(); // Manejo de errores
        }
    }
private void nimbusActionPerformed(java.awt.event.ActionEvent evt) {
    try {
        // Cambiar al Look and Feel Nimbus
        UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        UIManager.put("RadioButton.background", new Color(0, 102, 51)); // Fondo verde oscuro
        SwingUtilities.updateComponentTreeUI(this); // Actualiza la interfaz
    } catch (Exception e) {
        e.printStackTrace(); // Manejo de errores
    }
}

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
            java.util.logging.Logger.getLogger(interfaz_principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(interfaz_principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(interfaz_principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(interfaz_principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new interfaz_principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    
    private javax.swing.JButton Boton_asignar_mision;
    private javax.swing.JButton Boton_patrullar;
    private javax.swing.JButton Boton_regañar_soldado;
    private javax.swing.JButton Boton_relizar_accion;
    private javax.swing.JButton Boton_reportar_estado;
    private javax.swing.JButton Boton_saludar;
    private javax.swing.JRadioButtonMenuItem CDE;
    private javax.swing.JTextField Capitanes_totales;
    private javax.swing.JTextField Coroneles_totales;
    private javax.swing.JScrollPane Panel_de_menus;
    private javax.swing.JTextField Soldados_rasos_totales;
    private javax.swing.JTextField Tenientes_totales;
    private javax.swing.JRadioButtonMenuItem Windows_classic;
    private javax.swing.JButton boton_crear_soldado;
    private javax.swing.JButton boton_editar_soldado;
    private javax.swing.JButton boton_mostrar_informacion;
    private javax.swing.JButton boton_resetear;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JTextField entrada_codigo;
    private javax.swing.JTextField entrada_mision;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JList<String> lista_de_soldado;
    private javax.swing.JRadioButtonMenuItem metal;
    private javax.swing.JRadioButtonMenuItem nimbus;
    private javax.swing.JScrollPane panel_de_Lista;
    private javax.swing.JPanel panel_menu_de_edicion;
    private javax.swing.JPanel panel_menu_de_gestion;
    private javax.swing.JPanel panel_mision_y_codigo;
    private javax.swing.JPanel panel_principal_de_lista;
    private javax.swing.JPanel panel_total_de_registros;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
