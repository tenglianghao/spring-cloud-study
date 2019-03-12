package com.jack.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.ZuulFilterResult;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class LogFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;//定义过滤器类型
    }

    @Override
    public int filterOrder() {
        // 定义过滤器优先级，越小越优先，对同种类的过滤器的先后顺序，例如指定多个pre过滤器
        // 每个种类的过滤器，zuul都有一个默认的 PRE_DECORATION_FILTER_ORDER，路由后的地址就是由这个过滤器设置进去的
        return FilterConstants.PRE_DECORATION_FILTER_ORDER + 1;
    }

    public LogFilter() {
        super();
    }

    @Override
    public boolean isStaticFilter() {
        return super.isStaticFilter();
    }

    @Override
    public String disablePropertyName() {
        return super.disablePropertyName();
    }

    @Override
    public boolean isFilterDisabled() {
        return super.isFilterDisabled();
    }

    @Override
    public ZuulFilterResult runFilter() {
        return super.runFilter();
    }

    @Override
    public int compareTo(ZuulFilter filter) {
        return super.compareTo(filter);
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        // request.getRequestURI()路由后的地址
        String s = currentContext.get(FilterConstants.REQUEST_URI_KEY).toString();
        System.out.println("路由后的地址：" + s);
        System.out.println("调用方的ip地址：" + request.getRemoteAddr()+"访问了：" + request.getRequestURI());
        return null;
    }

}
