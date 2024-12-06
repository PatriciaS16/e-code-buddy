package com.codeforall.online.ecodebuddy.model.speech;

/**
 * The possible {@link Speech} types
 */
public enum SpeechType {

    /**
     * @see UnknownItemSpeech
     */
    UNKNOWN_ITEM,
    /**
     * @see KnownItemSpeech
     */
    KNOWN_ITEM,
    /**
     * @see WelcomeSpeech
     */
    WELCOME,
    /**
     * @see ThanksSpeech
     */
    THANKS,
    /**
     * @see HomepageSpeech
     */
    HOMEPAGE,
    /**
     * @see SuggestionSpeech
     */
    SUGGESTION,
}
