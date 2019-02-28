
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
public class ProductoVenta extends Producto{
    private ArrayList<Farmer> granjas;
    private Manufacturer manufacturera;
    private Distribution centro;
    private Retail punto;

    public ProductoVenta(ArrayList<Farmer> granjas, Manufacturer manufacturera, Distribution centro, Retail punto, String nombre, Double precio, int codigo) {
        super(nombre, precio, codigo);
        this.granjas = granjas;
        this.manufacturera = manufacturera;
        this.centro = centro;
        this.punto = punto;
    }

    public ArrayList<Farmer> getGranjas() {
        return granjas;
    }

    public void setGranjas(ArrayList<Farmer> granjas) {
        this.granjas = granjas;
    }

    public Manufacturer getManufacturera() {
        return manufacturera;
    }

    public void setManufacturera(Manufacturer manufacturera) {
        this.manufacturera = manufacturera;
    }

    public Distribution getCentro() {
        return centro;
    }

    public void setCentro(Distribution centro) {
        this.centro = centro;
    }

    public Retail getPunto() {
        return punto;
    }

    public void setPunto(Retail punto) {
        this.punto = punto;
    }

    
    
}
