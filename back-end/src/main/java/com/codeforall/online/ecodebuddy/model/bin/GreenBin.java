package com.codeforall.online.ecodebuddy.model.bin;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("GREEN_BIN")
public class GreenBin extends Bin {

    /**
     * @see Bin#getBinType()
     * @return
     */
    @Override
    public BinType getBinType() {
        return BinType.GREEN_BIN;
    }


    /*
    private static final GreenBin INSTANCE = new GreenBin();

    private GreenBin() {
        super("Green");
    }

    /**
     * Returns the single instance of the {@code GreenBin} class.
     * This method ensures that only one instance of {@code GreenBin} exists
     * during the lifetime of the application (Singleton Pattern).
     * Subsequent calls will always return the same instance.
     *
     * @return the single instance of {@code GreenBin}
     */
   /* public static GreenBin getInstance() {
        return INSTANCE;
    }*/


}
