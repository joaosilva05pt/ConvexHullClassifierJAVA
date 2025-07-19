import java.util.List;

public class Square extends Rectangle {

    
   
    public Square(List<Point> vertices) {
        super(vertices);
        if (!isSquare()) {
            throw new IllegalArgumentException("Os vértices fornecidos não formam um quadrado.");
        }
    }

    protected boolean isSquare() {
        double sideLength = vertices.get(0).distanceTo(vertices.get(1));
        for (int i = 1; i < vertices.size(); i++) {
            if (vertices.get(i).distanceTo(vertices.get((i + 1) % vertices.size())) != sideLength) {
                return false;
            }
        }
        double diag1 = vertices.get(0).distanceTo(vertices.get(2));
        double diag2 = vertices.get(1).distanceTo(vertices.get(3));
        return diag1 == diag2;
    }


   
    @Override
    public String toString() {
        return "Quadrado " + "\n" +
               "Perimetro: " + Math.round(calculatePerimeter());
    }
}
