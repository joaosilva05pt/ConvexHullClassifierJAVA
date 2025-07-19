import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.List;

public class SquareTest {

    @Test
    public void testValidSquare() {
        // Cenário: Quadrado válido
        Point p1 = new Point(0, 0);
        Point p2 = new Point(2, 0);
        Point p3 = new Point(2, 2);
        Point p4 = new Point(0, 2);

        Square square = new Square(Arrays.asList(p1, p2, p3, p4));

        // Verifica o perímetro
        assertEquals(8.0, square.calculatePerimeter(), 0.1);

        // Verifica o método toString
        assertTrue(square.toString().contains("Perimetro: 8"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSquareWithInvalidShape() {
        // Cenário: Os vértices não formam um quadrado
        Point p1 = new Point(0, 0);
        Point p2 = new Point(4, 0);
        Point p3 = new Point(4, 2);
        Point p4 = new Point(0, 2);

        new Square(Arrays.asList(p1, p2, p3, p4)); // Deve lançar exceção
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSquareWithInvalidVerticesCount() {
        // Cenário: Menos de 4 vértices fornecidos
        Point p1 = new Point(0, 0);
        Point p2 = new Point(2, 0);
        Point p3 = new Point(2, 2);

        new Square(Arrays.asList(p1, p2, p3)); // Deve lançar exceção
    }

    @Test
    public void testSquareToString() {
        // Cenário: Verifica a saída do método toString
        Point p1 = new Point(0, 0);
        Point p2 = new Point(1, 0);
        Point p3 = new Point(1, 1);
        Point p4 = new Point(0, 1);

        Square square = new Square(Arrays.asList(p1, p2, p3, p4));

        // Verifica a saída
        String output = square.toString();
        assertTrue(output.contains("Quadrado com vertices:"));
        assertTrue(output.contains("Perimetro: 4"));
    }

    @Test
    public void testSquareWithLargeCoordinates() {
        // Cenário: Quadrado com coordenadas grandes
        Point p1 = new Point(100, 100);
        Point p2 = new Point(200, 100);
        Point p3 = new Point(200, 200);
        Point p4 = new Point(100, 200);

        Square square = new Square(Arrays.asList(p1, p2, p3, p4));

        // Verifica o perímetro
        assertEquals(400.0, square.calculatePerimeter(), 0.1);
    }

    @Test
    public void testSquareWithSmallSideLengths() {
        // Cenário: Quadrado com lados pequenos
        Point p1 = new Point(0, 0);
        Point p2 = new Point(0.1, 0);
        Point p3 = new Point(0.1, 0.1);
        Point p4 = new Point(0, 0.1);

        Square square = new Square(Arrays.asList(p1, p2, p3, p4));

        // Verifica o perímetro
        assertEquals(0.4, square.calculatePerimeter(), 0.01);
    }
}
