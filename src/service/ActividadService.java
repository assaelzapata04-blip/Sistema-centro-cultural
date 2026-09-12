package service;

import model.Actividad;
import repository.ActividadRepository;
import repository.EspacioRepository;
import repository.InstructorRepository;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class ActividadService {
    private ActividadRepository repositorio = new ActividadRepository();
    private EspacioRepository espacioRepo = new EspacioRepository();
    private InstructorRepository instructorRepo = new InstructorRepository();

    public Actividad registrar(String nombre, String tipo, LocalDate fecha, LocalTime hora, Long idEspacio, Long idInstructor) {
        if (nombre == null || nombre.trim().isEmpty() || nombre.length() < 3) {
            throw new IllegalArgumentException("El nombre debe tener al menos 3 caracteres");
        }
        if (!List.of("taller", "conferencia", "exposición").contains(tipo.toLowerCase())) {
            throw new IllegalArgumentException("El tipo debe ser: taller, conferencia o exposición");
        }
        if (fecha == null || fecha.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("La fecha debe ser futura");
        }
        if (hora == null) {
            throw new IllegalArgumentException("La hora es obligatoria");
        }
        if (espacioRepo.buscarPorId(idEspacio) == null) {
            throw new IllegalArgumentException("El espacio no existe");
        }
        if (instructorRepo.buscarPorId(idInstructor) == null) {
            throw new IllegalArgumentException("El instructor no existe");
        }
        return repositorio.guardar(new Actividad(null, nombre, tipo, fecha, hora, idEspacio, idInstructor));
    }

    public Actividad buscarPorId(Long id) {
        return repositorio.buscarPorId(id);
    }

    public List<Actividad> listarTodos() {
        return repositorio.listarTodos();
    }
}
