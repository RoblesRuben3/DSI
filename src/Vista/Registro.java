/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Modelo.Conexion;
import java.awt.Color;
import java.awt.event.ItemEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class Registro extends javax.swing.JFrame {

    /**
     * Creates new form Registro
     */
    public Registro() throws ClassNotFoundException {
        initComponents();
        setResizable(false);
        this.lblAdvCampos.setVisible(false);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.WHITE);
    }

    public boolean validarCampos() {
        if (this.txtID.getText().isEmpty() || (String) this.cbxNaturaleza.getSelectedItem() == "- Seleccione -" || this.txtPeso.getText().isEmpty() || this.txtAltura.getText().isEmpty()
                || (String) this.cbxNombre.getSelectedItem() == "- Seleccione -" || (String) this.cbxSexo.getSelectedItem() == "- Seleccione -") {
            this.lblAdvCampos.setVisible(true);
            return false;
        } else {
            this.lblAdvCampos.setVisible(false);
            return true;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblNaturaleza = new javax.swing.JLabel();
        lblSexo = new javax.swing.JLabel();
        cbxSexo = new javax.swing.JComboBox<>();
        lblImgTipoPrim = new javax.swing.JLabel();
        lblTipo = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        cbxNombre = new javax.swing.JComboBox<>();
        txtID = new javax.swing.JTextField();
        lblID = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        lblImgTipoSec = new javax.swing.JLabel();
        lblLogo = new javax.swing.JLabel();
        lblPeso = new javax.swing.JLabel();
        lblAltura = new javax.swing.JLabel();
        txtPeso = new javax.swing.JTextField();
        txtAltura = new javax.swing.JTextField();
        btnRegistrar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        lblAdvCampos = new javax.swing.JLabel();
        lblEntrenador = new javax.swing.JLabel();
        txtEntrenador = new javax.swing.JTextField();
        cbxNaturaleza = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0), 5));

        lblNaturaleza.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblNaturaleza.setText("Naturaleza");

        lblSexo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblSexo.setText("Sexo");

        cbxSexo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cbxSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- Seleccione -", "Macho", "Hembra" }));

        lblImgTipoPrim.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        lblTipo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblTipo.setText("Tipo");

        lblNombre.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblNombre.setText("Nombre");

        cbxNombre.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cbxNombre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- Seleccione -" }));

        txtID.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtID.setEnabled(false);

        lblID.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblID.setText("ID");

        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblTitulo.setText("Registro Pokémon");

        lblImgTipoSec.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/logopokemon.png"))); // NOI18N

        lblPeso.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblPeso.setText("Peso");

        lblAltura.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblAltura.setText("Altura");

        txtPeso.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txtAltura.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        btnRegistrar.setBackground(new java.awt.Color(255, 0, 0));
        btnRegistrar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrar.setText("Registrar");

        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnCancelar.setText("Cancelar");

        lblAdvCampos.setForeground(new java.awt.Color(255, 0, 0));
        lblAdvCampos.setText("* Complete todos los campos");

        lblEntrenador.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblEntrenador.setText("Entrenador");

        txtEntrenador.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        cbxNaturaleza.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cbxNaturaleza.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- Seleccione -", "Activa", "Afable", "Agitada", "Alegre", "Alocada", "Amable", "Audaz", "Cauta", "Dócil ", "Firme", "Floja", "Fuerte", "Grosera", "Huraña", "Ingenua", "Mansa", "Miedosa", "Modesta", "Osada", "Pícara", "Plácida", "Rara", "Serena", "Seria", "Tímida" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(162, 162, 162)
                        .addComponent(lblTitulo))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(242, 242, 242)
                        .addComponent(lblLogo))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cbxNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(lblTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(75, 75, 75)
                        .addComponent(lblImgTipoPrim, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(lblImgTipoSec, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(lblSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cbxSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(lblNaturaleza, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cbxNaturaleza, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(lblPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(lblAltura, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtAltura, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(lblAdvCampos))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblEntrenador, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblID, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEntrenador, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(106, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lblTitulo)
                .addGap(18, 18, 18)
                .addComponent(lblLogo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEntrenador)
                    .addComponent(txtEntrenador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(lblID))
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(lblNombre))
                    .addComponent(cbxNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTipo)
                            .addComponent(lblImgTipoSec, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lblImgTipoPrim, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(lblSexo))
                    .addComponent(cbxSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNaturaleza)
                    .addComponent(cbxNaturaleza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(lblPeso))
                    .addComponent(txtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(lblAltura))
                    .addComponent(txtAltura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblAdvCampos)
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrar)
                    .addComponent(btnCancelar))
                .addGap(41, 41, 41))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnCancelar;
    public javax.swing.JButton btnRegistrar;
    public javax.swing.JComboBox<String> cbxNaturaleza;
    public javax.swing.JComboBox<String> cbxNombre;
    public javax.swing.JComboBox<String> cbxSexo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblAdvCampos;
    private javax.swing.JLabel lblAltura;
    private javax.swing.JLabel lblEntrenador;
    private javax.swing.JLabel lblID;
    public javax.swing.JLabel lblImgTipoPrim;
    public javax.swing.JLabel lblImgTipoSec;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblNaturaleza;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPeso;
    private javax.swing.JLabel lblSexo;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JLabel lblTitulo;
    public javax.swing.JTextField txtAltura;
    public javax.swing.JTextField txtEntrenador;
    public javax.swing.JTextField txtID;
    public javax.swing.JTextField txtPeso;
    // End of variables declaration//GEN-END:variables
}
