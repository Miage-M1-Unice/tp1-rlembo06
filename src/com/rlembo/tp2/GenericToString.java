/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rlembo.tp2;

/**
 *
 * @author romain
 */
public class GenericToString {
    
    public String toString(Object obj) throws ClassNotFoundException {
        Class cl = obj.getClass();
        
        AnalyseurDeClasse analyseur = new AnalyseurDeClasse();
        analyseur.analyseClasse(cl.getName());
        
        System.out.print("\n");
        analyseur.afficheEnTeteClasse(cl);
        System.out.print("\n");
        analyseur.afficheConstructeurs(cl);
        System.out.print("\n");
        analyseur.afficheAttributs(cl);
        System.out.print("\n");
        analyseur.afficheMethodes(cl);
        
        return "test";
    } 
}
