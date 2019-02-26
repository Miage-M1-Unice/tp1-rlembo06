/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rlembo.tp1.exo1.exo1c;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author romain
 */
public class MyFilenameFilter implements FilenameFilter{

    @Override
    public boolean accept(File dir, String name) {
        File file = new File(dir.getAbsolutePath() + "/" + name);

        if (file.isDirectory()) {
            return true;
        }
        
        Pattern p = Pattern.compile("^.*\\.java$");
        return p.matcher(name).matches();
    }
}
