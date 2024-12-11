package com.example.freemarker.freemarker_demo.filter;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.ComponentScan;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Enumeration;

@WebFilter(
        filterName = "MyFilterRequest",
        urlPatterns = {"/*"}
)
@ComponentScan
public class MyrRequestFilter implements Filter {
    private static final Path LOG_PATH = Paths.get("logs");


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("filter````````");
        log(servletRequest, servletResponse, filterChain);
    }

    private void log(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        ArrayList<String> infos = new ArrayList<>();
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        ServletRequest wrapRequest = null;

        infos.add("[start]" + LocalDateTime.now() + "---------123--------------");
        infos.add("requestHost: " + request.getRemoteAddr());
        infos.add("requestURL: " + request.getRequestURL().toString() + (request.getQueryString() != null ? "?" + request.getQueryString() : ""));
        infos.add("requestMethod: " + request.getMethod());

        if (!request.getMethod().equals("GET")) {
            wrapRequest = new BodyReaderHttpServletRequestWrapper(request, infos);
        }

        // 创建日志目录
        if (!Files.exists(LOG_PATH)) {
            Files.createDirectories(LOG_PATH);
        }

        StandardOpenOption[] options = {StandardOpenOption.CREATE, StandardOpenOption.APPEND};

        infos.add("headers: ");
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String element = headerNames.nextElement();
            String header = request.getHeader(element);
            infos.add(element + " : " + header);
        }
        infos.add("[end]" + "------------------------------------------\r\n\r\n");
        Files.write(getAllLogPath(), infos, options);
        Files.write(getCurUserLogPath(request), infos, options);

        if (null == wrapRequest) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            filterChain.doFilter(wrapRequest, servletResponse);
        }
    }

    private Path getAllLogPath() {
        return LOG_PATH.resolve("all_request.log");
    }

    private Path getCurUserLogPath(HttpServletRequest request) {
        String userLogFileName = "user_" + request.getRemoteAddr().replace(":", "_") + ".log";
        return LOG_PATH.resolve(userLogFileName);
    }
}
