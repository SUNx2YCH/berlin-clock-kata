package com.ubs.opsit.interviews.util;

import java.time.format.DateTimeParseException;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
public class TimeUtilsTest {

    @Test
    @Parameters({
            "00:00:00, 0, 0, 0",
            "01:02, 1, 2, 0",
            "01:02:03, 1, 2, 3",
            "23:59:59, 23, 59, 59",
            "24:00:00, 24, 0, 0",
            "24:00, 24, 0, 0"
    })
    public void testParse24hClockPositive(String time, int hours, int minutes, int seconds) {
        int[] parsedTime = TimeUtils.parse24hClock(time);
        assertThat(parsedTime).containsExactly(hours, minutes, seconds);
    }

    @Test(expected = DateTimeParseException.class)
    @Parameters({
            "",
            "00",
            "1:2:3",
            "24:00:01",
            "25:00:00",
            "00:60:00",
            "00:00:60"
    })
    public void testParse24hClockNegative(String time) {
        TimeUtils.parse24hClock(time);
    }
}
