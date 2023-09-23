import java.util.ArrayList;
import java.util.List;

public class Nivel {
    private int numero;
    private List<Salon> salones;

    // Constructor
    public Nivel(int numero) {
        this.numero = numero;
        this.salones = new ArrayList<>();
    }

    // Método para agregar un salón al nivel
    public void agregarSalon(Salon salon) {
        salones.add(salon);
    }

    // Método para obtener la lista de salones del nivel
    public List<Salon> obtenerSalones() {
        return salones;
    }

    // Método para obtener un salón por su id
    public Salon obtenerSalonPorId(int idSalon) {
        for (Salon salon : salones) {
            if (salon.getIdSalon() == idSalon) {
                return salon;
            }
        }
        return null; // Si no se encuentra el salón
    }

    // Getter para el atributo "numero"
    public int getNumero() {
        return numero;
    }
}
