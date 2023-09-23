import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Informe {
    private List<Curso> cursosAsignados;
    private List<Curso> cursosSinSalon;

    public Informe(List<Curso> cursosAsignados, List<Curso> cursosSinSalon) {
        this.cursosAsignados = cursosAsignados;
        this.cursosSinSalon = cursosSinSalon;
    }

    // Método para generar el informe
    public void generarInforme(String nombreArchivo) {
        try (FileWriter writer = new FileWriter(nombreArchivo)) {
            writer.write("Listado de Cursos Asignados a Salones:\n");
            for (Curso curso : cursosAsignados) {
                writer.write("ID: " + curso.getIdCurso() + "\n");
                writer.write("Sede: " + curso.getSede().getIdSede() + "\n");
                writer.write("Nombre Curso: " + curso.getNombre() + "\n");
                writer.write("\n");
            }

            writer.write("\nListado de Cursos No Asignados a Salones:\n");
            for (Curso curso : cursosSinSalon) {
                writer.write("ID: " + curso.getIdCurso() + "\n");
                writer.write("Nombre Curso: " + curso.getNombre() + "\n");
                writer.write("\n");
            }

            System.out.println("Informe generado con éxito en " + nombreArchivo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
