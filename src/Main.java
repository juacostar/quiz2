
import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Estudiante
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Farmer> granjas=new ArrayList<>();
        ArrayList<Farmer> granjasProducto=new ArrayList<>();
        Manufacturer manufacturera=null;
        Distribution centro=null;
        Retail punto=null;
        ArrayList<ProductoVenta> inventario= new ArrayList<>();
        
        
        Cadena cadena= new Cadena(granjas, manufacturera, centro, punto);
        PrintStream output=new PrintStream(new File("datos/centro.txt"));
        Scanner x=new Scanner(System.in);
        int k=0;
        
        do{
            try{
                
            System.out.println("Bienvenido al centro de cadena, que desea hacer: ");
            System.out.println("1.Agregar granja");
            System.out.println("2.Asignar manufacturera ");
            System.out.println("3.Asignar centro de distribucion");
            System.out.println("4.Asignar punto de venta");
            System.out.println("5.Asignar producto");
            System.out.println("6.Solicitar producto");
            System.out.println("0.Salir");
            k=x.nextInt();
            switch(k){
                case 1:
                    System.out.println("Ingrese el nombre de la granja:");
                    String nombreg= x.next();
                    System.out.println("Ingrese la descripcion: ");
                    String descripciong= x.next();
                    System.out.println("Ingrese latitud: ");
                    int latitud= x.nextInt();
                    System.out.println("Ingrese longitud: ");
                    int longitud= x.nextInt();
                    System.out.println("Ingrese el numero de materias prima que produce");
                    int numMaterias= x.nextInt();
                    Direccion direccion= new Direccion(latitud, longitud);
                    Farmer granja= new Farmer(nombreg, descripciong, direccion);
                    cadena.addGranja(granja);
                    for(int i=0;i<numMaterias;i++){
                        System.out.println("Ingrese el nombre de la materia prima "+(i+1)+":");
                        String materiai= x.next();
                        granja.registrarProducto(materiai);
                        
                    }
                    System.out.println("Ingreso exitoso");
                    
                break;
                
                case 2:
                    System.out.println("Ingrese el nombre de la manufacturera: ");
                    String nombrem= x.next();
                    System.out.println("Ingrese la descripcion: ");
                    String descripcionm= x.next();
                    System.out.println("Ingrese latitud: ");
                    int latitudm= x.nextInt();
                    System.out.println("Ingrese longitud: ");
                    int longitudm= x.nextInt();
                    System.out.println("Ingrese el numero de granjas asociadas a la manufacturera: ");
                    int num=x.nextInt();
                    ArrayList<Farmer> granjasAsignadas= new ArrayList<>();
                    for(int i=0;i<num;i++){
                        System.out.println("Ingrese el nombre de la granja "+(i+1)+" a asignar: ");
                        String asignar=x.next();
                        for(int j=0;j<granjas.size();j++){
                            if(granjas.get(i).getNombre().equals(asignar)){
                                granjasAsignadas.add(granjas.get(i));
                            }else throw new NullPointerException("La granja no se encuentra");
                        }
                    }
                    Direccion direccionm= new Direccion(latitudm, longitudm);
                    manufacturera= new Manufacturer(granjasAsignadas ,nombrem, descripcionm, direccionm);
                    granjasProducto=granjasAsignadas;
                    System.out.println("Ingreso exitoso");
                break;
                
                case 3:
                    System.out.println("Ingrese el nombre del centro de distribucion: ");
                    String nombrec= x.next();
                    System.out.println("Ingrese la descripcion: ");
                    String descripcionc= x.next();
                    System.out.println("Ingrese latitud: ");
                    int latitudc= x.nextInt();
                    System.out.println("Ingrese longitud: ");
                    int longitudc= x.nextInt();
                    Direccion direccionc= new Direccion(latitudc, longitudc);
                    centro= new Distribution(manufacturera ,nombrec, descripcionc, direccionc);
                    System.out.println("Ingreso exitoso");
                    
                break;
                
                case 4:
                    System.out.println("Ingrese el nombre del punto de venta: ");
                    String nombrep= x.next();
                    System.out.println("Ingrese la descripcion: ");
                    String descripcionp= x.next();
                    System.out.println("Ingrese latitud: ");
                    int latitudp= x.nextInt();
                    System.out.println("Ingrese longitud: ");
                    int longitudp= x.nextInt();
                    Direccion direccionp= new Direccion(latitudp, longitudp);
                    System.out.println("Ingreso exitoso");
                    punto= new Retail(centro, nombrep, descripcionp, direccionp);
                    
                break;
                
                case 5:
                    System.out.println("Escriba el nombre del producto: ");
                    String nombreProducto= x.next();
                    System.out.println("Escriba el precio del producto: ");
                    double valor=x.nextDouble();
                    System.out.println("Escriba el codigo del producto");
                    int codigo=x.nextInt();
                    output.print(nombreProducto+":");
                    output.print(valor+":");
                    output.print(codigo);
                    output.println();
                    //Registro manufacturera
                    
                    Producto producto= new Producto(nombreProducto, valor, codigo);
                    System.out.println("Ingrese el numero de materias prima que se necesita para crear el producto: ");
                    int materias=x.nextInt();
                    output.print(materias+":");
                    System.out.println("Ingrese el numero de granjas donde se produjo la materia prima");
                    int numGranjas=x.nextInt();
                    for(int i=0;i<numGranjas;i++){
                        System.out.println("Ingrese el nombre de la granja "+(i+1)+": ");
                        String nombreGranja=x.next();
                        output.print(nombreGranja+":");
                        output.print("granja "+(i+1)+": ");
                        System.out.println("Ingrese el numero de materias prima que necesita de la granja "+(i+1)+(": "));
                        int numMaterias2=x.nextInt();
                        for(int j=0;j<numMaterias2;j++){
                            System.out.println("Ingrese el nombre de la materia prima "+(j+1)+": ");
                            String materiaPrima=x.next();
                            cadena.enviarMateria(manufacturera.buscarGranja(nombreGranja), materiaPrima, manufacturera);
                            output.print(materiaPrima+":");
                            
                        }
                        output.println();
                    }
                    
                    output.println();
                    
                       
                        
                    
                        output.println();
                        System.out.println("Ingrese el dia en que ingresaron las materias primas: ");
                        int dia=x.nextInt();
                        System.out.println("Ingrese el mes en que ingresaron las materias primas: ");
                        int mes=x.nextInt();
                        System.out.println("Ingrese el anio en que ingresaron las materias primas: ");
                        int anio=x.nextInt();
                        System.out.println("Ingrese la hora en que ingresaron las materias primas: ");
                        int hora=x.nextInt();
                        System.out.println("Ingrese el dia en que ingresaron las materias primas: ");
                        int minutos=x.nextInt();
                        output.print("Ingresaron las materias primas a la manufacturera  " + manufacturera.getNombre() + " en la fecha: " +dia+"/"+mes+"/"+anio+ " a las "+ hora+":"+minutos);
                        output.println();
                    //Registro centro de distribucion
                        if(centro==null) throw new NullPointerException("no se puede seguir, no existe el centro de distribucion");
                        System.out.println("");
                        System.out.println("Ingrese el dia en que ingreso el producto al centro de distribucion: ");
                        int dia2=x.nextInt();
                        System.out.println("Ingrese el mes en que ingreso el producto al centro de distribucion: ");
                        int mes2=x.nextInt();
                        System.out.println("Ingrese el anio en que ingreso el producto al centro de distribucion: ");
                        int anio2=x.nextInt();
                        System.out.println("Ingrese la hora en que ingreso el producto al centro de distribucion: ");
                        int hora2=x.nextInt();
                        System.out.println("Ingrese el dia en que ingreso el producto al centro de distribucion: ");
                        int minutos2=x.nextInt();
                        output.print("Ingresaron ingreso el producto al centro de distribucion " + centro.getNombre() + " en la fecha: " +dia2+"/"+mes2+"/"+anio2+ " a las "+ hora2+":"+minutos2 +" proveniente de la manufacturera"+ manufacturera.getNombre());
                        output.println();
                        
                    //registro al punto de venta
                        if(punto==null) throw new NullPointerException("no se puede seguir, no existe el punto de venta");
                        System.out.println("");
                        System.out.println("Ingrese el dia en que ingreso el producto al punto de venta: ");
                        int dia3=x.nextInt();
                        System.out.println("Ingrese el mes en que ingreso el producto al punto de venta: ");
                        int mes3=x.nextInt();
                        System.out.println("Ingrese el anio en que ingreso el producto al punto de venta: ");
                        int anio3=x.nextInt();
                        System.out.println("Ingrese la hora en que ingreso el producto al punto de venta: ");
                        int hora3=x.nextInt();
                        System.out.println("Ingrese el dia en que ingreso el producto al punto de venta: ");
                        int minutos3=x.nextInt();
                        output.print("Ingresaron las materias primas al punto de venta  " + punto.getNombre() + " en la fecha: " +dia3+"/"+mes3+"/"+anio3+ " a las "+ hora3+":"+minutos3 +" proveniente del centro de distribucion"+ centro.getNombre());
                        output.println();
                        
                        ProductoVenta pv=new ProductoVenta(granjasProducto, manufacturera, centro, punto, nombreProducto, valor, codigo);
                        inventario.add(pv);
                    //FALTA FECHA ok, MANUFACTURA CON FECHA ok, CENTRO CON FECHA ok Y PUNTO CON FECHA    ok
                break;
                
                case 6:
                    System.out.println("Ingrese el nombre del producto");
                    String nombreP=x.next();
                    for(int i=0;i<inventario.size();i++){
                        if(inventario.get(i).getNombre().equals(nombreP)){
                            System.out.println("Producto: "+nombreP);
                            System.out.println("Valor: "+inventario.get(i).getPrecio());
                            System.out.println("Codigo: "+inventario.get(i).getCodigo());
                            System.out.println("Granjas de donde proviene materia prima: ");
                            for(int j=0;j<inventario.get(i).getGranjas().size();j++){
                                System.out.println(inventario.get(j).getGranjas().get(j).getNombre());
                                System.out.println("Descripcion: "+ inventario.get(j).getGranjas().get(j).getDescripcion());
                                System.out.println("Direccion: latitud "+inventario.get(j).getGranjas().get(j).getDireccion().getLatitud()+", longitud: "+inventario.get(i).getGranjas().get(j).getDireccion().getLongitud());
                                
                            }
                            System.out.println("Nombre centro de distribucion al que fue dirigido: "+inventario.get(i).getCentro().getNombre());
                            System.out.println("Descripcion centro de distribucion: "+inventario.get(i).getCentro().getDescripcion());
                            System.out.println("Direccion centro de distribucion: latitud "+inventario.get(i).getCentro().getDireccion().getLatitud()+", longitud "+inventario.get(i).getCentro().getDireccion().getLongitud());
                            System.out.println("Nombre del punto de venta al que fue dirigido: "+inventario.get(i).getPunto().getNombre());
                            System.out.println("Descripcion punto de venta: "+inventario.get(i).getPunto().getDescripcion());
                            System.out.println("Direccion punto de venta: latitud "+inventario.get(i).getPunto().getDireccion().getLatitud() +", longitud "+inventario.get(i).getPunto().getDireccion().getLongitud());
                            System.out.println();
                        }
                    }
                break;
            }
                
                
                }catch(NullPointerException e){
                    System.out.println(e.getMessage());
            
                }
                
            
            }while(k!=0);
    
        }
        
    
    
}
    

