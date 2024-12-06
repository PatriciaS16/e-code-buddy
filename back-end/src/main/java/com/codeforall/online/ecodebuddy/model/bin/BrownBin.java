package com.codeforall.online.ecodebuddy.model.bin;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

/**
 * An item list for the brown bin
 */
@Entity
@DiscriminatorValue("BROWN_BIN")
public class BrownBin extends Bin {

    /**
     * @see Bin#getBinType()
     * @return
     */
    @Override
    public BinType getBinType() {
        return BinType.BROWN_BIN;
    }



    /*
    private static final BrownBin INSTANCE = new BrownBin();

    private BrownBin() {
        super("Brown");
    }

    /**
     * Returns the single instance of the {@code BrownBin} class.
     * This method ensures that only one instance of {@code BrownBin} exists
     * during the lifetime of the application (Singleton Pattern).
     * Subsequent calls will always return the same instance.
     *
     * @return the single instance of {@code BrownBin}
     */
   /* public static BrownBin getInstance() {
        return INSTANCE;
    }*/
}
