package fr.treeptik.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.treeptik.exception.ServiceException;
import fr.treeptik.model.Client;
import fr.treeptik.service.ClientService;

@Controller
@RequestMapping(value = "/client")
public class ClientController
{
	@Autowired
	ClientService clientService;

	@RequestMapping(value = "/init.do", method = RequestMethod.GET)
	public ModelAndView initForm(Client client) throws ServiceException
	{
		ModelAndView mv = new ModelAndView("client/client-creation");
		
		boolean isUpdate = true;
		
		if(client.getId() == null)
		{
			client = new Client();
			isUpdate = false;
		}
		
		else
		{
			clientService.findById(client.getId());
		}
		
		mv.addObject("client",client);
		mv.addObject("isUpdate", isUpdate);
		return mv;
	}
	
	@RequestMapping(value = "/save.do", method = RequestMethod.POST)
	public ModelAndView save(@Valid Client client, BindingResult result) throws ServiceException
	{	
		if(result.hasErrors())
			return new ModelAndView("client/client-creation", "client", client);

		if(client.getId() != null)
		{
			client = clientService.update(client);
		}
		
		else
		{
			client = clientService.save(client);
		}
		
		Map<String, Object> mvItems = new HashMap<>();
		mvItems.put("client", client);

		ModelAndView mv = new ModelAndView("client/client-show");
		mv.addAllObjects(mvItems);
		return mv;
	}
}
