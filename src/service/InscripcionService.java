package service;

import model.Inscripcion;
import model.Actividad;
import repository.InscripcionRepository;
import repository.ActividadRepository;
import java.time.LocalDate;
import java.util.List;

public class InscripcionService {
    private InscripcionRepository repositorio = new InscripcionRepository();
    private ActividadRepository actividadRepo = new ActividadRepository();

    public Inscripcion registrar(Long idParticipante, Long idActividad) {
        Actividad actividad = actividadRepo.buscarPorId(idActividad);
        if (actividad == null) {
            throw new IllegalArgumentException("La actividad no existe");
        }
        List<Inscripcion> inscritos = repositorio.listarTodos();
        long cuposOcupados = inscritos.stream().filter(i -> i.getIdActividad().equals(idActividad)).count();
        if (cuposOcupados >= 30) {
            throw new IllegalArgumentException("No hay cupos disponibles");
        }
        return repositorio.guardar(new Inscripcion(null, idParticipante, idActividad, LocalDate.now()));
    }

    public Inscripcion buscarPorId(Long id) {
        return repositorio.buscarPorId(id);
    }

    public List<Inscripcion> listarTodos() {
        return repositorio.listarTodos();
    }
}
