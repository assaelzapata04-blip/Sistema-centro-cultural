package repository;

import model.Participante;
import java.util.ArrayList;
import java.util.List;

public class ParticipanteRepository {
    private List<Participante> lista = new ArrayList<>();
    private Long siguienteId = 1L;

    public Participante guardar(Participante participante) {
        participante.setId(siguienteId++);
        lista.add(participante);
        return participante;
    }

    public Participante buscarPorId(Long id) {
        for (Participante p : lista) {
            if (p.getId().equals(id)) return p;
        }
        return null;
    }

    public List<Participante> listarTodos() {
        return new ArrayList<>(lista);
    }

    public boolean existeDocumento(String documento) {
        for (Participante p : lista) {
            if (p.getDocumento().equals(documento)) return true;
        }
        return false;
    }
}