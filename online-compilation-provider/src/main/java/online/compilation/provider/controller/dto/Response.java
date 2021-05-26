package online.compilation.provider.controller.dto;

import lombok.Data;

/**
 * @author: pf_xu
 * @date: 2021/5/24 20:35
 * @Email:pfxuchn@gmail.com
 */
@Data
public class Response {

    private boolean success;

    private String errorCode;

    private String errorMessage;

    private Object date;

    public static Response fail(String errorMessage){
        Response response = new Response();
        response.setErrorMessage(errorMessage);
        return response;
    }

}
