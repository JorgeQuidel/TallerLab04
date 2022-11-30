import modelos.Seleccion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;
public class SeleccionTest {

    private Seleccion seleccion;

    @BeforeEach
    void init(){
        seleccion = new Seleccion("Chile", "40", "chi.png");
    }

    @Test
    void getRutaEquipoTest(){
        assertEquals("src/equipos/chi.txt", seleccion.getRutaEquipo());
    }

    @Test
    void obtenerIconoTest(){
        assertThrows(RuntimeException.class,
                () -> seleccion.buscarJugadorPorNombre(""));
    }
}
