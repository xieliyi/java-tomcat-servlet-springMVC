package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

@Controller
public class controller {

	 /**
	 * 1. 使用RequestMapping注解来映射请求的URL
	 * 2. 返回值会通过视图解析器解析为实际的物理视图, 对于InternalResourceViewResolver视图解析器，会做如下解析
	 * 通过prefix+returnVal+suffix 这样的方式得到实际的物理视图，然后会转发操作
	 * "/WEB-INF/views/helloworld.jsp"
	 * @return
	 */
	
	 @RequestMapping("/helloworld")
	 public String hello(ModelMap mm) {
	      System.out.println("hello world");
	      mm.addAttribute("text", "hello world!");
	      mm.addAttribute("result", "success");
	      return "helloworld";
	 }
	
	 @RequestMapping("/register")
	 public String register() {
	      System.out.println("register");
	      return "register";
	 }
	 
	 @RequestMapping("/login")
	 public String login() {
	      System.out.println("login");
	      return "login";
	 }
	 
	 @RequestMapping("/bind")
	 public String bind() {
	      System.out.println("bind");
	      return "bind";
	 }
	 
	 @RequestMapping("/inquire")
	 public String inquire() {
	      System.out.println("inquire");
	      return "inquire";
	 }	
	 
	 @RequestMapping("/RegisterServlet")
	 public String RegisterServlet(String username, String password, ModelMap mm) {
	      System.out.println("RegisterServlet");
	      System.out.println("username:" +username);
	      mm.addAttribute("username", username);
	      mm.addAttribute("password", password);
	      if(username!=null && username.length()>0) {
	    	  mm.addAttribute("result", "success");
	      }
	      else {
	    	  mm.addAttribute("result", "fail");
	      }
	      return "register";
	 }	 
	 
	 @RequestMapping("/LoginServlet")
	 public String LoginServlet(String username, String password, ModelMap mm) {
	      System.out.println("LoginServlet");
	      System.out.println("username:" +username);
	      mm.addAttribute("username", username);
	      mm.addAttribute("password", password);
	      if(username!=null && username.length()>0) {
	    	  mm.addAttribute("result", "success");
	      }
	      else {
	    	  mm.addAttribute("result", "fail");
	      }
	      return "login";
	 }	
	 
	 @RequestMapping("/BindServlet")
	 public String BindServlet(String sn,String name,String mobile,String address, ModelMap mm) {
	      System.out.println("BindServlet");
	      
	      System.out.println("sn:" +sn);
	      System.out.println("name:" +name);
	      System.out.println("mobile:" +mobile);
	      System.out.println("address:" +address);
	      
	      mm.addAttribute("sn", sn);
	      mm.addAttribute("name", name);
	      mm.addAttribute("mobile", mobile);
	      mm.addAttribute("address", address);
	      
	      if(sn!=null && sn.length()>0) {
	    	  mm.addAttribute("result", "success");
	      }
	      else {
	    	  mm.addAttribute("result", "fail");
	      }
	      return "bind";
	 }	
	 
	 @RequestMapping("/InquireServlet")
	 public String InquireServlet(String sn, ModelMap mm) {
	      System.out.println("InquireServlet");
	      System.out.println("sn:" +sn);
	      mm.addAttribute("sn", sn);
	      if(sn!=null && sn.length()>0) {
	    	  mm.addAttribute("result", "success");
	      }
	      else {
	    	  mm.addAttribute("result", "fail");
	      }
	      return "inquire";
	 }	
	 
	 
	@RequestMapping("/users")
	public String users(ModelMap mm) {
		System.out.println("users");
		mm.addAttribute("School", "SuZhou");
		mm.addAttribute("Work", "YanFa");
		return "userList";
	}
	
	@RequestMapping("/usersModelAndView")
	public ModelAndView showUserListModelAndView() {
		System.out.println("usersModelAndView");
		ModelAndView mav = new ModelAndView(new MappingJacksonJsonView());
		mav.addObject("School", "SuZhou");
		mav.addObject("Work", "YanFa");
		mav.setViewName("userList");
		return mav;
	}

	 
}
