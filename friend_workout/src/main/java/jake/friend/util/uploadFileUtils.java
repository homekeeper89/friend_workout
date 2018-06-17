package jake.friend.util;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.UUID;
import jake.friend.util.resizeFile;

import javax.imageio.ImageIO;

import org.imgscalr.Scalr;
import org.imgscalr.Scalr.Method;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.FileCopyUtils;

public class uploadFileUtils {

	private static final Logger logger = LoggerFactory.getLogger(uploadFileUtils.class);


	// �ʿ��� �� ������ : uploadPath, originalName, byte[](file data)
	public static String uploadFile(String uploadPath, String originalName, byte[] fileData) throws Exception{
		UUID uid = UUID.randomUUID();
		String mainPosition;
		String savedName = uid.toString() + "_" + originalName;
		String savedPath = calcPath(uploadPath);
		File target = new File(uploadPath + savedPath, savedName);
		FileCopyUtils.copy(fileData, target);
		// 06.17 file ����� �˾ƺ��� ���� �ۼ���, 600 * 400 ���� �Ǿ� �� ����
		BufferedImage bi = ImageIO.read(target);
		logger.debug("weight : " + bi.getWidth() + ":" + "heiglt : " + bi.getHeight()); // ���� ���� ���ϱ�.
		double rate = (double)((double)bi.getWidth() / (double)bi.getHeight());
		if (rate < 0.7 ) {
			mainPosition = "W"; // ���η� ���� ������ ���
		}else if(rate > 1.3) {
			mainPosition = "H"; // ���η� ���� ������ ���
		}else {
			mainPosition = "E"; // ����Ұ��(���簢��)
		}
		logger.debug("mainPo : " + mainPosition + ": ratio :" + rate);
		String uploadedFileName = resizeFile.reszieFiles(uploadPath, savedPath, savedName, mainPosition);
				//String uploadedFileName = makeThumnail(uploadPath, savedPath, savedName); 
		// 06.16 ����Ϸ� ���� ������ �ϰ� �Խ��ǿ� �Ѹ��� ȭ���� �ʹ�������. ���� �״�� �ؾ���
		//String uploadedFileName = uploadPath+ savedPath+ "\\" + savedName; �̰Ŵ� �������� �״�� �����ϴ� ���
		logger.info("uploadname : " + 
				uploadedFileName.substring(uploadPath.length()).replace(File.separatorChar, '/'));
		return uploadedFileName;
	}
// making folder
private static String calcPath(String uploadPath) {
	Calendar cal = Calendar.getInstance(); // ���� ��¥ ����
	String yearPath = File.separator + cal.get(Calendar.YEAR); // \ + �⵵
	String monthPath = yearPath + File.separator + new DecimalFormat("00").format(cal.get(Calendar.MONTH)+1);
	// monthPaths
	String datePath = monthPath + File.separator + new DecimalFormat("00").format(cal.get(Calendar.DATE));
	// �� 3���� ���� �ܰ� �� ����
	makeDir(uploadPath, yearPath, monthPath, datePath);
	logger.info("month" + monthPath);
	logger.info(datePath); // ���� ���
	return datePath;
}
// folder �����
private static void makeDir(String uploadPath, String...paths) {
	if(new File(uploadPath + paths[paths.length-1]).exists())
		return; // ���� ������ ��α��� �ؼ� ������ �����ϸ� �������� ����

	for (String path:paths) {
		File dirPath = new File(uploadPath + path);
		// �� > �� > �� ������ ��θ� �����ϱ� ����, ���� �߰��� ���� ��, ���� ���� �����ϸ� ������ �ʴ´�.
		logger.info(path);
		if(!dirPath.exists()) {
			dirPath.mkdirs();
		}
	}
}

private static String makeThumnail(String uploadPath, String path, String fileName) throws Exception{
	BufferedImage sourceImg =
			ImageIO.read(new File(uploadPath + path, fileName)); // ��λ� �ִ� ������ �о�´�
	BufferedImage destImg = Scalr.resize(sourceImg, 400, 600); // �̹��� �����ε� ������ ��������, ���� ����?
	String thumbnailName =
			uploadPath + path + File.separator + "s_" + fileName;  // thumbnail �̸��� s_�� �ٴ´�.
	logger.info("thum :" + thumbnailName);
	File newFile = new File(thumbnailName);  // thunmbnail ��η� �� ���� �ۼ�
	String formatName = fileName.substring(fileName.lastIndexOf(".")+1);
	// format�� �̴� ���ε�
	ImageIO.write(destImg, formatName.toUpperCase(), newFile);
	return thumbnailName.substring(uploadPath.length()).replace(File.separatorChar, '/');

}




}
