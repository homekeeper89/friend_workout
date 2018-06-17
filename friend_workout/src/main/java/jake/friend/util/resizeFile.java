package jake.friend.util;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class resizeFile {

	public static String reszieFiles(String uploadPath, String path, 
			String fileName, String mainPosition ) {
		String imgFormat = "jpg";                             // �� �̹��� ����. jpg, gif ��
		int newWidth = 600;                                  // ���� �� ����
		int newHeight = 400;                                 // ���� �� ����
		// W:�����߽�, H:�����߽�, X:������ ��ġ��(��������)
		int imageWidth;
		int imageHeight;
		double ratio;
		int w;
		int h;
		String resizeName = null;
		try{
			// ���� �̹��� ��������
			BufferedImage image =
					ImageIO.read(new File(uploadPath + path, fileName));
			// ���� �̹��� ������ ��������
			imageWidth = image.getWidth(null);
			imageHeight = image.getHeight(null);
			if(mainPosition.equals("W")){    // ���̱���
				ratio = (double)newWidth/(double)imageWidth;
				w = (int)(imageWidth * ratio);
				h = (int)(imageHeight * ratio);
			}else if(mainPosition.equals("H")){ // ���̱���
				ratio = (double)newHeight/(double)imageHeight;
				w = (int)(imageWidth * ratio);
				h = (int)(imageHeight * ratio);
			}else{ //������ (��������)
				w = newWidth;
				h = newHeight;
			}
			// �̹��� ��������
			// Image.SCALE_DEFAULT : �⺻ �̹��� �����ϸ� �˰��� ���
			// Image.SCALE_FAST    : �̹��� �ε巯�򺸴� �ӵ� �켱
			// Image.SCALE_REPLICATE : ReplicateScaleFilter Ŭ������ ��üȭ �� �̹��� ũ�� ���� �˰���
			// Image.SCALE_SMOOTH  : �ӵ����� �̹��� �ε巯���� �켱
			// Image.SCALE_AREA_AVERAGING  : ��� �˰��� ���
			Image resizeImage = image.getScaledInstance(w, h, Image.SCALE_SMOOTH);
			// �� �̹���  �����ϱ�
			BufferedImage newImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
			Graphics g = newImage.getGraphics();
			g.drawImage(resizeImage, 0, 0, null);
			g.dispose();
			resizeName =
					uploadPath + path + File.separator + "s_" + fileName;  // thumbnail �̸��� s_�� �ٴ´�.
			ImageIO.write(newImage, imgFormat, new File(resizeName));
		}catch (Exception e){
			e.printStackTrace();
		}
		return resizeName.substring(uploadPath.length()).replace(File.separatorChar, '/');
	}
}
