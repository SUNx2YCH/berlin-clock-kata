package com.ubs.opsit.interviews.util;

import static org.apache.commons.lang.StringUtils.repeat;

public final class StringUtils {

    private StringUtils() {
    }

    /**
     * Replaces given number of trailing chars with a given symbol.
     * {@code replaceTrailingChars("Some text", 3, '.') = "Some t..."}
     */
    public static String replaceTrailingChars(String initialText, int charsToReplace, char replaceChar) {
        int length = initialText.length();
        if (charsToReplace < 0 || charsToReplace > length) {
            throw new IllegalArgumentException("Unexpected 'charsToReplace' value: " + charsToReplace);
        }
        return initialText.substring(0, length - charsToReplace) + repeat(String.valueOf(replaceChar), charsToReplace);
    }
}
