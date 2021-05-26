package online.compilation.provider.core;

import online.compilation.provider.exception.UserFriendlyException;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;
import java.util.UUID;

/**
 * @author: pf_xu
 * @date: 2021/5/24 21:23
 * @Email:pfxuchn@gmail.com
 */
@Component("java8Compiler")
class Java8Compiler implements Compiler {

    @Override
    public boolean support(CompilerType compilerType) {
        return CompilerType.JAVA_8.equals(compilerType);
    }

    @Override
    public Target compiler(Source source) {
//       String classPath = Objects.requireNonNull(this.getClass().getResource("/")).getPath();
        try {
            Path temp = Files.createTempFile("resource-"+UUID.randomUUID(), ".ext");
            FileOutputStream fileOutputStream = new FileOutputStream(temp.toFile());
            int index;
            byte[] buffer = new byte[4096*200];
            while ((index = source.getInputStream().read(buffer)) != -1) {
                fileOutputStream.write(buffer, 0, index);
                fileOutputStream.flush();
            }
            fileOutputStream.close();
            return new FileTarget(temp.toFile());
        }catch (IOException ioException){
            throw new  UserFriendlyException(ioException);
        }
    }


}
