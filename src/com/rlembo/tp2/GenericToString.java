/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rlembo.tp2;

import java.awt.*;
import java.lang.reflect.Array;
import java.lang.reflect.Field;

/**
 *
 * @author romain
 */
public class GenericToString {
    
    private String PolygonToString(Object object) {
        
        String string = "";
        
        int length = Array.getLength(object);
        string += "{";
        for (int j = 0; j < length; j++) {
            // Récupération d'un point du polygon :
            string += Array.get(object, j);
            if ((j+1) != length) {
                string += ",";
            }
        }
        string += "}";
        
        return string;
    }
            
    public String toString(Object object, int profondeur) throws IllegalAccessException {
        if (profondeur == 0) {
            return object + "";
        }

        String string = "";

        Class cl = object.getClass();

        string += cl.getName() + "\n";
        string += "[";

        Field[] fields = cl.getDeclaredFields();

        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            field.setAccessible(true);

            Object fieldObject = field.get(object);

            string += field.getName();
            string += "=";

            if (fieldObject != null) {
                if (field.getType().isPrimitive()) {
                    string += fieldObject;
                } else if (field.getType().isArray()) {
                    string += PolygonToString(fieldObject);
                } else {
                    // Récursivité :
                    string += toString(fieldObject, profondeur - 1);
                }

            } else {
                string += "null";
            }

            if ((i + 1) != fields.length) {
                string += ";\n";
            }
        }
        
        string += "]";

        return string;
    }
}
