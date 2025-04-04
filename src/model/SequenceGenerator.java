package model;

import javax.sound.midi.*;
import java.util.List;

public class SequenceGenerator {

    /**
     * Generates a MIDI sequence from a list of MidiEventData.
     * @param midiEvents List of MidiEventData to generate the sequence from.
     * @return The generated Sequence.
     * @throws InvalidMidiDataException If the MIDI data is invalid.
     */
    public static Sequence generateSequence(List<MidiEventData> midiEvents) throws InvalidMidiDataException {
        // Create a new MIDI sequence with PPQ (pulses per quarter note) and resolution of 384 ticks per beat.
        Sequence sequence = new Sequence(Sequence.PPQ, 384);

        // Create a track to hold the MIDI events.
        Track track = sequence.createTrack();

        // Iterate through each MidiEventData object and convert it to a MIDI event.
        for (MidiEventData event : midiEvents) {
            // Create a new ShortMessage for each MIDI event.
            ShortMessage message;

            // Handle "Note On" and "Note Off" events.
            if (event.getNoteOnOff() == 1) {
                // "Note On" event: Set the message with Note On, velocity, and the correct channel and note.
                message = new ShortMessage();
                message.setMessage(ShortMessage.NOTE_ON, event.getChannel(), event.getNote(), event.getVelocity());
            } else {
                // "Note Off" event: Set the message with Note Off. Typically, velocity is set to 0 for "Note Off".
                message = new ShortMessage();
                message.setMessage(ShortMessage.NOTE_OFF, event.getChannel(), event.getNote(), 0); // Typically velocity is 0 for Note Off
            }

            // Create a MidiEvent with the message and the tick position from the MidiEventData.
            MidiEvent midiEvent = new MidiEvent(message, event.getStartEndTick());

            // Add the event to the track.
            track.add(midiEvent);
        }

        // Return the complete sequence.
        return sequence;
    }
}
