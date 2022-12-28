/*
 * Author: Sergio Manuel Valdivia Marcelo
 * Date: 28 dic. 2022
 */
package Controlador;

import Estado.*;
import Vista.*;
import Modelo.*;
import Objetos.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JOptionPane;

public class ControladorOpciones implements ActionListener {

    public PokemonDAO dao;
    public OpcionesPokemon opciones;
    public int id;
    
    public ControladorOpciones(OpcionesPokemon opciones, PokemonDAO dao, int id) {
        this.opciones = opciones;
        this.dao = dao;
        this.id = id;
        this.opciones.btnJugar.addActionListener(this);
        this.opciones.btnDormir.addActionListener(this);
        this.opciones.btnAlimentar.addActionListener(this);
        this.opciones.btnBailar.addActionListener(this);
        this.opciones.btnSanar.addActionListener(this);
        this.opciones.btnRegresar.addActionListener(this);

        cargarDatos();
    }

    public void cargarDatos() {
        String nombre = dao.obtenerNombrePorID(id);
        String[] datos = dao.obtenerTiposPokemonID(id);
        String estado = dao.obtenerEstado(id);
        System.out.println(estado);

        int numero = Integer.valueOf(datos[0]);
        String tipo1 = datos[1];
        String tipo2 = datos[2];

        opciones.lblNombre.setText(nombre);
        opciones.lblNroID.setText(String.valueOf(id));

        if (numero <= 9) {
            opciones.lblNroPokedex.setText("00" + String.valueOf(numero));
        } else {
            if (numero > 9 && numero <= 99) {
                opciones.lblNroPokedex.setText("0" + String.valueOf(numero));
            } else {
                opciones.lblNroPokedex.setText(String.valueOf(numero));
            }
        }

        opciones.lblImgPokemon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/" + nombre + ".png")));
        opciones.lblTipoPrim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/" + tipo1 + "_Pokemon.png")));

        if (tipo2 == null) {
            opciones.lblTipoSec.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Vacio.png")));
        } else {
            opciones.lblTipoSec.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/" + tipo2 + "_Pokemon.png")));
        }
        
        
        if(estado.equals("Enfermo")){
            opciones.btnAlimentar.setEnabled(false);
            opciones.btnBailar.setEnabled(false);
            opciones.btnDormir.setEnabled(false);
            opciones.btnJugar.setEnabled(false);
        }
         
    }

    public void Accion(String accion, int tiempo) {
        Accion sanar = new Accion(accion);
        sanar.setVisible(true);
        sanar.setLocationRelativeTo(null);
        Timer timer = new Timer();
        opciones.btnAlimentar.setEnabled(false);
        opciones.btnBailar.setEnabled(false);
        opciones.btnDormir.setEnabled(false);
        opciones.btnJugar.setEnabled(false);
        opciones.btnSanar.setEnabled(false);

        TimerTask tarea = new TimerTask() {
            @Override
            public void run() {
                sanar.setVisible(false);
                opciones.btnAlimentar.setEnabled(true);
                opciones.btnBailar.setEnabled(true);
                opciones.btnDormir.setEnabled(true);
                opciones.btnJugar.setEnabled(true);
                opciones.btnSanar.setEnabled(true);
                if (accion.equals("Sanar")) {
                    JOptionPane.showMessageDialog(null, "POKEMON SANADO!!!");
                }
                if (accion.equals("Jugar")) {
                    JOptionPane.showMessageDialog(null, "POKEMON TERMINO DE JUGAR!!!");                      
                }
                if (accion.equals("Dormir")) {
                    JOptionPane.showMessageDialog(null, "POKEMON TERMINO DE DORMIR!!!");        
                }
                if (accion.equals("Alimentar")){
                    JOptionPane.showMessageDialog(null, "POKEMON TERMINO DE COMER!!!");   
                }
                if (accion.equals("Bailar")) {
                    JOptionPane.showMessageDialog(null, "POKEMON TERMINO DE BAILAR!!!");       
                }

            }
        };
        timer.schedule(tarea, tiempo);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == opciones.btnJugar) {
            Pokemon pokemon = new Pokemon();
            pokemon = dao.obtenerPokemonPorID(id);
            
            if (pokemon.getEstadoS().equals("Sano")) {
                String accion = "Jugar";
                Accion(accion, 2000);
            } else {
                JOptionPane.showMessageDialog(null, "POKEMON NO PUEDE JUGAR!!!" + "\nESTA ENFERMO");
            }
        }
        if (e.getSource() == opciones.btnDormir) {
            Pokemon pokemon = new Pokemon();

            pokemon = dao.obtenerPokemonPorID(id);
            if (pokemon.getEstadoS().equals("Sano")) {
                String accion = "Dormir";
                Accion(accion, 2000);
            } else {
                JOptionPane.showMessageDialog(null, "POKEMON NO PUEDE DORMIR!!!" + "\nESTA ENFERMO");
            }
        }
        if (e.getSource() == opciones.btnAlimentar) {
            Pokemon pokemon = new Pokemon();
            pokemon = dao.obtenerPokemonPorID(id);
            
            if (pokemon.getEstadoS().equals("Sano")) {
                String accion = "Alimentar";
                Accion(accion, 2000);
            } else {
                JOptionPane.showMessageDialog(null, "POKEMON NO PUEDE ALIMENTAR!!!" + "\nESTA ENFERMO");
            }
        }
        if (e.getSource() == opciones.btnBailar) {
            Pokemon pokemon = new Pokemon();

            pokemon = dao.obtenerPokemonPorID(id);
            if (pokemon.getEstadoS().equals("Sano")) {
                String accion = "Bailar";
                Accion(accion, 2000);
            } else {
                JOptionPane.showMessageDialog(null, "POKEMON NO PUEDE BAILAR!!!" + "\nESTA ENFERMO");
            }
        }
        if (e.getSource() == opciones.btnSanar) {
            Pokemon pokemon = new Pokemon();

            pokemon = dao.obtenerPokemonPorID(id);

            if (pokemon.getEstadoS().equals("Enfermo")) {
                pokemon.setEstado(new Sano());
                String accion = "Sanar";
                Accion(accion, 4500);
                System.out.println(pokemon.toString());
                dao.Actualizar(pokemon, id);

                cargarDatos();
            } else {
                JOptionPane.showMessageDialog(null, "POKEMON SANO!!!");
            }
        }
        if (e.getSource() == opciones.btnRegresar) {
            ListaPokemon lista = new ListaPokemon();
            ControladorVer controlVer = new ControladorVer(lista, dao);
            lista.setVisible(true);
            lista.setLocationRelativeTo(null);
            opciones.dispose();
        }
    }

}
