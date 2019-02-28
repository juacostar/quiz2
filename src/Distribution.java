
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Estudiante
 */
public class Distribution extends Eslabon{
    
    private ArrayList<Producto> distribuidos;
    Manufacturer manufact;

    public Distribution(Manufacturer manufact, String nombre, String descripcion, Direccion direccion) {
        super(nombre, descripcion, direccion);
        this.distribuidos = new ArrayList<>();
        this.manufact = manufact;
    }
   

    public ArrayList<Producto> getDistribuidos() {
        return distribuidos;
    }

    public void setDistribuidos(ArrayList<Producto> distribuidos) {
        this.distribuidos = distribuidos;
    }

    public Manufacturer getManufact() {
        return manufact;
    }

    public void setManufact(Manufacturer manufact) {
        this.manufact = manufact;
    }

    @Override
    public void registrarProducto(String nombreProducto) {
        Producto p= new Producto(nombreProducto, 0.0, 0);
        this.distribuidos.add(p);
    }

   
    
    
    
}
