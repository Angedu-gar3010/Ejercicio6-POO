import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class VistaDashboard extends JFrame {

    private JPanel panel;
    private JButton botonOrdenar;
    private JButton botonActualizar;

    public VistaDashboard() {
        setTitle("Mi Dashboard");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel superior = new JPanel();
        superior.add(new JLabel("Mi Dashboard"));

        botonOrdenar = new JButton("Ordenar por memoria");
        botonActualizar = new JButton("Actualizar");

        superior.add(botonOrdenar);
        superior.add(botonActualizar);

        panel = new JPanel(new GridLayout(0, 2, 10, 10));

        add(superior, BorderLayout.NORTH);
        add(new JScrollPane(panel), BorderLayout.CENTER);
    }

    public void mostrarWidgets(ArrayList<Renderizable> widgets) {
        panel.removeAll();

        for (Renderizable widget : widgets) {
            panel.add(widget.obtenerVista());
        }

        panel.revalidate();
        panel.repaint();
    }

    public JButton getBotonOrdenar() {
        return botonOrdenar;
    }

    public JButton getBotonActualizar() {
        return botonActualizar;
    }
}
