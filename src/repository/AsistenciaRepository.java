package repository;

import model.Asistencia;
import java.util.ArrayList;
import java.util.List;

public class AsistenciaRepository {
    private List<Asistencia> lista = new ArrayList<>();
    private Long siguienteId = 1L;

    public Asistencia guardar(Asistencia asistencia) {
        if (asistencia.getId() == null) {
            asistencia.setId(siguienteId++);
        }
        lista.add(asistencia);
        return asistencia;
    }

    public Asistencia buscarPorId(Long id) {
        for (Asistencia a : lista) {
            if (a.getId().equals(id)) return a;
        }
        return null;
    }

    public List<Asistencia> listarTodos() {
        return new ArrayList<>(lista);
    }

    public List<Asistencia> listarPorActividad(Long idActividad) {
        List<Asistencia> resultado = new ArrayList<>();
        for (Asistencia a : lista) {
            if (a.getIdActividad().equals(idActividad)) {
                resultado.add(a);
            }
        }
        return resultado;
    }
}
