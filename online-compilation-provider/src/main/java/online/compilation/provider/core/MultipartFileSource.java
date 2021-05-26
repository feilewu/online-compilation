package online.compilation.provider.core;

import online.compilation.provider.exception.UserFriendlyException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author: pf_xu
 * @date: 2021/5/24 21:39
 * @Email:pfxuchn@gmail.com
 */
public class MultipartFileSource implements Source{

    private final MultipartFile multipartFile;

    private final InputStream inputStream;

    public MultipartFileSource(MultipartFile multipartFile){
        this.multipartFile = multipartFile;
        try {
            this.inputStream = multipartFile.getInputStream();
        }catch (IOException ioException){
            throw new UserFriendlyException(ioException);
        }
    }

    @Override
    public String getName() {
        return multipartFile.getOriginalFilename();
    }

    @Override
    public InputStream getInputStream(){
        return inputStream;
    }
}
