package com.medallies.lifemedid.rest.filter;

import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerResponse;
import com.sun.jersey.spi.container.ContainerResponseFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

/**
 * The class CORSFilter is for todo.
 * This class will do the CORS fix and it has been tested
 */
@Provider
public class CORSFilter implements ContainerResponseFilter, Filter {

    /**
     * The constant logger.
     */
    private static final Logger logger = LoggerFactory.getLogger(CORSFilter.class);

    /**
     * Filter container response.
     *
     * @param request  the request
     * @param response the response
     * @return the container response
     */
    @Override
    public ContainerResponse filter (ContainerRequest request,
                                     ContainerResponse response) {

        response.getHttpHeaders( ).add("Access-Control-Allow-Origin", "*");
        response.getHttpHeaders( ).add("Access-Control-Allow-Headers",
                "origin, content-type, accept, authorization");
        response.getHttpHeaders( ).add("Access-Control-Allow-Credentials", "true");
        response.getHttpHeaders( ).add("Access-Control-Allow-Methods",
                "GET, POST, PUT, DELETE, OPTIONS, HEAD");

        return response;
    }

    /**
     * Init.
     *
     * @param filterConfig the filter config
     * @throws ServletException the servlet exception
     */
    @Override
    public void init (FilterConfig filterConfig) throws ServletException {

    }

    /**
     * Do filter.
     *
     * @param servletRequest  the servlet request
     * @param servletResponse the servlet response
     * @param filterChain     the filter chain
     * @throws IOException      the io exception
     * @throws ServletException the servlet exception
     */
    @Override
    public void doFilter (ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        logger.debug("Starting doFilter for adding response headers");
        ( (HttpServletResponse) servletResponse ).addHeader("Access-Control-Allow-Origin", "*");
        ( (HttpServletResponse) servletResponse ).addHeader("Access-Control-Allow-Headers",
                "origin, content-type, accept, authorization");
        ( (HttpServletResponse) servletResponse ).addHeader("Access-Control-Allow-Credentials", "true");
        ( (HttpServletResponse) servletResponse ).addHeader("Access-Control-Allow-Methods",
                "GET, POST, PUT, DELETE, OPTIONS, HEAD");
        filterChain.doFilter(servletRequest, servletResponse);
        logger.debug("Finishing doFilter for adding response headers");
    }

    /**
     * Destroy.
     */
    @Override
    public void destroy () {

    }
}
