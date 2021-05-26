package online.compilation.provider.exception;

/**
 * @author: pf_xu
 * @date: 2021/5/24 22:07
 * @Email:pfxuchn@gmail.com
 */
public class UserFriendlyException extends RuntimeException{

    private static final long serialVersionUID = -7671075699640449654L;

    public UserFriendlyException(Throwable cause) {
        super(cause);
    }

    public UserFriendlyException(String message) {
        super(message);
    }
}
