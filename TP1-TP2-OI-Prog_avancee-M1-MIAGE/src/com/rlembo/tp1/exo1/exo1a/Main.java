/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rlembo.tp1.exo1.exo1a;

import java.io.File;
import java.io.FilenameFilter;

/**
 *
 * @author romain
 */
public class Main {
        
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Directory dir = new Directory("./");
        
        // Exercice 1.A.1 :
        System.out.println("1.A.1) list : ");
        for (String item : dir.getContentDir()) {
            System.out.println(item);
        }
        
        // Exercice 1.A.2 :
        System.out.println("1.A.2) list Files : ");
        for(File path:dir.getContentListFiles()) {
            System.out.println(path);
        }
        
        // Exercice 1.A.3 :
        Filter filter = new Filter(dir.getDir(), dir.getPath(), "test");
        System.out.println("1.A.3) list with filter - classe indépendante : ");
        for(File path:dir.getContentListFilesWithFilter(filter)) {
            System.out.println(path);
        }
        
        System.out.println("1.A.3) list with filter - anonyme : ");
        String[] list = dir.getDir().list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.contains("test");
            }
        });
        for (String item : list) {
            System.out.println(item);
        }
    }
}
