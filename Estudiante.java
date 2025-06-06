package ec.edu.ups.poo;
import java.util.ArrayList;
import java.util.List;

public class Estudiante {
    private String cedula;
    private String nombre;
    private String apellido;
    private List<Calificacion> calificaciones;

    public Estudiante(String cedula, String nombre, String apellido) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.calificaciones = new ArrayList<>();
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public List<Calificacion> getCalificaciones() {
        return calificaciones;
    }

    public void agregarCalificacion(Calificacion calificacion) {
        this.calificaciones.add(calificacion);
    }

    public void eliminarCalificaciones() {
        this.calificaciones.clear(); // Composición: se eliminan al eliminar el estudiante
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Estudiante: ").append(cedula).append(" - ").append(nombre).append(" ").append(apellido).append("\n");
        for (Calificacion c : calificaciones) {
            sb.append("  ").append(c.toString()).append("\n");
        }
        return sb.toString();
    }
}
