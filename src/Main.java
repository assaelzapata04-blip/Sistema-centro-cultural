import model.Instructor;
import model.Espacio;
import model.Actividad;
import model.Inscripcion;
import service.InstructorService;
import service.EspacioService;
import service.ActividadService;
import service.InscripcionService;
import java.time.LocalDate;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        System.out.println("===== PRUEBA PARTE DE DANIEL =====");

        InstructorService instructorService = new InstructorService();
        EspacioService espacioService = new EspacioService();
        ActividadService actividadService = new ActividadService();
        InscripcionService inscripcionService = new InscripcionService();

        System.out.println("\n--- REGISTRAR INSTRUCTOR ---");
        Instructor profe = instructorService.registrar("Carlos Pérez", "Programación", "carlos@correo.com");
        System.out.println("✅ Instructor registrado: ID " + profe.getId() + " - " + profe.getNombre());

        System.out.println("\n--- REGISTRAR ESPACIO ---");
        Espacio salon = espacioService.registrar("Salón A-101", 40, "Edificio Principal, Piso 1");
        System.out.println("✅ Espacio registrado: ID " + salon.getId() + " - " + salon.getNombre());

        System.out.println("\n--- REGISTRAR ACTIVIDAD ---");
        Actividad taller = actividadService.registrar(
            "Introducción a Java",
            "taller",
            LocalDate.now().plusWeeks(2),
            LocalTime.of(14, 0),
            salon.getId(),
            profe.getId()
        );
        System.out.println("✅ Actividad registrada: ID " + taller.getId() + " - " + taller.getNombre());

        System.out.println("\n--- REGISTRAR INSCRIPCIÓN ---");
        Inscripcion insc = inscripcionService.registrar(1L, taller.getId());
        System.out.println("✅ Inscripción registrada: ID " + insc.getId() + " - Participante " + insc.getIdParticipante());

        System.out.println("\n=== LISTADO TOTAL ===");
        System.out.println("Instructores: " + instructorService.listarTodos().size());
        System.out.println("Espacios: " + espacioService.listarTodos().size());
        System.out.println("Actividades: " + actividadService.listarTodos().size());
        System.out.println("Inscripciones: " + inscripcionService.listarTodos().size());

        System.out.println("\n✅ TODAS LAS PRUEBAS DE DANIEL FINALIZADAS CON ÉXITO");
    }
}
