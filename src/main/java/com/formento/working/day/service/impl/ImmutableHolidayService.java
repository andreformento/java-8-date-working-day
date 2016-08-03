package com.formento.working.day.service.impl;

import com.formento.working.day.service.HolidayService;

import java.time.temporal.Temporal;
import java.util.Collection;
import java.util.Collections;

/**
 * Can connect in database, or another service to get information about business day
 */
public class ImmutableHolidayService implements HolidayService {

    private final Collection<Temporal> holidays;

    public ImmutableHolidayService(Collection<Temporal> holidays) {
        this.holidays = Collections.unmodifiableCollection(holidays);
    }

    @Override
    public Boolean isHoliday(Temporal toValidate) {
        return holidays.contains(toValidate);
    }

}
