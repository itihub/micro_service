package com.xxx.user.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.xxx.thrift.user.domain.dto.UserDTO;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

/**
 * @Description: TODO
 * @Author: JiZhe
 */
public abstract class LoginFilter implements Filter {


    /**缓存*/
    private static Cache<String, UserDTO> cache =
            CacheBuilder.newBuilder().maximumSize(10000)
                    .expireAfterWrite(3, TimeUnit.MINUTES).build();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        //获取token(请求参数)
        String token = request.getParameter("token");

        //获取token(cookie)
        if (StringUtils.isBlank(token)){
            Cookie[] cookies = request.getCookies();

            if(cookies!=null) {
                for(Cookie c : cookies) {
                    if(c.getName().equals("token")) {
                        token = c.getValue();
                    }
                }
            }
        }

        //获取token(请求头)
        if (StringUtils.isBlank(token)){
            token = request.getHeader("token");
        }

        //使用token获取用户信息
        UserDTO userDTO = null;
        if (StringUtils.isNotBlank(token)){
            userDTO = cache.getIfPresent(token);
            if (userDTO == null){
                userDTO = requestUserInfo(token);
            }
        }

        if (userDTO == null){
            response.sendRedirect("http://localhost:8080/user/login");
            return;
        }

        cache.put(token, userDTO);

        chain.doFilter(request, response);

    }

    /**
     *
     * @return
     */
    protected abstract String userEdgeServiceAddr();

    protected abstract void login(HttpServletRequest request, HttpServletResponse response, UserDTO userDTO);

    /**
     * 使用token请求用户信息
     * @param token 令牌
     * @return
     */
    private UserDTO requestUserInfo(String token){
        //获取用户信息地址
        String url = String.format("http://%s/user/authentication", userEdgeServiceAddr());

        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(url);
        post.addHeader("token", token);

        InputStream inputStream = null;
        try {
            HttpResponse response = client.execute(post);
            if(response.getStatusLine().getStatusCode()!= HttpStatus.SC_OK) {
                throw new RuntimeException("request user info failed! StatusLine:"+response.getStatusLine());
            }
            inputStream = response.getEntity().getContent();
            byte[] temp = new byte[1024];
            StringBuilder sb = new StringBuilder();
            int len = 0;
            while((len = inputStream.read(temp))>0) {
                sb.append(new String(temp,0,len));
            }

            UserDTO userDTO = new ObjectMapper().readValue(sb.toString(), UserDTO.class);
            return userDTO;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(inputStream!=null) {
                try{
                    inputStream.close();
                }catch(Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    @Override
    public void destroy() {

    }
}
