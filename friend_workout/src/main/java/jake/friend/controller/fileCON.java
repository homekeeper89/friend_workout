package jake.friend.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import jake.friend.domain.fileVO;
import jake.friend.persistence.fileDAOimpl;
import jake.friend.util.MediaUtils;

/* 메인 페이지에서 파일을 불러오고 보여주는 동작을 하는 컨트롤러
 * 
 */
@Controller
public class fileCON {
	private static Logger logger = Logger.getLogger(fileCON.class);
	
	@Autowired
	private fileDAOimpl dao;
	
	@Resource(name = "uploadPath") // sevelet-context에 등록되어 있음
	private String uploadPath;
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView getFils() throws Exception{
		List<fileVO> flst = dao.getFiles();
		Map<Integer, fileVO> fdata = new HashMap();
		/*HashMap<Integer, ResponseEntity<byte[]>> fdata = new HashMap();*/
		for(fileVO v : flst) {
			File file = new File(uploadPath + v.getF_path());
			if(!file.exists()) {
				continue;
			}
			fdata.put(v.getB_seq(), v);
			//logger.info("f_regdate :" + v.getF_regdate());
		}
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		mv.addObject("fdata", fdata);
		return mv;
	}
	// 저장되어있는 파일을 가져온다.
	
	@RequestMapping(value = "/display", method = RequestMethod.GET)
	public ResponseEntity<byte[]> displayFile(@RequestParam("name") String fileName)throws Exception{
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
