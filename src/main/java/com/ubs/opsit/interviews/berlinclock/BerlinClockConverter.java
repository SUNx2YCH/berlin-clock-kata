package com.ubs.opsit.interviews.berlinclock;

import org.apache.commons.lang.BooleanUtils;

import com.ubs.opsit.interviews.TimeConverter;
import com.ubs.opsit.interviews.util.TimeUtils;

import static com.ubs.opsit.interviews.berlinclock.BerlinClockLights.*;

public class BerlinClockConverter implements TimeConverter {

    public String convertTime(String aTime) {
        int[] timeParts = TimeUtils.parse24hClock(aTime);
        int hours = timeParts[0], minutes = timeParts[1], seconds = timeParts[2];
        return String.join(" ",
                SECONDS.turnOn(BooleanUtils.toInteger(seconds % 2 == 0)),
                HOURS_1ST_ROW.turnOn(hours / 5),
                HOURS_2ND_ROW.turnOn(hours % 5),
                MINUTES_1ST_ROW.turnOn(minutes / 5),
                MINUTES_2ND_ROW.turnOn(minutes % 5));
    }
}
