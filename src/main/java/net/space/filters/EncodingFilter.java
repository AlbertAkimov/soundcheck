package net.space.filters;


import javax.servlet.*;
import java.io.IOException;

/**
 * @Author A.Albert
 * @Data 8/11/17
 * @Time 12:10 PM
 * @Version 1.0
 * @Info encoding filter to utf-8
 */

public class EncodingFilter implements Filter {

    private String encoding = "utf-8";

    public void doFilter(ServletRequest request,

                         ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        request.setCharacterEncoding(encoding);
        filterChain.doFilter(request, response);
    }

    public void init(FilterConfig filterConfig) throws ServletException {
        String encodingParam = filterConfig.getInitParameter("encoding");
        if (encodingParam != null) {
            encoding = encodingParam;
        }
    }

    public void destroy() {
        // nothing todo
    }
}
