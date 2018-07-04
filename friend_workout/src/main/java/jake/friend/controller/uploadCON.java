package jake.friend.controller;


import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import jake.friend.domain.bbsVO;
import jake.friend.persistence.bbsServiceT;
import jake.friend.util.uploadFileUtils;
/* copyright by : homekeeper89@gmail.com
 * Controller about Upload function
 */

@Controller
public class uploadCON {
	private static final Logger logger = LoggerFactory.getLogger(uploadCON.class);
	
	@Autowired
	private bbsServiceT bt;
	
	@Resource(name = "uploadPath") // sevelet-context에 등록되어 있음
	private String uploadPath;
	
	@RequestMapping(value = "/files", method = RequestMethod.POST)
	public String uploadForm(MultipartFile file, Model model, bbsVO vo) throws Exception{
		//logger.info("originalName" + file.getOriginalFilename());
		String path  = uploadFileUtils.uploadFile(uploadPath, file.getOriginalFilename(), file.getBytes());
		//logger.info("after uploaddd " +path);
		//logger.info("after " + vo.getU_name());
		vo.setFiles(path);
		bt.regist(vo);
		return "redirect:" + "/";
	}
	// 파일 업로드 할 경우 작동되는 컨트롤러, 업로드가 성공하면 home으로 움지인다.
}
