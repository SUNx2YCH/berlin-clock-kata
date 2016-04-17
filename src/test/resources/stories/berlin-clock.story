Story: The Berlin Clock

Narrative:
    As a clock enthusiast
    I want to tell the time using the Berlin Clock
    So that I can increase the number of ways that I can read the time

Scenario: Clock lights correctly display given time

When the time is <given_time>
Then the clock should look like <seconds> <hours_1st_row> <hours_2nd_row> <minutes_1st_row> <minutes_2nd_row>

Examples:
|given_time|seconds|hours_1st_row|hours_2nd_row|minutes_1st_row|minutes_2nd_row|
|00:00:00  |Y      |OOOO         |OOOO         |OOOOOOOOOOO    |OOOO           |
|13:17:01  |O      |RROO         |RRRO         |YYROOOOOOOO    |YYOO           |
|23:59:59  |O      |RRRR         |RRRO         |YYRYYRYYRYY    |YYYY           |
|24:00:00  |Y      |RRRR         |RRRR         |OOOOOOOOOOO    |OOOO           |
