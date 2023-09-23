import java.util.ArrayList;
import java.util.List;

public class Sede {
    private int idSede;
    private String nombre;
    private List<Edificio> edificios;

    // Constructor
    public Sede(int idSede, String nombre) {
        this.idSede = idSede;
        this.nombre = nombre;
        this.edificios = new ArrayList<>();
    }

    public int getIdSede() {
        return idSede;
    }

    // Método para agregar un edificio a la sede
    public void agregarEdificio(Edificio edificio) {
        edificios.add(edificio);
    }

    // Método para obtener la lista de edificios de la sede
    public List<Edificio> obtenerEdificios() {
        return edificios;
    }

    // Método para obtener un edificio por su nombre
    public Edificio obtenerEdificioPorNombre(String nombreEdificio) {
        for (Edificio edificio : edificios) {
            if (edificio.getNombre().equals(nombreEdificio)) {
                return edificio;
            }
        }
        return null; // Si no se encuentra el edificio
    }

    // Método para obtener un salón por su id
    public Salon obtenerSalonPorId(char idEdificio, int nivel, int idSalon) {
        for (Edificio edificio : edificios) {
            if (edificio.getIdEdificio() == idEdificio) {
                Nivel nivelEnEdificio = edificio.obtenerNivelPorNumero(nivel);
                if (nivelEnEdificio != null) {
                    Salon salon = nivelEnEdificio.obtenerSalonPorId(idSalon);
                    if (salon != null) {
                        return salon;
                    }
                }
            }
        }
        return null; // Si no se encuentra el salón
    }
}
