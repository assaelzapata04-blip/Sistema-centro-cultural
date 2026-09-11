package model;

import java.time.LocalDate;

public class Asistencia {
    private Long id;
    private Long idParticipante;
    private Long idActividad;
    private LocalDate fecha;
    private boolean presente;

    public Asistencia() {}

    public Asistencia(Long id, Long idParticipante, Long idActividad, LocalDate fecha, boolean presente) {
        this.id = id;
        this.idParticipante = idParticipante;
        this.idActividad = idActividad;
        this.fecha = fecha;
        this.presente = presente;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getIdParticipante() { return idParticipante; }
    public void setIdParticipante(Long idParticipante) { this.idParticipante = idParticipante; }
    public Long getIdActividad() { return idActividad; }
    public void setIdActividad(Long idActividad) { this.idActividad = idActividad; }
    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }
    public boolean isPresente() { return presente; }
    public void setPresente(boolean presente) { this.presente = presente; }
}