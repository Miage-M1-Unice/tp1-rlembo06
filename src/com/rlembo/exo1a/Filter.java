/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rlembo.exo1a;

import java.io.File;
import java.io.FilenameFilter;

/**
 *
 * @author romain
 */
public class Filter implements FilenameFilter {
    
    private String filterQuery;

    public Filter(File dir, String name, String filterQuery) {
        this.filterQuery = filterQuery;
        accept(dir, name);
    }

    public String getFilterQuery() {
        return filterQuery;
    }

    public void setFilterQuery(String filterQuery) {
        this.filterQuery = filterQuery;
    }
        
    @Override
    public boolean accept(File dir, String name) {
        return name.contains(filterQuery);
    }
    
}
