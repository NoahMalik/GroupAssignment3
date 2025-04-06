package pattern;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;

import model.*;

public interface MidiEventFactory {
    MidiEventData createNoteOn(int tick, int note, int velocity, int channel) throws InvalidMidiDataException;
    MidiEventData createNoteOff(int tick, int note, int channel) throws InvalidMidiDataException;
}