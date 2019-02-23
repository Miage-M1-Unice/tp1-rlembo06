/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rlembo.tp1.exo1.exo1c;

import com.rlembo.tp1.exo1.exo1b.*;
import com.rlembo.tp1.exo1.exo1a.Directory;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author romain
 */
public class Main {
        
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Main main = new Main();
        main.broweFilter(new File("."), new MyFilenameFilter());
    }
    
    public void broweFilter(File f, FilenameFilter filenameFilter) {
        File[] files = f.listFiles(filenameFilter);

        if (files == null) {
            return;
        }

        for (File file : files) {
            if (file.isDirectory()) {
                broweFilter(file, filenameFilter);
            } else {
                System.out.println(file.getAbsolutePath());
            }
        }
    }

}
