/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rlembo.tp3;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 *
 * @author romain
 */
public class Main {
    
    public static void main(String[] args) throws MalformedURLException {
        URL[] urls = { 
            new URL("~/Documents/Cours/Cours-Master-MIAGE/Master-1/Semestre-2/UE-Composants_logiciels_Entreprise/Programmation_avancee/TP/TP1-OI-Prog_avancee-M1-MIAGE/src/com/rlembo/tp3/Test.java") 
        };
        URLClassLoader urlClassLoader = new URLClassLoader(urls);
        
        // Exception in thread "main" java.net.MalformedURLException
        System.out.println("URLClassLoader: "+ urlClassLoader);
    }
    
}
