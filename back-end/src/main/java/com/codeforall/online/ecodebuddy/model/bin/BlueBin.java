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
     */
    @Override
    public BinType getBinType() {
        return BinType.BLUE_BIN;
    }
}
