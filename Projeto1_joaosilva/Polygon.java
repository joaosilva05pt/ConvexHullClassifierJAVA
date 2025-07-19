import java.util.List;

public class Polygon {
    protected List<Point> vertices;

    public Polygon(List<Point> vertices) {
        this.vertices = vertices;
    }

    public double calculatePerimeter() {
        double perimeter = 0.0;
        for (int i = 0; i < vertices.size(); i++) {
            Point current = vertices.get(i);
            Point next = vertices.get((i + 1) % vertices.size());
            perimeter += current.distanceTo(next);
        }
        return perimeter;
    }

    @Override
    public String toString() {
        return 
               "Perimeter: " + Math.round(calculatePerimeter());
    }
}
