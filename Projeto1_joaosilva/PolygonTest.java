import static org.junit.Assert.*;
import java.util.Arrays;
import org.junit.Test;

public class PolygonTest {

    @Test
    public void testCalculatePerimeter() {
        // Triângulo 
        Point p1 = new Point(0, 0);
        Point p2 = new Point(3, 0);
        Point p3 = new Point(3, 4); 
        Polygon triangle = new Polygon(Arrays.asList(p1, p2, p3));

        double expectedPerimeter = 12.0; 
        assertEquals(expectedPerimeter, triangle.calculatePerimeter(), 0.001);
    }

    @Test
    public void testToString() {
        // Quadrado
        Point p1 = new Point(0, 0);
        Point p2 = new Point(1, 0);
        Point p3 = new Point(1, 1);
        Point p4 = new Point(0, 1);
        Polygon square = new Polygon(Arrays.asList(p1, p2, p3, p4));

        String expectedOutput = 
                                "Perimeter: 4";
        assertEquals(expectedOutput, square.toString());
    }

    public void testMultiplePolygonScenarios() {


        // Cenário 1: Triângulo equilátero
        Point t1 = new Point(0, 0);
        Point t2 = new Point(1, 0);
        Point t3 = new Point(0.5, Math.sqrt(3) / 2);
        Polygon triangle = new Polygon(Arrays.asList(t1, t2, t3));
        assertEquals(3.0, triangle.calculatePerimeter(), 0.1);

        // Cenário 2: Quadrado 
        Point q1 = new Point(0, 0);
        Point q2 = new Point(2, 0);
        Point q3 = new Point(2, 2);
        Point q4 = new Point(0, 2);
        Polygon square = new Polygon(Arrays.asList(q1, q2, q3, q4));
        assertEquals(8.0, square.calculatePerimeter(), 0.1);

        // Cenário 3: retangulo 
        Point a1 = new Point(0, 0);
        Point a2 = new Point(4, 0);
        Point a3 = new Point(4, 2);
        Point a4 = new Point(0, 2);
        Polygon Rectangle = new Polygon(Arrays.asList(a1, a2, a3, a4));
        assertEquals(12.0, Rectangle.calculatePerimeter(), 0.1);

       
    }
}
