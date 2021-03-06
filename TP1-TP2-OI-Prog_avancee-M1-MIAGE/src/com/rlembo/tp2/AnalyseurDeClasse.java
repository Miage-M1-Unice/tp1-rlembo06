package com.rlembo.tp2;

import com.sun.xml.internal.ws.spi.db.FieldSetter;
import java.lang.reflect.*;
import java.io.*;

public class AnalyseurDeClasse {

    public void analyseClasse(String nomClasse) throws ClassNotFoundException {
      // Récupération d'un objet de type Class correspondant au nom passé en paramètres
      Class cl = getClasse(nomClasse);
      
      System.out.print("\n");
      afficheEnTeteClasse(cl);
      System.out.print("\n");
      afficheAttributs(cl);
      System.out.print("\n");
      afficheConstructeurs(cl);
      System.out.print("\n");
      afficheMethodes(cl);
    }


    public static Class getClasse(String nomClasse) throws ClassNotFoundException {
        return Class.forName(nomClasse);
    }

    /** Cette méthode affiche par ex "public class Toto extends Tata implements Titi, Tutu {" */
    public void afficheEnTeteClasse(Class cl) {
        //  Affichage du modifier et du nom de la classe
        System.out.println("Modifiers: " + cl.getModifiers());
        System.out.println("Nom de la classe : " + cl.getName());

        // Récupération de la superclasse si elle existe (null si cl est le type Object)
        Class supercl = cl.getSuperclass();
        System.out.println("Nom de la super classe : " + getSuperclass(cl));

        // Affichage des interfaces que la classe implemente
        afficherInterfaces(cl);
    }
    
    public void afficherInterfaces(Class cl) {
        Class[]interfaces  = cl.getInterfaces();
        
        System.out.println("Interface(s) :");
        for (Class inter : interfaces) {
            System.out.println("-"+ inter.getName());
        }
    }
  
    public Class getSuperclass(Class cl) {
        Class supercl = cl.getSuperclass();
        if(supercl.getName() != "java.lang.Object") {
            return cl.getSuperclass();
        }
        return null;
    }

    public void afficheAttributs(Class cl) {
        Field[] attributs = cl.getFields();
      
        System.out.println("Attribut(s) :");
        for (Field attribut : attributs) {
            System.out.println("-"+ attribut.getName());
        }
    }

    public void afficheConstructeurs(Class cl) {
        Constructor[] constructors = cl.getConstructors();
        
        System.out.println("Constructeur(s) :");
        for (Constructor constructor : constructors) {
            System.out.println("-"+ constructor.getName());
        }
    }
    
    public void afficheMethodes(Class cl) {
        Method[] methods = cl.getMethods();
        
        System.out.println("Methode(s) :");
        for (Method method : methods) {
            System.out.println("-"+ method.getName());
        }
    }
    
    /*public void getRefFromField(Field field) {
        field.getType().
    }*/
  
}
