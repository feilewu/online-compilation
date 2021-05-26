package online.compilation.provider.config;

import ch.qos.logback.core.PropertyDefinerBase;

/**
 * @author: pf_xu
 * @date: 2021/5/25 22:23
 * @Email:pfxuchn@gmail.com
 */
public class DefineLogDir extends PropertyDefinerBase {

    @Override
    public String getPropertyValue() {

        // 设置日志目录
        return "./logs";
    }
}
