package com.archies.web.action.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Component;

import com.archies.model.user.User;
import com.archies.service.auth.AuthServiceImpl.SecureUser;
import com.archies.service.user.UserService;
import com.archies.web.action.ArchiesAction;

@SuppressWarnings("serial")
@Component
@Scope(value=ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class LoginSuccessHandler extends ArchiesAction implements AuthenticationSuccessHandler  {
	
	@Autowired
	private UserService userService;
	
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
		this.request = request;
		SecureUser secureUser = (SecureUser)authentication.getPrincipal();
		String username = secureUser.getUsername();
		User user = userService.getUserDetails(username);
		
		// if we are here, user is already authenticated by spring-security
		String ipAddress  = request.getHeader("X-FORWARDED-FOR");
		
		if(ipAddress == null) {  
			ipAddress = request.getRemoteAddr();  
		}
		
		SavedRequest savedRequest = new HttpSessionRequestCache().getRequest(request, response);
		if(savedRequest != null && savedRequest.getRedirectUrl() != null){
			String redirectUri = savedRequest.getRedirectUrl();
			response.sendRedirect(redirectUri);
		}

	}

}
