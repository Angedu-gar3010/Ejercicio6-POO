
import javax.swing.*;

public class ClimaWid implements Renderizable, Interactivo {

    private int temperatura;
    private int sensacion;
    private String ubicacion;
    private boolean fahrenheit = false;

    public ClimaWid(int temperatura, int sensacion, String ubicacion) {
        this.temperatura = temperatura;
        this.sensacion = sensacion;
        this.ubicacion = ubicacion;
    }

    public int getTemperatura() {
        return temperatura;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public int getSensacion() {
        return sensacion;
    }

    @Override
    public void dibujarContenido(String contenido) {
        System.out.println(contenido);
    }

    @Override
    public void detectarInteraccion() {
        fahrenheit = !fahrenheit;
    }

    @Override
    public String getTitulo() {
        return "Widget de Clima";
    }

    @Override
    public int getId() {
        return 1;
    }

    @Override
    public String compartir() {
        return "Compartir información del clima";
    }

    @Override
    public float memoriaUso() {
        return 2.5f;
    }

    @Override
    public JComponent obtenerVista() {
        JPanel panel = new JPanel();

        JLabel texto = new JLabel();
        JButton boton = new JButton("Cambiar unidad");

        actualizarTexto(texto);

        boton.addActionListener(e -> {
            detectarInteraccion();
            actualizarTexto(texto);
        });

        panel.add(texto);
        panel.add(boton);

        return panel;
    }

    private void actualizarTexto(JLabel texto) {
        if (fahrenheit) {
            double tempF = temperatura * 9.0 / 5 + 32;
            texto.setText(ubicacion + ": " + tempF + " °F");
        } else {
            texto.setText(ubicacion + ": " + temperatura + " °C");
        }
    }
}
