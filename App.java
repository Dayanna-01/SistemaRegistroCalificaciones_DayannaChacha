package ec.edu.ups.poo;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class App extends Frame implements ActionListener {

    private TextField cedulaField, nombreField, apellidoField;
    private Button agregarBtn, modificarBtn, eliminarBtn, guardarBtn, cancelarBtn;

    private List<Estudiante> estudiantes = new ArrayList<>();

    public App() {
        setTitle("Registro de Calificaciones");
        setSize(500, 300);
        setLayout(new BorderLayout());

        Color fondo = new Color(255, 225, 251);
        Color botones = new Color(216, 160, 233);
        Color campos = new Color(240, 200, 255);

        // Panel superior
        Panel panelSuperior = new Panel(new FlowLayout());
        agregarBtn = new Button("Agregar");
        modificarBtn = new Button("Modificar");
        eliminarBtn = new Button("Eliminar");

        agregarBtn.setBackground(botones);
        modificarBtn.setBackground(botones);
        eliminarBtn.setBackground(botones);

        panelSuperior.add(agregarBtn);
        panelSuperior.add(modificarBtn);
        panelSuperior.add(eliminarBtn);

        // Panel central
        Panel panelCentral = new Panel(new GridLayout(3, 2, 10, 10));
        panelCentral.setBackground(fondo);

        panelCentral.add(new Label("Cédula:"));
        cedulaField = new TextField();
        cedulaField.setBackground(campos);
        panelCentral.add(cedulaField);

        panelCentral.add(new Label("Nombre:"));
        nombreField = new TextField();
        nombreField.setBackground(campos);
        panelCentral.add(nombreField);

        panelCentral.add(new Label("Apellido:"));
        apellidoField = new TextField();
        apellidoField.setBackground(campos);
        panelCentral.add(apellidoField);

        // Panel inferior
        Panel panelInferior = new Panel(new FlowLayout());
        guardarBtn = new Button("Guardar");
        cancelarBtn = new Button("Cancelar");

        guardarBtn.setBackground(botones);
        cancelarBtn.setBackground(botones);

        panelInferior.add(guardarBtn);
        panelInferior.add(cancelarBtn);

        // Agregamos los paneles al Frame
        add(panelSuperior, BorderLayout.NORTH);
        add(panelCentral, BorderLayout.CENTER);
        add(panelInferior, BorderLayout.SOUTH);

        // Listeners
        agregarBtn.addActionListener(this);
        modificarBtn.addActionListener(this);
        eliminarBtn.addActionListener(this);
        guardarBtn.addActionListener(this);
        cancelarBtn.addActionListener(this);

        // Cierre de ventana
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                dispose();
            }
        });

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cedula = cedulaField.getText();
        String nombre = nombreField.getText();
        String apellido = apellidoField.getText();

        Object src = e.getSource();

        if (src == guardarBtn) {
            Estudiante est = new Estudiante(cedula, nombre, apellido);
            est.agregarCalificacion(new Calificacion("Matemática", 18.5));
            estudiantes.add(est);

            System.out.println("[GUARDAR]");
            System.out.println("Estudiante registrado:");
            System.out.println(est);
        } else if (src == cancelarBtn) {
            cedulaField.setText("");
            nombreField.setText("");
            apellidoField.setText("");
            System.out.println("[CANCELAR]");
            System.out.println("Campos limpiados.");
        } else if (src == agregarBtn) {
            System.out.println("[AGREGAR]");
            mostrarDatosIngresados(cedula, nombre, apellido);
        } else if (src == modificarBtn) {
            System.out.println("[MODIFICAR]");
            mostrarDatosIngresados(cedula, nombre, apellido);
        } else if (src == eliminarBtn) {
            System.out.println("[ELIMINAR]");
            mostrarDatosIngresados(cedula, nombre, apellido);
        }
    }

    private void mostrarDatosIngresados(String cedula, String nombre, String apellido) {
        System.out.println("Datos ingresados:");
        System.out.println("Cédula: " + cedula);
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellido: " + apellido);
    }

    public static void main(String[] args) {
        new App();
    }
}
