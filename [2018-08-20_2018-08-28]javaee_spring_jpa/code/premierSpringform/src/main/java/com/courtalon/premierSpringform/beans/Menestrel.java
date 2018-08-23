package com.courtalon.premierSpringform.beans;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class Menestrel implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation mi) throws Throwable {
		//System.out.println("appel du menestrel");
		// quel est le chevalier appelant
		Chevalier c= (Chevalier)mi.getThis();
		System.out.println("tralala, " + c.getNom() + " part en quete");
		return mi.proceed(); // appel de la méthode originale
	}

}
