package com.ubs.opsit.interviews.berlinclock;

import static com.ubs.opsit.interviews.util.StringUtils.replaceTrailingChars;

/**
 * Berlin Clock presentation logic
 */
public enum BerlinClockLights {

    SECONDS("Y"),
    HOURS_1ST_ROW("RRRR"),
    HOURS_2ND_ROW("RRRR"),
    MINUTES_1ST_ROW("YYRYYRYYRYY"),
    MINUTES_2ND_ROW("YYYY");

    private static final char OFF_LIGHT = 'O';

    private final String allLights;

    BerlinClockLights(String allLights) {
        this.allLights = allLights;
    }

    public String turnOn(int lightCount) {
        return replaceTrailingChars(allLights, allLights.length() - lightCount, OFF_LIGHT);
    }
}
