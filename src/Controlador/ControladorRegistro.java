/*
 * Author: Sergio Manuel Valdivia Marcelo
 * Date: 27 dic. 2022
 */
package Controlador;

import Vista.*;
import Modelo.*;
import Objetos.*;
import Estado.*;

import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class ControladorRegistro implements ActionListener,ItemListener{
    public PokemonDAO dao;
    public Registro registro;
    
    public ControladorRegistro(Registro registro, PokemonDAO dao) {
        this.dao=dao;
        this.registro=registro;
        this.registro.setVisible(true);
        
        this.registro.btnRegistrar.addActionListener(this);
        this.registro.btnCancelar.addActionListener(this);
        this.registro.cbxNombre.addItemListener(this);
        this.registro.cbxSexo.addItemListener(this);
        
        llenarPokemon();   
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==registro.btnRegistrar){
            if(registro.validarCampos()){
                State estado;
                int numero=dao.obtenerNumeroPokedex((String) registro.cbxNombre.getSelectedItem());
                   
                Random numAleatorio = new Random();
                boolean aleatorio=numAleatorio.nextBoolean();
                
                if(aleatorio){
                    estado=new Enfermo();
                }
                else{
                    estado=new Sano();
                }

                Pokemon pokempon;
                pokempon = new Pokemon(numero
                        , (String) registro.cbxSexo.getSelectedItem()
                        , (String) registro.cbxNaturaleza.getSelectedItem()
                        , Double.valueOf((String) registro.txtPeso.getText())
                        , Double.valueOf((String) registro.txtAltura.getText())
                        , estado
                        , registro.txtEntrenador.getText());
                dao.Agregar(pokempon);
                JOptionPane.showMessageDialog(null, "POKEMON REGISTRADO !!!");
            }
        }
        if(e.getSource()==registro.btnCancelar){
            registro.dispose();
        }
    }
    
    public void llenarPokemon(){
        List<String> lista=dao.ObtenerListaPokemones(); 
        for(int i=0; i<lista.size(); i++){
            registro.cbxNombre.addItem(lista.get(i));
        }
        registro.txtID.setText(String.valueOf(dao.obtenerUltimoID()+1));
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if(e.getSource()==registro.cbxNombre){
            
            String[] datos=dao.obtenerTiposPokemon((String)registro.cbxNombre.getSelectedItem());
            int numero=Integer.valueOf(datos[0]);
            String tipo1=datos[1];
            String tipo2=datos[2];

            registro.lblImgTipoPrim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/" + tipo1 + "_Pokemon.png")));

            System.out.println(tipo1);
            System.out.println(tipo2);

            if(tipo2 == null) {
                registro.lblImgTipoSec.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Vacio.png")));
            } 
            else{
                registro.lblImgTipoSec.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/" + tipo2 + "_Pokemon.png")));
            }

            if(numero == 32 || numero == 33 || numero == 34
                    || numero == 106 || numero == 107 || numero == 128) {
                registro.cbxSexo.setSelectedItem("Macho");
                registro.cbxSexo.setEnabled(false);
            } 
            else {
                if(numero == 29 || numero == 30 || numero == 31
                    || numero == 113 || numero == 115 || numero == 124) {
                    registro.cbxSexo.setSelectedItem("Hembra");
                    registro.cbxSexo.setEnabled(false);
                } 
                else {
                    if(numero == 81 || numero == 82 || numero == 100 || 
                        numero == 101 || numero == 120 || numero == 121 ||
                        numero == 132 || numero == 137 || numero == 144 ||
                        numero == 145 || numero == 146 || numero == 150 ||
                        numero == 151){
                        registro.cbxSexo.addItem("Sin sexo");
                        registro.cbxSexo.setSelectedItem("Sin sexo");
                        registro.cbxSexo.setEnabled(false);
                    }
                }
            }
        }
    }  
}
