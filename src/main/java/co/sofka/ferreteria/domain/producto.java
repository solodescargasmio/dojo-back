package co.sofka.ferreteria.domain;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document(value = "producto")
public class producto {
    private String id= UUID.randomUUID().toString().substring(0, 15);
    private String nombre;
    private Long precio;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getPrecio() {
        return precio;
    }

    public void setPrecio(Long precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "producto{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                '}';
    }
}
