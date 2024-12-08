package com.codeforall.online.ecodebuddy.model.bin;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("GREEN_BIN")
public class GreenBin extends Bin {

    /**
     * @see Bin#getBinType()
     */
    @Override
    public BinType getBinType() {
        return BinType.GREEN_BIN;
    }

}
