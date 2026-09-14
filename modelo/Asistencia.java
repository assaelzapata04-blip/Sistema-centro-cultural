package modelo;

import java.time.LocalDate;

public class Asistencia {
    private long id;
    private long idParticipante;
    private LocalDate fecha;
    private static long contador = 1;

    public Asistencia(long idParticipante, LocalDate fecha) {
        this.id = contador++;
        this.idParticipante = idParticipante;
        this.fecha = fecha;
    }

    public long getId() { return id; }
    public long getIdParticipante() { return idParticipante; }
    public LocalDate getFecha() { return fecha; }
}
