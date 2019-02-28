
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
public class Retail extends Eslabon{
    private ArrayList<Producto> ventas;
    private Distribution centroD;

    public Retail(Distribution centroD, String nombre, String descripcion, Direccion direccion) {
        super(nombre, descripcion, direccion);
        this.ventas = new ArrayList<>();
        this.centroD = centroD;
    }
    
    public void ponerPrecio(double valor,String nombreProducto){
        for(int i=0;i<this.ventas.size();i++){
            if(this.ventas.get(i).getNombre().equals(nombreProducto)) this.ventas.get(i).setPrecio(valor);
            
        }
    }

    public ArrayList<Producto> getVentas() {
        return ventas;
    }

    public void setVentas(ArrayList<Producto> ventas) {
        this.ventas = ventas;
    }

    public Distribution getCentroD() {
        return centroD;
    }

    public void setCentroD(Distribution centroD) {
        this.centroD = centroD;
    }

    @Override
    public void registrarProducto(String nombreProducto) {
        Producto p= new Producto(nombreProducto, 0.0, 0);
        this.ventas.add(p);
    }

   
    
    
}
