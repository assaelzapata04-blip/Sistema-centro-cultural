package repository;

import model.Instructor;
import java.util.ArrayList;
import java.util.List;

public class InstructorRepository {
    private List<Instructor> lista = new ArrayList<>();
    private Long siguienteId = 1L;

    public Instructor guardar(Instructor instructor) {
        if (instructor.getId() == null) {
            instructor.setId(siguienteId++);
        }
        lista.add(instructor);
        return instructor;
    }

    public Instructor buscarPorId(Long id) {
        for (Instructor i : lista) {
            if (i.getId().equals(id)) return i;
        }
        return null;
    }

    public List<Instructor> listarTodos() {
        return new ArrayList<>(lista);
    }

    public boolean eliminar(Long id) {
        return lista.removeIf(i -> i.getId().equals(id));
    }
}
