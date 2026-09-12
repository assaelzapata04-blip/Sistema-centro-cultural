package service;

import model.Asistencia;
import repository.AsistenciaRepository;
import java.time.LocalDate;
import java.util.List;

public class AsistenciaService {
    private AsistenciaRepository repositorio = new AsistenciaRepository();

    public Asistencia registrar(Long idParticipante, Long idActividad, LocalDate fecha, boolean asistio) {
        if (idParticipante == null || idParticipante <= 0) {
            throw new IllegalArgumentException("El ID del participante es inválido");
        }
        if (idActividad == null || idActividad <= 0) {
            throw new IllegalArgumentException("El ID de la actividad es inválido");
        }
        if (fecha == null || fecha.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("La fecha no puede ser futura");
        }
        
        List<Asistencia> existentes = repositorio.listarTodos();
        for (Asistencia a : existentes) {
            if (a.getIdParticipante().equals(idParticipante) && 
                a.getIdActividad().equals(idActividad) && 
                a.getFecha().equals(fecha)) {
                throw new IllegalArgumentException("Ya se registró la asistencia para este participante en esta fecha");
            }
        }

        return repositorio.guardar(new Asistencia(null, idParticipante, idActividad, fecha, asistio));
    }

    public List<Asistencia> listarPorActividad(Long idActividad) {
        return repositorio.listarPorActividad(idActividad);
    }

    public List<Asistencia> listarTodos() {
        return repositorio.listarTodos();
    }
}
