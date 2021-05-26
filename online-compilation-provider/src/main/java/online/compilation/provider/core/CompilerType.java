package online.compilation.provider.core;

import online.compilation.provider.exception.UserFriendlyException;

import java.util.Arrays;

/**
 * @author: pf_xu
 * @date: 2021/5/24 20:21
 * @Email:pfxuchn@gmail.com
 */
public enum CompilerType {

    JAVA_8,
    JAVA_9,
    JAVA_10,

    GOLANG_1_11,
    GOLANG_1_12,
    ;

    public static CompilerType get(String compiler){
        for(CompilerType compilerType:CompilerType.values()){
            if(compilerType.toString().equals(compiler)){
                return compilerType;
            }
        }
        throw new UserFriendlyException("unknown compiler args");
    }

}
