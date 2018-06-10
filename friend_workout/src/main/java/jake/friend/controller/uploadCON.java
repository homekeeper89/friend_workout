package jake.friend.controller;

import java.io.File;
import java.util.UUID;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import jake.friend.domain.bbsVO;
import jake.friend.persistence.bbsDAOImpl;
import jake.friend.persistence.bbsService;
import jake.friend.util.uploadFileUtils;

@Controller
public class uploadCON {
	private static final Logger logger = LoggerFactory.getLogger(uploadCON.class);
	
	@Autowired
	private bbsService bss;
	
	@Resource(name = "uploadPath") // sevelet-context�� ��ϵǾ� ����
	private String uploadPath;
	
	@RequestMapping(value = "/files", method = RequestMethod.POST)
	public String uploadForm(MultipartFile file, Model model, bbsVO vo) throws Exception{
		logger.info("originalName" + file.getOriginalFilename());
		String path  = uploadFileUtils.uploadFile(uploadPath, file.getOriginalFilename(), file.getBytes());
		logger.info("after uploaddd " +path);
		logger.info("after " + vo.getU_name());
		vo.setFiles(path);
		bss.regist(vo);
		return "home";
	}
}
