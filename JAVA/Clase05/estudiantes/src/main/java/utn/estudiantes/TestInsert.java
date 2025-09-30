package utn.estudiantes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import utn.estudiantes.modelo.Estudiantes1;
import utn.estudiantes.servicio.EstudianteServicio;

import java.util.List;

@SpringBootApplication
public class TestInsert implements CommandLineRunner {

    @Autowired
    private EstudianteServicio estudianteServicio;

    public static void main(String[] args) {
        SpringApplication.run(TestInsert.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("\n========================================");
        System.out.println("PRUEBA DE INSERCIÓN EN BASE DE DATOS");
        System.out.println("========================================\n");

        try {
            // Contar estudiantes antes
            List<Estudiantes1> estudiantesAntes = estudianteServicio.listarEstudiantes();
            System.out.println("Estudiantes antes: " + estudiantesAntes.size());

            // Crear nuevo estudiante
            System.out.println("\nCreando nuevo estudiante...");
            Estudiantes1 nuevoEstudiante = new Estudiantes1();
            nuevoEstudiante.setNombre("Test");
            nuevoEstudiante.setApellido("Prueba");
            nuevoEstudiante.setTelefono("1234567890");
            nuevoEstudiante.setEmail("test@prueba.com");

            // Guardar estudiante
            System.out.println("Guardando estudiante...");
            estudianteServicio.guardarEstudiante(nuevoEstudiante);
            System.out.println("✅ Estudiante guardado!");

            // Contar estudiantes después
            List<Estudiantes1> estudiantesDespues = estudianteServicio.listarEstudiantes();
            System.out.println("\nEstudiantes después: " + estudiantesDespues.size());

            // Mostrar todos los estudiantes
            System.out.println("\nLista completa de estudiantes:");
            System.out.println("------------------------------------------");
            for (Estudiantes1 est : estudiantesDespues) {
                System.out.println("ID: " + est.getIdEstudiante() +
                                 " | Nombre: " + est.getNombre() +
                                 " | Apellido: " + est.getApellido());
            }

            System.out.println("\n✅ INSERCIÓN EXITOSA!");

        } catch (Exception e) {
            System.err.println("❌ ERROR AL INSERTAR: " + e.getMessage());
            e.printStackTrace();
        }

        System.out.println("\n========================================");
        System.out.println("FIN DE LA PRUEBA");
        System.out.println("========================================\n");
    }
}