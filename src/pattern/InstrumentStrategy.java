package pattern;

import javax.sound.midi.*;

public interface InstrumentStrategy {
    void applyInstrument(Track track, int tick);
}