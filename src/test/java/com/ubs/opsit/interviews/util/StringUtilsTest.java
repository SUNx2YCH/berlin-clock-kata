package com.ubs.opsit.interviews.util;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
public class StringUtilsTest {

    @Test
    @Parameters({
            "abcde, 2, x, abcxx",
            "abCDE, 0, z, abCDE",
            "ABCDE, 5, *, *****",
            ", 0, x, "
    })
    public void testReplaceTrailingCharsPositive(String initialText,
                                                 int charsToReplace,
                                                 char replaceChar,
                                                 String expectedText) {
        String actualText = StringUtils.replaceTrailingChars(initialText, charsToReplace, replaceChar);
        assertThat(actualText).isEqualTo(expectedText);
    }

    @Test(expected = IllegalArgumentException.class)
    @Parameters({
            "abcde, 6, x",
            "abcde, -1, y",
            ", 1, *"
    })
    public void testReplaceTrailingCharsNegative(String initialText,
                                                 int charsToReplace,
                                                 char replaceChar) {
        StringUtils.replaceTrailingChars(initialText, charsToReplace, replaceChar);
    }
}
