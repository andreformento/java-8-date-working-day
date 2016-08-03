package com.formento.working.day.component.impl;

import com.formento.working.day.component.NextBusinessDay;
import com.formento.working.day.component.NextWorkDay;
import com.formento.working.day.service.HolidayService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.time.LocalDate;
import java.time.temporal.Temporal;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class NextBusinessDayImplTest {

    @Mock
    private HolidayService holidayService;

    @Mock
    private NextWorkDay nextWorkDay;

    private NextBusinessDay nextBusinessDay;

    @Before
    public void init() {
        this.nextBusinessDay = new NextBusinessDayImpl(holidayService, nextWorkDay);
    }

    @Test
    public void shouldBePlus1WhenFindAHolidayInWeekday() {
        // given
        LocalDate day = LocalDate.of(2016, 8, 3);

        // when
        when(holidayService.isHoliday(LocalDate.of(2016, 8, 4))).thenReturn(true);
        when(holidayService.isHoliday(LocalDate.of(2016, 8, 5))).thenReturn(false);

        when(nextWorkDay.adjustInto(LocalDate.of(2016, 8, 3))).thenReturn(LocalDate.of(2016, 8, 4));
        when(nextWorkDay.adjustInto(LocalDate.of(2016, 8, 4))).thenReturn(LocalDate.of(2016, 8, 5));

        Temporal result = nextBusinessDay.adjustInto(day);

        // then
        assertEquals(LocalDate.of(2016, 8, 5), result);
    }

    @Test
    public void shouldNotBePlusNothingWhenFindAHolidayInSaturday() {
        // given
        LocalDate day = LocalDate.of(2016, 8, 5);

        // when
        when(holidayService.isHoliday(LocalDate.of(2016, 8, 8))).thenReturn(false);

        when(nextWorkDay.adjustInto(LocalDate.of(2016, 8, 5))).thenReturn(LocalDate.of(2016, 8, 8));

        Temporal result = nextBusinessDay.adjustInto(day);

        // then
        assertEquals(LocalDate.of(2016, 8, 8), result);
    }

    @Test
    public void shouldNotBePlusNothingWhenFindAHolidayInSunday() {
        // given
        LocalDate day = LocalDate.of(2016, 8, 5);

        // when
        when(holidayService.isHoliday(LocalDate.of(2016, 8, 8))).thenReturn(false);

        when(nextWorkDay.adjustInto(LocalDate.of(2016, 8, 5))).thenReturn(LocalDate.of(2016, 8, 8));

        Temporal result = nextBusinessDay.adjustInto(day);

        // then
        assertEquals(LocalDate.of(2016, 8, 8), result);
    }

}
