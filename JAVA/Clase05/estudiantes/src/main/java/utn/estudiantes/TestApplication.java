package utn.estudiantes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import utn.estudiantes.modelo.Estudiantes1;
import utn.estudiantes.servicio.EstudianteServicio;

import java.util.List;

@SpringBootApplication
public class TestApplication implements CommandLineRunner {

    @Autowired
    private EstudianteServicio estudianteServicio;

    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("\n========================================");
        System.out.println("PRUEBA DE CONEXIÓN A BASE DE DATOS");
        System.out.println("========================================\n");

        try {
            // Listar todos los estudiantes
            System.out.println("Listando estudiantes en la base de datos:");
            System.out.println("------------------------------------------");
            List<Estudiantes1> estudiantes = estudianteServicio.listarEstudiantes();

            if (estudiantes.isEmpty()) {
                System.out.println("No hay estudiantes en la base de datos.");
            } else {
                System.out.println("Se encontraron " + estudiantes.size() + " estudiantes:\n");
                for (Estudiantes1 estudiante : estudiantes) {
                    System.out.println("ID: " + estudiante.getIdEstudiante());
                    System.out.println("Nombre: " + estudiante.getNombre());
                    System.out.println("Apellido: " + estudiante.getApellido());
                    System.out.println("Teléfono: " + estudiante.getTelefono());
                    System.out.println("Email: " + estudiante.getEmail());
                    System.out.println("------------------------------------------");
                }
            }

            System.out.println("\n✅ CONEXIÓN EXITOSA - La aplicación funciona correctamente!");
            System.out.println("✅ La base de datos PostgreSQL está conectada!");

        } catch (Exception e) {
            System.err.println("❌ ERROR: " + e.getMessage());
            e.printStackTrace();
        }

        System.out.println("\n========================================");
        System.out.println("FIN DE LA PRUEBA");
        System.out.println("========================================\n");
    }
}