package com.codeforall.online.ecodebuddy.converters;

import com.codeforall.online.ecodebuddy.command.CodeDto;
import com.codeforall.online.ecodebuddy.model.Code;
import org.springframework.stereotype.Component;

/**
 *
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
