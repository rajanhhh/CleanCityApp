package com.clean.springbootstarter.controller;


import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.disaster.springbootstarter.APIController.NewsAPIController;
import com.disaster.springbootstarter.beans.Article;
import com.disaster.springbootstarter.beans.Disaster;
import com.disaster.springbootstarter.beans.History;

@org.springframework.stereotype.Controller
@Component("MyController")
public class Controller {

	@RequestMapping("/cleancity")
	@ResponseBody
	public String index() {
		return "Welcome to clean city portal !";
		
	}
	
}
