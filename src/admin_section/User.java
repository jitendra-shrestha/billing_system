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
class User {
    private int u_id,status;
    private String firstname,lastname,address,email,phoneno,type,username,designation,shift;
    
    public User(int u_id, String firstname, String lastname, String address, String email, 
            String phoneno, String type, String username, String designation, 
            String shift, int status){
        this.u_id=u_id;
        this.firstname=firstname;
        this.lastname=lastname;
        this.address=address;
        this.email=email;
        this.phoneno=phoneno;
        this.type=type;
        this.username=username;
        this.designation=designation;
        this.shift=shift;  
        this.status=status;
    }
    
    public int getu_id(){
        return u_id;
    }
    
    public int getstatus(){
        return status;
    }
    
    public String getfirstname(){
        return firstname;
    }
    
    public String getlastname(){
        return lastname;
    }
    
    public String getaddress(){
        return address;
    }
    
    public String getemail(){
        return email;
    }
    
    public String getphoneno(){
        return phoneno;
    }
    
    public String gettype(){
        return type;
    }
    
    public String getusername(){
        return username;
    }
    
    public String getdesignation(){
        return designation;
    }
    
    public String getshift(){
        return shift;
    }
    
}
