package com.example.demo;

import javax.annotation.Priority;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.ext.WriterInterceptor;
import javax.ws.rs.ext.WriterInterceptorContext;
import java.io.IOException;

/**
 * Created by jpairaiturkar on 5/17/17.
 */
@Priority(value = 2000)
@Provider
public class AuthenticationFilter implements WriterInterceptor {

    @Context
    private HttpServletRequest request;

    @Override
    public void aroundWriteTo(WriterInterceptorContext interceptorContext)
            throws IOException, WebApplicationException {
        System.out.println("AuthenticationFilter invoked.");
        System.out.println("request URL " + request.getRequestURL().toString());


        interceptorContext.proceed();
    }
}

