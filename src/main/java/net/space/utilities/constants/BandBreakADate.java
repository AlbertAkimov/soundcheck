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
        band.setYear(DateUtils.getYear(band.getDataBand()));
        band.setMonth(DateUtils.getMonthName(band.getDataBand()));
        band.setDay(DateUtils.getDay(band.getDataBand()));

        return band;
    }
}
