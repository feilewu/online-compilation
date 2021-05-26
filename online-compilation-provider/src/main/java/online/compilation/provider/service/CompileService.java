package online.compilation.provider.service;

import online.compilation.provider.core.CompilerHolder;
import online.compilation.provider.core.CompilerType;
import online.compilation.provider.core.Source;
import online.compilation.provider.core.Target;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: pf_xu
 * @date: 2021/5/24 20:00
 * @Email:pfxuchn@gmail.com
 */
@Service
public class CompileService{

    @Autowired
    private CompilerHolder compilerHolder;

    public final Target compiler(Source source, CompilerType type) {
        return compilerHolder.getCompiler(type).compiler(source);
    }
}
