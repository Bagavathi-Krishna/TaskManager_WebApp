package com.bagavathikrishna.springboot.myfirstwebapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SayHelloController {
	@RequestMapping("sayHelloToMe")
	public String sayHelloJSP()
	{
		return "say-hello-jsp";
	}
}
