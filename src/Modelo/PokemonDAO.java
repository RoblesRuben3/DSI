package Modelo;

import Estado.*;
import Objetos.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PokemonDAO {

    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    Conexion conectar = new Conexion();
    Pokemon p = new Pokemon();

    //LISTO
    public List Listar() {
        List<Pokemon> datos = new ArrayList<>();
        String Estado;
        int bandera=0;
        
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement("select * from vw_datos_poke");
            rs = ps.executeQuery();
            
            while (rs.next()) {
                Pokemon p = new Pokemon();
                
                p.setID(rs.getInt(1));
                
                p.setNro_Pokedex(rs.getInt(2));
                
                p.setNombre(rs.getString(3));
                
                p.setTipo1(rs.getString(4));
                
                p.setTipo2(rs.getString(5));
                
                p.setSexo(rs.getString(6));
                
                p.setNaturaleza(rs.getString(7));
                
                p.setAltura(rs.getFloat(8));
                
                p.setPeso(rs.getFloat(9));
                
                p.setEstado(obtenerObjetoEstado(rs.getString(10)));
                
                p.setEntrenador(rs.getString(11));

                
                datos.add(p);
                
                
                bandera=bandera+1;
            }
        }
        catch (Exception e) {
            System.out.println("Error en la carga de los pokemones en: "+bandera);
        }
        return datos;
    }
    
    //LISTO
    public int Agregar(Pokemon pok) {  
        int r=0;
        String sql="INSERT INTO Datos (Nro_Pokedex,Sexo,Naturaleza,Altura,Peso,Estado,Entrenador)VALUES(?,?,?,?,?,?,?)";
        
        try { 
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);     
            
            System.out.println("Entro?");
            
            ps.setInt(1,pok.getNro_Pokedex());
            
            ps.setString(2,pok.getSexo());
            ps.setString(3,pok.getNaturaleza());
            ps.setDouble(4,pok.getAltura());
            ps.setDouble(5,pok.getPeso());
            ps.setString(6,obtenerEstadoNombre(pok.getEstado()));
            ps.setString(7, pok.getEntrenador());
            
            r=ps.executeUpdate();   
           
            if(r==1){
                System.out.println("Pokemon agregado");
                return 1;
            }
            else{
                System.out.println("Pokemon no agregado");
                return 0;
            }
        }
        catch (Exception e) {
            System.out.println("Error en la agregacion de pokemon");
        }
        return r;
    }
    
    //LISTO
    public int Actualizar(Pokemon pok,int id) {  
        int r=0;
        String sql="UPDATE Datos SET Sexo=?,Naturaleza=?,Altura=?,Peso=?,Estado=? WHERE ID = "+ id; 
       
        try {
            con = conectar.getConnection();
            
            ps = con.prepareStatement(sql);
            ps.setString(1,pok.getSexo());
            ps.setString(2,pok.getNaturaleza());
            ps.setDouble(3,pok.getAltura());
            ps.setDouble(4,pok.getPeso());
            ps.setString(5,obtenerEstadoNombre(pok.getEstado()));            
           
            r=ps.executeUpdate();    
            
            if(r==1){
                System.out.println("Pokemon actualizado");
                return 1;
            }
            else{
                System.out.println("Pokemon no actualizado");
                return 0;
            }
        } 
        catch (Exception e) {
            System.out.println("Error en la actualizacion de pokemon");
        }  
        return r;
    }
    
    //LISTO
    public int Borrar(int id){
        int r=0;
        String sql="DELETE FROM Datos WHERE ID="+id;
        
        try {
            con=conectar.getConnection();
            ps=con.prepareStatement(sql);
            r= ps.executeUpdate();
            
            if(r==1){
                System.out.println("Pokemon borrado");
                return 1;
            }
            else{
                System.out.println("Pokemon no borrado");
                return 0;
            }
        }
        catch (Exception e) {
            System.out.println("Error en borrar pokemon: "+id);
        }
        return r;
    }
    
    public Pokemon obtenerPokemonPorID(int id) {
        Pokemon pokemon = new Pokemon();
        String Estado;
        int bandera=0;

        try {
            con = conectar.getConnection();
            ps = con.prepareStatement("select * from vw_datos_poke where ID = "+String.valueOf(id));
            rs = ps.executeQuery();
            
            if (rs.next()) {

                pokemon.setID(rs.getInt(1));
                
                pokemon.setNro_Pokedex(rs.getInt(2));
                
                pokemon.setNombre(rs.getString(3));
                
                pokemon.setTipo1(rs.getString(4));
                
                pokemon.setTipo2(rs.getString(5));
                
                pokemon.setSexo(rs.getString(6));
                
                pokemon.setNaturaleza(rs.getString(7));
                
                pokemon.setAltura(rs.getFloat(8));
                
                pokemon.setPeso(rs.getFloat(9));
                
                pokemon.setEstado(obtenerObjetoEstado(rs.getString(10)));
                
                pokemon.setEntrenador(rs.getString(11));
                
                pokemon.setEstadoS(obtenerEstadoNombre(pokemon.getEstado()));

            }
        }
        catch (Exception e) {
            System.out.println("Error en la obtencion del pokemon : "+id);
        }
        return pokemon;
    }

    public String obtenerEstado(int id){
        String estado="Desconocido";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(" select Estado from vw_datos_poke where ID="+String.valueOf(id));
            rs = ps.executeQuery();
            
            if(rs.next()){
                estado=rs.getString(1);
            }
        }
        catch (Exception e) {
            System.out.println("Error en la obtension del estado de: "+id);
        }
        
        return estado;
    }
        
    //LISTO
    public static State obtenerObjetoEstado(String Vestado){
        State estado=null;
        if(Vestado!=null){
            if(Vestado.equals("Sano")){
                estado=new Sano();
            }
            else{
                if(Vestado.equals("Enfermo")){
                    estado=new Enfermo();
                }
            }
        }
            
        return estado; 
    }  
    
    //LISTO
    public static String obtenerEstadoNombre(State Vestado){
        String estado="Desconocido";
        if(Vestado instanceof Sano){
            estado="Sano";
        }
        else{
            if(Vestado instanceof Enfermo){
                estado="Enfermo";
            }
        }
        return estado;
    }
    
    public String[] obtenerTiposPokemon(String nombre){
        String[] tipos = new String[3];
        tipos[0]="";
        tipos[1]="";
        tipos[2]="";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement("select [Número],[Tipo Primario], [Tipo Secundario] from ListaPokemon where [Nombre] = '"+nombre+"'");
            rs = ps.executeQuery();
            
            if(rs.next()){
                tipos[0]=String.valueOf(rs.getInt(1));
                tipos[1]=rs.getString(2);
                tipos[2]=rs.getString(3);
            }
        }
        catch (Exception e) {
            System.out.println("Error en la obtension de los tipos de: "+nombre);
        }
        return tipos;        
    }
    
    //LISTO
    public String obtenerNombrePorID(int id){
        String nombre="";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(" select Nombre from vw_datos_poke where ID="+id);
            rs = ps.executeQuery();
            
            if(rs.next()){
                nombre=rs.getString(1);
            }
        }
        catch (Exception e) {
            System.out.println("Error en la obtension del nombre de: "+id);
        }
        return nombre;        
    }

    public String[] obtenerTiposPokemonID(int id){
        String[] tipos = new String[3];
        tipos[0]="";
        tipos[1]="";
        tipos[2]="";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(" select Número, [Tipo Primario], [Tipo Secundario] from vw_datos_poke where ID = "+id);
            rs = ps.executeQuery();
                       
            if(rs.next()){
                tipos[0]=String.valueOf(rs.getInt(1));
                tipos[1]=rs.getString(2);
                tipos[2]=rs.getString(3);
            }
        }
        catch (Exception e) {
            System.out.println("Error en la obtension de los estados de: "+id);
        }
        return tipos;        
    }
    
    public int obtenerUltimoID(){
        int id=0;
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement("select max(ID) from Datos");
            rs = ps.executeQuery();

            if(rs.next()){
                id=rs.getInt(1);
            }
        }
        catch (Exception e) {
            System.out.println("Error al obtener ID");
        }
        return id;  
    }
    
    public int obtenerNumeroPokedex(String nombre){
        int numero=0;
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement("select [Número] from ListaPokemon where [Nombre] = '"+nombre+"'");
            rs = ps.executeQuery();

            if(rs.next()){
                numero=rs.getInt(1);
            }
        }
        catch (Exception e) {
            System.out.println("Error al obtener NumeroPokedex");
        }
        return numero;  
    }
    
    //LISTO
    public List ObtenerListaPokemones() {
        List<String> datos = new ArrayList<>();
        String p;
        int bandera=0;
        
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement("SELECT Nombre FROM ListaPokemon order by [Nombre] asc");
            rs = ps.executeQuery();
            
            while (rs.next()) {
                p=new String();
                p=rs.getString(1);
                datos.add(p);
                bandera=bandera+1;
            }
        }
        catch (Exception e) {
            System.out.println("Error en la carga de los pokemones en: "+bandera);
        }
        return datos;
    }
}

