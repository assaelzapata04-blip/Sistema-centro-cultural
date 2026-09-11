package service;

import model.Asistencia;
import repository.AsistenciaRepository;
import java.time.LocalDate;
import java.util.List;

public class AsistenciaService {
    private AsistenciaRepository repositorio = new AsistenciaRepository();

    public Asistencia registrar(Long idParticipante, Long idActividad, LocalDate fecha, boolean presente) {
        if (idParticipante == null)
            throw new IllegalArgumentException("El ID del participante es obligatorio");
        if (idActividad == null)
            throw new IllegalArgumentException("El ID de la actividad es obligatorio");
        if (fecha == null)
            throw new IllegalArgumentException("La fecha es obligatoria");

        Asistencia a = new Asistencia(null, idParticipante, idActividad, fecha, presente);
        return repositorio.guardar(a);
    }

    public List<Asistencia> listarPorActividad(Long idActividad) {
        return repositorio.listarPorActividad(idActividad);
    }

    public List<Asistencia> listarTodos() {
        return repositorio.listarTodos();
    }
}