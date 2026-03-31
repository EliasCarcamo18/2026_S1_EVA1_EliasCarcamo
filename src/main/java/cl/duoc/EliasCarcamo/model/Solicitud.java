package cl.duoc.EliasCarcamo.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Solicitud {

    @NotNull(message = "El id no puede ser nulo")
    private Long id;

    @NotBlank(message = "El nombre del paciente no puede estar vacio")
    private String nombrePaciente;

    @NotBlank(message = "La especialidad no puede estar vacia")
    private String especialidad;

    @NotBlank(message = "El estado no puede estar vacio")
    private String estado;

    @NotNull(message = "La fecha de registro no puede ser nula")
    private LocalDateTime fechaRegistro;

    @NotBlank(message = "La prioridad no puede estar vacia")
    private String prioridad;
}
