package servicio;

import modelo.Participante;
import java.util.ArrayList;
import java.util.List;

public class ParticipanteServicio {
    private List<Participante> lista = new ArrayList<>();

    public Participante registrar(String nombre, String documento, String correo, String telefono) {
        if (nombre == null || nombre.trim().length() < 2)
            throw new IllegalArgumentException("El nombre debe tener al menos 2 caracteres");
        if (documento == null || documento.trim().length() < 5)
            throw new IllegalArgumentException("Documento invalido");
        if (correo == null || !correo.contains("@"))
            throw new IllegalArgumentException("El correo debe tener formato valido");

        for (Participante p : lista) {
            if (p.getDocumento().equals(documento))
                throw new IllegalArgumentException("Ya existe un participante con ese documento");
        }

        Participante nuevo = new Participante(nombre, documento, correo, telefono);
        lista.add(nuevo);
        return nuevo;
    }

    public List<Participante> listarTodos() {
        return new ArrayList<>(lista);
    }

    public Participante buscarPorDocumento(String documento) {
        for (Participante p : lista) {
            if (p.getDocumento().equals(documento))
                return p;
        }
        return null;
    }
}
