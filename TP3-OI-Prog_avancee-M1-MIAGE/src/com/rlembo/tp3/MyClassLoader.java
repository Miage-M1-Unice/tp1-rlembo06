/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rlembo.tp3;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.security.SecureClassLoader;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author romain
 */
public class MyClassLoader extends SecureClassLoader {  
    private ArrayList<File> path = null;  
    
    public MyClassLoader(ArrayList<File> p) {  
      this.path = p;  
    }  
    
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] b = new byte[0];
        try {
            b = loadClassData(name);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return super.defineClass(name, b, 0, b.length);
    } 
    
    private byte[] loadClassData(String name) throws IOException {
        for (int i = 0; i < path.size(); i++) {
            String url = path.get(i).getAbsolutePath() + "/" + name.replace(".", "/") + ".class";
            System.out.println(url);
            File f = new File(url);

            if (f.exists()) {
                return Files.readAllBytes(f.toPath());
            }
        }
        return null;

    }
    
    public static void main(String[] args) {
        ArrayList<File> al = new ArrayList<File>();
        
        String urls [] = { "file:///home/romain/Documents/Cours/Cours-Master-MIAGE/Master-1/Semestre-2/UE-Composants_logiciels_Entreprise/Programmation_avancee/TP/TPs-OI-Prog_avancee-M1-MIAGE/annexes/build/classes/" };
        for (String url : urls) {
            File f = new File(url);

            if (f.isDirectory()) {
                al.add(new File(url));
            }
        }

        MyClassLoader myCL = new MyClassLoader(al);
        try {
            Class cl = myCL.loadClass("com.Test");

            for(Field f: cl.getDeclaredFields()) {
                System.out.println("- Field name : " + f.getName());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
  
}  