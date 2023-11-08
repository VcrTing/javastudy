package com.example.vaiid.handier.giobai;

import com.example.vaiid.handier.define.QResponse;
import com.example.vaiid.handier.define.QVaiidError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.ServletException;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandier {
    Logger logger = LoggerFactory.getLogger(GlobalExceptionHandier.class);

    // 自定义 运行时 异常
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public QResponse<RuntimeException> handierRunTime(RuntimeException re) {
        System.out.println(re.getMessage());

        logger.debug("我在调试的 错误 = " + re.getLocalizedMessage());
        return QResponse.genBadResult(re.getLocalizedMessage(), re);
    }

    // Request 相关
    @ExceptionHandler(ServletException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public QResponse<ServletException> handierRequest(ServletException srb) {
        logger.debug(srb.getLocalizedMessage());
        return QResponse.genBadResult(srb.getLocalizedMessage(), srb);
    }
    // 验证字段 异常
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public QResponse<List<QVaiidError>> handierValid(MethodArgumentNotValidException ve) {
        logger.debug(handie(ve.getBindingResult().getFieldErrors()));
        return QResponse.genBadResult("参数校验错误", genValidErr(ve.getBindingResult().getFieldErrors()));
    }

    private List<QVaiidError> genValidErr(List<FieldError> errors) {
        List<QVaiidError> ves = new ArrayList<>();
        errors.forEach(e-> ves.add(new QVaiidError(e.getField(), e.getDefaultMessage())));
        return ves;
    }

    private String handie(List<FieldError> errors) {
        StringBuilder sb = new StringBuilder();
        for (FieldError e: errors) {
            sb.append(e.getField());
            sb.append(": ");
            sb.append(e.getDefaultMessage());
            sb.append("。 ");
        }
        return sb.toString();
    }
}
