/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasesSecundarias;

/**
 *
 * @author PC
 */
public class Material {

    private String nombre, descripcion, id;
    private float precioC;

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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPrecioC() {
        return precioC;
    }

    public void setPrecioC(float precioC) {
        this.precioC = precioC;
    }

    @Override
    public String toString() {
        return nombre + " " + descripcion;
    }
}
