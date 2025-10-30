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
			errorMsg = "���̵� �Ǵ� ��й�ȣ�� ���� �ʽ��ϴ�";
		} else if(exception instanceof InternalAuthenticationServiceException) {
			errorMsg = "���̵� �������� �ʽ��ϴ�";
		} else if(exception instanceof DisabledException) {
			errorMsg = "������ ��Ȱ��ȭ �����Դϴ�. �����ڿ��� ���� �ٶ��ϴ�";
		} else if(exception instanceof CredentialsExpiredException) {
			errorMsg = "��й�ȣ ��ȿ�Ⱓ�� ����� �����Դϴ�. �����ڿ��� ���� �ٶ��ϴ�";
		}
		
		request.setAttribute("username",loginId);
		request.setAttribute("error_msg", errorMsg);
		
		request.getRequestDispatcher("/loginForm?error=true").forward(request, response);
		
	}
}
