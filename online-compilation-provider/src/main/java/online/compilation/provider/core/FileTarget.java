package online.compilation.provider.core;

import online.compilation.provider.exception.UserFriendlyException;

import java.io.*;

/**
 * @author: pf_xu
 * @date: 2021/5/24 22:04
 * @Email:pfxuchn@gmail.com
 */
public class FileTarget implements Target{

    private final File file;

    private final FileInputStream fileInputStream;

    public FileTarget(File file){
        this.file = file;
        try {
            this.fileInputStream = new FileInputStream(file);
        }catch (FileNotFoundException fileNotFoundException){
            throw new UserFriendlyException(fileNotFoundException);
        }
    }

    @Override
    public String getName() {
        return file.getName();
    }

    @Override
    public InputStream getInputStream(){
        return fileInputStream;
    }
}
