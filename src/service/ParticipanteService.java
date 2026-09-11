package service;

import model.Participante;
import repository.ParticipanteRepository;
import java.util.List;

public class ParticipanteService {
    private ParticipanteRepository repositorio = new ParticipanteRepository();

    public Participante registrar(String nombre, String documento, String correo, String telefono) {
        if (nombre == null || nombre.trim().isEmpty())
            throw new IllegalArgumentException("El nombre es obligatorio");
        if (documento == null || documento.trim().isEmpty())
            throw new IllegalArgumentException("El documento es obligatorio");
        if (repositorio.existeDocumento(documento))
            throw new IllegalArgumentException("Ya existe un participante con ese documento");
        if (correo == null || correo.trim().isEmpty())
            throw new IllegalArgumentException("El correo es obligatorio");

        Participante p = new Participante(null, nombre, documento, correo, telefono);
        return repositorio.guardar(p);
    }

    public Participante buscarPorId(Long id) {
        return repositorio.buscarPorId(id);
    }

    public List<Participante> listarTodos() {
        return repositorio.listarTodos();
    }
}