import modelo.Participante;
import modelo.Asistencia;
import servicio.ParticipanteServicio;
import servicio.AsistenciaServicio;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("===== SISTEMA DE GESTION - CENTRO CULTURAL =====");
        System.out.println("=== Trabajo realizado por Assael y Daniel ===\n");

        ParticipanteServicio participanteServicio = new ParticipanteServicio();
        AsistenciaServicio asistenciaServicio = new AsistenciaServicio();

        System.out.println("--- REGISTRAR PARTICIPANTES ---");
        
        try {
            Participante p1 = participanteServicio.registrar(
                "Maria Lopez", 
                "1001234567", 
                "maria@correo.com", 
                "3001234567"
            );
            System.out.println("Participante registrado: " + p1.getNombre() + " - ID: " + p1.getId());
        } catch (IllegalArgumentException e) {
            System.out.println("Error al registrar: " + e.getMessage());
        }

        try {
            Participante p2 = participanteServicio.registrar(
                "Juan Perez", 
                "1007654321", 
                "juan@correo.com", 
                "3109876543"
            );
            System.out.println("Participante registrado: " + p2.getNombre() + " - ID: " + p2.getId());
        } catch (IllegalArgumentException e) {
            System.out.println("Error al registrar: " + e.getMessage());
        }

        System.out.println("\n--- LISTA DE PARTICIPANTES ---");
        List<Participante> lista = participanteServicio.listarTodos();
        
        if (lista.isEmpty()) {
            System.out.println("No hay participantes registrados.");
        } else {
            for (Participante p : lista) {
                System.out.println("ID: " + p.getId() + 
                    " | Nombre: " + p.getNombre() + 
                    " | Documento: " + p.getDocumento() +
                    " | Correo: " + p.getCorreo());
            }
        }

        System.out.println("\n--- REGISTRAR ASISTENCIA ---");
        try {
            Participante p = participanteServicio.buscarPorDocumento("1001234567");
            if (p != null) {
                asistenciaServicio.registrarAsistencia(p.getId(), LocalDate.now());
                System.out.println("Asistencia registrada para: " + p.getNombre());
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\n========================================");
        System.out.println("SISTEMA CARGADO Y FUNCIONANDO");
        System.out.println("Realizado por Assael y Daniel");
        System.out.println("========================================");
    }
}
