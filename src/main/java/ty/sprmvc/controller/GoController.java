package ty.sprmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class GoController {

	//处理HEAD类型的“/”请求
	@RequestMapping(value={"/"},method={RequestMethod.HEAD})
	public String head(){
		return "WEB-INF/pages/go.jsp";
	}
	
	//处理GET类型的“/index”请求
	@RequestMapping(value={"/index"},method={RequestMethod.GET})
	public String index(Model model){
		model.addAttribute("msg", "Let's Go!");
		return "WEB-INF/pages/go.jsp";
	}
	
}
