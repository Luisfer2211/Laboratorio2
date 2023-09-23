import java.util.ArrayList;
import java.util.List;

public class Edificio {
    private char idEdificio;
    private String nombre;
    private List<Nivel> niveles;

    // Constructor
    public Edificio(char idEdificio, String nombre) {
        this.idEdificio = idEdificio;
        this.nombre = nombre;
        this.niveles = new ArrayList<>();
    }

    // Método para agregar un nivel al edificio
    public void agregarNivel(Nivel nivel) {
        niveles.add(nivel);
    }

    // Método para obtener la lista de niveles del edificio
    public List<Nivel> obtenerNiveles() {
        return niveles;
    }

    // Método para obtener un nivel por su número
    public Nivel obtenerNivelPorNumero(int numeroNivel) {
        for (Nivel nivel : niveles) {
            if (nivel.getNumero() == numeroNivel) {
                return nivel;
            }
        }
        return null; // Si no se encuentra el nivel
    }

    // Getters para los atributos
    public char getIdEdificio() {
        return idEdificio;
    }

    public String getNombre() {
        return nombre;
    }
}
