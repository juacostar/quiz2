
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
public class Manufacturer extends Eslabon{
    private ArrayList<Producto> productos;
    private ArrayList<Farmer> granjas;

    public Manufacturer( ArrayList<Farmer> granjas, String nombre, String descripcion, Direccion direccion) {
        super(nombre, descripcion, direccion);
        this.productos = new ArrayList<>();
        this.granjas = granjas;
    }


    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }

    public ArrayList<Farmer> getGranjas() {
        return granjas;
    }

    public void setGranjas(ArrayList<Farmer> granjas) {
        this.granjas = granjas;
    }
    
    
    public Farmer buscarGranja(String nombreGranja){
        Farmer f= null;
        for(int i=0;i<this.granjas.size();i++){
            if(this.granjas.get(i).getNombre().equals(nombreGranja)) f=this.granjas.get(i);
        }
        
        if(f==null) throw new NullPointerException("Granja no encontrada");
        return f;
    }

    @Override
    public void registrarProducto(String nombreProducto) {
        Producto p=new Producto(nombreProducto, 0.0, 0);
        this.productos.add(p);
    }
    
   
    
    
}
