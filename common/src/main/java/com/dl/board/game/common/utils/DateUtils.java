package com.dl.board.game.common.utils;



import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName DateUtil
 * @Description 日期工具类
 * @dateTime 2014-12-1 下午6:17:29
 */
public final class DateUtils extends org.apache.commons.lang3.time.DateUtils {

    public static final String PATTERN_DATE_SHORT = "yyyyMMdd";
    public static final String PATTERN_DATE_MS = "yyMMddHHmmssss";
    public static final String PATTERN_DATE_FULL_MS = "yyyyMMddHHmmss";
    public static final String PATTERN_DATE_HH = "yyMMddHH";
    public static final String PATTERN_DATE = "yyyy-MM-dd";
    public static final String PATTERN_MONTH = "yyyy-MM";
    public static final String PATTERN_DATE_TIME_MS = "yyyy-MM-dd HH:mm:ssss";
    public static final String PATTERN_DATE_TIME = "yyyy-MM-dd HH:mm:ss";
    public static final String PATTERN_DATE_MINUTES = "yyyy-MM-dd HH:mm";
    public static final String PATTERN_DATE_TIME_SHORT = "yyyy-MM-dd HH-mm-ss";

    private DateUtils() {

    }

    /**
     * 获取日期23点59分59秒
     *
     * @param date
     * @return
     */
    public static Date getLastOfDate(Date date) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        instance.set(Calendar.HOUR_OF_DAY, 23);
        instance.set(Calendar.MINUTE, 59);
        instance.set(Calendar.SECOND, 59);
        instance.set(Calendar.MILLISECOND, 999);
        return instance.getTime();
    }

    public static Date getFirstOfDate(Date date) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        instance.set(Calendar.HOUR_OF_DAY, 0);
        instance.set(Calendar.MINUTE, 0);
        instance.set(Calendar.SECOND, 0);
        instance.set(Calendar.MILLISECOND, 0);
        return instance.getTime();
    }


    public static Calendar date2Calendar(Date date) {
        return new Calendar.Builder().setInstant(date).build();
    }

    /**
     * 通过时间秒毫秒数判断两个时间的间隔
     * @param date1
     * @param date2
     * @return
     */
    public static int differentDaysByMillisecond(Date date1,Date date2)
    {
        int days = (int) ((date2.getTime() - date1.getTime()) / (1000*3600*24));
        return days;
    }
    /**
     * @param d
     * @return
     * @Title dateToStryyyymmddhhmmssss
     * @Description 格式化日期 yyyy-MM-dd HH:mm:ssss
     * @dateTime 2014-12-2 下午2:47:49
     */
    public static String dateToStryyyymmddhhmmssss(Date d) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(PATTERN_DATE_TIME_MS);
        return dateFormat.format(d);
    }

    /**
     * @param d
     * @param formatPattern 格式
     * @return
     * @Title formatDateToString
     * @Description 格式化日期
     * @dateTime 2014-12-2 下午2:49:04
     */
    public static String formatDateToString(Date d, String formatPattern) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(formatPattern);
        return dateFormat.format(d);
    }

    /**
     * @param d
     * @return
     * @Title formatDateToStringShort
     * @Description 格式化日期
     * @dateTime 2014-12-2 下午2:49:27
     */
    public static String formatDateToStringShort(Date d) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(PATTERN_DATE);
        return dateFormat.format(d);
    }

    /**
     * @param d
     * @return
     * @Title formatDateToStringHH
     * @Description 格式化日期
     * @dateTime 2014-12-2 下午2:49:25
     */
    public static String formatDateToStringHH(Date d) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(PATTERN_DATE_HH);
        return dateFormat.format(d);
    }

    /**
     * @param d
     * @return
     * @Title formatDateToStringMs
     * @Description 格式化日期
     * @dateTime 2014-12-2 下午2:50:02
     */
    public static String formatDateToStringMs(Date d) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(PATTERN_DATE_MS);
        return dateFormat.format(d);
    }

    public static String formatDateToStringFullMs(Date d) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(PATTERN_DATE_FULL_MS);
        return dateFormat.format(d);
    }

    /**
     * @param d
     * @return
     * @Title formatDateToStringDefault
     * @Description 格式化日期
     * @dateTime 2014-12-2 下午2:50:11
     */
    public static String formatDateToStringDefault(Date d) {
        if (d == null) {
            return "";
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat(PATTERN_DATE_TIME);
        return dateFormat.format(d);
    }

    /**
     * @param dateString
     * @param formatPattern
     * @return
     * @throws ParseException
     * @Title formatStringToDate
     * @Description 格式化日期
     * @dateTime 2014-12-2 下午2:50:21
     */
    public static Date formatStringToDate(String dateString, String formatPattern) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat(formatPattern);
        return dateFormat.parse(dateString);
    }

    public static Date formatStringShortToDate(String dateString) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(PATTERN_DATE);
        try {
            return dateFormat.parse(dateString);
        } catch (ParseException e) {
            LogService.error("DateUtils formatStringShortToDate error dateString=" + dateString, e);
            return null;
        }
    }

    /**
     * @param dateString
     * @return
     * @throws ParseException
     * @Title formatStringToDateDefault
     * @Description 格式化日期
     * @dateTime 2014-12-2 下午2:50:35
     */
    public static Date formatStringToDateDefault(String dateString) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat(PATTERN_DATE_TIME);
        return dateFormat.parse(dateString);
    }

    public static Date formatStringToDate(String dateString) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(PATTERN_DATE_TIME);
        try {
            return dateFormat.parse(dateString);
        } catch (ParseException e) {
            LogService.error("formatStringToDateDefault error", e);
        }
        return null;
    }

    /**
     * @return
     * @Title getCurrentMonth
     * @Description 获取当前月
     * @dateTime 2014-12-2 下午3:02:26
     */
    public static Date getCurrentMonth() {
        Calendar thisMonthStart = Calendar.getInstance();
        thisMonthStart.set(Calendar.DAY_OF_MONTH, 1);
        thisMonthStart.set(Calendar.HOUR_OF_DAY, 0);
        thisMonthStart.set(Calendar.MINUTE, 0);
        thisMonthStart.set(Calendar.SECOND, 0);
        thisMonthStart.set(Calendar.MILLISECOND, 0);
        return thisMonthStart.getTime();
    }

    /**
     * @return
     * @Title getCurrentDate
     * @Description 获取当天日期
     * @dateTime 2014-12-2 下午3:02:01
     */
    public static Date getCurruntDate() {
        Calendar thisMonthStart = Calendar.getInstance();
        return thisMonthStart.getTime();
    }

    /**
     * @return
     * @Title getCurruntDateForString
     * @param formatPattern 时间格式
     * @Description 获取当天日期字符串，默认格式：yyyy-MM-dd HH:mm:ss
     * @dateTime 2014-12-2 下午3:02:01
     */
    public static String getCurruntDateForString(String formatPattern) {
        Calendar thisMonthStart = Calendar.getInstance();
        if(StringUtils.isEmpty(formatPattern)) {
            formatPattern = PATTERN_DATE_TIME_SHORT;
        }
        return formatDateToString(thisMonthStart.getTime(), formatPattern);
    }

    /**
     * @param calendarType type of Calendar
     * @return
     * @Title getFistTimeByCalType
     * @Description 获取第一天
     * @dateTime 2014-12-2 下午3:01:37
     */
    public static Date getFistTimeByCalType(int calendarType) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());

        if (calendarType != Calendar.WEEK_OF_YEAR) {
            switch (calendarType) {
                case Calendar.YEAR:
                    cal.set(Calendar.MONTH, 0);
                case Calendar.MONTH:
                    cal.set(Calendar.DAY_OF_MONTH, 1);
                case Calendar.DAY_OF_MONTH:
                    cal.set(Calendar.HOUR_OF_DAY, 0);
                case Calendar.HOUR_OF_DAY:
                    cal.set(Calendar.MINUTE, 0);
                    cal.set(Calendar.SECOND, 0);
                    cal.set(Calendar.MILLISECOND, 0);
                    break;
                default:
                    throw new IllegalArgumentException("The date cut type parameter is wrong.");
            }
        } else {
            cal.set(Calendar.DAY_OF_WEEK, 1);
            cal.set(Calendar.HOUR_OF_DAY, 0);
            cal.set(Calendar.MINUTE, 0);
            cal.set(Calendar.SECOND, 0);
            cal.set(Calendar.MILLISECOND, 0);
        }
        return cal.getTime();
    }

    /**
     * @return
     * @Title getLastMonth
     * @Description 上一个月
     * @dateTime 2014-12-2 下午3:01:08
     */
    public static Date getLastMonth() {
        Calendar lastMonthStart = Calendar.getInstance();

        lastMonthStart.set(Calendar.DAY_OF_MONTH, 1);
        lastMonthStart.set(Calendar.HOUR_OF_DAY, 0);
        lastMonthStart.set(Calendar.MINUTE, 0);
        lastMonthStart.set(Calendar.SECOND, 0);
        lastMonthStart.set(Calendar.MILLISECOND, 0);
        lastMonthStart.add(Calendar.MONTH, -1);

        return lastMonthStart.getTime();
    }

    /**
     * @return
     * @Title getNextMonth
     * @Description 下一个月
     * @dateTime 2014-12-2 下午3:00:57
     */
    public static Date getNextMonth() {
        Calendar nextMonthStart = Calendar.getInstance();

        nextMonthStart.set(Calendar.DAY_OF_MONTH, 1);
        nextMonthStart.set(Calendar.HOUR_OF_DAY, 0);
        nextMonthStart.set(Calendar.MINUTE, 0);
        nextMonthStart.set(Calendar.SECOND, 0);
        nextMonthStart.set(Calendar.MILLISECOND, 0);
        nextMonthStart.add(Calendar.MONTH, 1);

        return nextMonthStart.getTime();
    }

    /**
     * @return
     * @Title getNextMonth
     * @Description 下一个月25号
     * @dateTime 2014-12-2 下午3:00:57
     */
    public static Date getNextMonth25() {
        Calendar nextMonthStart = Calendar.getInstance();

        nextMonthStart.set(Calendar.DAY_OF_MONTH, 25);
        nextMonthStart.set(Calendar.HOUR_OF_DAY, 0);
        nextMonthStart.set(Calendar.MINUTE, 0);
        nextMonthStart.set(Calendar.SECOND, 0);
        nextMonthStart.set(Calendar.MILLISECOND, 0);
        nextMonthStart.add(Calendar.MONTH, 1);

        return nextMonthStart.getTime();
    }



    /**
     * 根据给定的日期查找下一个月的开始时间
     *
     * @param d
     * @return
     */
    public static Date getNextMonth(Date d) {
        Calendar cal = Calendar.getInstance();

        cal.setTime(d);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) + 1);

        return cal.getTime();
    }

    /**
     * 根据给定日期找出本月开始时间
     *
     * @param d
     * @return
     */
    public static Date getCurrentMonth(Date d) {
        Calendar cal = Calendar.getInstance();

        cal.setTime(d);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);

        return cal.getTime();
    }

    /**
     * @return
     * @Title getTomorrow
     * @Description 获取明天时间
     * @dateTime 2014-12-2 下午2:59:34
     */
    public static Date getTomorrow() {
        return getNextDay(new Date());
    }

    /**
     * @return
     * @Title getAfterTomorrow
     * @Description 获取后天时间
     * @dateTime 2014-12-2 下午2:59:52
     */
    public static Date getAfterTomorrow() {
        Calendar cal = Calendar.getInstance();

        cal.setTime(new Date());
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        cal.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH) + 2);

        return cal.getTime();
    }

    /**
     * @return
     * @Title isAfterThreeDay
     * @Description 判断日期是否在三天前
     * @dateTime 2018-04-11 下午3:57:52
     */
    public static Boolean isAfterThreeDay(Date date) {
        Calendar cal = Calendar.getInstance();

        cal.setTime(new Date());
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        cal.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH) - 3);

        return date.after(cal.getTime());
    }

    /**
     * @param d
     * @return
     * @Title getNextDay
     * @Description 获取下一天
     * @dateTime 2014-12-2 下午3:00:28
     */
    public static Date getNextDay(Date d) {
        Calendar cal = Calendar.getInstance();

        cal.setTime(d);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        cal.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH) + 1);

        return cal.getTime();
    }
    /**
     * @param
     * @return
     * @Title getNextDay
     * @Description 获取当天的开始时间
     * @dateTime 2014-12-2 下午3:00:28
     */
    public static Date getDay() {
        Calendar cal = Calendar.getInstance();

        cal.setTime(new Date());
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        cal.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH));

        return cal.getTime();
    }

    /**
     * @param
     * @return
     * @Title getNextDay
     * @Description 获取今天0点
     * @dateTime 2014-12-2 下午3:00:28
     */
    public static Date getCurrentDay() {
        Calendar cal = Calendar.getInstance();

        cal.setTime(new Date());
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        cal.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH));

        return cal.getTime();
    }

    /**
     * 判断统计的是否是当年的数据
     */
    public static boolean isBeforeYear(Date startdate) {
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int curryear = cal.get(Calendar.YEAR);
        cal.setTime(startdate);
        int flagyear = cal.get(Calendar.YEAR);
        return flagyear < curryear;
    }

    /**
     * 判断统计的是否是当年的数据
     */
    public static boolean isBeforeDay(Date startdate) {

        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int currDay = cal.get(Calendar.DAY_OF_YEAR);
        int currYear = cal.get(Calendar.YEAR);
        cal.setTime(startdate);
        int flagDay = cal.get(Calendar.DAY_OF_YEAR);
        int flagYear = cal.get(Calendar.YEAR);

        if (flagYear < currYear) {
            return true;
        }

        if (flagYear > currYear) {
            return false;
        }

        return flagDay <= currDay;
    }

    /**
     * 判断统计的是否是当年的数据
     */
    public static boolean isBeforeMonth(Date startdate) {
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int currmonth = cal.get(Calendar.MONTH);
        int currYear = cal.get(Calendar.YEAR);
        cal.setTime(startdate);
        int flagmonth = cal.get(Calendar.MONTH);
        int flagYear = cal.get(Calendar.YEAR);

        if (flagYear < currYear) {
            return true;
        } else if (flagYear > currYear) {
            return false;
        } else {
            return flagmonth <= currmonth;
        }
    }

    /**
     * 判断月份是否在当前月后
     */
    public static boolean isAfterMonth(Date startdate) {
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int currmonth = cal.get(Calendar.MONTH);
        int currYear = cal.get(Calendar.YEAR);
        cal.setTime(startdate);
        int flagmonth = cal.get(Calendar.MONTH);
        int flagYear = cal.get(Calendar.YEAR);

        if (flagYear > currYear) {
            return true;
        }

        if (flagYear < currYear) {
            return false;
        }
        return flagmonth >= currmonth;
    }

    /**
     * 判断日期是否在当前日后
     */
    public static boolean isAfterDay(Date startdate) {
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int currday = cal.get(Calendar.DAY_OF_YEAR);
        int currYear = cal.get(Calendar.YEAR);
        cal.setTime(startdate);
        int flagday = cal.get(Calendar.DAY_OF_YEAR);
        int flagYear = cal.get(Calendar.YEAR);

        if (flagYear > currYear) {
            return true;
        }

        if (flagYear < currYear) {
            return false;
        }
        return flagday >= currday;
    }

    /**
     * 判断是否是当月的数据
     */
    public static boolean isCurrentMonth(Date startdate) {
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int currmonth = cal.get(Calendar.MONTH);
        int currYear = cal.get(Calendar.YEAR);
        cal.setTime(startdate);
        int flagmonth = cal.get(Calendar.MONTH);
        int flagYear = cal.get(Calendar.YEAR);

        if (flagYear == currYear) {
            if (currmonth == flagmonth) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断是否是当月的数据
     */
    public static boolean isCurrentWeek(Date startdate) {
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int currweek = cal.get(Calendar.WEEK_OF_YEAR);
        int currYear = cal.get(Calendar.YEAR);
        cal.setTime(startdate);
        int flagweek = cal.get(Calendar.WEEK_OF_YEAR);
        int flagYear = cal.get(Calendar.YEAR);

        if (flagYear == currYear) {
            if (currweek == flagweek) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断是否是当日
     *
     * @param startdate
     */
    public static boolean isCurrentDay(Date startdate) {
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int currDay = cal.get(Calendar.DAY_OF_YEAR);
        int currYear = cal.get(Calendar.YEAR);
        cal.setTime(startdate);
        int flagDay = cal.get(Calendar.DAY_OF_YEAR);
        int flagYear = cal.get(Calendar.YEAR);

        if (flagYear == currYear) {
            if (currDay == flagDay) {
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @param date1 这个是比较的对象
     * @param date2
     * @return
     */
    public static  boolean isSameAndAfterTime(Date date1, Date date2){
        long date1Time = date1.getTime();
        long date2Time = date2.getTime();
        if (date1Time <= date2Time){
            return true;
        }
        return false;
    }

    /**
     *
     * @param date1 这个是比较的对象
     * @param date2
     * @return
     */
    public static  boolean isSameAndBeforeTime(Date date1, Date date2){
        long date1Time = date1.getTime();
        long date2Time = date2.getTime();
        if (date1Time >= date2Time){
            return true;
        }
        return false;
    }
    /**
     * 得到当月的第一天
     */
    public static Date getStartDateMonth(Date d) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    /**
     * 得到当月的最后一天
     */
    public static Date lastDayOfMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        cal.add(Calendar.MONTH, 1);
        cal.add(Calendar.DATE, -1);
        return cal.getTime();
    }

    /**
     * 得到上月的最后一天
     */
    public static Date getEndDateOfLastMonth(Date d) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        cal.set(Calendar.DAY_OF_MONTH, 0);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    /**
     * 得到下月的第一天
     */
    public static Date getStartDateOfNextMonth(Date d) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        cal.add(Calendar.MONTH, 1);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    /**
     * 得到昨天零点的date
     */
    public static Date getZeroOfYesterday() {
        Calendar yesterdayCal = Calendar.getInstance();
        yesterdayCal.add(Calendar.DAY_OF_MONTH, -1);
        yesterdayCal.set(Calendar.HOUR_OF_DAY, 0);
        yesterdayCal.set(Calendar.MINUTE, 0);
        yesterdayCal.set(Calendar.SECOND, 0);
        yesterdayCal.set(Calendar.MILLISECOND, 0);
        return yesterdayCal.getTime();
    }

    /**
     * 得到今天零点的date
     */
    public static Date getZeroOfToday() {
        Calendar todayCal = Calendar.getInstance();
        todayCal.set(Calendar.HOUR_OF_DAY, 0);
        todayCal.set(Calendar.MINUTE, 0);
        todayCal.set(Calendar.SECOND, 0);
        todayCal.set(Calendar.MILLISECOND, 0);
        return todayCal.getTime();
    }

    /**
     * 得到时间的零点date
     */
    public static Date getZeroOfToday(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    /**
     * 得到上周一零点的date
     */
    public static Date getZeroOfLastMonday() {
        Calendar lastMondayCal = Calendar.getInstance();

        lastMondayCal.add(Calendar.WEEK_OF_MONTH, -1);
        lastMondayCal.set(Calendar.DAY_OF_WEEK, 2);
        lastMondayCal.set(Calendar.HOUR_OF_DAY, 0);
        lastMondayCal.set(Calendar.MINUTE, 0);
        lastMondayCal.set(Calendar.SECOND, 0);
        lastMondayCal.set(Calendar.MILLISECOND, 0);

        return lastMondayCal.getTime();
    }

    /**
     * 得到上周日零点的date
     */
    public static Date getZeroOfLastSunday() {
        Calendar lastSundayCal = Calendar.getInstance();

        lastSundayCal.set(Calendar.DAY_OF_WEEK, 1);
        lastSundayCal.set(Calendar.HOUR_OF_DAY, 0);
        lastSundayCal.set(Calendar.MINUTE, 0);
        lastSundayCal.set(Calendar.SECOND, 0);
        lastSundayCal.set(Calendar.MILLISECOND, 0);

        return lastSundayCal.getTime();
    }

    /**
     * 得到时间零点的date
     */
    public static Date getZeroDate(Date date) throws ParseException {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);

        return cal.getTime();
    }

    /**
     * 增加或减少时间的月数
     */
    public static Date addMonth(Date date, int m) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(date.getTime());
        cal.add(Calendar.MONTH, m);

        return cal.getTime();
    }

    /**
     * 增加或减少时间的天数
     */
    public static Date addDay(Date date, int d) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(date.getTime());
        cal.add(Calendar.DATE, d);

        return cal.getTime();
    }

    public static Date addHour(Date date, int v) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.HOUR, v);

        return cal.getTime();
    }

    /**
     * 得到两个日期时间相差几秒
     * @param early 小一点的时间
     * @param late 大一点的时间
     * @return
     */
    public static int getSecondSpace(Date early, Date late) {
        //得到两个日期相差几秒
        int hours = (int) ((late.getTime()- early.getTime()) / 1000);
        return hours;
    }

    /**
     * 小时*60= min
     * @param date
     * @param v
     * @return
     */
    public static Date addMinute(Date date, int v) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MINUTE, v);

        return cal.getTime();
    }

    public static Date addSecond(Date date, int v) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.SECOND, v);

        return cal.getTime();
    }

    public static Date addMillSecond(Date date, int v) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MILLISECOND, v);

        return cal.getTime();
    }

    // is the fisrt day of the month
    public static boolean isFirstDayOfMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        return cal.get(Calendar.DAY_OF_MONTH) == 1;
    }

    /**
     * 求两个时间差
     */
    public static long getDaysBetweenMonth(Date date, Date now) {
        long l = now.getTime() - date.getTime();

        return l / (24 * 60 * 60 * 1000);
    }

    /**
     * @param num
     * @return
     * @Title Days
     * @Description 获取天数对应的秒数
     * @dateTime 2014-12-2 下午2:58:10
     */
    public static int days(int num) {
        return num * 24 * 60 * 60;
    }

    /**
     * @param num
     * @return
     * @Title Hours
     * @Description 获取小时数对应的秒数
     * @dateTime 2014-12-2 下午2:58:44
     */
    public static int hours(int num) {
        return num * 60 * 60;
    }

    /**
     * @param num
     * @return
     * @Title Minutes
     * @Description 获取分钟数对应的秒数
     * @dateTime 2014-12-2 下午2:58:56
     */
    public static int minutes(int num) {
        return num * 60;
    }

    /**
     * @param num
     * @return
     * @Title Seconds
     * @Description 获取秒数
     * @dateTime 2014-12-2 下午2:59:06
     */
    public static int seconds(int num) {
        return num;
    }

    /**
     * 获取当前日期是星期几<br>
     *
     * @return 当前日期是星期几
     */
    public static int getDayOfWeek() {
        Calendar now = Calendar.getInstance();
        //一周第一天是否为星期天
        boolean isFirstSunday = (now.getFirstDayOfWeek() == Calendar.SUNDAY);
        //获取周几
        int weekDay = now.get(Calendar.DAY_OF_WEEK);
        //若一周第一天为星期天，则-1
        if (isFirstSunday) {
            weekDay = weekDay - 1;
            if(weekDay == 0) {
                weekDay = 7;
            }
        }
        return weekDay;
    }

    public static String getDateStringOfWeek(String date, int dayOfWeek) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(PATTERN_DATE);
        Calendar cal = Calendar.getInstance();
        cal.setTime(sdf.parse(date));
        cal.set(Calendar.DAY_OF_WEEK, dayOfWeek); //获取本周日的日期
        return sdf.format(cal.getTime());
    }

    /**
     * 获取当前日期的整点小时，如：09: 00
     *
     * @return
     */
    public static String getCurrentHours(){
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, cal.get(Calendar.HOUR_OF_DAY));
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
        return dateFormat.format(cal.getTime());
    }

    /**
     * 获取指定日期在今年的第几周
     * @param date
     * @return
     */
    public static int getWeekOfYear(Date date) {
        Calendar cal = Calendar.getInstance();
        if(date != null) {
            cal.setTime(date);
        }
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        cal.setMinimalDaysInFirstWeek(Calendar.MONDAY);
        int weeks = cal.get(Calendar.WEEK_OF_YEAR);
        return weeks;
    }

    /**
     * 获取当前日期
     * @return
     */
    public static String getCurruntDateForString(){
        return  getCurruntDateForString("yyyy-MM-dd");
    }


    /**
     * 获取当前日期最后一个时候
     * @return
     */
    public static Date getLastDate(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY,23);
        calendar.set(Calendar.MINUTE,59);
        calendar.set(Calendar.SECOND,59);
        calendar.set(Calendar.MILLISECOND, 0);
        return  calendar.getTime();
    }

    public static Date getLastDate(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY,23);
        calendar.set(Calendar.MINUTE,59);
        calendar.set(Calendar.SECOND,59);
        calendar.set(Calendar.MILLISECOND, 0);
        return  calendar.getTime();
    }


    /**
     * 获取多少天后的最后一刻
     * @param date
     * @param day
     * @return
     */
    public static Date getDateLastDateTime(Date date,int day){
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(date.getTime());
        calendar.add(Calendar.DATE, day);
        calendar.set(Calendar.HOUR_OF_DAY,23);
        calendar.set(Calendar.MINUTE,59);
        calendar.set(Calendar.SECOND,59);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }


    /**
     * 判断是否同一天
     * @param date1
     * @param date2
     * @return
     */
    public static boolean isSameDay(Date date1, Date date2) {
        if(date1 != null && date2 != null) {
            Calendar cal1 = Calendar.getInstance();
            cal1.setTime(date1);
            Calendar cal2 = Calendar.getInstance();
            cal2.setTime(date2);
            return isSameDay(cal1, cal2);
        } else {
            throw new IllegalArgumentException("The date must not be null");
        }
    }

    public static boolean isSameDay(Calendar cal1, Calendar cal2) {
        if(cal1 != null && cal2 != null) {
            return cal1.get(0) == cal2.get(0) && cal1.get(1) == cal2.get(1) && cal1.get(6) == cal2.get(6);
        } else {
            throw new IllegalArgumentException("The date must not be null");
        }
    }

    public static String getDayOfWeekCN(){
        int day = getDayOfWeek();
        switch (day){
            case 1 :
                return "一";
            case 2 :
                return "二";
            case 3 :
                return "三";
            case 4 :
                return "四";
            case 5 :
                return "五";
            case 6 :
                return "六";
            case 7 :
                return "七";
            default:
                return "";
        }
    }

    /**
     * local时间转换成UTC时间
     * @param localDate 当前时间
     * @return
     */
    public static Date localToUTC(Date localDate) {

        long localTimeInMillis=localDate.getTime();
        /** long时间转换成Calendar */
        Calendar calendar= Calendar.getInstance();
        calendar.setTimeInMillis(localTimeInMillis);
        /** 取得时间偏移量 */
        int zoneOffset = calendar.get(Calendar.ZONE_OFFSET);
        /** 取得夏令时差 */
        int dstOffset = calendar.get(Calendar.DST_OFFSET);
        /** 从本地时间里扣除这些差量，即可以取得UTC时间*/
        calendar.add(Calendar.MILLISECOND, -(zoneOffset + dstOffset));
        /** 取得的时间就是UTC标准时间 */
        Date utcDate=new Date(calendar.getTimeInMillis());
        return utcDate;
    }

    /**
     * utc时间转成local时间
     * @param utcTime
     * @return
     */
    public static Date utcToLocal(Date utcTime){
        long localTimeInMillis=utcTime.getTime();
        /** long时间转换成Calendar */
        Calendar calendar= Calendar.getInstance();
        calendar.setTimeInMillis(localTimeInMillis);
        /** 取得时间偏移量 */
        int zoneOffset = calendar.get(Calendar.ZONE_OFFSET);
        /** 取得夏令时差 */
        int dstOffset = calendar.get(Calendar.DST_OFFSET);
        /** 从本地时间里扣除这些差量，即可以取得UTC时间*/
        calendar.add(Calendar.MILLISECOND, (zoneOffset + dstOffset));
        /** 取得的时间就是UTC标准时间 */
        Date localDate=new Date(calendar.getTimeInMillis());
        return localDate;
    }

    public static String getLastDefinedTime(int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, -days);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        SimpleDateFormat sf = new SimpleDateFormat(PATTERN_DATE_TIME);
        return sf.format(calendar.getTime());
    }

    public static String getNowTime() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sf = new SimpleDateFormat(PATTERN_DATE_TIME);
        return sf.format(calendar.getTime());
    }

    /**
     * 获取现在到今天结束相差多少秒
     * @return
     */
    public static int getTodayEndSS(){
        //今天零点零分零秒的毫秒数
        long zero = LocalDateTime.of(LocalDate.now(), LocalTime.MIN).toInstant(ZoneOffset.ofHours(8)).toEpochMilli();
        //今天23点59分59秒的毫秒数
        long twelve = zero + 24 * 60 * 60 * 1000 - 1;
        //当前时间毫秒数
        long current = System.currentTimeMillis();
        return (int)((twelve - current) / 1000);
    }

    /**
     * 获取现在到今天结束相差多少秒
     * @return
     */
    public static int getTodayEndSS(Date date){
        //今天零点零分零秒的毫秒数
        long zero = LocalDateTime.of(LocalDate.now(), LocalTime.MIN).toInstant(ZoneOffset.ofHours(8)).toEpochMilli();
        //今天23点59分59秒的毫秒数
        long twelve = zero + 24 * 60 * 60 * 1000 - 1;
        //当前时间毫秒数
        long current = date.getTime();
        return (int)((twelve - current) / 1000);
    }

    /**
     * 获取现在到今天结束相差多少秒
     * @param current 当前的毫秒数
     * @return
     */
    public static int getTodayEndSS(long current){
        //今天零点零分零秒的毫秒数
        long zero = 0L;
        //今天23点59分59秒的毫秒数
        long twelve = zero + 24 * 60 * 60 * 1000;
        return (int)((twelve - current) / 1000);
    }
    /**
     *  获取当前时间 多少天前 或多少天后的零点
     * @param day 小于零：多少天前，大于零，多少天后的零点
     * @return
     */
    public static Date getZero(int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, day);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /**
     * 获取指定时间的前后多少天的零点
     * @param date
     * @param day
     * @return
     */
    public static Date getZero(Date date,int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, day);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /**
     * 得到两个日期时间相差的天数
     * @param early 小一点的时间
     * @param late 大一点的时间
     * @return
     */
    public static int getDateSpace(Date early, Date late) {
        Calendar calst = Calendar.getInstance();
        Calendar caled = Calendar.getInstance();
        calst.setTime(early);
        caled.setTime(late);
        //设置时间为0时
        calst.set(Calendar.HOUR_OF_DAY, 0);
        calst.set(Calendar.MINUTE, 0);
        calst.set(Calendar.SECOND, 0);
        caled.set(Calendar.HOUR_OF_DAY, 0);
        caled.set(Calendar.MINUTE, 0);
        caled.set(Calendar.SECOND, 0);
        //得到两个日期相差的天数
        int days = ((int) (caled.getTime().getTime() / 1000) - (int) (calst
                .getTime().getTime() / 1000)) / 3600 / 24;

        return days;
    }


    public static Integer getDays(String createTime, String updateTime) {
        try {
            Date var1 = formatStringToDateDefault(createTime);
            Date var2 = formatStringToDateDefault(updateTime);
            return (int) ((var2.getTime() - var1.getTime()) / (24 * 60 * 60 * 1000l));
        } catch (Exception e) {
            LogService.error("异常", e);
        }
        return 0;
    }

    public static Integer getMins(Date createTime, Date updateTime) {
        try {
            Date var1 = createTime;
            Date var2 = updateTime;
            return (int) ((var2.getTime() - var1.getTime()) / ( 60 * 1000l));
        } catch (Exception e) {
            LogService.error("异常", e);
        }
        return 0;
    }

    public static Long subtractDate(String dateStr1, String dateStr2) {
        long days = 0;
        try {
            Date date1 = DateUtils.formatStringToDate(dateStr1, "yyyy-MM-dd");
            Date date2 = DateUtils.formatStringToDate(dateStr2, "yyyy-MM-dd");
            long diff = date2.getTime() - date1.getTime();
            days = diff / (1000 * 60 * 60 * 24);
        } catch (ParseException e) {
            LogService.error("异常", e);
        }
        return days;
    }

    /**
     * 获取时间本周的第一天
     * @param date
     * @return
     */
    public static Date getFirstOfWeek(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int d = 0;
        if (cal.get(Calendar.DAY_OF_WEEK) == 1) {
            d = -6;
        } else {
            d = 2 - cal.get(Calendar.DAY_OF_WEEK);
        }
        cal.add(Calendar.DAY_OF_WEEK, d);
        // 所在周开始日期
        Date firstDate = cal.getTime();
        return firstDate;
    }

    /**
     * 得到两个日期时间相差几个小时
     * @param early 小一点的时间
     * @param late 大一点的时间
     * @return
     */
    public static int getHourSpace(Date early, Date late) {
        //得到两个日期相差几个小时
        return (int) ((late.getTime()- early.getTime()) / 1000 / 3600);
    }

    public static Map<String, Date> getStartDateAndEndDate(Date time) {
        Map<String, Date> map = new HashMap<>();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(time);
        calendar.set(Calendar.HOUR_OF_DAY,0);
        calendar.set(Calendar.MINUTE,0);
        calendar.set(Calendar.SECOND,0);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH));
        Date dayStart = calendar.getTime();

        calendar.set(Calendar.HOUR_OF_DAY,23);
        calendar.set(Calendar.MINUTE,59);
        calendar.set(Calendar.SECOND,59);
        calendar.set(Calendar.MILLISECOND, 999);
        Date dayEnd = calendar.getTime();

        map.put("dayStart", dayStart);
        map.put("dayEnd", dayEnd);
        return map;
    }
}