package pattern;

import javax.sound.midi.*;

public class StaccatoMidiEventFactory implements MidiEventFactory {
    @Override
    public MidiEvent createNoteOn(int tick, int note, int velocity, int channel) throws InvalidMidiDataException {
        // ShortMessage for "Note On"
        ShortMessage message = new ShortMessage();
        message.setMessage(ShortMessage.NOTE_ON, channel, note, velocity);
        return new MidiEvent(message, tick);
    }

    @Override
    public MidiEvent createNoteOff(int tick, int note, int channel) throws InvalidMidiDataException {
        // ShortMessage for "Note Off"
        ShortMessage message = new ShortMessage();
        message.setMessage(ShortMessage.NOTE_OFF, channel, note, 0); // 0 velocity for Note Off
        return new MidiEvent(message, tick);
    }
}