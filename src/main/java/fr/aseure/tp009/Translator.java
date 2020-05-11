package fr.aseure.tp009;

import fr.aseure.tp009.io.Reader;
import fr.aseure.tp009.io.Speaker;

class Translator<R extends Reader, S extends Speaker> {
    private final R reader;
    private final S speaker;

    public Translator(R reader, S speaker) {
        this.reader = reader;
        this.speaker = speaker;
    }

    String translate(String number) {
        int i = reader.read(number);
        return speaker.speak(i);
    }
}
