import model.Participante;
import model.Asistencia;
import service.ParticipanteService;
import service.AsistenciaService;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("===== SISTEMA DE GESTIÓN - CENTRO CULTURAL =====");

        ParticipanteService participanteService = new ParticipanteService();
        AsistenciaService asistenciaService = new AsistenciaService();

        System.out.println("\n--- REGISTRAR PARTICIPANTES ---");
        try {
            Participante p1 = participanteService.registrar("María López", "1001234567", "maria@correo.com", "3001234567");
            System.out.println("Participante registrado: " + p1.getNombre() + " - ID: " + p1.getId());

            Participante p2 = participanteService.registrar("Juan Pérez", "1007654321", "juan@correo.com", "3107654321");
            System.out.println("Participante registrado: " + p2.getNombre() + " - ID: " + p2.getId());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\n--- LISTAR TODOS LOS PARTICIPANTES ---");
        List<Participante> lista = participanteService.listarTodos();
        for (Participante p : lista) {
            System.out.println("ID: " + p.getId() + " | Nombre: " + p.getNombre() + " | Documento: " + p.getDocumento());
        }

        System.out.println("\n--- REGISTRAR ASISTENCIA ---");
        try {
            Asistencia a1 = asistenciaService.registrar(1L, 1L, LocalDate.now(), true);
            System.out.println("Asistencia registrada - Participante 1 - Presente: " + a1.isPresente());

            Asistencia a2 = asistenciaService.registrar(2L, 1L, LocalDate.now(), false);
            System.out.println("Asistencia registrada - Participante 2 - Presente: " + a2.isPresente());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\n--- LISTAR ASISTENCIAS POR ACTIVIDAD ---");
        List<Asistencia> asistencias = asistenciaService.listarPorActividad(1L);
        for (Asistencia a : asistencias) {
            System.out.println("Participante ID: " + a.getIdParticipante() + " | Fecha: " + a.getFecha() + " | Presente: " + a.isPresente());
        }

        System.out.println("\n===== FIN DE PRUEBAS =====");
    }
}