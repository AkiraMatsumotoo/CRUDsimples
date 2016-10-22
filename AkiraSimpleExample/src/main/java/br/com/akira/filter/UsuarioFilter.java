package br.com.akira.filter;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(dispatcherTypes = { DispatcherType.REQUEST }, urlPatterns = "/*")
public class UsuarioFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;

		//Pega a URI do resquest
		String uri = httpServletRequest.getRequestURI();
		//Cria a Session
		HttpSession sessao = httpServletRequest.getSession(false);

		
		if (sessao!=null || uri.indexOf("login.jsp") != -1 || uri.indexOf("loginController") != -1) {
			System.out.println("Passou pelo Filter");
			chain.doFilter(request, response);
		}else {
			httpServletResponse.sendRedirect("login.jsp");
		}
	}

	@Override
	public void destroy() {
	}

}
