/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nexus.demo.DTOS.RESPONSE.USUARIO;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

/**
 *
 * @author luis
 */
public class UsuarioDtoReq {

    @Schema(
            description = "Primer nombre del usuario",
            example = "Luis",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @NotBlank(message = "El primer nombre es obligatorio")
    @Size(min = 2, max = 50, message = "El primer nombre debe tener entre 2 y 50 caracteres")
    @Pattern(
            regexp = "^[a-zA-ZáéíóúÁÉÍÓÚñÑüÜ ]+$",
            message = "El primer nombre solo puede contener letras y espacios"
    )
    private String primerNombre;

    @Schema(
            description = "Segundo nombre del usuario",
            example = "Fernando",
            requiredMode = Schema.RequiredMode.NOT_REQUIRED
    )
    @Size(max = 50, message = "El segundo nombre no puede superar los 50 caracteres")
    @Pattern(
            regexp = "^[a-zA-ZáéíóúÁÉÍÓÚñÑüÜ ]+$",
            message = "El segundo nombre solo puede contener letras y espacios"
    )
    private String segundoNombre;

    @Schema(
            description = "Correo electrónico del usuario",
            example = "luis@gmail.com",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @NotBlank(message = "El correo electrónico es obligatorio")
    @Email(message = "El correo electrónico no tiene un formato válido")
    @Size(max = 100, message = "El correo electrónico no puede superar los 100 caracteres")
    private String email;

    @Schema(
            description = "Apellido paterno del usuario",
            example = "Yepes",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @NotBlank(message = "El apellido paterno es obligatorio")
    @Size(min = 2, max = 50, message = "El apellido paterno debe tener entre 2 y 50 caracteres")
    @Pattern(
            regexp = "^[a-zA-ZáéíóúÁÉÍÓÚñÑüÜ ]+$",
            message = "El apellido paterno solo puede contener letras y espacios"
    )
    private String apellidoPaterno;

    @Schema(
            description = "Apellido materno del usuario",
            example = "Meléndez",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @NotBlank(message = "El apellido materno es obligatorio")
    @Size(min = 2, max = 50, message = "El apellido materno debe tener entre 2 y 50 caracteres")
    @Pattern(
            regexp = "^[a-zA-ZáéíóúÁÉÍÓÚñÑüÜ ]+$",
            message = "El apellido materno solo puede contener letras y espacios"
    )
    private String apellidoMaterno;

    @Schema(
            description = "Identificador del rol del usuario",
            example = "2",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @NotNull(message = "El rol es obligatorio")
    private Long id_rol;

    @Schema(
            description = "Identificador del tipo de documento",
            example = "1",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @NotNull(message = "El tipo de documento es obligatorio")
    private Long id_tipo_doc;

    @Schema(
            description = "Contraseña del usuario",
            example = "Luis1234@",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @NotBlank(message = "La contraseña es obligatoria")
    @Size(min = 8, max = 100, message = "La contraseña debe tener entre 8 y 100 caracteres")
    @Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]+$",
            message = "La contraseña debe contener al menos una mayúscula, una minúscula, un número y un carácter especial"
    )
    private String contrasenia;

    @Schema(
            description = "Número de documento del usuario",
            example = "1001234567",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @NotBlank(message = "El número de documento es obligatorio")
    @Size(min = 5, max = 20, message = "El número de documento debe tener entre 5 y 20 caracteres")
    @Pattern(
            regexp = "^[0-9]+$",
            message = "El número de documento solo puede contener números"
    )
    private String numDocumento;

    @Schema(
            description = "Número telefónico del usuario",
            example = "3001234567",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @NotBlank(message = "El teléfono es obligatorio")
    @Pattern(
            regexp = "^3[0-9]{9}$",
            message = "El teléfono debe ser un número celular colombiano válido de 10 dígitos"
    )
    private String telefono;

    public UsuarioDtoReq(String primerNombre, String segundoNombre, String email, String apellidoPaterno, String apellidoMaterno, Long id_rol, Long id_tipo_doc, String contrasenia, String numDocumento, String telefono) {
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.email = email;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.id_rol = id_rol;
        this.id_tipo_doc = id_tipo_doc;
        this.contrasenia = contrasenia;
        this.numDocumento = numDocumento;
        this.telefono = telefono;
    }

    public UsuarioDtoReq() {
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public Long getId_rol() {
        return id_rol;
    }

    public void setId_rol(Long id_rol) {
        this.id_rol = id_rol;
    }

    public Long getId_tipo_doc() {
        return id_tipo_doc;
    }

    public void setId_tipo_doc(Long id_tipo_doc) {
        this.id_tipo_doc = id_tipo_doc;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getNumDocumento() {
        return numDocumento;
    }

    public void setNumDocumento(String numDocumento) {
        this.numDocumento = numDocumento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

}
