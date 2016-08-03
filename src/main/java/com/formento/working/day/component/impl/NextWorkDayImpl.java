package com.formento.working.day.component.impl;

import com.formento.working.day.component.NextWorkDay;

import java.time.DayOfWeek;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;

import static java.time.DayOfWeek.of;

public class NextWorkDayImpl implements NextWorkDay {

    private Integer getDayToAdd(DayOfWeek dayOfWeek) {
        switch (dayOfWeek) {
            case FRIDAY:
                return 3;
            case SATURDAY:
                return 2;
            default:
                return 1;
        }
    }

    @Override
    public Temporal adjustInto(Temporal temporal) {
        return temporal.plus(getDayToAdd(of(temporal.get(ChronoField.DAY_OF_WEEK))), ChronoUnit.DAYS);
    }

}
