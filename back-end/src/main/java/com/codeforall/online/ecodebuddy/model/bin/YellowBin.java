package com.codeforall.online.ecodebuddy.model.bin;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

/**
 * An item list for the yellow bin
 */
@Entity
@DiscriminatorValue("YELLOW_BIN")
public class YellowBin extends Bin {


    @Override
    public BinType getBinType() {
        return BinType.YELLOW_BIN;
    }


    /*
    private static final YellowBin INSTANCE = new YellowBin();

    private YellowBin() {
        super("Yellow");
    }

    /**
     * Returns the single instance of the {@code YellowBin} class.
     * This method ensures that only one instance of {@code YellowBin} exists
     * during the lifetime of the application (Singleton Pattern).
     * Subsequent calls will always return the same instance.
     *
     * @return the single instance of {@code YellowBin}
     */
    /*
    public static YellowBin getInstance() {
        return INSTANCE;
    }*/
}
