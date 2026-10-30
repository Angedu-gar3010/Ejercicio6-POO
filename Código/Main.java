
import java.awt.*;
import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        JFrame ventana = new JFrame("Mi Dashboard");
        ventana.setSize(700, 400);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 2, 10, 10));

        // Crear widgets
        ClimaWid clima = new ClimaWid(25, 27, "Guatemala");
        RelojWid reloj = new RelojWid();

        TareaWid tareas = new TareaWid();
        tareas.agregarTarea("Estudiar Java");
        tareas.agregarTarea("Hacer tarea");

        FraseWid frase = new FraseWid("Nunca dejes de aprender");

        // Agregar vistas al panel
        panel.add(clima.obtenerVista());
        panel.add(reloj.obtenerVista());
        panel.add(tareas.obtenerVista());
        panel.add(frase.obtenerVista());

        ventana.add(panel);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }
}
