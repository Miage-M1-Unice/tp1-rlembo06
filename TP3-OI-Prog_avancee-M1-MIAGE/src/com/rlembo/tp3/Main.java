/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rlembo.tp3;

import java.io.File;
import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author romain
 */
public class Main {
    
    
    public static void main(String args[]) throws MalformedURLException, ClassNotFoundException {
        URL classUrl = new URL("file:///home/romain/Documents/Cours/Cours-Master-MIAGE/Master-1/Semestre-2/UE-Composants_logiciels_Entreprise/Programmation_avancee/TP/TPs-OI-Prog_avancee-M1-MIAGE/annexes/build/classes/");
        
        URL[] urls = { classUrl };

        URLClassLoader ucl = new URLClassLoader(urls);

        displayFieldsFromClass(ucl.loadClass("Test"));
    }
    
    public static void displayFieldsFromClass(Class cl) {
        System.out.println("CLASSE : "+ cl.getName() + "\n");
        for(Field f: cl.getDeclaredFields()) {
            System.out.println("- Field name : " + f.getName());
        }
    }
    
}
