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
public class Directory {
    private String path;
    private File dir;

    public Directory(String path) {
        this.path = path;
        this.dir = new File(path);
    }

    public String getPath() {
        return path;
    }

    public File getDir() {
        return dir;
    }    

    public String[] getContentDir() {
        File dir = new File(path);
        dir.list();
        
        return dir.list();
    }
    
    public File[] getContentListFiles() {
        File dir = new File(path);
        File[] paths = dir.listFiles();
        
        return paths;
    }
    
    public File[] getContentListFilesWithFilter(FilenameFilter filter) {
        File dir = new File(path);
        File[] paths = dir.listFiles(filter);
     
        return paths;
    }
}
