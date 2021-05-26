package online.compilation.provider.controller;

import online.compilation.provider.controller.dto.Request;
import online.compilation.provider.core.CompilerType;
import online.compilation.provider.core.MultipartFileSource;
import online.compilation.provider.core.Target;
import online.compilation.provider.service.CompileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * @author: pf_xu
 * @date: 2021/5/24 20:07
 * @Email:pfxuchn@gmail.com
 */
@Controller("/")
public class MainController {

    @Autowired
    private CompileService compileService;

    @PostMapping(value = "compile")
    public void compile(HttpServletResponse httpServletResponse,  @RequestPart("file") MultipartFile multipartFile, @RequestPart("request") Request request) throws IOException {
        Target target = compileService.compiler(new MultipartFileSource(multipartFile), CompilerType.get(request.getCompilerType()));
        httpServletResponse.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        httpServletResponse.setHeader("Content-Disposition", "attachment; filename=" + System.currentTimeMillis() + target.getName());
        httpServletResponse.setHeader("Pragma", "no-cache");
        httpServletResponse.setHeader("Expires", "0");
        httpServletResponse.setHeader("Last-Modified", new Date().toString());
        httpServletResponse.setHeader("ETag", String.valueOf(System.currentTimeMillis()));
        httpServletResponse.setContentType("application/octet-stream");
        ServletOutputStream outputStream = httpServletResponse.getOutputStream();
        int n = 0;
        byte[] buffer = new byte[1024];
        while (-1 != (n = target.getInputStream().read(buffer))) {
            outputStream.write(buffer, 0, n);
        }
        outputStream.flush();
        outputStream.close();
    }

}
