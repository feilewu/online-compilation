package online.compilation.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: pf_xu
 * @date: 2021/5/24 20:10
 * @Email:pfxuchn@gmail.com
 */
@SpringBootApplication(scanBasePackages = "online.compilation.provider")
public class ProviderApp {

    public static void main(String[] args) {
        SpringApplication.run(ProviderApp.class,args);
    }



}
