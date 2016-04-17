package com.ubs.opsit.interviews.util;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import static java.util.Arrays.asList;

public final class TimeUtils {

    private TimeUtils() {
    }

    /**
     * Parses a 24-hour clock string to an array [hours, minutes, seconds].
     */
    public static int[] parse24hClock(String time) {
        // LocalTime wouldn't parse "24:00", so we need this workaround
        if (asList("24:00", "24:00:00").contains(time)) {
            return new int[] {24, 0, 0};
        }
        LocalTime localTime = LocalTime.parse(time, DateTimeFormatter.ISO_LOCAL_TIME);
        return new int[] {localTime.getHour(), localTime.getMinute(), localTime.getSecond()};
    }
}
