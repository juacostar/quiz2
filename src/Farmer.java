
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ADMIN
 */
public class Farmer extends Eslabon{
    private ArrayList<Producto> materias;

    public Farmer(String nombre, String descripcion, Direccion direccion) {
        super(nombre, descripcion, direccion);
        this.materias = new ArrayList<>();
    }

    public ArrayList<Producto> getMaterias() {
        return materias;
    }

    public void setMaterias(ArrayList<Producto> materias) {
        this.materias = materias;
    }

    @Override
    public void registrarProducto(String nombreProducto) {
        Producto p=new Producto(nombreProducto, 0.0, 0);
        this.materias.add(p);
    }
    
    
   
}
