package com.railword;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    {
	 Configuration cfg=new Configuration(); 
	 cfg.configure("hibernate.cfg.xml");
     SessionFactory factory =cfg.buildSessionFactory();
    
   
   Session session = factory.openSession(); 
   Transaction t = session.beginTransaction();  
   StudentBean std=new StudentBean();
   
   std.setId(101);
   std.setName("railworld");
   std.setRollno(1); 
   
   System.out.println(std);
   
  
   session.save(std);
   t.commit();
   session.close();
   factory.close();
   System.out.println("saved the data");
   
   
   
 
       
       
	     
	        

      
    }
}