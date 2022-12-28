package Estado;

import Objetos.Pokemon;

public interface State {

    String Jugar();
    String Dormir();
    String Alimentar();
    String Bailar();
    String Sanar();
    String DescribirEstado();

    void setPokemon(Pokemon pokemon);

}