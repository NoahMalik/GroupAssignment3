package model;

import java.io.*;
import java.util.*;

public class MidiCsvParser {
    public static List<MidiEventData> parseCsv(String filePath) throws IOException {
        List<MidiEventData> midiEvents = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] fields = line.split(",");
            int startEndTick = Integer.parseInt(fields[0].trim());
            int noteOnOff = fields[1].trim().equals("Note_on_c") ? 1 : 0;
            int channel = Integer.parseInt(fields[2].trim());
            int note = Integer.parseInt(fields[3].trim());
            int velocity = Integer.parseInt(fields[4].trim());
            int instrument = Integer.parseInt(fields[5].trim());

            MidiEventData event = new MidiEventData(startEndTick, velocity, note, channel, instrument, noteOnOff);
            midiEvents.add(event);
        }
        reader.close();
        return midiEvents;
    }
}