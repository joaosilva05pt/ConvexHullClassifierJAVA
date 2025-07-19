import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.List;

public class RectangleTest {

    @Test
    public void testValidRectangle() {
        // Cenário: Retângulo válido
        Point p1 = new Point(0, 0);
        Point p2 = new Point(4, 0);
        Point p3 = new Point(4, 2);
        Point p4 = new Point(0, 2);

        Rectangle rectangle = new Rectangle(Arrays.asList(p1, p2, p3, p4));

        // Verifica o perímetro
        assertEquals(12.0, rectangle.calculatePerimeter(), 0.1);

        // Verifica o método toString
        assertTrue(rectangle.toString().contains("Perimeter: 12"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRectangleWithInvalidVerticesCount() {
        // Cenário: Número de vértices inválido
        Point p1 = new Point(0, 0);
        Point p2 = new Point(4, 0);
        Point p3 = new Point(4, 2);

        new Rectangle(Arrays.asList(p1, p2, p3)); // Deve lançar exceção
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRectangleWithInvalidShape() {
        // Cenário: Os vértices não formam um retângulo
        Point p1 = new Point(0, 0);
        Point p2 = new Point(3, 0);
        Point p3 = new Point(4, 2);
        Point p4 = new Point(0, 2);

        new Rectangle(Arrays.asList(p1, p2, p3, p4)); // Deve lançar exceção
    }

    @Test
    public void testRectangleWithSquareVertices() {
        // Cenário: Quadrado (um caso especial de retângulo)
        Point p1 = new Point(0, 0);
        Point p2 = new Point(2, 0);
        Point p3 = new Point(2, 2);
        Point p4 = new Point(0, 2);

        Rectangle rectangle = new Rectangle(Arrays.asList(p1, p2, p3, p4));

        // Verifica o perímetro
        assertEquals(8.0, rectangle.calculatePerimeter(), 0.1);
    }

    @Test
    public void testRectangleToString() {
        // Cenário: Verifica a saída do método toString
        Point p1 = new Point(0, 0);
        Point p2 = new Point(4, 0);
        Point p3 = new Point(4, 2);
        Point p4 = new Point(0, 2);

        Rectangle rectangle = new Rectangle(Arrays.asList(p1, p2, p3, p4));

        // Verifica o conteúdo
        String output = rectangle.toString();
        assertTrue(output.contains("Rectangle with vertices:"));
        assertTrue(output.contains("Perimeter: 12"));
    }
}
