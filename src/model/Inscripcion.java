package model;

import java.time.LocalDate;

public class Inscripcion {
    private Long id;
    private Long idParticipante;
    private Long idActividad;
    private LocalDate fechaInscripcion;

    public Inscripcion() {}

    public Inscripcion(Long id, Long idParticipante, Long idActividad, LocalDate fechaInscripcion) {
        this.id = id;
        this.idParticipante = idParticipante;
        this.idActividad = idActividad;
        this.fechaInscripcion = fechaInscripcion;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getIdParticipante() { return idParticipante; }
    public void setIdParticipante(Long idParticipante) { this.idParticipante = idParticipante; }
    public Long getIdActividad() { return idActividad; }
    public void setIdActividad(Long idActividad) { this.idActividad = idActividad; }
    public LocalDate getFechaInscripcion() { return fechaInscripcion; }
    public void setFechaInscripcion(LocalDate fechaInscripcion) { this.fechaInscripcion = fechaInscripcion; }
}
