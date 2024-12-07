package com.codeforall.online.ecodebuddy.converters;

import com.codeforall.online.ecodebuddy.command.SpeechDto;
import com.codeforall.online.ecodebuddy.model.speech.Speech;
import org.springframework.stereotype.Component;

/**
 * A concrete converter class that transforms an {@link Speech} entity into an {@link SpeechDto}
 */
@Component
public class speechToSpeehDto extends AbstractConverter<Speech, SpeechDto> {
    @Override
    public SpeechDto convert(Speech speech) {

        SpeechDto speechDto = new SpeechDto();
        speechDto.setId(speech.getId());
        speechDto.setSpeechType(speech.getSpeechType());

        return speechDto;
    }
}
