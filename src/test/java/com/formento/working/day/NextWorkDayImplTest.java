package com.formento.working.day;

import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class NextWorkDayImplTest {

    @Test
    public void shouldBeWednesdayWhenPlus1WorkinkDayInTuesday() {
        // given
        LocalDate wednesday = LocalDate.of(2016, 8, 2);

        // when
        LocalDate nextWorkingDay = wednesday.with(new NextWorkDayImpl());

        // then
        assertEquals(LocalDate.of(2016, 8, 3), nextWorkingDay);
    }

    @Test
    public void shouldBeMondayWhenPlus1WorkinkDayInFriday() {
        // given
        LocalDate wednesday = LocalDate.of(2016, 8, 5);

        // when
        LocalDate nextWorkingDay = wednesday.with(new NextWorkDayImpl());

        // then
        assertEquals(LocalDate.of(2016, 8, 8), nextWorkingDay);
    }

    @Test
    public void shouldBeMondayWhenPlus1WorkinkDayInSaturday() {
        // given
        LocalDate wednesday = LocalDate.of(2016, 8, 6);

        // when
        LocalDate nextWorkingDay = wednesday.with(new NextWorkDayImpl());

        // then
        assertEquals(LocalDate.of(2016, 8, 8), nextWorkingDay);
    }

    @Test
    public void shouldBeMondayWhenPlus1WorkinkDayInSunday() {
        // given
        LocalDate wednesday = LocalDate.of(2016, 8, 7);

        // when
        LocalDate nextWorkingDay = wednesday.with(new NextWorkDayImpl());

        // then
        assertEquals(LocalDate.of(2016, 8, 8), nextWorkingDay);
    }

}
