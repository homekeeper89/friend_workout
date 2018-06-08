package jake.friend.util;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.imgscalr.Scalr;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.FileCopyUtils;

public class uploadFileUtils {
	
	private static final Logger logger = LoggerFactory.getLogger(uploadFileUtils.class);
	
	// 필요한 것 세가지 : uploadPath, originalName, byte[](file data)
	
	public static String uploadFile(String uploadPath, String originalName, byte[] fileData) throws Exception{
		UUID uid = UUID.randomUUID();
		String savedName = uid.toString() + "_" + originalName;
		String savedPath = calcPath(uploadPath);
		File target = new File(uploadPath + savedPath, savedName);
		FileCopyUtils.copy(fileData, target);
		String uploadedFileName = makeThumnail(uploadPath, savedPath, savedName);
		// 사진만 올리게 하기 위해선
		return uploadedFileName;
	}
	
	// making folder
	private static String calcPath(String uploadPath) {
		Calendar cal = Calendar.getInstance(); // 현재 날짜 정보
		String yearPath = File.separator + cal.get(Calendar.YEAR); // \ + 년도
		String monthPath = yearPath + File.separator + new DecimalFormat("00").format(cal.get(Calendar.MONTH)+1);
		// monthPath
		String datePath = monthPath + File.separator + new DecimalFormat("00").format(Calendar.DATE);
		// 총 3개의 폴더 외곽 을 생성
		makeDir(uploadPath, yearPath, monthPath, datePath);
		
		logger.info(datePath); // 최종 경로
		return datePath;
	}
	
	private static void makeDir(String uploadPath, String...paths) {
		if(new File(uploadPath + paths[paths.length-1]).exists())
			return; // 제일 마지막 경로까지 해서 폴더가 존재하면 생성하지 않음
		
		for (String path:paths) {
			File dirPath = new File(uploadPath + path);
			// 년 > 월 > 일 순으로 경로를 생성하기 위함, 따라서 중간에 같은 년, 같은 월이 존재하면 만들지 않는다.
			if(!dirPath.exists()) {
				dirPath.mkdirs();
			}
		}
	}
	
	private static String makeThumnail(String uploadPath, String path, String fileName) throws Exception{
		BufferedImage sourceImg =
				ImageIO.read(new File(uploadPath + path, fileName)); // 경로상에 있는 파일을 읽어온단
		BufferedImage destImg = Scalr.resize(sourceImg, 
				Scalr.Method.AUTOMATIC, 
				Scalr.Mode.FIT_TO_HEIGHT, 100); // 이미지 압축
		String thumbnailName =
				uploadPath + path + File.separator + "s_" + fileName;  // thumbnail 이름엔 s_가 붙는다.
		File newFile = new File(thumbnailName);  // thunmbnail 경로로 새 파일 작성
		String formatName = fileName.substring(fileName.lastIndexOf(".")+1);
		// format을 뽑는 애인듯
		ImageIO.write(destImg, formatName.toUpperCase(), newFile);
		return thumbnailName.substring(uploadPath.length()).replace(File.separatorChar, '/');
		
	}
	

}
