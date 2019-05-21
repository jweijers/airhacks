package com.airhacks.full.boundary;

import javax.enterprise.context.ApplicationScoped;

/**
 * BandManager
 */
@ApplicationScoped
public class BandManager {

    public String all() {
        return "golden,normal,others";
    }
    
}