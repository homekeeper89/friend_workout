package jake.friend.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import jake.friend.domain.bbsVO;
import jake.friend.persistence.bbsDAOImpl;
import jake.friend.persistence.bbsService;
import jake.friend.util.MediaUtils;
import jake.friend.util.uploadFileUtils;

@Controller
public class uploadCON {
	private static final Logger logger = LoggerFactory.getLogger(uploadCON.class);
	
	@Autowired
	private bbsService bss;
	
	@Resource(name = "uploadPath") // sevelet-context에 등록되어 있음
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
	
	@RequestMapping(value = "/files", method = RequestMethod.GET)
	public String uploadForm() {
		return "getfiles";
		
	}
	
	@ResponseBody
	@RequestMapping(value="/uploadajax", method=RequestMethod.POST)
	public String uploadAjax(MultipartFile file) throws Exception {
		
		return "/2018/06/14/s_a0246319-fb5b-4c24-8e94-9f66995f06d5_KakaoTalk_20180614_132151577.jpg";
		
	}
	
	@ResponseBody
	@RequestMapping("/displayfile")
	public ResponseEntity<byte[]> displayFile(String fileName)throws Exception{
		InputStream in = null;
		ResponseEntity<byte[]> entity = null;
		
		logger.info("FILE NAME : " + fileName);
		try {
			String formatName = fileName.substring(fileName.lastIndexOf(".")+1);
			MediaType mType = MediaUtils.getMediaType(formatName);
			HttpHeaders headers = new HttpHeaders();
			in = new FileInputStream(uploadPath+fileName);
			
			//step: change HttpHeader ContentType
			if(mType != null) {
				//image file(show image)
				headers.setContentType(mType);
			}else {
				//another format file(download file)
				fileName = fileName.substring(fileName.indexOf("_")+1);//original file Name
				headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
				headers.add("Content-Disposition", "attachment; filename=\"" + new String(fileName.getBytes("UTF-8"), "ISO-8859-1")+"\""); 
			}
			
			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.CREATED);
			
		}catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		}finally {
			in.close();
		}
			return entity;
		
	}
}
