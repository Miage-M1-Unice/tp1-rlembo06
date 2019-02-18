/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rlembo.exo1.exo1b;

import com.rlembo.exo1.exo1a.Directory;
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
        System.out.println("1.B) : ");
        for (String item : dir.getContentDir()) {
            System.out.println(item);
        }
    }
}
