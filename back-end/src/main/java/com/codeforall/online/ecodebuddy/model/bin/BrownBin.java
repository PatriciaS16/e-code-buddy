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
     */
    @Override
    public BinType getBinType() {
        return BinType.BROWN_BIN;
    }
}
