import java.util.ArrayList;
import java.util.List;

public class Salon {
    private int idSalon;
    private int capacidad;
    private boolean[][] disponibilidadHoraria;
    private List<Curso> cursosAsignados;

    public Salon(int idSalon, int capacidad) {
        this.idSalon = idSalon;
        this.capacidad = capacidad;
        this.disponibilidadHoraria = new boolean[5][14]; // 5 días x 14 horas (de 7:00 AM a 8:00 PM)
        this.cursosAsignados = new ArrayList<>();
    }

    public boolean asignarCurso(Curso curso) {
        // Verificar si el curso cabe en el salón en función de su capacidad
        if (curso.getCantidadEstudiantes() <= capacidad) {
            // Verificar disponibilidad horaria para los días y horas del curso
            List<String> diasCurso = curso.getDias();
            int horaInicioCurso = curso.getHorario();
            int duracionCurso = curso.getDuracion();

            for (String diaCurso : diasCurso) {
                int diaIndex = obtenerIndiceDia(diaCurso);

                if (diaIndex != -1) {
                    for (int hora = horaInicioCurso; hora < horaInicioCurso + duracionCurso; hora++) {
                        if (hora >= 7 && hora <= 20) { // Horario válido de 7:00 AM a 8:00 PM
                            if (!disponibilidadHoraria[diaIndex][hora - 7]) {
                                return false; // El horario no está disponible
                            }
                        } else {
                            return false; // Horario fuera del rango válido
                        }
                    }
                } else {
                    return false; // Día no válido
                }
            }

            // Si pasó todas las verificaciones, asignar el curso al salón
            cursosAsignados.add(curso);

            // Marcar la disponibilidad horaria ocupada por el curso
            for (String diaCurso : diasCurso) {
                int diaIndex = obtenerIndiceDia(diaCurso);

                if (diaIndex != -1) {
                    for (int hora = horaInicioCurso; hora < horaInicioCurso + duracionCurso; hora++) {
                        disponibilidadHoraria[diaIndex][hora - 7] = false; // Marcar como no disponible
                    }
                }
            }

            return true; // Asignación exitosa
        } else {
            return false; // El salón no tiene capacidad suficiente para el curso
        }
    }

    // Método para desasignar un curso del salón
    public boolean desasignarCurso(Curso curso) {
        if (cursosAsignados.remove(curso)) {
            // Liberar la disponibilidad horaria ocupada por el curso
            List<String> diasCurso = curso.getDias();
            int horaInicioCurso = curso.getHorario();
            int duracionCurso = curso.getDuracion();

            for (String diaCurso : diasCurso) {
                int diaIndex = obtenerIndiceDia(diaCurso);

                if (diaIndex != -1) {
                    for (int hora = horaInicioCurso; hora < horaInicioCurso + duracionCurso; hora++) {
                        if (hora >= 7 && hora <= 20) { // Horario válido de 7:00 AM a 8:00 PM
                            disponibilidadHoraria[diaIndex][hora - 7] = true; // Marcar como disponible
                        }
                    }
                }
            }

            return true; // Desasignación exitosa
        } else {
            return false; // El curso no estaba asignado al salón
        }
    }
    private int obtenerIndiceDia(String dia) {
        switch (dia.toLowerCase()) {
            case "lunes":
                return 0;
            case "martes":
                return 1;
            case "miércoles":
                return 2;
            case "jueves":
                return 3;
            case "viernes":
                return 4;
            default:
                return -1; // Día no válido
        }
    }

    public boolean[][] obtenerDisponibilidadHoraria() {
        return disponibilidadHoraria;
    }

    public int getIdSalon() {
        return idSalon;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public List<Curso> getCursosAsignados() {
        return cursosAsignados;
    }
}
