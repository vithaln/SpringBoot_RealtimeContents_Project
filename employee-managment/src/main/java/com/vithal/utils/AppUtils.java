package com.vithal.utils;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.vithal.constant.AppConstant;
import com.vithal.dto.ResponseStatus;

@Slf4j
public class AppUtils {

    public static String getStringFormattedDate(LocalDateTime dateTime) {
        String formattedDate = dateTime.format(DateTimeFormatter.ofPattern("dd-MM-yyyy-HH-mm-ss"));
        log.info("[LocalDateTime] : {} \n[FormattedDate of Pattern(dd-MM-yyyy-HH-mm-ss)] : {}", dateTime, formattedDate);
        return formattedDate;
    }

    public static String getSimpleStringFormattedDate(LocalDateTime dateTime) {
        String formattedDate = dateTime.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        log.info("[LocalDateTime] : {} \n[FormattedDate of Pattern(dd-MM-yyyy)] : {}", dateTime, formattedDate);
        return formattedDate;
    }

    public static ResponseStatus getSuccessStatus() {
        ResponseStatus responseStatus = new ResponseStatus();
        responseStatus.setStatusCode(AppConstant.SUCCESS_CODE);
        responseStatus.setStatusMsg(AppConstant.SUCCESS_MSG);
        return responseStatus;
    }

    public static ResponseStatus getErrorStatus() {
        ResponseStatus responseStatus = new ResponseStatus();
        responseStatus.setStatusCode(AppConstant.FAILURE_CODE);
        responseStatus.setStatusMsg(AppConstant.FAILURE_MSG);
        return responseStatus;
    }
}
