/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rlembo.tp2;

import com.rlembo.tp1.exo1.exo1b.FilterListFiles;
import com.rlembo.tp1.exo1.exo1b.ListFiles;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author romain
 */
public class Main {
    public static void main(String[] args) throws ClassNotFoundException, IOException {
        Main main = new  Main();
        
        System.out.print("**** 1er PARTIE ********");
        //AnalyseurDeClasse analyseur = new AnalyseurDeClasse();
       
        //String classAChercher = main.litChaineAuClavier();
        //analyseur.analyseClasse(classAChercher);
        
        System.out.print("**** 2e PARTIE ********");
        GenericToString gts = new GenericToString();
        System.out.println(new GenericToString().toString(new Point(12, 24)));
    }
    
    public String litChaineAuClavier() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return br.readLine();
    }
}
