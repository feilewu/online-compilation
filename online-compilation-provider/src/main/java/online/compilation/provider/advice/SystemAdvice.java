package online.compilation.provider.advice;

import online.compilation.provider.controller.dto.Response;
import online.compilation.provider.exception.UserFriendlyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author: pf_xu
 * @date: 2021/5/24 23:42
 * @Email:pfxuchn@gmail.com
 */
@RestControllerAdvice
public class SystemAdvice {

    @ExceptionHandler(value = Exception.class)
    public Response errorHandler(Exception e) {
        if(e instanceof UserFriendlyException){
            return Response.fail(e.getMessage());
        }
        return Response.fail(e.getMessage());
    }


}
