package ec.edu.ups.poo;

public class Calificacion {
    private double nota;
    private String asignatura;

    public Calificacion(String asignatura, double nota) {
        this.asignatura = asignatura;
        this.nota = nota;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    @Override
    public String toString() {
        return "Asignatura: " + asignatura + ", Nota: " + nota;
    }
}

