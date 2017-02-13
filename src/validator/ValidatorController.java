package validator;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/valid")
public class ValidatorController {
	@RequestMapping(value="/testValid",produces=MediaType.TEXT_HTML_VALUE)
	public ModelAndView testValid(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/validTest/testPage");
		mv.addObject("testBean", new TestBean());
		return mv;
	}
	@RequestMapping(value="/validTest",produces=MediaType.TEXT_HTML_VALUE)
	public String validTest(@RequestParam(value="testBean",required=false) @Validated TestBean testBean,BindingResult br,Model m){
		if(br.hasErrors()){
			return "/validTest/testPage";
		}
		return "";
	}
}
