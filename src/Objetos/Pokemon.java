package Objetos;

import Estado.*;
import Modelo.*;

public class Pokemon {

private int ID;
    private int Nro_Pokedex;
    private String Nombre;
    private String Tipo1;
    private String Tipo2;
    private String Sexo;
    private String Naturaleza;
    private double Altura;
    private double Peso;
    private State Estado;
    private String EstadoS;
    private String Entrenador;

    public Pokemon(int ID, int Nro_Pokedex, String Nombre, String Tipo1,String Tipo2, String Sexo, String Naturaleza, double Altura, double Peso, State Estado, String Entrenador) {
        this.ID = ID;
        this.Nro_Pokedex = Nro_Pokedex;
        this.Nombre = Nombre;
        this.Tipo1 = Tipo1;
        this.Tipo2 = Tipo2;
        this.Sexo = Sexo;
        this.Naturaleza = Naturaleza;
        this.Altura = Altura;
        this.Peso = Peso;
        this.Entrenador=Entrenador;
        this.EstadoS=PokemonDAO.obtenerEstadoNombre(this.Estado);
        setEstado(Estado);        
    }
    
    //Constructores de la linea 31 al 50 agregados
    public Pokemon() {
        
    }

    public Pokemon(int Nro_Pokedex, String Sexo, String Naturaleza, double Altura, double Peso) {
        this.Nro_Pokedex = Nro_Pokedex;
        this.Sexo = Sexo;
        this.Naturaleza = Naturaleza;
        this.Altura = Altura;
        this.Peso = Peso;
    }
    
    public Pokemon(int Nro_Pokedex, String Sexo, String Naturaleza, double Altura, double Peso, State Estado, String Entrenador) {
        this.Nro_Pokedex = Nro_Pokedex;
        this.Sexo = Sexo;
        this.Naturaleza = Naturaleza;
        this.Altura = Altura;
        this.Peso = Peso;
        this.Estado=Estado;
        this.Entrenador = Entrenador;
    }

    public Pokemon(String Sexo, String Naturaleza, double Altura, double Peso,State Estado) {
        this.Sexo = Sexo;
        this.Naturaleza = Naturaleza;
        this.Altura = Altura;
        this.Peso = Peso;
        setEstado(Estado);
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    
    public int getNro_Pokedex() {
        return Nro_Pokedex;
    }

    public void setNro_Pokedex(int Nro_Pokedex) {
        this.Nro_Pokedex = Nro_Pokedex;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getTipo1() {
        return Tipo1;
    }

    public void setTipo1(String Tipo1) {
        this.Tipo1 = Tipo1;
    }

    
    public String getTipo2() {
        return Tipo2;
    }

    public void setTipo2(String Tipo2) {
        this.Tipo2 = Tipo2;
    }

    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String Sexo) {
        this.Sexo = Sexo;
    }

    public String getNaturaleza() {
        return Naturaleza;
    }

    public void setNaturaleza(String Naturaleza) {
        this.Naturaleza = Naturaleza;
    }

    public double getAltura() {
        return Double.parseDouble(String.format("%.2f",Altura));
    }

    public void setAltura(double Altura) {
        this.Altura = Altura;
    }

    public double getPeso() {
        return Peso;
    }

    public void setPeso(double Peso) {
        this.Peso = Peso;
    }

    public State getEstado() {
        return Estado;
    }
    
    public void setEstado(State Estado) {
        this.Estado = Estado;
    }
    
    public String getEntrenador() {
        return Entrenador;
    }

    public void setEntrenador(String Entrenador) {
        this.Entrenador = Entrenador;
    }

    public String getEstadoS() {
        return EstadoS;
    }

    public void setEstadoS(String EstadoS) {
        this.EstadoS = EstadoS;
    }
    
    public void Jugar(){
        this.Estado.Jugar();
    }
    public void Dormir(){
        this.Estado.Dormir();
    }
    public void Alimentar(){
        this.Estado.Alimentar();
    }
    public void Bailar(){
        this.Estado.Bailar();
    }
    public void Sanar(){
        this.Estado.Sanar();
    }
    
    @Override
    public String toString(){
        String s="";
        
        s = String.valueOf(ID)
            +"-"+String.valueOf(Nro_Pokedex)
            +"-"+Nombre
            +"-"+Tipo1
            +"-"+Tipo2
            +"-"+Sexo
            +"-"+Naturaleza
            +"-"+String.valueOf(Altura)
            +"-"+String.valueOf(Peso)
            +"-"+PokemonDAO.obtenerEstadoNombre(Estado)
            +"-"+Entrenador;
        return s;
    }

}