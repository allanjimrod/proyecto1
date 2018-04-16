package com.ucenfotec.ac.cr.proyecto1.entidades;

public class Cliente {
    private Integer id; // PK
    private String nombre;
    private String descripcion;
    private String razonSocial;
    private String cedulaJuridica;
    private String ubicacion;
    private String direccionExacta;
    private String logo;
    private String telefono;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getCedulaJuridica() {
        return cedulaJuridica;
    }

    public void setCedulaJuridica(String cedulaJuridica) {
        this.cedulaJuridica = cedulaJuridica;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getDireccionExacta() {
        return direccionExacta;
    }

    public void setDireccionExacta(String direccionExacta) {
        this.direccionExacta = direccionExacta;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", razonSocial='" + razonSocial + '\'' +
                ", cedulaJuridica='" + cedulaJuridica + '\'' +
                ", ubicacion='" + ubicacion + '\'' +
                ", direccionExacta='" + direccionExacta + '\'' +
                ", logo='" + logo + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}
