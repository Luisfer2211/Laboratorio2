import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Salon> salones = CargaArchivoCSV.cargarSalonesDesdeCSV("salones.csv");
        List<Curso> cursos = CargaArchivoCSV.cargarCursosDesdeCSV("cursos.csv");
        AsignacionSalones asignacionSalones = new AsignacionSalones(cursos, salones);

        while (true) {
            System.out.println("Menú:");
            System.out.println("1. Asignar Salones a Cursos");
            System.out.println("2. Generar Informe");
            System.out.println("3. Salir");
            System.out.print("Ingrese el número de opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    asignacionSalones.asignarSalones();
                    System.out.println("Asignación de salones completada.");
                    break;
                case 2:
                    List<Curso> cursosAsignados = asignacionSalones.getCursosAsignados();
                    List<Curso> cursosSinSalon = asignacionSalones.getCursosSinSalon();
                    Informe informe = new Informe(cursosAsignados, cursosSinSalon);
                    informe.generarInforme("informe.txt");
                    System.out.println("Informe generado con éxito.");
                    break;
                case 3:
                    System.out.println("Saliendo del programa.");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, ingrese un número válido.");
                    break;
            }
        }
    }
}
