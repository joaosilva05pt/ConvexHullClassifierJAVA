import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicita o número de pontos
        System.out.print("Digite o número de pontos: ");
        int numPoints = scanner.nextInt();

        // Cria uma lista de pontos
        List<Point> points = new ArrayList<>();
        System.out.println("Insira os pontos no formato X Y:");

        for (int i = 0; i < numPoints; i++) {
            double x = scanner.nextDouble();
            double y = scanner.nextDouble();
            points.add(new Point(x, y));
        }

        if (numPoints == 4) {
            PolygonUntils.ordenarPontosAntiHorario(points);
        } else if (numPoints == 3) {
            PolygonUntils.ordenarPontosAntiHorarioTriangulo(points);
        } else {
            System.out.println("Número de pontos não suportado.");
        }

        // Cria um polígono com base no número de vértices
        Polygon polygon;
        if (numPoints == 3) {
            polygon = new Triangle(points);
        } else if (numPoints == 4) {
            try {
                polygon = new Square(points);
            } catch (IllegalArgumentException e) {
                try {
                    polygon = new Rectangle(points);
                } catch (IllegalArgumentException ex) {
                    polygon = new Polygon(points);
                    System.out.println("Os pontos fornecidos não formam um quadrado nem um retângulo.");
                }
            }
        } else {
            polygon = new Polygon(points); //oo
        }

       
        System.out.println("Tipo de Polígono: " + polygon.toString());
        
        scanner.close();
    }
}
