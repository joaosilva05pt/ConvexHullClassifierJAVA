import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PolygonUntils {
    
    // Método para ordenar os pontos de um quadrilátero em sentido anti-horário
    public static void ordenarPontosAntiHorario(List<Point> points) {
        if (points.size() != 4) {
            throw new IllegalArgumentException("A lista de pontos deve conter exatamente 4 pontos para formar um quadrilátero.");
        }

        // Calcula o centro
        double centerX = points.stream().mapToDouble(Point::getX).average().orElse(0);
        double centerY = points.stream().mapToDouble(Point::getY).average().orElse(0);

        // Ordena os pontos em sentido anti-horário com base no ângulo em relação ao centroide
        points.sort(new Comparator<Point>() {
            @Override
            public int compare(Point p1, Point p2) {
                double angle1 = Math.atan2(p1.getY() - centerY, p1.getX() - centerX);
                double angle2 = Math.atan2(p2.getY() - centerY, p2.getX() - centerX);
                return Double.compare(angle1, angle2);
            }
        });
    }

    // Método para ordenar os pontos de um triângulo em sentido anti-horário
    public static void ordenarPontosAntiHorarioTriangulo(List<Point> points) {
        if (points.size() != 3) {
            throw new IllegalArgumentException("A lista de pontos deve conter exatamente 3 pontos para formar um triângulo.");
        }

        // Calcula o centro
        double centerX = points.stream().mapToDouble(Point::getX).average().orElse(0);
        double centerY = points.stream().mapToDouble(Point::getY).average().orElse(0);

        // Ordena os pontos em sentido anti-horário com base no ângulo em relação ao centroide
        points.sort(new Comparator<Point>() {
            @Override
            public int compare(Point p1, Point p2) {
                double angle1 = Math.atan2(p1.getY() - centerY, p1.getX() - centerX);
                double angle2 = Math.atan2(p2.getY() - centerY, p2.getX() - centerX);
                return Double.compare(angle1, angle2);
            }
        });
    }
}
