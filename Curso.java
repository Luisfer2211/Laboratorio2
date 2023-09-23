import java.util.List;
public class Curso {
    private int idCurso;
    private String nombre;
    private int horario;
    private int duracion;
    private List<String> dias;
    private int cantidadEstudiantes;
    private Sede sede;

    // Constructor
    public Curso(int idCurso, String nombre, int horario, int duracion, List<String> dias, int cantidadEstudiantes, Sede sede) {
        this.idCurso = idCurso;
        this.nombre = nombre;
        this.horario = horario;
        this.duracion = duracion;
        this.dias = dias;
        this.cantidadEstudiantes = cantidadEstudiantes;
        this.sede = sede;
    }

    // Métodos getters y setters para los atributos de la clase Curso

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getHorario() {
        return horario;
    }

    public void setHorario(int horario) {
        this.horario = horario;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public List<String> getDias() {
        return dias;
    }

    public void setDias(List<String> dias) {
        this.dias = dias;
    }

    public int getCantidadEstudiantes() {
        return cantidadEstudiantes;
    }

    public void setCantidadEstudiantes(int cantidadEstudiantes) {
        this.cantidadEstudiantes = cantidadEstudiantes;
    }

    public Sede getSede() {
        return sede;
    }

    public void setSede(Sede sede) {
        this.sede = sede;
    }
}
