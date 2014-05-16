package fr.treeptik.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/login")
public class LoginController
{
	@RequestMapping(value = "/redirect.do", method = RequestMethod.GET)
	public ModelAndView redirect()
	{
		ModelAndView mv = new ModelAndView("login");
		return mv;
	}
}
