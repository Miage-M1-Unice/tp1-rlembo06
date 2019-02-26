/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rlembo.tp1.exo1.exo1b;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

/**
 *
 * @author romain
 */
public class ListFiles extends SimpleFileVisitor<Path>{
    
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        System.out.println(file);
        return super.visitFile(file, attrs);
    }
    
    public void browe () throws IOException {
        Files.walkFileTree(new File(".").toPath(), new ListFiles());
    }
}
