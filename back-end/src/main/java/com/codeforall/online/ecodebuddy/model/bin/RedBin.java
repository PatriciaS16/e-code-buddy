package com.codeforall.online.ecodebuddy.model.bin;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

/**
 * An item list for the red bin
 */
@Entity
@DiscriminatorValue("RED_BIN")
public class RedBin extends Bin {

    /**
     * @see Bin#getBinType()
     * @return
     */
    @Override
    public BinType getBinType() {
        return BinType.RED_BIN;
    }



    /*
    private static final RedBin INSTANCE = new RedBin();

    private RedBin() {
        super("Red");
    }

    /**
     * Returns the single instance of the {@code RedBin} class.
     * This method ensures that only one instance of {@code RedBin} exists
     * during the lifetime of the application (Singleton Pattern).
     * Subsequent calls will always return the same instance.
     *
     * @return the single instance of {@code RedBin}
     */
   /* public static RedBin getInstance() {
        return INSTANCE;
    }*/
}
