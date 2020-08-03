package com.meifute.restructure.mmopenfeign.config.exception;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExceptionDetail<T> {

    private String currentSystemTimeStamp;

    private String rtnCode;

    private String rtnExt;

    private String rtnFtype;

    private String rtnMsg;

    private String rtnTip;



    private T data;

}
