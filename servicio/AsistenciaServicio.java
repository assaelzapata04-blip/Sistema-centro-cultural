package servicio;

import modelo.Asistencia;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AsistenciaServicio {
    private List<Asistencia> lista = new ArrayList<>();

    public Asistencia registrarAsistencia(long idParticipante, LocalDate fecha) {
        if (fecha.isAfter(LocalDate.now()))
            throw new IllegalArgumentException("La fecha no puede ser en el futuro");

        Asistencia nueva = new Asistencia(idParticipante, fecha);
        lista.add(nueva);
        return nueva;
    }
}
