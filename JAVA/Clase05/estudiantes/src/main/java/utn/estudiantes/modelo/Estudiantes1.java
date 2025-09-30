
package utn.estudiantes.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Estudiantes2025")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Estudiantes1 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estudiantes2025")   // coincide con la columna de la DB
    private Integer idEstudiante;

    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
}
