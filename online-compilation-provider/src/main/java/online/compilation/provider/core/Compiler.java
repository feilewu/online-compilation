package online.compilation.provider.core;

/**
 * @author: pf_xu
 * @date: 2021/5/24 20:03
 * @Email:pfxuchn@gmail.com
 */
public interface Compiler {

    default boolean support(CompilerType compilerType){
        return false;
    }

    Target compiler(Source source);

}
