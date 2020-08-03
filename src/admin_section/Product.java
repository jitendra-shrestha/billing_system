/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin_section;

/**
 *
 * @author tjite
 */
class Product {
    private int p_id,c_id;
    private String name,price,stock,barcode,manufacturer;
    
    public Product(int p_id, String name, String price, String stock, String barcode, 
            String manufacturer, int c_id){
        this.p_id=p_id;
        this.name=name;
        this.price=price;
        this.stock=stock;
        this.barcode=barcode;
        this.manufacturer=manufacturer;
        this.c_id=c_id;
    }
    
    public int getp_id(){
        return p_id;
    }
    
    public String getname(){
        return name;
    }
    
    public String getprice(){
        return price;
    }
    
    public String getstock(){
        return stock;
    }
    
    public String getbarcode(){
        return barcode;
    }
    
    public String getmanufacturer(){
        return manufacturer;
    }
    
    public int getc_id(){
        return c_id;
    }
    
}
