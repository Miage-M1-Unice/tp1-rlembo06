/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rlembo.exo1.exo1b;

import com.rlembo.exo1.exo1a.Directory;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;

/**
 *
 * @author romain
 */
public class Main {
        
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       FilterListFiles filterListFiles = new FilterListFiles(".java");
       ListFiles listFiles = new ListFiles();
        
        try {
            System.out.println("1.B) Avec filtre : ");
            filterListFiles.browe();
            System.out.println("1.B) Sans filtre : ");
            listFiles.browe();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
