package com.study.springboot.auth;

import java.io.IOException;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Configuration
public class CustomFailureHandler implements AuthenticationFailureHandler {

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		String loginId = request.getParameter("username");
		String errorMsg = "";
		
		if(exception instanceof BadCredentialsException) {
			errorMsg = "아이디 또는 비밀번호가 맞지 않습니다";
		} else if(exception instanceof InternalAuthenticationServiceException) {
			errorMsg = "아이디가 존재하지 않습니다";
		} else if(exception instanceof DisabledException) {
			errorMsg = "계정이 비활성화 상태입니다. 관리자에게 문의 바랍니다";
		} else if(exception instanceof CredentialsExpiredException) {
			errorMsg = "비밀번호 유효기간이 만료된 상태입니다. 관리자에게 문의 바랍니다";
		}
		
		request.setAttribute("username",loginId);
		request.setAttribute("error_msg", errorMsg);
		
		request.getRequestDispatcher("/loginForm?error=true").forward(request, response);
		
	}
}
