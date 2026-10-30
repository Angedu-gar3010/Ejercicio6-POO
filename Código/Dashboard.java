import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Dashboard {

    private ArrayList<Renderizable> widgets;

    // Constructor
    public Dashboard() {
        widgets = new ArrayList<>();
        iniciarWidgets();
    }

    // Cargar 10 widgets
    public void iniciarWidgets() {
        widgets.add(new ClimaWid(25, 27, "Guatemala"));
        widgets.add(new ClimaWid(18, 20, "Antigua"));

        TareaWid tareas1 = new TareaWid();
        tareas1.agregarTarea("Estudiar Java");
        tareas1.agregarTarea("Hacer ejercicios");
        widgets.add(tareas1);

        TareaWid tareas2 = new TareaWid();
        tareas2.agregarTarea("Revisar UML");
        widgets.add(tareas2);

        widgets.add(new AlertaWid(1, "Revisar sistema"));
        widgets.add(new AlertaWid(2, "Nueva notificación"));

        widgets.add(new RelojWid());
        widgets.add(new RelojWid());

        widgets.add(new FraseWid("Nunca dejes de aprender"));
        widgets.add(new FraseWid("La práctica hace al maestro"));
    }

    // Listar widgets
    public void listarWidgets() {
        for (Renderizable widget : widgets) {
            System.out.println(widget.getTitulo());
        }
    }

    // Buscar por ID
    public Renderizable buscarPorId(int id) {
        for (Renderizable widget : widgets) {
            if (widget.getId() == id) {
                return widget;
            }
        }
        return null;
    }

    // Ordenar por memoria
    public void ordenarPorMemoria() {
        Collections.sort(widgets,
            Comparator.comparingDouble(Renderizable::memoriaUso));
    }

    // Interactuar solo con widgets compatibles
    public void interactuar(int posicion) {
        if (posicion >= 0 && posicion < widgets.size()) {
            Renderizable widget = widgets.get(posicion);

            if (widget instanceof Interactivo) {
                ((Interactivo) widget).detectarInteraccion();
            }
        }
    }

    // Obtener lista
    public ArrayList<Renderizable> getWidgets() {
        return widgets;
    }
}

