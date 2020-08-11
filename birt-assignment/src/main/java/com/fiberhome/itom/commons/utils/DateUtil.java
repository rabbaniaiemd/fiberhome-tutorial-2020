package com.fiberhome.itom.commons.utils;
/**
 * Copyright  Fiberhome pvt. ltd.
 * Plot no 19 Noida 127 (India)
 * All rights reserved.
 * <p>
 * This software is the confidential and proprietary information of
 * FiberHome, Inc. ("Confidential Information"). You shall not disclose such
 * Confidential Information and shall use it only in accordance with the terms
 * of the license agreement you entered into with FiberHome.
 * <p>
 */

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * DateUtil
 *
 * @author Md  Rabbani
 * @version 1.0 12-05-2019
 */
public class DateUtil {
    /**
     * getCurrentDate
     * @return String not null
     */
    public static String getCurrentDate() {
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return f.format(new Date());
    }

    /**
     * toMins
     * @param timeDuration
     * @return int
     */
    public static int toMins(String timeDuration) {
        String[] hourMin = timeDuration.split(":");
        int hour = Integer.parseInt(hourMin[0]);
        int mins = Integer.parseInt(hourMin[1]);
        int seconds=Integer.parseInt(hourMin[2]);
        int hoursInMins = hour * 60;
        return hoursInMins + mins;
    }
}
