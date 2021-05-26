package online.compilation.provider.core;

import java.io.InputStream;

/**
 * @author: pf_xu
 * @date: 2021/5/24 20:04
 * @Email:pfxuchn@gmail.com
 */
public interface Target {

    String getName();

    InputStream getInputStream();

}
