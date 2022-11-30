import modelos.Jugador;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class JugadorTest {

    private Jugador jugador;

    @BeforeEach
    void init(){
        jugador = new Jugador("12", "Pepe", "GK", "src/equipos/chi.txt");
    }

    @Test
    void getNombreTest(){
        assertEquals("Pepe", jugador.getNombre());
    }

    @Test
    void getNumeroTest(){
        assertEquals("12", jugador.getNumero());
    }
}


