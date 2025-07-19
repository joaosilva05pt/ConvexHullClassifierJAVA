import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.List;

public class ConvexHullTest {

    @Test
    public void testConvexHullSimpleTriangle() {
        // Cenário: Triângulo simples
        Point p1 = new Point(0, 0);
        Point p2 = new Point(1, 0);
        Point p3 = new Point(0, 1);

        ConvexHull hull = new ConvexHull(Arrays.asList(p1, p2, p3));
        List<Point> result = hull.calculateConvexHull();

        
        assertEquals(3, result.size());
        assertTrue(result.containsAll(Arrays.asList(p1, p2, p3)));
    }

    @Test
    public void testConvexHullSquare() {
        // Cenário: Quadrado
        Point p1 = new Point(0, 0);
        Point p2 = new Point(1, 0);
        Point p3 = new Point(1, 1);
        Point p4 = new Point(0, 1);

        ConvexHull hull = new ConvexHull(Arrays.asList(p1, p2, p3, p4));
        List<Point> result = hull.calculateConvexHull();

       
        assertEquals(4, result.size());
        assertTrue(result.containsAll(Arrays.asList(p1, p2, p3, p4)));
    }

    @Test
    public void testConvexHullWithInternalPoints() {
        // Cenário: Pontos internos e externos
        Point p1 = new Point(0, 0);
        Point p2 = new Point(4, 0);
        Point p3 = new Point(4, 4);
        Point p4 = new Point(0, 4);
        Point p5 = new Point(2, 2); // Ponto interno

        ConvexHull hull = new ConvexHull(Arrays.asList(p1, p2, p3, p4, p5));
        List<Point> result = hull.calculateConvexHull();

       
        assertEquals(4, result.size());
        assertTrue(result.containsAll(Arrays.asList(p1, p2, p3, p4)));
        assertFalse(result.contains(p5));
    }

    @Test
    public void testConvexHullCollinearPoints() {
        // Cenário: Pontos colineares
        Point p1 = new Point(0, 0);
        Point p2 = new Point(2, 2);
        Point p3 = new Point(4, 4);

        ConvexHull hull = new ConvexHull(Arrays.asList(p1, p2, p3));
        List<Point> result = hull.calculateConvexHull();

       
        assertEquals(2, result.size());
        assertTrue(result.containsAll(Arrays.asList(p1, p3)));
        assertFalse(result.contains(p2));
    }

    @Test
    public void testConvexHullComplexShape() {
        // Cenário: Forma complexa
        Point p1 = new Point(0, 0);
        Point p2 = new Point(4, 0);
        Point p3 = new Point(2, 1);
        Point p4 = new Point(4, 4);
        Point p5 = new Point(0, 4);
        Point p6 = new Point(2, 3);

        ConvexHull hull = new ConvexHull(Arrays.asList(p1, p2, p3, p4, p5, p6));
        List<Point> result = hull.calculateConvexHull();

        
        assertEquals(4, result.size());
        assertTrue(result.containsAll(Arrays.asList(p1, p2, p4, p5)));
        assertFalse(result.contains(p3));
        assertFalse(result.contains(p6));
    }
}
