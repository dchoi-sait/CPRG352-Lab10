package filters;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;


public class AuthenticationFilter implements Filter {

 

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //any code before chain.doFilter will be executed before the servlet
        
        HttpServletRequest httpRequest = (HttpServletRequest)request;
        HttpSession session = httpRequest.getSession();
        
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        String email = (String)session.getAttribute("email");
        if(email == null){
            httpResponse.sendRedirect("login");
            return;
        }
        //This will either call upon the next filter in the chain,
        //or it will load the requested servlet
        chain.doFilter(request, response);     
        
        
        //any code after chain.doFilter will be executed agter the servlet
        
        
        
        
        
        
    }

    @Override
    public void destroy() {
        
    }
       @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        
    }
    
}
