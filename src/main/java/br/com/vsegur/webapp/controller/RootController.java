package br.com.vsegur.webapp.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Jorge Takeshi Sato
 */
@Controller
public class RootController {

    private final Logger logger = LoggerFactory.getLogger(RootController.class);
    
    @Autowired
	protected HttpServletRequest httpServletRequest;

	@RequestMapping(value = "/", method = { RequestMethod.GET })
	public String processRootRedirect(final Model model) throws Exception {
		logger.info("Redirecting to main page!");
		return "wizard-book-room";
	}

	@RequestMapping(value = "/logout", method = { RequestMethod.GET })	
	public String logout() throws Exception {
		httpServletRequest.logout();
		return "redirect:/";
	}
}
