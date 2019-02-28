
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
public class Cadena {
    private ArrayList<Farmer> granjas;
    private Manufacturer manufacturera;
    private Distribution centro;
    private Retail punto;

    public Cadena(ArrayList<Farmer> granjas, Manufacturer manufacturera, Distribution centros, Retail punto) {
        this.granjas = granjas;
        this.manufacturera = manufacturera;
        this.centro = centro;
        this.punto = punto;
    }
    
    public void addGranja(Farmer granja){
        this.granjas.add(granja);
    }
    
   
    
    public void AsignarGranja(Farmer granja, Manufacturer manufacturera){
        if(manufacturera==null) throw new NullPointerException("No se encuentra la manufacturera");
        manufacturera.getGranjas().add(granja);
    }
    
   
    
    
    public void enviarMateria(Farmer granja,String nombreProducto,Manufacturer manufacturera ){
        Producto p=null;
        for(int i=0;i<granja.getMaterias().size();i++){
            if(granja.getMaterias().get(i).getNombre().equals(nombreProducto)){
                p=granja.getMaterias().get(i);
            }
        }
        if(p==null) throw new NullPointerException("El producto no se encuentra");
        manufacturera.registrarProducto(p.getNombre());
        
    }
    
    
    
    
    
    
  
}

   
    

