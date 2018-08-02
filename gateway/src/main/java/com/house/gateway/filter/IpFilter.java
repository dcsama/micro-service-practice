package com.house.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IpFilter extends ZuulFilter {

    private Logger logger = LoggerFactory.getLogger(IpFilter.class);

    @Override
    public String filterType() {
        // 设置过滤器的类型:pre、route、post、error
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        // 设置为true表明执行过滤器
        return true;
    }

    @Override
    public Object run() {

        RequestContext requestContext = RequestContext.getCurrentContext();
        requestContext.setSendZuulResponse(false);
        requestContext.setResponseBody("test filter.");

        Throwable throwable = requestContext.getThrowable();
        logger.error("Filter error : " + throwable.getCause().getMessage());

        return null;
    }
}
