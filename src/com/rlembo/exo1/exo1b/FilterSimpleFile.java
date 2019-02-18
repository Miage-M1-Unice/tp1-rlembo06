/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rlembo.exo1.exo1b;

import static java.nio.file.FileVisitResult.CONTINUE;

import com.rlembo.exo1.exo1a.Directory;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

/**
 *
 * @author romain
 */
public class FilterSimpleFile extends SimpleFileVisitor<Path> {

    @Override
    public FileVisitResult visitFile(Path path,
        BasicFileAttributes basicFileAttributes) {

        if (basicFileAttributes.isRegularFile()) {
                System.out.println(path + " is a regular file with size "
                                + basicFileAttributes.size());
        } else if (basicFileAttributes.isSymbolicLink()) {
                System.out.println(path + " is a symbolic link.");
        } else {
                System.out.println(path + " is not a regular file or symbolic link.");
        }
        return CONTINUE;
    }

    public FileVisitResult postVisitDirectory(Path path, IOException ioException) {
        System.out.println(path + " visited.");
        return CONTINUE;
    }

    public FileVisitResult visitFileFailed(Path path, IOException ioException) {
        System.err.println(ioException);
        return CONTINUE;
    }
}