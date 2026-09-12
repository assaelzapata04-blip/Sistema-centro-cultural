package repository;

import model.Actividad;
import java.util.ArrayList;
import java.util.List;

public class ActividadRepository {
    private List<Actividad> lista = new ArrayList<>();
    private Long siguienteId = 1L;

    public Actividad guardar(Actividad actividad) {
        if (actividad.getId() == null) {
            actividad.setId(siguienteId++);
        }
        lista.add(actividad);
        return actividad;
    }

    public Actividad buscarPorId(Long id) {
        for (Actividad a : lista) {
            if (a.getId().equals(id)) return a;
        }
        return null;
    }

    public List<Actividad> listarTodos() {
        return new ArrayList<>(lista);
    }

    public boolean eliminar(Long id) {
        return lista.removeIf(a -> a.getId().equals(id));
    }
}
