
import javax.swing.*;

public class FraseWid implements Renderizable {

    private String frase;

    public FraseWid(String frase) {
        this.frase = frase;
    }

    public String mostrarFrase() {
        return frase;
    }

    @Override
    public void dibujarContenido(String contenido) {
        System.out.println(mostrarFrase());
    }

    @Override
    public String getTitulo() {
        return "Frase del día";
    }

    @Override
    public int getId() {
        return 6;
    }

    @Override
    public String compartir() {
        return frase;
    }

    @Override
    public float memoriaUso() {
        return 1.0f;
    }

    @Override
    public JComponent obtenerVista() {
        JPanel panel = new JPanel();

        JLabel texto = new JLabel(mostrarFrase());

        panel.add(texto);

        return panel;
    }
}
