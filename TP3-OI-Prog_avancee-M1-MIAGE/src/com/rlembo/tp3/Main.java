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
    
    public static void main(String[] args) throws MalformedURLException {
        URL[] urls = { 
            new URL("file://./src/com/rlembo/tp3/Test.java"),
        };
        URLClassLoader urlClassLoader = new URLClassLoader(urls);
        
        List<File> files = new ArrayList<File>();
        for (URL url : urlClassLoader.getURLs()) {
            files.add(new File(url.getFile()));
        }
        
        for (File file : files) {
            displayFieldsFromClassFile(file);
        }
        
        System.out.println("URLClassLoader: "+ urlClassLoader);
    }
    
    public static void displayFieldsFromClassFile(File file) {
        Class cl = file.getClass();
        Field[] fields = cl.getDeclaredFields();

        System.out.println("CLASSE : "+ cl.getName() + "\n");
        System.out.println("Fields : \n");
        for (Field field : fields) {
            System.out.println(field + "\r");
        }
    }
    
}
