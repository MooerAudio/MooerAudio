package com.mooer.manager.gtrs.plugin.tool;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.apache.commons.codec.binary.Base64;
import org.springframework.web.multipart.MultipartFile;

public class ImageUtil {

	public static String getBase64(BufferedImage image) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();// io流
		try {
			ImageIO.write(image, "png", baos);// 写入流中
		} catch (IOException e) {
			e.printStackTrace();
		}
		byte[] bytes = baos.toByteArray();// 转换成字节
		Base64.encodeBase64String(bytes);
		String png_base64 = Base64.encodeBase64String(bytes).trim();// 转换成base64串
		png_base64 = png_base64.replaceAll("\n", "").replaceAll("\r", "");// 删除 \r\n
		return "data:image/jpg;base64," + png_base64;
	}

	/**
	 * 按照宽高等比例缩放(缩小或放大)
	 * 
	 * @param img
	 * @param width
	 * @param height
	 * @param outputDir
	 */
	public static BufferedImage thumbnail_w_h(BufferedImage bi, int destWidth, int destHeight) {
		double srcWidth = bi.getWidth(); // 源图宽度
		double srcHeight = bi.getHeight(); // 源图高度
		double scale = 1;// 缩放比例因子，大于1表示放大，小于1表示缩小
		if (destWidth > 0 && destHeight > 0) {
			// 下面这个缩放比例因子取值很好理解，目标尺寸和原图尺寸的比值越大，
			// 表示缩放的比率越小，也就代表图片变形的越小，就取影响图片变形小的比例因子
			scale = destHeight / srcHeight < destWidth / srcWidth ? destHeight / srcHeight : destWidth / srcWidth;
		}
		return thumbnail(bi, (int) (srcWidth * scale), (int) (srcHeight * scale));
	}

	/**
	 * 按照指定的宽高压缩原图
	 * 
	 * @param img
	 * @param width
	 * @param height
	 * @param outputDir
	 */
	public static BufferedImage thumbnail(BufferedImage bi, int destWidth, int destHeight) {
		// 读取源图
		double srcWidth = bi.getWidth(); // 源图宽度
		double srcHeight = bi.getHeight(); // 源图高度
		if ((int) srcWidth >= destWidth && (int) srcHeight >= destHeight) {
			Image image = bi.getScaledInstance(destWidth, destHeight, Image.SCALE_SMOOTH);

			BufferedImage tag = new BufferedImage(destWidth, destHeight, BufferedImage.TYPE_INT_RGB);
			Graphics g = tag.getGraphics();
			g.setColor(Color.RED);
			g.drawImage(image, 0, 0, null);
			g.dispose();
			return tag;
		} else {
			return null;
		}
	}

	public static ByteArrayOutputStream thumbnail(MultipartFile uploadFile, int destWidth, int destHeight) {
		ByteArrayOutputStream baos = null;
		if (uploadFile != null && uploadFile.getSize() != 0) {
			String originalFilename = uploadFile.getOriginalFilename();// 接收上传的文件
			String extName = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);// 取扩展名
			try {
				InputStream inputStream = uploadFile.getInputStream();
				BufferedImage bufferedImage = ImageIO.read(inputStream);
				double srcWidth = bufferedImage.getWidth(); // 源图宽度
				double srcHeight = bufferedImage.getHeight(); // 源图高度
				if(srcWidth>destWidth&&srcHeight>destHeight) {
					bufferedImage = ImageUtil.thumbnail(bufferedImage, destWidth, destHeight);
				}
				baos = new ByteArrayOutputStream();
				ImageIO.write(bufferedImage, extName, baos);
				baos.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return baos;
//		//读取图片
//		BufferedImage bufferedImage = ImageIO.read(uploadFile.getInputStream());
//		//等比例处理图片
//		if(bufferedImage.getWidth()>bufferedImage.getHeight()) {
//			bufferedImage = ImageUtil.thumbnail(bufferedImage, bufferedImage.getHeight(), bufferedImage.getHeight());
//		}else {
//			bufferedImage = ImageUtil.thumbnail(bufferedImage, bufferedImage.getWidth(), bufferedImage.getWidth());
//		}
//		//图片比率
////		double l = (double)bufferedImage.getWidth()/filed.getRule();
//		
//		int top = (int) (filed.getTop()*l);
//		int left = (int) (filed.getLeft()*l);
//		int w = (int) ((filed.getRight()-filed.getLeft())*l);
//		int h = (int) ((filed.getBottom()-filed.getTop())*l);
//		
//		bufferedImage = bufferedImage.getSubimage(left, top, w, h);
//		//输出图片
//		baos = new ByteArrayOutputStream();
//	    ImageIO.write(bufferedImage, "png", baos);
//	    baos.flush();
	}

	public static ByteArrayOutputStream thumbnail(MultipartFile uploadFile, int destWidth) {
		ByteArrayOutputStream baos = null;
		if (uploadFile != null && uploadFile.getSize() != 0) {
			String originalFilename = uploadFile.getOriginalFilename();// 接收上传的文件
			String extName = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);// 取扩展名
			try {
				InputStream inputStream = uploadFile.getInputStream();
				BufferedImage bufferedImage = ImageIO.read(inputStream);
				double srcWidth = bufferedImage.getWidth(); // 源图宽度
				double srcHeight = bufferedImage.getHeight(); // 源图高度
				
				int destHeight = (int) (destWidth/srcWidth*srcHeight);
				
				if(srcWidth>destWidth&&srcHeight>destHeight) {
					bufferedImage = ImageUtil.thumbnail(bufferedImage, destWidth, destHeight);
				}
				baos = new ByteArrayOutputStream();
				ImageIO.write(bufferedImage, extName, baos);
				baos.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return baos;
	}
}
