package com.codeforall.online.ecodebuddy.converters;

import com.codeforall.online.ecodebuddy.command.BinDto;
import com.codeforall.online.ecodebuddy.model.bin.Bin;
import org.springframework.stereotype.Component;

/**
 * A concrete converter class that transforms an {@link Bin} entity into an {@link BinDto}
 */
@Component
public class BinToBinDto extends AbstractConverter<Bin, BinDto> {

    /**
     * Convert a bin into a binDto
     * @param bin to take info out of
     * @return the binDto
     */
    @Override
    public BinDto convert(Bin bin) {

        BinDto binDto = new BinDto();
        binDto.setId(bin.getId());
        binDto.setColor(bin.getColor());
        binDto.setDescription(bin.getDescription());

        return binDto;
    }
}
