
package com.airhacks.poppodium.bands.entity;

/**
 *
 * @author airhacks.com
 */
public class Band {

    public String name;
    public int loudness;
    private String crimeFactor;

    public Band(String name, int loudness) {
        this.name = name;
        this.loudness = loudness;
        this.crimeFactor = "no";
    }

    public Band() {
    }



}
