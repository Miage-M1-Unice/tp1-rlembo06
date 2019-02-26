package com.rlembo.tp2;

import com.rlembo.tp1.exo1.exo1b.FilterListFiles;
import com.rlembo.tp1.exo1.exo1b.ListFiles;
import java.awt.Point;
import java.awt.Polygon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author romain
 */
public class Main {
    public static void main(String[] args) throws ClassNotFoundException, IOException, IllegalAccessException {
        Main main = new  Main();
        
        System.out.print("\n\n**** 1er PARTIE ********\n\n");
        AnalyseurDeClasse analyseur = new AnalyseurDeClasse();
        
        System.out.print("Quel classe à chercher ? : ");
        String classAChercher = main.litChaineAuClavier();
        analyseur.analyseClasse(classAChercher);
        
        System.out.print("\n\n**** 2e PARTIE ********\n\n");
        
        System.out.println(new GenericToString().toString(new Point(12, 24), 2) + "\n");
        
        Polygon pol = new Polygon(new int[]{10, 20, 30}, new int[]{20,30, 40}, 3);  
        pol.getBounds();  
        System.out.println(new GenericToString().toString(pol, 2) + "\n");
    }
    
    public String litChaineAuClavier() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return br.readLine();
    }
}
