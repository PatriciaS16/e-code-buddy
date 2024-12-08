package com.codeforall.online.ecodebuddy.model.bin;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

/**
 * An item list for the yellow bin
 */
@Entity
@DiscriminatorValue("YELLOW_BIN")
public class YellowBin extends Bin {

    /**
     * @see Bin#getBinType()
     */
    @Override
    public BinType getBinType() {
        return BinType.YELLOW_BIN;
    }

}
