/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rlembo.exo1.exo1b;

import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;

/**
 *
 * @author romain
 */
public class ParseDirectories {
    
    private Path path;
    private FilterSimpleFile fileVisitor;

    public ParseDirectories(Path path) {
        this.path = path;
        this.fileVisitor = new FilterSimpleFile();
    }
    
    public void getWalkFileTree() {
        
    }
    
}
