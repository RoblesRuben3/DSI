package Estado;

import Objetos.Pokemon;
import java.util.Timer;
import java.util.TimerTask;

public class Enfermo implements State{

    private Pokemon pokemon;
    String Mensaje = "";
    
    @Override
    public String Jugar() {
        Mensaje += "El pokemon "+pokemon.getNombre()+" no puede jugar porque está "+pokemon.getEstadoS();
        
        return Mensaje;
    }

    @Override
    public String Dormir() {
        Mensaje += pokemon.getNombre() + " no puede dormir";

        return Mensaje;
    }

    @Override
    public String Alimentar() {
        Mensaje += "El pokemon "+pokemon.getNombre()+" no puede comer";
        
        return Mensaje;
    }

    @Override
    public String Bailar() {
       Mensaje += "El pokemon "+pokemon.getNombre()+" no puede bailar porque está "+pokemon.getEstadoS();
        
        return Mensaje;
    }

    @Override
    public void setPokemon(Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    @Override
    public String Sanar() {
        Mensaje +="El pokemon está sano";
        pokemon.setEstado(new Sano());
        pokemon.setEstadoS("Sano");
        return Mensaje;
    }

    @Override
    public String DescribirEstado(){
        String Estado = "Enfermo";
        return Estado;
    }

}
