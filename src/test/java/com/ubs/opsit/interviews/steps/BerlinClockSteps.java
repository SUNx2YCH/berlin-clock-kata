package com.ubs.opsit.interviews.steps;

import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import com.ubs.opsit.interviews.TimeConverter;

import static org.assertj.core.api.Assertions.assertThat;

public class BerlinClockSteps {

    private TimeConverter timeConverter;
    private String givenTime;

    @When("the time is <given_time>")
    public void whenTheTimeIs(@Named("given_time") String givenTime) {
        this.givenTime = givenTime;
    }

    @Then("the clock should look like <seconds> <hours_1st_row> <hours_2nd_row> <minutes_1st_row> <minutes_2nd_row>")
    public void thenTheClockShouldLookLike(@Named("seconds") String seconds,
                                           @Named("hours_1st_row") String hours1stRow,
                                           @Named("hours_2nd_row") String hours2ndRow,
                                           @Named("minutes_1st_row") String minutes1stRow,
                                           @Named("minutes_2nd_row") String minutes2ndRow) {
        assertThat(timeConverter.convertTime(givenTime).split("\\s+"))
                .containsExactly(seconds, hours1stRow, hours2ndRow, minutes1stRow, minutes2ndRow);
    }
}
