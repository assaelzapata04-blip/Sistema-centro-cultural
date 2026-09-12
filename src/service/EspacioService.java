package service;

import model.Espacio;
import repository.EspacioRepository;
import java.util.List;

public class EspacioService {
    private EspacioRepository repositorio = new EspacioRepository();

    public Espacio registrar(String nombre, int capacidad, String ubicacion) {
        if (nombre == null || nombre.trim().isEmpty() || nombre.length() < 2) {
            throw new IllegalArgumentException("El nombre debe tener al menos 2 caracteres");
        }
        if (capacidad <= 0) {
            throw new IllegalArgumentException("La capacidad debe ser mayor a 0");
        }
        if (ubicacion == null || ubicacion.trim().isEmpty()) {
            throw new IllegalArgumentException("La ubicación es obligatoria");
        }
        return repositorio.guardar(new Espacio(null, nombre, capacidad, ubicacion));
    }

    public Espacio buscarPorId(Long id) {
        return repositorio.buscarPorId(id);
    }

    public List<Espacio> listarTodos() {
        return repositorio.listarTodos();
    }
}
