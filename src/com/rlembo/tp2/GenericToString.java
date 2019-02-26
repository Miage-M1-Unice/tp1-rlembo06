/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rlembo.tp2;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 *
 * @author romain
 */
public class GenericToString {
    
    private String polygonToString(Object object) {
        
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
     
    private Field[] getFieldsFromSuperClass(Class cl,  Field[] fields) {
        Class superclass = cl.getSuperclass();

        while (superclass != null) {
            Field[] superFields = superclass.getDeclaredFields();

            fields = Stream.concat(Arrays.stream(fields), Arrays.stream(superFields)).toArray(Field[]::new);

            superclass = superclass.getSuperclass();
        }
        return fields;
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
        
        fields = getFieldsFromSuperClass(cl, fields);

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
                    string += polygonToString(fieldObject);
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
