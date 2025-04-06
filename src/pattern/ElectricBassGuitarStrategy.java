package pattern;

import javax.sound.midi.*;

public class ElectricBassGuitarStrategy implements InstrumentStrategy {
    @Override
    public void applyInstrument(Track track, int tick) {
        try {
            // Program Change Message to set the instrument
            ShortMessage message = new ShortMessage();
            message.setMessage(ShortMessage.PROGRAM_CHANGE, 0, 35, 0);  // 35 is Electric Bass Guitar
            MidiEvent event = new MidiEvent(message, tick);
            track.add(event);
        } catch (InvalidMidiDataException e) {
            e.printStackTrace();
        }
    }
}