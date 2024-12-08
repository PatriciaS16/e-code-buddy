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
     */
    @Override
    public BinType getBinType() {
        return BinType.RED_BIN;
    }
}
