/*
 * Author: Sergio Manuel Valdivia Marcelo
 * Date: 27 dic. 2022
 */
package Controlador;
import Vista.*;
import Modelo.*;

import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.management.InvalidApplicationException;
import javax.swing.*;



public class ControladorPrincipal implements ActionListener{
    
    public PokemonDAO dao;
    public Bienvenida aplicacion;
    
    
    public ControladorRegistro controlAgregar;
    public ControladorVer controlVer;
    
    
    public ControladorPrincipal (Bienvenida b){
        dao=new PokemonDAO();
        aplicacion=b;
        
        this.aplicacion.menu.btnSalir.addActionListener(this);
        this.aplicacion.menu.btnRegistrar.addActionListener(this);
        this.aplicacion.menu.btnVer.addActionListener(this);
        aplicacion.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==aplicacion.menu.btnSalir){
            aplicacion.menu.dispose();
            aplicacion.dispose();
        }
        if(e.getSource()==aplicacion.menu.btnRegistrar){
            aplicacion.dispose();
            Registro registro;
            try {
                registro = new Registro();
                controlAgregar=new ControladorRegistro(registro,dao);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ControladorPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(e.getSource()==aplicacion.menu.btnVer){
            aplicacion.dispose();
            ListaPokemon lista;
            lista = new  ListaPokemon();
            controlVer=new ControladorVer(lista,dao);
            
        }
    }  
}
