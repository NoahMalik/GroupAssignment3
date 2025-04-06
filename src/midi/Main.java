package midi;

import model.*;
import pattern.*;
import javax.sound.midi.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            // Parse the CSV and create MidiEventData objects
            List<MidiEventData> midiEvents = MidiCsvParser.parseCsv("./files/mysterysong.csv");

            // Generate the MIDI sequence from the MidiEventData
            Sequence sequence = SequenceGenerator.generateSequence(midiEvents);

            // Choose factory and instrument strategy
            MidiEventFactoryAbstract factoryAbstract = new StandardMidiEventFactoryAbstract();
            MidiEventFactory factory = factoryAbstract.createFactory();

            // Apply instrument strategy
            InstrumentStrategy instrumentStrategy = new ElectricBassGuitarStrategy();
            instrumentStrategy.applyInstrument(sequence.getTracks()[0], 0);

            // Play the generated sequence
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();
            sequencer.setSequence(sequence);
            sequencer.start();

            while (sequencer.isRunning()) {
                Thread.sleep(100); // Wait until the sequence finishes
            }

            sequencer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}