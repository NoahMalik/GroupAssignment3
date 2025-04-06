package pattern;

import javax.sound.midi.*;

import model.MidiEventData;

public class LegatoMidiEventFactory implements MidiEventFactory {

    @Override
    public MidiEventData createNoteOn(int tick, int note, int velocity, int channel) throws InvalidMidiDataException {
        // Create MidiEventData for "Note On"
        return new MidiEventData(tick, velocity, note, channel, ShortMessage.NOTE_ON);
    }

    @Override
    public MidiEventData createNoteOff(int tick, int note, int channel) throws InvalidMidiDataException {
        // Create MidiEventData for "Note Off"
        return new MidiEventData(tick, 0, note, channel, ShortMessage.NOTE_OFF); // 0 velocity for note off
    }
}