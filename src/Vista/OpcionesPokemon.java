package Vista;

import Estado.Enfermo;
import Estado.Sano;
import Objetos.Pokemon;
import Modelo.Conexion;
import Modelo.PokemonDAO;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class OpcionesPokemon extends javax.swing.JFrame {

    PokemonDAO p = new PokemonDAO();
    ArrayList<Pokemon> listaPok;
    int IDBuscar;
    
    public OpcionesPokemon(int id) throws ClassNotFoundException {
        initComponents();
        setResizable(false);
        setTitle("Centro Pokémon");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.WHITE);
    }

//    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblImgPokemon = new javax.swing.JLabel();
        btnJugar = new javax.swing.JButton();
        btnDormir = new javax.swing.JButton();
        btnAlimentar = new javax.swing.JButton();
        btnBailar = new javax.swing.JButton();
        btnSanar = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        lblTipoSec = new javax.swing.JLabel();
        lblTipoPrim = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblTipo = new javax.swing.JLabel();
        lblNro = new javax.swing.JLabel();
        lblNroPokedex = new javax.swing.JLabel();
        lblID = new javax.swing.JLabel();
        lblNroID = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnJugar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnJugar.setText("Jugar");

        btnDormir.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnDormir.setText("Dormir");

        btnAlimentar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnAlimentar.setText("Alimentar");

        btnBailar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnBailar.setText("Bailar");

        btnSanar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnSanar.setText("Sanar");

        btnRegresar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnRegresar.setText("Regresar");

        lblNombre.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N

        lblTipo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblTipo.setText("Tipo:");

        lblNro.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblNro.setText("Nro:");

        lblNroPokedex.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        lblID.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblID.setText("ID:");

        lblNroID.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnJugar, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDormir, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAlimentar, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBailar, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSanar, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNro)
                            .addComponent(lblID))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNroID, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNroPokedex, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblTipoPrim, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblTipoSec, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(347, 347, 347))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblImgPokemon, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblID, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNroID, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNro, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNroPokedex, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTipoPrim, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTipoSec, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btnJugar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDormir, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAlimentar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBailar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSanar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblImgPokemon, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(41, 41, 41))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAlimentar;
    public javax.swing.JButton btnBailar;
    public javax.swing.JButton btnDormir;
    public javax.swing.JButton btnJugar;
    public javax.swing.JButton btnRegresar;
    public javax.swing.JButton btnSanar;
    private javax.swing.JLabel lblID;
    public javax.swing.JLabel lblImgPokemon;
    public javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNro;
    public javax.swing.JLabel lblNroID;
    public javax.swing.JLabel lblNroPokedex;
    private javax.swing.JLabel lblTipo;
    public javax.swing.JLabel lblTipoPrim;
    public javax.swing.JLabel lblTipoSec;
    // End of variables declaration//GEN-END:variables
}
