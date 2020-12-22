package com.mooer.manager.gtrs.plugin.tool;


import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.OutputStream;
import java.util.Hashtable;

import javax.imageio.ImageIO;

import org.springframework.core.io.ClassPathResource;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.Result;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
 
public class QRCodeUtil {
	private static final String CHARSET = "utf-8";
	private static final String FORMAT_NAME = "JPG";
	// 二维码尺寸
	private static final int QRCODE_SIZE = 300;
	// LOGO宽度
	private static final int WIDTH = 60;
	// LOGO高度
	private static final int HEIGHT = 60;
 
	private static BufferedImage createImage(String content, String imgPath, boolean needCompress,String text) throws Exception {
		@SuppressWarnings("rawtypes")
		Hashtable<EncodeHintType, Comparable> hints = new Hashtable<>();
		hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
		hints.put(EncodeHintType.CHARACTER_SET, CHARSET);
		hints.put(EncodeHintType.MARGIN, 1);
		BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, QRCODE_SIZE, QRCODE_SIZE,
				hints);
		int width = bitMatrix.getWidth();
		int height = bitMatrix.getHeight();
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				image.setRGB(x, y, bitMatrix.get(x, y) ? 0xFF000000 : 0xFFFFFFFF);
			}
		}
		if (imgPath == null || "".equals(imgPath)) {
			return image;
		}
		// 插入图片
		QRCodeUtil.insertImage(image, imgPath, needCompress,text);
		// 插入文字背景
		return image;
	}
 
	public static BufferedImage createImageByText(String str) throws Exception {
        String[] strArr = str.split(",");
        Font font = new Font("微软雅黑", Font.PLAIN, 12); // 字体大小
        int image_height = 12; // 每张图片的高度
        int line_height = 10; // 每行或者每个文字的高度
        int width = 8 * str.length();

        // 创建图片
        BufferedImage image = new BufferedImage(width,image_height,BufferedImage.TYPE_USHORT_565_RGB);
        Graphics2D g = image.createGraphics();
        g.setClip(0, 0, width, image_height);
        g.setColor(Color.white); // 背景色白色
//        g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 1.0f));
        g.fillRect(0, 0, width, image_height);
        g.setColor(new Color(120, 120, 120));//  
        g.setFont(font);// 设置画笔字体
        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HRGB); // 抗锯齿
        // 画布
        g.drawString(strArr[0], 0, line_height);
        g.dispose(); // 释放资源
        return image;
    }

	private static void insertImage(BufferedImage source, String imgPath, boolean needCompress,String text) throws Exception {
		ClassPathResource resource = new ClassPathResource(imgPath);
		if (!resource.isReadable()) {
			System.err.println("" + imgPath + "   该文件不存在！");
			return;
		}
		Image src = ImageIO.read(resource.getInputStream());
		int width = src.getWidth(null);
		int height = src.getHeight(null);
		if (needCompress) { // 压缩LOGO
			if (width > WIDTH) {
				width = WIDTH;
			}
			if (height > HEIGHT) {
				height = HEIGHT;
			}
			Image image = src.getScaledInstance(width, height, Image.SCALE_SMOOTH);
			BufferedImage tag = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			Graphics g = tag.getGraphics();
			g.drawImage(image, 0, 0, null); // 绘制缩小后的图
			g.dispose();
			src = image;
		}
		// 插入LOGO
		Graphics2D graph = source.createGraphics();
		int x = (QRCODE_SIZE - width) / 2;
		int y = (QRCODE_SIZE - height) / 2;
		graph.drawImage(src, x, y, width, height, null);
		Shape shape = new RoundRectangle2D.Float(x, y, width, width, 6, 6);
		graph.setStroke(new BasicStroke(3f));
		graph.draw(shape);
		
		//插入文字
		Image textImg = QRCodeUtil.createImageByText(text);
//		int textWidth = textImg.getWidth(null);
		int textHeight = textImg.getHeight(null);
		graph.drawImage(textImg, 18, QRCODE_SIZE-textHeight-4, null);
		graph.dispose();
	}
 
	public static void encode(String content, String imgPath, String destPath, boolean needCompress,String text) throws Exception {
		BufferedImage image = QRCodeUtil.createImage(content, imgPath, needCompress,text);
		mkdirs(destPath);
		// String file = new Random().nextInt(99999999)+".jpg";
		// ImageIO.write(image, FORMAT_NAME, new File(destPath+"/"+file));
		ImageIO.write(image, FORMAT_NAME, new File(destPath));
	}
 
	public static BufferedImage encode(String content, String imgPath, boolean needCompress,String text) throws Exception {
		BufferedImage image = QRCodeUtil.createImage(content, imgPath, needCompress,text);
		return image;
	}
 
	public static void mkdirs(String destPath) {
		File file = new File(destPath);
		// 当文件夹不存在时，mkdirs会自动创建多层目录，区别于mkdir．(mkdir如果父目录不存在则会抛出异常)
		if (!file.exists() && !file.isDirectory()) {
			file.mkdirs();
		}
	}
 
	public static void encode(String content, String imgPath, String destPath,String text) throws Exception {
		QRCodeUtil.encode(content, imgPath, destPath, false,text);
	}
	// 被注释的方法
	/*
	 * public static void encode(String content, String destPath, boolean
	 * needCompress) throws Exception { QRCodeUtil.encode(content, null, destPath,
	 * needCompress); }
	 */
 
	public static void encode(String content, String destPath,String text) throws Exception {
		QRCodeUtil.encode(content, null, destPath, false,text);
	}
 
	public static void encode(String content, String imgPath, OutputStream output, boolean needCompress,String text)
			throws Exception {
		BufferedImage image = QRCodeUtil.createImage(content, imgPath, needCompress,text);
		ImageIO.write(image, FORMAT_NAME, output);
	}
 
	public static void encode(String content, OutputStream output,String text) throws Exception {
		QRCodeUtil.encode(content, null, output, false,text);
	}
 
	public static String decode(File file) throws Exception {
		BufferedImage image;
		image = ImageIO.read(file);
		if (image == null) {
			return null;
		}
		BufferedImageLuminanceSource source = new BufferedImageLuminanceSource(image);
		BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
		Result result;
		Hashtable<DecodeHintType, String> hints = new Hashtable<>();
		hints.put(DecodeHintType.CHARACTER_SET, CHARSET);
		result = new MultiFormatReader().decode(bitmap, hints);
		String resultStr = result.getText();
		return resultStr;
	}
 
	public static String decode(String path) throws Exception {
		return QRCodeUtil.decode(new File(path));
	}
 
//	public static void main(String[] args) throws Exception {
//		// 存放在二维码中的内容
//		String text = "https://v1.cecdn.yun300.cn/fsite_1804040320/GE200_Manual_EN_V03_2019.04.301559198689170.pdf";
//		// 嵌入二维码的图片路径
//		String imgPath = "D:/work/gtrs网站/q/gtrs_q.jpg";
//		// 生成的二维码的路径及名称
//		String destPath = "D:/work/gtrs网站/q/main.jpg";
//		//生成二维码
//		QRCodeUtil.encode(text, imgPath, destPath, true);
//		// 解析二维码
//		String str = QRCodeUtil.decode(destPath);
//		// 打印出解析出的内容
//		System.out.println(str);
//	}
	
}
