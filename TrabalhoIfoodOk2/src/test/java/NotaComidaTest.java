import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NotaComidaTest {
    @Test
    void deveRetornarQuantidadeEstrelasComida() {
        Comida comida = new Comida("pizza marguerita",true,50,1);
        comida.setAvaliacao("*****");

        assertEquals("*****", comida.getAvaliacao());
    }

    @Test
    void deveRetornarNotaComida() {
        Comida comida = new Comida("pizza marguerita",true,50,1);
        comida.setAvaliacao("*****");

        assertEquals(9.0f,comida.getNota());
    }
}
