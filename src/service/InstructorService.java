package service;

import model.Instructor;
import repository.InstructorRepository;
import java.util.List;

public class InstructorService {
    private InstructorRepository repositorio = new InstructorRepository();

    public Instructor registrar(String nombre, String especialidad, String correo) {
        if (nombre == null || nombre.trim().isEmpty() || nombre.length() < 3) {
            throw new IllegalArgumentException("El nombre debe tener al menos 3 caracteres");
        }
        if (especialidad == null || especialidad.trim().isEmpty()) {
            throw new IllegalArgumentException("La especialidad es obligatoria");
        }
        if (correo == null || !correo.contains("@")) {
            throw new IllegalArgumentException("El correo debe ser válido");
        }
        return repositorio.guardar(new Instructor(null, nombre, especialidad, correo));
    }

    public Instructor buscarPorId(Long id) {
        return repositorio.buscarPorId(id);
    }

    public List<Instructor> listarTodos() {
        return repositorio.listarTodos();
    }
}
