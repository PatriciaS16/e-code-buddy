package com.codeforall.online.ecodebuddy.model;

import com.codeforall.online.ecodebuddy.model.bin.*;
import com.codeforall.online.ecodebuddy.model.speech.Speech;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name ="code")
public class Code extends AbstractModel {
    private String name;

    @OneToMany(
            cascade = {CascadeType.ALL},
            orphanRemoval = true,
            mappedBy = "code",
            fetch = FetchType.EAGER
    )
    private Set<Speech> dialogs = new HashSet<>();

    @OneToMany(
            cascade = {CascadeType.ALL},
            orphanRemoval = true,
            mappedBy = "code",
            fetch = FetchType.EAGER
    )
    private Set<Bin> bins = new HashSet<>();

    /*private static final Code INSTANCE = new Code();

    public static Code getInstance() {
        return INSTANCE;
    }

    private Code() {
        this.name = "Cod-e";
        initializeBins();

    }

    /**
     * Add all bins to Cod-e
     */
    /*private void initializeBins(){
        bins.add(BlueBin.getInstance());
        bins.add(BrownBin.getInstance());
        bins.add(GreenBin.getInstance());
        bins.add(RedBin.getInstance());
        bins.add(YellowBin.getInstance());
    }*/

    /**
     * List all bins
     * @return a Set of bins
     */
    public Set<Bin> getBins() {
        return bins;
    }

    /**
     * List all dialogs
     * @return a Set of dialogs
     */
    public Set<Speech> getDialogs() {
        return dialogs;
    }

    /**
     * Get code's name
     * @return the code's name
     */
    public String getName() {
        return name;
    }

    /**
     * Set code's name
     * @param name given
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Set the dialogs to the given dialogs list
     * @param dialogs given
     */
    public void setDialogs(Set<Speech> dialogs) {
        this.dialogs = dialogs;
    }
    /**
     * Set the bin to the given bins list
     * @param bins given
     */
    public void setBins(Set<Bin> bins) {
        this.bins = bins;
    }
}
