package repository;

import model.Inscripcion;
import java.util.ArrayList;
import java.util.List;

public class InscripcionRepository {
    private List<Inscripcion> lista = new ArrayList<>();
    private Long siguienteId = 1L;

    public Inscripcion guardar(Inscripcion inscripcion) {
        if (inscripcion.getId() == null) {
            inscripcion.setId(siguienteId++);
        }
        lista.add(inscripcion);
        return inscripcion;
    }

    public Inscripcion buscarPorId(Long id) {
        for (Inscripcion i : lista) {
            if (i.getId().equals(id)) return i;
        }
        return null;
    }

    public List<Inscripcion> listarTodos() {
        return new ArrayList<>(lista);
    }

    public boolean eliminar(Long id) {
        return lista.removeIf(i -> i.getId().equals(id));
    }
}
