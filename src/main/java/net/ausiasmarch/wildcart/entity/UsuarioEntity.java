package net.ausiasmarch.wildcart.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
@JsonIgnoreProperties({"hibernateLazyInitialize", "handler"})
public class UsuarioEntity {

    @Schema(example = "3")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Schema(example = "55996633M")
    private String dni;
    @Schema(example = "Pedro")
    private String nombre;
    @Schema(example = "Pérez")
    private String apellido1;
    @Schema(example = "Gómez")
    private String apellido2;
    @Schema(example = "pepergom")
    private String login;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @Schema(example = "pepego@ausias.net")
    private String email;
    @Schema(example = "0")
    private int descuento;

    @JsonIgnore
    private String token;

    @Schema(example = "false")
    private boolean validado;
    @Schema(example = "false")
    private boolean activo;

    @Schema(example = "{\"id\": 1}")
    @ManyToOne
    @JoinColumn(name = "id_tipousuario")
    private TipousuarioEntity tipousuario;

    @Schema(hidden = true)
    @OneToMany(mappedBy = "usuario")
    private final List<CarritoEntity> carritos;

    @Schema(hidden = true)
    @OneToMany(mappedBy = "usuario")
    private final List<FacturaEntity> facturas;

    public UsuarioEntity() {
        this.facturas = new ArrayList<>();
        this.carritos = new ArrayList<>();
    }

    public UsuarioEntity(Long id) {
        this.facturas = new ArrayList<>();
        this.carritos = new ArrayList<>();
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public boolean isValidado() {
        return validado;
    }

    public void setValidado(boolean validado) {
        this.validado = validado;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public TipousuarioEntity getTipousuario() {
        return tipousuario;
    }

    public void setTipousuario(TipousuarioEntity tipousuario) {
        this.tipousuario = tipousuario;
    }

    public int getCarritos() {
        return carritos.size();
    }

    public int getFacturas() {
        return facturas.size();
    }

}
