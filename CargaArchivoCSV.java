import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CargaArchivoCSV {
    public static List<Salon> cargarSalonesDesdeCSV(String archivo) {
        List<Salon> salones = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 5) {
                    int idSede = Integer.parseInt(partes[0]);
                    char edificio = partes[1].charAt(0);
                    int nivel = Integer.parseInt(partes[2]);
                    int idSalon = Integer.parseInt(partes[3]);
                    int capacidad = Integer.parseInt(partes[4]);
                    Salon salon = new Salon(idSede, edificio, nivel, idSalon, capacidad);
                    salones.add(salon);
                } else {
                    System.out.println("Error: línea incorrecta en el archivo CSV de salones.");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return salones;
    }

    public static List<Curso> cargarCursosDesdeCSV(String archivo) {
        List<Curso> cursos = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 7) { 
                    int idCurso = Integer.parseInt(partes[0]);
                    int idSede = Integer.parseInt(partes[1]);
                    String nombreCurso = partes[2];
                    int horario = Integer.parseInt(partes[3]);
                    int duracion = Integer.parseInt(partes[4]);
                    String[] dias = partes[5].split(",");
                    int cantidadEstudiantes = Integer.parseInt(partes[6]);
                    Curso curso = new Curso(idCurso, idSede, nombreCurso, horario, duracion, dias, cantidadEstudiantes);
                    cursos.add(curso);
                } else {
                    System.out.println("Error: línea incorrecta en el archivo CSV de cursos.");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cursos;
    }
}
