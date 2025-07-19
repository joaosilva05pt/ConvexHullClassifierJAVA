import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.List;

public class PolygonUntilsTest {

    @Test
    public void testOrdenarPontosAntiHorarioQuadrilatero() {
        // Cenário: Quadrilátero em desordem
        Point p1 = new Point(1, 1);
        Point p2 = new Point(3, 1);
        Point p3 = new Point(3, 3);
        Point p4 = new Point(1, 3);
        List<Point> points = Arrays.asList(p3, p1, p4, p2);

        // Ordenar em sentido anti-horário
        PolygonUntils.ordenarPontosAntiHorario(points);

        // Verifica a ordem correta
        assertEquals(p1, points.get(0)); // Inferior esquerdo
        assertEquals(p2, points.get(1)); // Inferior direito
        assertEquals(p3, points.get(2)); // Superior direito
        assertEquals(p4, points.get(3)); // Superior esquerdo
    }

    @Test
    public void testOrdenarPontosAntiHorarioTriangulo() {
        // Cenário: Triângulo em desordem
        Point p1 = new Point(0, 0);
        Point p2 = new Point(2, 0);
        Point p3 = new Point(1, 2);
        List<Point> points = Arrays.asList(p2, p3, p1);

        // Ordenar em sentido anti-horário
        PolygonUntils.ordenarPontosAntiHorarioTriangulo(points);

        // Verifica a ordem correta
        assertEquals(p1, points.get(0)); // Inferior esquerdo
        assertEquals(p2, points.get(1)); // Inferior direito
        assertEquals(p3, points.get(2)); // Superior
    }

    @Test(expected = IllegalArgumentException.class)
    public void testOrdenarPontosAntiHorarioQuadrilateroInvalido() {
        // Cenário: Lista com menos de 4 pontos
        List<Point> points = Arrays.asList(new Point(1, 1), new Point(2, 2));
        PolygonUntils.ordenarPontosAntiHorario(points);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testOrdenarPontosAntiHorarioTrianguloInvalido() {
        // Cenário: Lista com mais de 3 pontos
        List<Point> points = Arrays.asList(new Point(0, 0), new Point(1, 1), new Point(2, 2), new Point(3, 3));
        PolygonUntils.ordenarPontosAntiHorarioTriangulo(points);
    }

    @Test
    public void testOrdenarPontosAntiHorarioQuadrilateroNaoConvexo() {
        // Cenário: Quadrilátero não convexo
        Point p1 = new Point(0, 0);
        Point p2 = new Point(4, 0);
        Point p3 = new Point(2, 2);
        Point p4 = new Point(0, 4);
        List<Point> points = Arrays.asList(p4, p3, p1, p2);

        // Ordenar em sentido anti-horário
        PolygonUntils.ordenarPontosAntiHorario(points);

        // Verifica a ordem correta
        assertEquals(p1, points.get(0)); // Inferior esquerdo
        assertEquals(p2, points.get(1)); // Inferior direito
        assertEquals(p4, points.get(2)); // Superior esquerdo
        assertEquals(p3, points.get(3)); // Ponto interior ou intermediário
    }
}
