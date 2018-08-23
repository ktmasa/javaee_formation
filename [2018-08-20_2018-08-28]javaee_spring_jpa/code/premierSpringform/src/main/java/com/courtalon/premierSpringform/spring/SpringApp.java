package com.courtalon.premierSpringform.spring;

import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.courtalon.premierSpringform.beans.Chevalier;
import com.courtalon.premierSpringform.beans.IChevalier;
import com.courtalon.premierSpringform.beans.Message;

public class SpringApp {

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		
        Scanner input = new Scanner(System.in);
        

        input.nextLine();
        System.out.println("--------------------------------------");
 
        // spring me fournit l'objet perceval "pret à l'emploi"
        // c.a.d avec ses dépendances satisfaites
        IChevalier c1 = ctx.getBean("perceval", IChevalier.class);
        
        c1.partirEnQuete();
        
        IChevalier c2 = ctx.getBean("caradoc", IChevalier.class);
        
        c2.partirEnQuete();
        
       input.nextLine();
		System.out.println("--------------------------------------");

		System.out.println("done...");
	}





}
