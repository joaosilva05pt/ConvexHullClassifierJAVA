import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.List;

public class TriangleTest {

    @Test
    public void testEquilateralTriangle() {
        // Cenário: Triângulo equilátero
        Point p1 = new Point(0, 0);
        Point p2 = new Point(1, 0);
        Point p3 = new Point(0.5, Math.sqrt(3) / 2);

        Triangle triangle = new Triangle(Arrays.asList(p1, p2, p3));

        // Verifica o tipo do triângulo
        assertEquals("Triângulo Equilátero", triangle.identifyType());

        // Verifica o perímetro
        assertEquals(3.0, triangle.calculatePerimeter(), 0.1);

        // Verifica o método toString
        assertTrue(triangle.toString().contains("Type: Triângulo Equilátero"));
    }

    @Test
    public void testIsoscelesTriangle() {
        // Cenário: Triângulo isósceles
        Point p1 = new Point(0, 0);
        Point p2 = new Point(2, 0);
        Point p3 = new Point(1, Math.sqrt(3));

        Triangle triangle = new Triangle(Arrays.asList(p1, p2, p3));

        // Verifica o tipo do triângulo
        assertEquals("Triângulo Isósceles", triangle.identifyType());

        // Verifica o perímetro
        assertEquals(6.464, triangle.calculatePerimeter(), 0.1);

        // Verifica o método toString
        assertTrue(triangle.toString().contains("Type: Triângulo Isósceles"));
    }

    @Test
    public void testScaleneTriangle() {
        // Cenário: Triângulo escaleno
        Point p1 = new Point(0, 0);
        Point p2 = new Point(4, 0);
        Point p3 = new Point(2, 3);

        Triangle triangle = new Triangle(Arrays.asList(p1, p2, p3));

        // Verifica o tipo do triângulo
        assertEquals("Triângulo Escaleno", triangle.identifyType());

        // Verifica o perímetro
        assertEquals(11.211, triangle.calculatePerimeter(), 0.1);

        // Verifica o método toString
        assertTrue(triangle.toString().contains("Type: Triângulo Escaleno"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidTriangleWithExtraVertices() {
        // Cenário: Número de vértices inválido
        Point p1 = new Point(0, 0);
        Point p2 = new Point(1, 0);
        Point p3 = new Point(0.5, Math.sqrt(3) / 2);
        Point p4 = new Point(1, 1);

        new Triangle(Arrays.asList(p1, p2, p3, p4)); // Deve lançar exceção
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidTriangleWithLessVertices() {
        // Cenário: Menos de 3 vértices
        Point p1 = new Point(0, 0);
        Point p2 = new Point(1, 0);

        new Triangle(Arrays.asList(p1, p2)); // Deve lançar exceção
    }

    @Test
    public void testTriangleToString() {
        // Cenário: Verifica a saída do método toString
        Point p1 = new Point(0, 0);
        Point p2 = new Point(1, 0);
        Point p3 = new Point(0.5, Math.sqrt(3) / 2);

        Triangle triangle = new Triangle(Arrays.asList(p1, p2, p3));

        // Verifica o conteúdo
        String output = triangle.toString();
        assertTrue(output.contains("Triangle with vertices:"));
        assertTrue(output.contains("Type: Triângulo Equilátero"));
        assertTrue(output.contains("Perimeter: 3"));
    }
}
