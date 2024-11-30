package interfaz_grafica;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import Militar.Soldados.Soldado;
import Militar.Soldados.SoldadoRaso;
import Militar.Soldados.Teniente;
import Militar.Soldados.Capitan;
import Militar.Soldados.Coronel;

/**
 * Clase para ingresar o modificar un soldado
 * @author Miguel
 */
public class Ingresar_modificar_soldado extends javax.swing.JFrame {
    // Instancia del controlador
    public static ArrayList<Soldado> listaSoldados = new ArrayList<>(); 
    public interfaz_principal interfaz;

    /**
     * Constructor por defecto
     */
    public Ingresar_modificar_soldado() {
        initComponents();
    }

    /**
     * Método generado automáticamente para inicializar los componentes.
     * WARNING: No modificar este código manualmente.
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {
        panel_menu = new javax.swing.JPanel();
        pane_de_entrada = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        entrada_id_soldado = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        boton_buscar = new javax.swing.JButton();
        boton_volver = new javax.swing.JButton();
        boton_subir_rango = new javax.swing.JButton();
        boton_bajar_rango = new javax.swing.JButton();
        boton_modificar_atributo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel_menu.setBackground(new java.awt.Color(0, 102, 51));
        panel_menu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pane_de_entrada.setBackground(new java.awt.Color(0, 102, 51));
        pane_de_entrada.setLayout(new java.awt.GridLayout(0, 1));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Digite ID del soldado");
        pane_de_entrada.add(jLabel4);

        entrada_id_soldado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entrada_id_soldadoActionPerformed(evt);
            }
        });
        pane_de_entrada.add(entrada_id_soldado);

        panel_menu.add(pane_de_entrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 210, 50));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Modificar Soldado");
        panel_menu.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 270, -1));

        boton_buscar.setText("Buscar");
        boton_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_buscarActionPerformed(evt);
            }
        });
        panel_menu.add(boton_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 113, -1, 30));

        boton_volver.setText("Volver");
        boton_volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_volverActionPerformed(evt);
            }
        });
        panel_menu.add(boton_volver, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 113, -1, 30));

        boton_subir_rango.setText("Subir Rango");
        boton_subir_rango.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_subir_rangoActionPerformed(evt);
            }
        });
        panel_menu.add(boton_subir_rango, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, -1, 30));

        boton_bajar_rango.setText("Bajar Rango");
        boton_bajar_rango.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_bajar_rangoActionPerformed(evt);
            }
        });
        panel_menu.add(boton_bajar_rango, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 160, -1, 30));

        boton_modificar_atributo.setText("Modificar Atributo");
        boton_modificar_atributo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_modificar_atributoActionPerformed(evt);
            }
        });
        panel_menu.add(boton_modificar_atributo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 210, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(panel_menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 6, Short.MAX_VALUE)
                .addComponent(panel_menu, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        pack();
    }

    private void entrada_id_soldadoActionPerformed(java.awt.event.ActionEvent evt) {
        boton_buscarActionPerformed(evt);
    }

    private void boton_buscarActionPerformed(java.awt.event.ActionEvent evt) {
        String idBuscado = entrada_id_soldado.getText().trim();
        Soldado soldadoEncontrado = buscarSoldadoPorID(idBuscado);

        if (soldadoEncontrado != null) {
            JOptionPane.showMessageDialog(this,
                "Soldado encontrado:\n" + soldadoEncontrado.mostrarInformacion(),
                "Búsqueda Exitosa", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this,
                "No se encontró un soldado con el ID: " + idBuscado,
                "Búsqueda Fallida", JOptionPane.ERROR_MESSAGE);
        }
        interfaz.update();
    }

    private void boton_subir_rangoActionPerformed(java.awt.event.ActionEvent evt) {
        String idBuscado = entrada_id_soldado.getText().trim();
        Soldado soldado = buscarSoldadoPorID(idBuscado);

        if (soldado instanceof SoldadoRaso) {
            listaSoldados.remove(soldado);
            listaSoldados.add(new Teniente(soldado.getNombre(), soldado.getId()));
            JOptionPane.showMessageDialog(this, "El rango ha sido cambiado a Teniente.");
        } else if (soldado instanceof Teniente) {
            listaSoldados.remove(soldado);
            listaSoldados.add(new Capitan(soldado.getNombre(), soldado.getId()));
            JOptionPane.showMessageDialog(this, "El rango ha sido cambiado a Capitán.");
        } else if (soldado instanceof Capitan) {
            listaSoldados.remove(soldado);
            listaSoldados.add(new Coronel(soldado.getNombre(), soldado.getId()));
            JOptionPane.showMessageDialog(this, "El rango ha sido cambiado a Coronel.");
        } else {
            JOptionPane.showMessageDialog(this, "No puede subir más el rango.");
        }
        interfaz.update();
    }

    private void boton_bajar_rangoActionPerformed(java.awt.event.ActionEvent evt) {
        String idBuscado = entrada_id_soldado.getText().trim();
        Soldado soldado = buscarSoldadoPorID(idBuscado);

        if (soldado instanceof Coronel) {
            listaSoldados.remove(soldado);
            listaSoldados.add(new Capitan(soldado.getNombre(), soldado.getId()));
            JOptionPane.showMessageDialog(this, "El rango ha sido cambiado a Capitán.");
        } else if (soldado instanceof Capitan) {
            listaSoldados.remove(soldado);
            listaSoldados.add(new Teniente(soldado.getNombre(), soldado.getId()));
            JOptionPane.showMessageDialog(this, "El rango ha sido cambiado a Teniente.");
        } else if (soldado instanceof Teniente) {
            listaSoldados.remove(soldado);
            listaSoldados.add(new SoldadoRaso(soldado.getNombre(), soldado.getId()));
            JOptionPane.showMessageDialog(this, "El rango ha sido cambiado a Soldado Raso.");
        } else {
            JOptionPane.showMessageDialog(this, "No puede bajar más el rango.");
        }
        interfaz.update();
    }

    private void boton_modificar_atributoActionPerformed(java.awt.event.ActionEvent evt) {
        String idBuscado = entrada_id_soldado.getText().trim();
        Soldado soldado = buscarSoldadoPorID(idBuscado);

        if (soldado != null) {
            String nuevoValor = JOptionPane.showInputDialog(this,
                "Ingrese el nuevo valor para el atributo 'unidad' o 'estrategia':");

            if (soldado instanceof Coronel) {
                ((Coronel) soldado).setEstrategia(nuevoValor);
                JOptionPane.showMessageDialog(this, "Estrategia actualizada exitosamente para el Coronel.");
            } else if (soldado instanceof Capitan) {
                ((Capitan) soldado).setUnidad(nuevoValor);
                JOptionPane.showMessageDialog(this, "Unidad actualizada exitosamente para el Capitán.");
            } else {
                soldado.setUnidad(nuevoValor);
                JOptionPane.showMessageDialog(this, "Unidad actualizada exitosamente.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "No se encontró el soldado para modificar.");
        }
        interfaz.update();
    }

    private Soldado buscarSoldadoPorID(String id) {
        for (Soldado soldado : listaSoldados) {
            if (soldado.getId().equalsIgnoreCase(id)) {
                return soldado;
            }
        }
        return null;
    }

    private void boton_volverActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ingresar_modificar_soldado().setVisible(true);
                
            }
            
        });
    }

    // Declaración de variables
    private javax.swing.JButton boton_buscar;
    private javax.swing.JButton boton_bajar_rango;
    private javax.swing.JButton boton_modificar_atributo;
    private javax.swing.JButton boton_subir_rango;
    private javax.swing.JButton boton_volver;
    private javax.swing.JTextField entrada_id_soldado;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel pane_de_entrada;
    private javax.swing.JPanel panel_menu;
}