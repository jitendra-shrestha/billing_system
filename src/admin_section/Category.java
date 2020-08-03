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
class Category {
    private int c_id;
    private String name,discount;
    
    public Category(int c_id, String name, String discount){
        this.c_id=c_id;
        this.name=name;
        this.discount=discount;
    }
    
    public int getc_id(){
        return c_id;
    }
    
    public String getname(){
        return name;
    }
    
    public String getdiscount(){
        return discount;
    }
}
