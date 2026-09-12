package repository;

import model.Espacio;
import java.util.ArrayList;
import java.util.List;

public class EspacioRepository {
    private List<Espacio> lista = new ArrayList<>();
    private Long siguienteId = 1L;

    public Espacio guardar(Espacio espacio) {
        if (espacio.getId() == null) {
            espacio.setId(siguienteId++);
        }
        lista.add(espacio);
        return espacio;
    }

    public Espacio buscarPorId(Long id) {
        for (Espacio e : lista) {
            if (e.getId().equals(id)) return e;
        }
        return null;
    }

    public List<Espacio> listarTodos() {
        return new ArrayList<>(lista);
    }

    public boolean eliminar(Long id) {
        return lista.removeIf(e -> e.getId().equals(id));
    }
}
