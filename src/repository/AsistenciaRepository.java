package repository;

import model.Asistencia;
import java.util.ArrayList;
import java.util.List;

public class AsistenciaRepository {
    private List<Asistencia> lista = new ArrayList<>();
    private Long siguienteId = 1L;

    public Asistencia guardar(Asistencia asistencia) {
        asistencia.setId(siguienteId++);
        lista.add(asistencia);
        return asistencia;
    }

    public List<Asistencia> listarPorActividad(Long idActividad) {
        List<Asistencia> resultado = new ArrayList<>();
        for (Asistencia a : lista) {
            if (a.getIdActividad().equals(idActividad)) resultado.add(a);
        }
        return resultado;
    }

    public List<Asistencia> listarTodos() {
        return new ArrayList<>(lista);
    }
}