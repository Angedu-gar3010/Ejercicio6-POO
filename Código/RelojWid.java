
import java.time.LocalTime;
import javax.swing.*;

public class RelojWid implements Renderizable {

    private String horaActual;

    public RelojWid() {
        horaActual = LocalTime.now().toString();
    }

    public String mostrarHora() {
        horaActual = LocalTime.now().toString();
        return horaActual;
    }

    @Override
    public void dibujarContenido(String contenido) {
        System.out.println(mostrarHora());
    }

    @Override
    public String getTitulo() {
        return "Reloj";
    }

    @Override
    public int getId() {
        return 5;
    }

    @Override
    public String compartir() {
        return mostrarHora();
    }

    @Override
    public float memoriaUso() {
        return 1.5f;
    }

    @Override
    public JComponent obtenerVista() {
        JPanel panel = new JPanel();

        JLabel hora = new JLabel(mostrarHora());

        panel.add(hora);

        return panel;
    }
}
