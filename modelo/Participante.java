package modelo;

public class Participante {
    private long id;
    private String nombre;
    private String documento;
    private String correo;
    private String telefono;
    private static long contador = 1;

    public Participante(String nombre, String documento, String correo, String telefono) {
        this.id = contador++;
        this.nombre = nombre;
        this.documento = documento;
        this.correo = correo;
        this.telefono = telefono;
    }

    public long getId() { return id; }
    public String getNombre() { return nombre; }
    public String getDocumento() { return documento; }
    public String getCorreo() { return correo; }
    public String getTelefono() { return telefono; }
}
