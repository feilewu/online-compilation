package online.compilation.provider.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.List;

/**
 * @author: pf_xu
 * @date: 2021/5/24 20:20
 * @Email:pfxuchn@gmail.com
 */
@Component
public class CompilerHolder {

    @Autowired
    private List<Compiler> compilers;

    public Compiler getCompiler(CompilerType compilerType){
        Assert.notNull(compilerType,"compilerType should not be null");
        Compiler compiler =  compilers.stream()
                .filter(compilerItem -> compilerItem.support(compilerType))
                .findFirst().orElse(null);
        Assert.notNull(compiler,"compiler should not be null");
        return compiler;
    }

}
