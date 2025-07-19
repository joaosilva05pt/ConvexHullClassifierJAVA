import java.util.List;

public class Rectangle extends Polygon {

    public Rectangle(List<Point> vertices) {
        super(vertices);
        if (vertices.size() != 4) {
            throw new IllegalArgumentException("Um retângulo deve ter exatamente 4 vértices.");
        }
        if (!isRectangle()) {
            throw new IllegalArgumentException("Os vértices fornecidos não formam um retângulo.");
        }
    }

    protected boolean isRectangle() {
        double d1 = vertices.get(0).distanceTo(vertices.get(1));
        double d2 = vertices.get(1).distanceTo(vertices.get(2));
        double d3 = vertices.get(2).distanceTo(vertices.get(3));
        double d4 = vertices.get(3).distanceTo(vertices.get(0));

        double diag1 = vertices.get(0).distanceTo(vertices.get(2));
        double diag2 = vertices.get(1).distanceTo(vertices.get(3));

        return d1 == d3 && d2 == d4 && diag1 == diag2;
    }

    @Override
    public String toString() {
        return "Retangulo " + "\n" +
               "Perimetro: " + Math.round(calculatePerimeter());
    }
}
