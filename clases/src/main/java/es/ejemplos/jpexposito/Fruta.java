package es.ejemplos.jpexposito;

import java.util.Objects;

public class Fruta {
    float peso;
    String color;
    float precio;
    String nombre;

    public Fruta() {}

    public Fruta(float precio,String color, float peso)  {
        this.color = color;
        this.precio = precio;
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "Nombre:" +this.nombre+", Color:"+this.color+
        ", Peso:"+this.peso+", Precio:"+this.precio;
    }


    public float getPeso() {
        return this.peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public float getPrecio() {
        return this.precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
