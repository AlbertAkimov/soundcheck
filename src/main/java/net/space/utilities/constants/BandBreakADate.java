package net.space.utilities.constants;

import net.space.model.Band;

import java.util.Date;

/**
 * @Author A.Albert
 * @Data 8/9/17
 * @Time 12:50 PM
 * @Version 1.0
 * @Info empty
 */

public class BandBreakADate {

    public static Band breakADate(Band band) {
        band.setCreateDate(new Date());
        band.setYear(DateUtils.getYear(band.getDateBand()));
        band.setMonth(DateUtils.getMonthName(band.getDateBand()));
        band.setDay(DateUtils.getDay(band.getDateBand()));

        return band;
    }

    public static int getDiffTimes(String startTime, String endTime) {
        return 0;
    }
}
