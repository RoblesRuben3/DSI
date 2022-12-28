package Estado;

import Objetos.Pokemon;
import java.util.TimerTask;
import java.util.Timer;

public class Sano implements State{
    
    private Pokemon pokemon;
    String Mensaje = "";
    
    @Override
    public String Jugar() {

        Mensaje += pokemon.getNombre() + " esta jugando";

        return Mensaje;
    }

    @Override
    public String Dormir() {
        Mensaje += pokemon.getNombre() + " esta durmiendo";
        
        return Mensaje;
    }

    @Override
    public String Alimentar() {
        double Aleatorio = Math.random();
        if(Aleatorio<0.5){
            Mensaje += "El pokemon "+ pokemon.getNombre()+ " se esta alimentando con bayas\n";
            Mensaje += "Las bayas que ha comido el pokemon estaban envenenadas, el pokemon se ha enfermado";
            pokemon.setEstado(new Enfermo());
            pokemon.setEstadoS("Enfermo");
        }else{
            Mensaje += "El pokemon se esta alimentando con bayas Aranja\n";
            Mensaje += "Al pokemon le han gustado las bayas!!";
        }
        
        return Mensaje;
    }

    @Override
    public String Bailar() {
     
        Mensaje += pokemon.getNombre() + " esta bailando";
        
        return Mensaje;
    }

    @Override
    public void setPokemon(Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    @Override
    public String Sanar() {
        Mensaje += pokemon.getNombre() + " no puede sanarse porque ya esta sano";
        
        return Mensaje;
    }

    @Override
    public String DescribirEstado(){
        String Estado = "Sano";
        return Estado;
    }

}