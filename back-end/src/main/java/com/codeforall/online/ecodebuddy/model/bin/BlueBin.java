package com.codeforall.online.ecodebuddy.model.bin;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

/**
 * An item list for the blue bin
 */
@Entity
@DiscriminatorValue("BLUE_BIN")
public class BlueBin extends Bin {

    /**
     * @see Bin#getBinType()
     * @return
     */
    @Override
    public BinType getBinType() {
        return BinType.BLUE_BIN;
    }








    /*
    private static final BlueBin INSTANCE = new BlueBin();


    private BlueBin() {
        super("Blue");
    }

    /**
     * Returns the single instance of the {@code BlueBin} class.
     * This method ensures that only one instance of {@code BlueBin} exists
     * during the lifetime of the application (Singleton Pattern).
     * Subsequent calls will always return the same instance.
     *
     * @return the single instance of {@code BlueBin}
     */
   /* public static BlueBin getInstance() {
        return INSTANCE;
    }*/
}
