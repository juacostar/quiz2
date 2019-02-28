/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Estudiante
 */
public abstract class Eslabon {
    private String nombre;
    private String descripcion;
    private Direccion direccion;
    

    public Eslabon(String nombre, String descripcion, Direccion direccion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.direccion = direccion;
        
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

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }
    
    public abstract void registrarProducto(String nombreProducto);
    
}

   
    
    
    
    

   
    
    
   
