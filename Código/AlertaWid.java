
import javax.swing.*;

public class AlertaWid implements Renderizable, Interactivo {

    private boolean leida;
    private int prioridad;
    private String mensaje;

    public AlertaWid(int prioridad, String mensaje) {
        this.prioridad = prioridad;
        this.mensaje = mensaje;
        this.leida = false;
    }

    public void marcar() {
        leida = true;
    }

    public String mostrarMensaje() {
        return "Prioridad " + prioridad + ": " + mensaje;
    }

    @Override
    public void dibujarContenido(String contenido) {
        System.out.println(mostrarMensaje());
    }

    @Override
    public void detectarInteraccion() {
        marcar();
    }

    @Override
    public String getTitulo() {
        return "Alerta";
    }

    @Override
    public int getId() {
        return 3;
    }

    @Override
    public String compartir() {
        return mostrarMensaje();
    }

    @Override
    public float memoriaUso() {
        return 1.5f;
    }

    @Override
    public JComponent obtenerVista() {
        JPanel panel = new JPanel();

        JLabel texto = new JLabel(mostrarMensaje());
        JButton boton = new JButton("Marcar como leída");

        boton.addActionListener(e -> {
            detectarInteraccion();
            texto.setText("Alerta leída: " + mensaje);
            boton.setEnabled(false);
        });

        panel.add(texto);
        panel.add(boton);

        return panel;
    }
}
