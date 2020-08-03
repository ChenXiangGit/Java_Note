package com.meifute.restructure.mmopenfeign.config.exception;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@Slf4j
@ControllerAdvice
public class ResourceAdvice {

    @Autowired
    private ExceptionService exceptionService;

    @ExceptionHandler(MallException.class)
    public ResponseEntity<ExceptionDetail> handleBizException(MallException e) {
        ExceptionDetail exceptionDetail = new ExceptionDetail();
        String message = exceptionService.getMessageDetailByCode(e.getCode(), e.getArgs());
        if (ObjectUtils.isEmpty(message)) {
            if (ObjectUtils.isEmpty(e.getMessage())) {
                message = "未知异常";
            } else {
                message = e.getMessage();
            }
        }
        e.setMsg(message);
        log.info("the system have a MallException:{}", e);
        exceptionDetail.setCurrentSystemTimeStamp(String.valueOf(System.currentTimeMillis()));
//        exceptionDetail.setBaseResponse(new BaseResponse(e.getCode(), message));
        return new ResponseEntity<>(exceptionDetail, HttpStatus.BAD_REQUEST);
    }


//
//    @ExceptionHandler(AccessDeniedException.class)
//    public ResponseEntity<ExceptionDetail> handleAccessDeniedException(AccessDeniedException e) {
//        ExceptionDetail exceptionDetail = new ExceptionDetail();
//        String message = exceptionService.getMessageDetailByCode(RespCode.ACCESS_IS_DENIED);
//        log.info("the system have a Exception:{},{}", "无权限访问", e);
//        exceptionDetail.setCurrentSystemTimeStamp(String.valueOf(System.currentTimeMillis()));
//        //e.getMessage()这个返回值为Null
//        exceptionDetail.setBaseResponse(new BaseResponse(RespCode.ACCESS_IS_DENIED, message));
//        return new ResponseEntity<>(exceptionDetail, HttpStatus.BAD_REQUEST);
//    }
//
////    @ExceptionHandler(OAuth2Exception.class)
////    public ResponseEntity<ExceptionDetail> handleOAuth2Exception(Exception e){
////        String message = exceptionService.getMessageDetailByCode(RespCode.SYSTEM_UP);
////
////    }
//
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<ExceptionDetail> handleBizException(Exception e) {
//        ExceptionDetail exceptionDetail = new ExceptionDetail();
//        String message = exceptionService.getMessageDetailByCode(RespCode.SYSTEM_ERROR);
//        log.info("the system have a Exception:{},{}", "系统异常", e);
//        exceptionDetail.setCurrentSystemTimeStamp(String.valueOf(System.currentTimeMillis()));
//        //e.getMessage()这个返回值为Null
//        exceptionDetail.setBaseResponse(new BaseResponse(RespCode.SYSTEM_ERROR, message));
//        return new ResponseEntity<>(exceptionDetail, HttpStatus.BAD_REQUEST);
//    }
//
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<ExceptionDetail> MallMethodArgumentNotValidException(MethodArgumentNotValidException e) {
//        BindingResult bindingResult = e.getBindingResult();
//        ExceptionDetail exceptionDetail = new ExceptionDetail();
//        exceptionDetail.setCurrentSystemTimeStamp(String.valueOf(System.currentTimeMillis()));
//        exceptionDetail.setBaseResponse(new BaseResponse(HttpStatus.BAD_REQUEST.toString(), bindingResult.getFieldError().getField() + bindingResult.getFieldError().getDefaultMessage()));
//        return new ResponseEntity<>(exceptionDetail, HttpStatus.BAD_REQUEST);
//    }

}
