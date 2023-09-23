import java.util.ArrayList;
import java.util.List;

public class AsignacionSalones {
    private List<Curso> cursos;
    private List<Salon> salones;
    private List<Curso> cursosSinSalon; // Cursos que no se pueden asignar a ningún salón

    public AsignacionSalones(List<Curso> cursos, List<Salon> salones) {
        this.cursos = cursos;
        this.salones = salones;
        this.cursosSinSalon = new ArrayList<>();
    }

    // Método para realizar la asignación de salones a cursos
    public void asignarSalones() {
        for (Curso curso : cursos) {
            boolean asignado = false;
            for (Salon salon : salones) {
                if (salon.asignarCurso(curso)) {
                    asignado = true;
                    break;
                }
            }
            if (!asignado) {
                cursosSinSalon.add(curso);
            }
        }
    }

    // Método para obtener la lista de cursos asignados a salones
    public List<Curso> getCursosAsignados() {
        List<Curso> cursosAsignados = new ArrayList<>();
        for (Salon salon : salones) {
            cursosAsignados.addAll(salon.getCursosAsignados());
        }
        return cursosAsignados;
    }

    // Método para obtener la lista de cursos que no se pudieron asignar a ningún salón
    public List<Curso> getCursosSinSalon() {
        return cursosSinSalon;
    }
}
