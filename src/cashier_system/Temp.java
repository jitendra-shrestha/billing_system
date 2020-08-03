/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cashier_system;

/**
 *
 * @author tjite
 */
class Temp {
    private int temp_id;
    private String name,rate,quantity,category,barcode;
    private Double amount,discount;
    
    public Temp(int temp_id, String name, String rate,String category,String barcode, String quantity, Double amount,Double discount){
        this.temp_id=temp_id;
        this.name=name;
        this.rate=rate;
        this.category=category;
        this.barcode=barcode;
        this.quantity=quantity;
        this.amount=amount;
        this.discount=discount;
    }
    
    public int gettemp_id(){
        return temp_id;
    }
    
    public String getname(){
        return name;
    }
    
    public String getrate(){
        return rate;
    }
    public String getcategory(){
        return category;
    }
    
     public String getbarcode(){
        return barcode;
    }
     
    public String getquantity(){
        return quantity;
    }
    
    public Double getamount(){
        return amount;
    }
    
    public Double getdiscount(){
        return discount;
    }
    
}
