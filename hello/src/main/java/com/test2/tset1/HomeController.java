package com.test2.tset1;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 * @throws IOException 
	 */
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public ModelAndView home(String lat, String lon) {
		
		System.out.println(lat);
		System.out.println(lon);
		return new ModelAndView("home","lat",lat);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public void home(Locale locale, Model model,HttpServletResponse res) throws IOException {
		logger.info("Welcome home! The client locale is {}.", locale);
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
		String script= "  if (navigator.geolocation) {\n" + 
				"            //위치 정보를 얻기\n" + 
				"            navigator.geolocation.getCurrentPosition (function(pos) {\n" + 
				"                var lat = pos.coords.latitude;     // 위도\n" + 
				"                var lon = pos.coords.longitude; // 경도\n" +
				"				location.href='main?lat='+lat+'&lon='+lon"+
				"            });\n" + 
				"        } else {\n" + 
				"            alert(\"이 브라우저에서는 Geolocation이 지원되지 않습니다.\")\n" + 
				"        }";
		out.println("<script>");	
		out.println(script);
		out.println("</script>");
		out.close();
									
	}
	
	
	
}
