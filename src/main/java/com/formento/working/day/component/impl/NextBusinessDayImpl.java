package com.formento.working.day.component.impl;

import com.formento.working.day.component.NextBusinessDay;
import com.formento.working.day.component.NextWorkDay;
import com.formento.working.day.service.HolidayService;

import java.time.temporal.Temporal;

public class NextBusinessDayImpl implements NextBusinessDay {

    private final HolidayService holidayService;
    private final NextWorkDay nextWorkDay;

    public NextBusinessDayImpl(HolidayService holidayService, NextWorkDay nextWorkDay) {
        this.holidayService = holidayService;
        this.nextWorkDay = nextWorkDay;
    }

    public Temporal adjustInto(final Temporal temporal) {
        Temporal result = temporal;
        do {
            result = nextWorkDay.adjustInto(result);
        } while (holidayService.isHoliday(result));
        return result;
    }

}
