package jake.friend.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.annotation.RequestScope;
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

	@RequestMapping(value = "/bbs", method =  RequestMethod.GET) // �Խ������� ���� ��Ʈ�ѷ� 
	public ModelAndView bbslist(Criteira cri,Model model) throws Exception {		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("bbslistCri");
		mv.addObject("list", service.listCriteria(cri));
		PageMaker pg = new PageMaker();
		pg.setCri(cri);
		pg.setTotalCount(service.listCountCriteria(cri)); // tot�� ����ϱ� ���ؼ� 
		mv.addObject("pageMaker", pg);
		return mv;
	}// ������ ��ü �������� �����ִ� �޼���, cri ���
	
	@RequestMapping(value = "/bbs", method = RequestMethod.POST)
	public String pageRegister(bbsVO vo, Model model) throws Exception{
		logger.info("reg" + vo.getB_content());
		service.register(vo);
		return "redirect:/bbs";
	} // ���� ����ϴ� �޼���
	
	@RequestMapping(value = "/pages", method = RequestMethod.GET)
	public String movePage() throws Exception{
		return "bbsRegister";
	} // ������������� ����� ������ ����� �Ǵ� �޼���
	
	@RequestMapping(value = "/bbs/pages", method = RequestMethod.GET)
	public ModelAndView read(@RequestParam("b_seq") int b_seq, 
			@ModelAttribute("cri") Criteira cri , Model model) throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("bbspage");
		mv.addObject("boardVO", service.read(b_seq));
		return mv;
	}// ��Ͽ��� �� Ŭ���� �� �������� �Ѿ�� ��
	
	@RequestMapping(value = "/bbs/pages", method = RequestMethod.DELETE)
	public String remove(@RequestParam("b_seq") int b_seq, Criteira cri, 
			RedirectAttributes rttr) throws Exception{
		service.remove(b_seq);
		rttr.addFlashAttribute("msg", "SUCCESS");
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		return "redirect:/bbs";
	} // ������ ����
	@RequestMapping(value = "/bbs/pages", method = RequestMethod.POST)
	public String modifyPOST(bbsVO board, Criteira cri, RedirectAttributes rttr) throws Exception{
		logger.info("mod post.........." + board.toString());
		service.modify(board);
		rttr.addFlashAttribute("msg", "SUCCESS");
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		return "redirect:/bbs";
	}// �����ϰ� �� ���� ������ư ������ �۵� ��
	
	@RequestMapping(value = "/bbs/page", method = RequestMethod.GET)
	public ModelAndView modify(int b_seq, @ModelAttribute("cri") Criteira cri, Model model) throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("bbspageput");
		mv.addObject("boardVO", service.read(b_seq));
		return mv;
	} // �����ϱ� ���ؼ� �۷� �Ѿ�� ��
	
	

}
