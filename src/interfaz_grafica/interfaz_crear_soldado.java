package interfaz_grafica;

import javax.swing.JOptionPane;
import Militar.Soldados.Soldado;
import Militar.Soldados.SoldadoRaso;
import Militar.Soldados.Teniente;
import Militar.Soldados.Capitan;
import Militar.Soldados.Coronel;
import java.util.ArrayList;

public class interfaz_crear_soldado extends javax.swing.JFrame {


    public static ArrayList<Soldado> listaSoldados = new ArrayList<>();  // Lista global para almacenar los soldados creados
    private static int contadorID = 6; // Empezamos en 6 porque ya hay soldados con ID S001 a S005


    @SuppressWarnings("unchecked")
    private void initComponents() {
        buttonGroup1 = new javax.swing.ButtonGroup();
        panel_menu = new javax.swing.JPanel();
        panel_de_campo_de_nombre = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        Entrada_nombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        boton_crear = new javax.swing.JButton();
        boton_volver = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        Capitan_radioButton = new javax.swing.JRadioButton();
        SoldadoRaso_radioButton = new javax.swing.JRadioButton();
        Coronel_radioButton = new javax.swing.JRadioButton();
        Teniente_radioButton = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 102, 51));

        panel_menu.setBackground(new java.awt.Color(0, 102, 51));
        panel_menu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_de_campo_de_nombre.setBackground(new java.awt.Color(0, 102, 51));
        panel_de_campo_de_nombre.setLayout(new java.awt.GridLayout(0, 1));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14));
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Nombre");
        panel_de_campo_de_nombre.add(jLabel4);

        Entrada_nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Entrada_nombreActionPerformed(evt);
            }
        });
        panel_de_campo_de_nombre.add(Entrada_nombre);

        panel_menu.add(panel_de_campo_de_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 290, 110));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 24));
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Crear soldado");
        panel_menu.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 270, -1));

        boton_crear.setText("Crear");
        boton_crear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_crearActionPerformed(evt);
            }
        });
        panel_menu.add(boton_crear, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, -1, -1));

        boton_volver.setText("Volver");
        boton_volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_volverActionPerformed(evt);
            }
        });
        panel_menu.add(boton_volver, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 220, -1, -1));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14));
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Rango");
        panel_menu.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 100, 127, -1));

        buttonGroup1.add(Capitan_radioButton);
        Capitan_radioButton.setFont(new java.awt.Font("Arial", 1, 12));
        Capitan_radioButton.setForeground(new java.awt.Color(255, 255, 255));
        Capitan_radioButton.setText("Capitán");
        panel_menu.add(Capitan_radioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 200, 130, 37));

        buttonGroup1.add(SoldadoRaso_radioButton);
        SoldadoRaso_radioButton.setFont(new java.awt.Font("Arial", 1, 12));
        SoldadoRaso_radioButton.setForeground(new java.awt.Color(255, 255, 255));
        SoldadoRaso_radioButton.setText("Soldado Raso");
        panel_menu.add(SoldadoRaso_radioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 120, 130, 37));

        buttonGroup1.add(Coronel_radioButton);
        Coronel_radioButton.setFont(new java.awt.Font("Arial", 1, 12));
        Coronel_radioButton.setForeground(new java.awt.Color(255, 255, 255));
        Coronel_radioButton.setText("Coronel");
        panel_menu.add(Coronel_radioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 240, 130, 37));

        buttonGroup1.add(Teniente_radioButton);
        Teniente_radioButton.setFont(new java.awt.Font("Arial", 1, 12));
        Teniente_radioButton.setForeground(new java.awt.Color(255, 255, 255));
        Teniente_radioButton.setText("Teniente");
        panel_menu.add(Teniente_radioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 160, 130, 37));

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
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(panel_menu, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }

    private void boton_crearActionPerformed(java.awt.event.ActionEvent evt) {
        String nombre = Entrada_nombre.getText().trim(); // Eliminamos espacios en blanco
        String rango = null;

        // Verificar qué rango fue seleccionado
        if (SoldadoRaso_radioButton.isSelected()) {
            rango = "Soldado Raso";
        } else if (Teniente_radioButton.isSelected()) {
            rango = "Teniente";
        } else if (Capitan_radioButton.isSelected()) {
            rango = "Capitán";
        } else if (Coronel_radioButton.isSelected()) {
            rango = "Coronel";
        }

        // Validar entrada
        if (nombre.isEmpty() || rango == null) {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos y seleccione un rango.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Generar ID y crear soldado
        String id = "S" + String.format("%03d", contadorID++);
        Soldado nuevoSoldado;

        // Crear el soldado dependiendo del rango seleccionado
        switch (rango) {
            case "Soldado Raso":
                nuevoSoldado = new SoldadoRaso(nombre, id);
                break;
            case "Teniente":
                nuevoSoldado = new Teniente(nombre, id);
                break;
            case "Capitán":
                nuevoSoldado = new Capitan(nombre, id);
                break;
            case "Coronel":
                nuevoSoldado = new Coronel(nombre, id);
                break;
            default:
                return; // No debería llegar aquí
        }

        // Añadir a la lista de soldados
        listaSoldados.add(nuevoSoldado);

        // Confirmación y reset de campos
        JOptionPane.showMessageDialog(this, "Soldado creado con ID: " + id, "Éxito", JOptionPane.INFORMATION_MESSAGE);
        Entrada_nombre.setText("");  // Limpiar el campo de nombre
        buttonGroup1.clearSelection(); // Limpiar selección de rango
    }

    private void boton_volverActionPerformed(java.awt.event.ActionEvent evt) {
        // Volver a la pantalla anterior
        this.setVisible(false);
    }

    private void Entrada_nombreActionPerformed(java.awt.event.ActionEvent evt) {
        // Aquí puedes poner alguna acción si es necesario cuando el usuario presione Enter en el campo de nombre
    }

    private javax.swing.JButton boton_crear;
    private javax.swing.JButton boton_volver;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JRadioButton Capitan_radioButton;
    private javax.swing.JRadioButton Coronel_radioButton;
    private javax.swing.JTextField Entrada_nombre;
    private javax.swing.JRadioButton SoldadoRaso_radioButton;
    private javax.swing.JRadioButton Teniente_radioButton;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel panel_de_campo_de_nombre;
    private javax.swing.JPanel panel_menu;
}
