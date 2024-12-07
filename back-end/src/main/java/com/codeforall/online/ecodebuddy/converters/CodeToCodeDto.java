package com.codeforall.online.ecodebuddy.converters;

import com.codeforall.online.ecodebuddy.command.CodeDto;
import com.codeforall.online.ecodebuddy.model.Code;
import org.springframework.stereotype.Component;

/**
 * A concrete converter class that transforms an {@link Code} entity into an {@link CodeDto}.
 */
@Component
public class CodeToCodeDto extends AbstractConverter<Code, CodeDto> {

    @Override
    public CodeDto convert(Code code) {

        CodeDto codeDto = new CodeDto();
        codeDto.setId(code.getId());
        codeDto.setName(code.getName());

        return codeDto;
    }

}
