/*
 * Author: Sergio Manuel Valdivia Marcelo
 * Date: 28 dic. 2022
 */
package Controlador;

import Vista.*;
import Modelo.*;
import Objetos.*;
import Estado.*;

import java.awt.event.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.*;

public class ControladorVer implements ActionListener,MouseListener{
    public PokemonDAO dao;
    public ListaPokemon listaPokemon;
    public ControladorOpciones controlOpciones;
    
    public ControladorVer(ListaPokemon listaPokemon, PokemonDAO dao){
        this.dao=dao;
        this.listaPokemon=listaPokemon;
        this.listaPokemon.setVisible(true);
        this.listaPokemon.tblPokemones.addMouseListener(this);
        this.listaPokemon.btnRegresar.addActionListener(this);
        
        cargarTabla();
    }
    
    public void cargarTabla (){
        DefaultTableModel modeloTabla = (DefaultTableModel) listaPokemon.tblPokemones.getModel();
        modeloTabla.setRowCount(0);
        int[] anchos = {5, 50, 10, 50, 50, 10, 10, 8, 8, 10, 20};

        for (int i = 0; i < listaPokemon.tblPokemones.getColumnCount(); i++) {
            listaPokemon.tblPokemones.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        
        List<Pokemon> pokemones = new ArrayList<>();
        pokemones=dao.Listar();
        
        Object[] datos=new Object[11];

        for (int i = 0; i < pokemones.size(); i++) {
            datos[0]=pokemones.get(i).getID();
            datos[1]=pokemones.get(i).getNro_Pokedex();
            datos[2]=pokemones.get(i).getNombre();
            datos[3]=pokemones.get(i).getTipo1();
            datos[4]=pokemones.get(i).getTipo2();
            datos[5]=pokemones.get(i).getSexo();
            datos[6]=pokemones.get(i).getNaturaleza();
            datos[7]=pokemones.get(i).getAltura();
            datos[8]=pokemones.get(i).getPeso();
            datos[9]=PokemonDAO.obtenerEstadoNombre(pokemones.get(i).getEstado());
            datos[10]=pokemones.get(i).getEntrenador();
            
            modeloTabla.addRow(datos);
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==listaPokemon.btnRegresar){
            listaPokemon.dispose();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()==listaPokemon.tblPokemones){
            int fila=listaPokemon.tblPokemones.rowAtPoint(e.getPoint());
            int id=(int) listaPokemon.tblPokemones.getValueAt(fila, 0);
            listaPokemon.dispose();
            OpcionesPokemon opciones;
            try {
                opciones = new OpcionesPokemon(id);
                controlOpciones=new ControladorOpciones(opciones,dao,id);
                opciones.setVisible(true);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ControladorPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
 
    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
