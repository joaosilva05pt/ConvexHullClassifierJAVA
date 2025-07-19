import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ConvexHull {
    private List<Point> points;

    // Construtor que recebe a lista de pontos
    public ConvexHull(List<Point> points) {
        this.points = points;
    }

    
    public List<Point> calculateConvexHull() {
        // Ordena os pontos por coordenadas x, depois y
        List<Point> sortedPoints = new ArrayList<>(points);
        Collections.sort(sortedPoints, (a, b) -> {
            if (a.getX() != b.getX()) return Double.compare(a.getX(), b.getX());
            return Double.compare(a.getY(), b.getY());
        });

        List<Point> hull = new ArrayList<>();

        // Construir a parte inferior do hull
        for (Point p : sortedPoints) {
            while (hull.size() >= 2 && crossProduct(hull.get(hull.size() - 2), hull.get(hull.size() - 1), p) <= 0) {
                hull.remove(hull.size() - 1);
            }
            hull.add(p);
        }

        // Construir a parte superior do hull
        int t = hull.size() + 1;
        for (int i = sortedPoints.size() - 1; i >= 0; i--) {
            Point p = sortedPoints.get(i);
            while (hull.size() >= t && crossProduct(hull.get(hull.size() - 2), hull.get(hull.size() - 1), p) <= 0) {
                hull.remove(hull.size() - 1);
            }
            hull.add(p);
        }

        hull.remove(hull.size() - 1); // Remove o último ponto duplicado
        return hull; // Retorna a lista de pontos do Convex Hull
    }

    // Método auxiliar para calcular o produto cruzado
    private double crossProduct(Point a, Point b, Point c) {
        return (b.getX() - a.getX()) * (c.getY() - a.getY()) - (b.getY() - a.getY()) * (c.getX() - a.getX());
    }
}
