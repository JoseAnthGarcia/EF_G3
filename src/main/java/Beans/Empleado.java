package Beans;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Empleado {
    private int idEmpleado;
    private String nombre;
    private String apellido;
    private String dni;
    private BigDecimal salario;
    private String fechaContrato;
    private String nombreUsuario;
    private int edad;
    private boolean activo;
    private Cine cine;
    private Empleado jefe;
    private ArrayList<Rol> roles;

    /**
     * @return the idEmpleado
     */
    public int getIdEmpleado() {
        return idEmpleado;
    }

    /**
     * @param idEmpleado the idEmpleado to set
     */
    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * @return the dni
     */
    public String getDni() {
        return dni;
    }

    /**
     * @param dni the dni to set
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * @return the salario
     */
    public BigDecimal getSalario() {
        return salario;
    }

    /**
     * @param salario the salario to set
     */
    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    /**
     * @return the fechaContrato
     */
    public String getFechaContrato() {
        return fechaContrato;
    }

    /**
     * @param fechaContrato the fechaContrato to set
     */
    public void setFechaContrato(String fechaContrato) {
        this.fechaContrato = fechaContrato;
    }

    /**
     * @return the nombreUsuario
     */
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    /**
     * @param nombreUsuario the nombreUsuario to set
     */
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    /**
     * @return the edad
     */
    public int getEdad() {
        return edad;
    }

    /**
     * @param edad the edad to set
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * @return the activo
     */
    public boolean isActivo() {
        return activo;
    }

    /**
     * @param activo the activo to set
     */
    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    /**
     * @return the cine
     */
    public Cine getCine() {
        return cine;
    }

    /**
     * @param cine the cine to set
     */
    public void setCine(Cine cine) {
        this.cine = cine;
    }

    /**
     * @return the jefe
     */
    public Empleado getJefe() {
        return jefe;
    }

    /**
     * @param jefe the jefe to set
     */
    public void setJefe(Empleado jefe) {
        this.jefe = jefe;
    }

    /**
     * @return the roles
     */
    public ArrayList<Rol> getRoles() {
        return roles;
    }

    /**
     * @param roles the roles to set
     */
    public void setRoles(ArrayList<Rol> roles) {
        this.roles = roles;
    }
}
