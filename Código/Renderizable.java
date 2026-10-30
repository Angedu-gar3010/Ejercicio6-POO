import javax.swing.JComponent;

public interface Renderizable {

    void dibujarContenido(String contenido);

    String getTitulo();

    int getId();

    String compartir();

    float memoriaUso();

    JComponent obtenerVista();
}
