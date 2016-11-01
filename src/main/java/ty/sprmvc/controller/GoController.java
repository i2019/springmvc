package ty.sprmvc.controller;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.PropertyAccessorFactory;
import org.springframework.beans.PropertyValue;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class GoController implements EnvironmentAware{

	private Environment environment;
	
	@Override
	public void setEnvironment(Environment environment) {
		this.environment=environment;
	}
	
	//处理HEAD类型的“/”请求
	@RequestMapping(value={"/"},method={RequestMethod.HEAD})
	public String head(){
		return "WEB-INF/pages/go.jsp";
	}
	
	//处理GET类型的“/index”请求
	@RequestMapping(value={"/index"},method={RequestMethod.GET})
	public String index(Model model){
		
		Go go=new Go();
		BeanWrapper bw=PropertyAccessorFactory.forBeanPropertyAccess(go);
		bw.setPropertyValue("goMsg", "欢迎");
		PropertyValue propertyValue=new PropertyValue("goName","李江涛");
		bw.setPropertyValue(propertyValue);
		
		model.addAttribute("msg", go.getGoMsg()+go.getGoName()+"！"+"Let's Go!");
		return "WEB-INF/pages/go.jsp";
	}

	
}
