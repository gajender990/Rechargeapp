package com.example.Recharge;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
public class Control {	
	
	ModelAndView mv=new ModelAndView();
	
	static String number;
	
	static String username;
	static String password;

	List<Object[]> s;
	
	@Autowired
	AddUserRepo al;
	
	@Autowired
	Rechargedetailsrepo a;
	
	@ResponseBody()
	public boolean usercheck(String username,String password)
	{
		
		s=getdetails(username,password);
	
		System.out.println(s.toString()); 
		if(!s.isEmpty())
		{
			bool=true;
		}
		else
		{
			if(bool==false)
			{
			bool=false;
			}	
		}
		return bool;
		
	}
	
	 @ResponseBody()
		public List<Object[]> getdetails(String username,String password)
		{
		return al.gotuserverification(username, password);
		}
		
		public List<Rechargedetails> getPlans()
		{
			List<Rechargedetails> recharge=new ArrayList<Rechargedetails>();
			for(Rechargedetails r:a.findAll())
			{
				recharge.add(r);
			}
		return recharge;
		}
		
	
	@RequestMapping(value="/welcome",method= {RequestMethod.GET,RequestMethod.POST})

	public ModelAndView  welcome()
	{
	if(bool==true)
	{
		mv.addObject("checkuser",Control.username);
		mv.addObject("signdetails", "Sign out");
		System.out.println(Control.username);
	}
	else {
		mv.addObject("checkuser", "Login");
		mv.addObject("signdetails", "Sign Up");
	}
	mv.setViewName("welcome.jsp");
	return mv;
	}
	
	static int sign=0;
	
	@RequestMapping(value="/signup",method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView signup()
	{
		if(bool==false)
		{mv.setViewName("SignUp.jsp");}
		else
		{	bool=false;
			s.removeAll(s);
			sign=0;
			mv.addObject("checkuser","Login");
			mv.addObject("signdetails", "Sign Up");
			mv.setViewName("welcome.jsp");}
		return mv;
	}
	
	@RequestMapping(value="/adduser",method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView useradd(@RequestParam(name="name",required=true) String name,@RequestParam(name="username",required=true) String username,@RequestParam(name="password",required=true) String password)
	{
		User l=new User();
		l.setname(name);
		
		l.setusername(username);
		l.setpassword(password);
		System.out.println(username);
		System.out.println(password);
		al.save(l);
		mv.setViewName("login.jsp");
		return mv;
	}
	
	@RequestMapping(value="/login",method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView login(@RequestParam(name="phoneno",required=false,defaultValue="Enter your Phone number") String phoneno)
	{
		Control.number=phoneno;
		System.out.println(Control.number);
		if(bool==false)
		{}
		else
		{
		mv.addObject("checkuser",Control.username);
		mv.addObject("signdetails", "Sign out");
		}
		mv.setViewName("login.jsp");
		return mv;
	}
	
	
	static boolean bool;
	
	@RequestMapping(value="/try",method= {RequestMethod.GET,RequestMethod.POST})

		public ModelAndView  add(@PathParam(value="username") String username,@PathParam( value = "password") String password,@RequestParam(name="phoneno",required=false,defaultValue="Enter your Phone number") String phoneno,
				HttpServletRequest req)
		{
		 Control.bool=usercheck(username, password);
		 System.out.println(Control.bool);
		 
			if(Control.bool==false)//bool==false means user is not verified
			{
				 
				if(sign==0)
				{
					mv.addObject("credentials", "");
					Control.number=phoneno;
					System.out.println(Control.number);
				}
				
				else
				if(sign==1)
				mv.addObject("credentials", "Bad Credentials");
		
				
				mv.addObject("number", Control.number);
				
				System.out.println(Control.number);
				mv.setViewName("login.jsp");
				sign=1;
			}
			else 
				if(Control.bool==true)
			{
					
				if(sign==1 && Control.bool==true)
				{	
				Control.username=username;
				}
				sign++;
				mv.addObject("number", Control.number);
				mv.addObject("credentials", "");
				req.setAttribute("recharge",getPlans());
				mv.addObject("checkuser",Control.username);
				mv.addObject("signdetails", "Sign out");
				mv.setViewName("try.jsp");
			}
			return mv;
		}
	static int Amount;

	@RequestMapping(value="/addamount",method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView addamount(HttpServletRequest req)
	{
		Amount=Integer.parseInt(req.getParameter("Amount"));
		mv.addObject("amount", Amount);
		req.setAttribute("recharge",getPlans());
		mv.setViewName("try.jsp");
		return mv;
	
	}
	

	@RequestMapping(value="/Rechargedone",method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView Rechargedone(HttpServletRequest req)
	{
		req.setAttribute("recharge",getPlans());
		mv.setViewName("Rechargedone.jsp");
		return mv;
	}
	
}
