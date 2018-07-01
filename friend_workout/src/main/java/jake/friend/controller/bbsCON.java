package jake.friend.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jake.friend.cri.Criteira;
import jake.friend.cri.PageMaker;
import jake.friend.domain.bbsVO;
import jake.friend.service.bbsServiceImpl;

@Controller
public class bbsCON {
	private static Logger logger = Logger.getLogger(bbsCON.class);
	@Autowired
	private bbsServiceImpl service;
	
	/*@RequestMapping(value = "/bbs", method =  RequestMethod.GET) // �Խ������� ���� ��Ʈ�ѷ� 
	public ModelAndView bbsRegister(Model model) throws Exception {
		logger.info("show all list");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("bbslist");
		mv.addObject("list", service.listall());
		return mv;
	}*/
	@RequestMapping(value = "/bbs", method =  RequestMethod.GET) // �Խ������� ���� ��Ʈ�ѷ� 
	public ModelAndView bbslist(Criteira cri,Model model) throws Exception {		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("bbslistCri");
		mv.addObject("list", service.listCriteria(cri));
		PageMaker pg = new PageMaker();
		pg.setCri(cri);
		pg.setTotalCount(service.listCountCriteria(cri)); // tot�� ����ϱ� ���ؼ� 
		mv.addObject("pageMaker", pg);
		logger.info("all" + pg.toString());
		return mv;
	}// ������ ��ü �������� �����ִ� �޼���, cri ���
	
	
	@RequestMapping(value = "/bbs/pages", method = RequestMethod.GET)
	public ModelAndView read(@RequestParam("b_seq") int b_seq, Model model) throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("bbspage");
		mv.addObject("boardVO", service.read(b_seq));
		return mv;
	}// ��Ͽ��� �� Ŭ���� �� �������� �Ѿ�� ��
	
	@RequestMapping(value = "/bbs/pages", method = RequestMethod.DELETE)
	public String remove(@RequestParam("b_seq") int b_seq, 
			RedirectAttributes rttr) throws Exception{
		service.remove(b_seq);
		rttr.addFlashAttribute("msg", "SUCCESS");
		return "redirect:/bbs";
	} // ������ �����ε� ������ �ȵɵ�. DELETE �޼��尡 �ȵ�
	
	@RequestMapping(value = "/bbs/page", method = RequestMethod.GET)
	public ModelAndView modify(int b_seq, Model model) throws Exception{
		logger.info("mod");
		model.addAttribute(service.read(b_seq));
		ModelAndView mv = new ModelAndView();
		mv.setViewName("bbspageput");
		mv.addObject("boardVO", service.read(b_seq));
		return mv;
	} // �����ϱ� ���ؼ� �۷� �Ѿ�� ��
	
	@RequestMapping(value = "/bbs/pages", method = RequestMethod.POST)
	public String modifyPOST(bbsVO board, RedirectAttributes rttr) throws Exception{
		logger.info("mod post.........." + board.toString());
		service.modify(board);
		rttr.addFlashAttribute("msg", "SUCCESS");
		return "redirect:/bbs";
	}
	

}
