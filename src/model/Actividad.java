package model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Actividad {
    private Long id;
    private String nombre;
    private String tipo;
    private LocalDate fecha;
    private LocalTime hora;
    private Long idEspacio;
    private Long idInstructor;

    public Actividad() {}

    public Actividad(Long id, String nombre, String tipo, LocalDate fecha, LocalTime hora, Long idEspacio, Long idInstructor) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.fecha = fecha;
        this.hora = hora;
        this.idEspacio = idEspacio;
        this.idInstructor = idInstructor;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }
    public LocalTime getHora() { return hora; }
    public void setHora(LocalTime hora) { this.hora = hora; }
    public Long getIdEspacio() { return idEspacio; }
    public void setIdEspacio(Long idEspacio) { this.idEspacio = idEspacio; }
    public Long getIdInstructor() { return idInstructor; }
    public void setIdInstructor(Long idInstructor) { this.idInstructor = idInstructor; }
}
