
import java.util.ArrayList;
import javax.swing.*;

public class TareaWid implements Renderizable, Interactivo {

    private ArrayList<String> pendientes;
    private int cantidadPendientes;

    public TareaWid() {
        pendientes = new ArrayList<>();
        cantidadPendientes = 0;
    }

    public void agregarTarea(String tarea) {
        pendientes.add(tarea);
        cantidadPendientes++;
    }

    public boolean marcarCompletada(int posicion) {
        if (posicion >= 0 && posicion < pendientes.size()) {
            pendientes.remove(posicion);
            cantidadPendientes--;
            return true;
        }
        return false;
    }

    public ArrayList<String> getPendientes() {
        return pendientes;
    }

    public int getCantidadPendientes() {
        return cantidadPendientes;
    }

    @Override
    public void dibujarContenido(String contenido) {
        System.out.println("Tareas: " + pendientes);
    }

    @Override
    public void detectarInteraccion() {
        if (cantidadPendientes > 0) {
            marcarCompletada(0);
        }
    }

    @Override
    public String getTitulo() {
        return "Widget de Tareas";
    }

    @Override
    public int getId() {
        return 2;
    }

    @Override
    public String compartir() {
        return pendientes.toString();
    }

    @Override
    public float memoriaUso() {
        return 2.0f;
    }

    @Override
    public JComponent obtenerVista() {
        JPanel panel = new JPanel();

        JLabel texto = new JLabel(pendientes.toString());
        JButton boton = new JButton("Completar tarea");

        boton.addActionListener(e -> {
            detectarInteraccion();
            texto.setText(pendientes.toString());
        });

        panel.add(texto);
        panel.add(boton);

        return panel;
    }
}

