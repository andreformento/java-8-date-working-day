package com.formento.working.day.service.impl;

import com.formento.working.day.service.HolidayService;
import com.google.common.collect.ImmutableSet;
import org.junit.Test;

import java.time.LocalDate;
import java.time.temporal.Temporal;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ImmutableHolidayServiceTest {

    @Test
    public void shouldBeHoliday() {
        // given
        LocalDate day = LocalDate.of(2016, 8, 3);
        HolidayService holidayService = new ImmutableHolidayService(new ImmutableSet.Builder<Temporal>().add(LocalDate.of(2016, 8, 4)).build());

        // when
        Boolean isHoliday = holidayService.isHoliday(day);

        // then
        assertFalse(isHoliday);
    }

    @Test
    public void shouldNotBeHoliday() {
        // given
        LocalDate day = LocalDate.of(2016, 8, 4);
        HolidayService holidayService = new ImmutableHolidayService(new ImmutableSet.Builder<Temporal>().add(LocalDate.of(2016, 8, 4)).build());

        // when
        Boolean isHoliday = holidayService.isHoliday(day);

        // then
        assertTrue(isHoliday);
    }

}
