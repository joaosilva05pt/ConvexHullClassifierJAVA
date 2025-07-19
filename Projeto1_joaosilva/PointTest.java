import org.junit.Test;
import static org.junit.Assert.*;

public class PointTest {

    @Test
    public void testGetters() {
        // Teste básico para os métodos getX e getY
        Point p = new Point(3.5, -7.2);
        assertEquals(3.5, p.getX(), 0.001);
        assertEquals(-7.2, p.getY(), 0.001);
    }

    @Test
    public void testDistanceToSamePoint() {
        // Distância entre o ponto e ele mesmo deve ser zero
        Point p = new Point(2, 3);
        assertEquals(0.0, p.distanceTo(p), 0.001);
    }

    @Test
    public void testDistanceToDifferentPoints() {
        // Teste de distância entre dois pontos
        Point p1 = new Point(0, 0);
        Point p2 = new Point(3, 4);
        assertEquals(5.0, p1.distanceTo(p2), 0.001); // Triângulo 3-4-5

        Point p3 = new Point(-1, -1);
        Point p4 = new Point(2, 3);
        assertEquals(5.0, p3.distanceTo(p4), 0.001); // Triângulo 3-4-5, transladado
    }

    @Test
    public void testDistanceToHorizontalPoints() {
        // Distância entre pontos ao longo do eixo X
        Point p1 = new Point(1, 0);
        Point p2 = new Point(5, 0);
        assertEquals(4.0, p1.distanceTo(p2), 0.001);
    }

    @Test
    public void testDistanceToVerticalPoints() {
        // Distância entre pontos ao longo do eixo Y
        Point p1 = new Point(0, 1);
        Point p2 = new Point(0, -3);
        assertEquals(4.0, p1.distanceTo(p2), 0.001);
    }

    @Test
    public void testDistanceToDiagonalPoints() {
        // Distância entre dois pontos com coordenadas diagonais
        Point p1 = new Point(1, 1);
        Point p2 = new Point(4, 5);
        assertEquals(5.0, p1.distanceTo(p2), 0.001);
    }
}
