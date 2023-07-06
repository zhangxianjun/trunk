package team.flint.trunk.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


@Slf4j
public class ControllerExceptionAdvice {

    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    @ExceptionHandler(value = {
            Exception.class,
            ServerException.class
    })
    public String handleServerException(Exception e) {
        log.error("ServerException", e);
        return e.getMessage();
    }

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ResponseBody
    @ExceptionHandler(value = {
            ClientException.class
    })
    public String handleClientException(Exception e) {
        log.error("ClientException", e);
        return e.getMessage();
    }
}
