package com.formento.working.day.service;

import java.time.temporal.Temporal;

public interface HolidayService {

    Boolean isHoliday(Temporal toValidate);

}
