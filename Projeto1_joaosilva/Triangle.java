import java.util.List;

public class Triangle extends Polygon {

    public Triangle(List<Point> vertices) {
        super(vertices);
        if (vertices.size() != 3) {
            throw new IllegalArgumentException("Um triângulo deve ter exatamente 3 vértices.");
        }
    }

    public String identifyType() {
        double side1 = vertices.get(0).distanceTo(vertices.get(1));
        double side2 = vertices.get(1).distanceTo(vertices.get(2));
        double side3 = vertices.get(2).distanceTo(vertices.get(0));
        
        // Define uma margem de erro para comparação de valores de ponto flutuante
        final double EPSILON = 0.001;
    
       

        if (Math.abs(side1 - side2) < EPSILON && Math.abs(side2 - side3) < EPSILON) {
            return "Triângulo Equilátero";
        } else if (Math.abs(side1 - side2) < EPSILON || Math.abs(side2 - side3) < EPSILON || Math.abs(side1 - side3) < EPSILON) {
            return "Triângulo Isósceles";
        } else if (side1 + side2 <= side3 || side2 + side3 <= side1 || side1 + side3 <= side2) {
            return "Os pontos fornecidos não formam um triângulo";
        } else {
            return "Triângulo Escaleno";
        }
        
    }
    
    @Override
    public String toString() {
        return 
                 identifyType() + "\n" +
               "Perimetro: " + Math.round(calculatePerimeter());
    }
}
