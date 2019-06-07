package com.woyi.common.fileutil;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Random;

/**
 * 图片生成缩略图，生成水印，加水印
 * 
 * @author 崔祥
 * @since 2014-12-18
 */
public class ImageUtil {
    /**
     * 图片压缩之后再添加水印
     *
     * @param from
     * @param to
     * @param waterMark
     * @throws IOException
     */
    public void createWatermark(String from, String to, String waterMark)
            throws IOException {
        /**
         *
         * 16 size=10px -> 12 size=12*0.625=7.5px ;
         */
        File file = new File(from);
        BufferedImage image = ImageIO.read(file);
        int width = image.getWidth();
        int height = image.getHeight();
     // font pixel length
        int length = (int) (waterMark.length() * 7.5);
 
        if (width > length) {
            Graphics2D graph = (Graphics2D) image.getGraphics();
            graph.drawImage(image, 0, 0, width, height, null);
            Font font = new Font("黑体", Font.TYPE1_FONT, 12);
            graph.setFont(font);
            graph.setColor(Color.WHITE);
            int x = width - length;
            int y = height - 4;
 
            graph.drawString(waterMark, x, y);
            graph.dispose();
            OutputStream out = new BufferedOutputStream(
                    new FileOutputStream(to));
            String imageType = "";
 
            if (from.endsWith(".jpg")) {
                imageType = "jpg";
            } else if (from.endsWith(".png")) {
                imageType = "png";
            } else if (from.endsWith(".bmp")) {
                imageType = "bmp";
            } else {
                imageType = "gif";
            }
            ImageIO.write(image, imageType, out);
            out.close();
        }
 
    }
 
    /**
     * 生成邮箱图片
     *
     * @param mail
     * @param to
     * @throws IOException
     */
    public void createMail(String mail, String to) throws IOException {
        /**
         *
         * 16 size=10px -> 12 size=12*0.625=7.5px ;
         */
        int width = (int) (mail.length() * 7.5) + 2;
        int height = 17;
        BufferedImage image = new BufferedImage(width, height,
                BufferedImage.TYPE_INT_RGB);
        Graphics2D graph = (Graphics2D) image.getGraphics();
        graph.fillRect(0, 0, width, height);
        Font font = new Font("Courier New", Font.TYPE1_FONT, 12);
        graph.setFont(font);
        graph.setColor(new Color(0, 162, 232));
        int x = 4;
        int y = 13;
        graph.drawString(mail, x, y);
        graph.dispose();
        OutputStream out = new BufferedOutputStream(new FileOutputStream(to));
        ImageIO.write(image, "jpg", out);
        out.close();
 
    }
 
    /**
     * 参数随机验证码
     *
     * @param to
     * @throws IOException
     */
    public void createCaptcha(String to) throws IOException {
        int width = 120;
        int height = 34;
        BufferedImage image = new BufferedImage(width, height,
                BufferedImage.TYPE_INT_RGB);
        Graphics2D graph = (Graphics2D) image.getGraphics();
        graph.fillRect(0, 0, width, width);
        graph.setColor(new Color(0, 162, 232));
     // border
        graph.drawRect(1, 1, width - 2, height - 2);
        Font font = new Font("consolas", Font.BOLD, 30);
        graph.setFont(font);
        drawRandomNumber(graph);
 
        graph.dispose();
        OutputStream out = new BufferedOutputStream(new FileOutputStream(to));
 
        ImageIO.write(image, "gif", out);
        out.close();
 
    }
 
    /**
     * 获取随机数（验证码）
     * @param graph
     */
    public void drawRandomNumber(Graphics2D graph) {
        Random r = new Random();
        String letters = "B7ASV8XC9WD1IYT2KL3EPQ4ZJRGH5FUMO6N";
        int length = letters.length();
        int start = 12;
        int times = 6;
      //随机颜色
        graph.setColor(new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256)));
        for (int i = 0; i < times; i++) {
        	
        	//旋转度数 最好小于45度
            int degree = r.nextInt(30);
            String ch = letters.charAt(r.nextInt(length)) + "";
            if (i % 2 == 1) {
				degree = degree * (-1);
			}
            graph.rotate(Math.toRadians(degree), start, 21);
            graph.drawString(ch, start, 28);
            
          //旋转之后，必须旋转回来
            graph.rotate(-Math.toRadians(degree), start, 21);
            start += 16;
 
        }
    }
 
    /**
     * 参考豆瓣相册缩放比例制作 生成图片缩略图
     *
     * @param from
     * @param to
     * @param zoomWidth
     * @param zoomHeight
     * @throws IOException
     */
    public void thumbnai(String from, String to, int zoomWidth, int zoomHeight)
            throws IOException {
        File file = new File(from);
        BufferedImage image = ImageIO.read(file);
        int width = image.getWidth();
        int height = image.getHeight();
        double scale = 1.0;
        /**
         * 参考豆瓣相册缩放比例制作的
         *  1 图片尺寸宽度小于压缩宽度 并且高度小于压缩高度：不缩放，直接压缩即可
         *  2 图片尺寸宽度小于压缩宽度 但高度大于压缩高度：按照 zoomwidth/height缩放
         *  3 图片尺寸宽度大于压缩宽度 并且高度小于宽度 ：按照宽度缩放
         *   4 图片尺寸宽度大于压缩宽度 但高度大于宽度 ：按照 zoomWidth/ height缩放
         */
        if (width <= zoomWidth) {
            if (height <= zoomHeight) {
                scale = 1.0;
            } else {
                scale = zoomWidth * 1.0 / height;
            }
        } else {
            if (height > width) {
                scale = zoomWidth * 1.0 / height;
            } else {
                scale = zoomWidth * 1.0 / width;
            }
        }
        width = (int) (width * scale);
        height = (int) (height * scale);
        BufferedImage thumb = new BufferedImage(width, height,
                BufferedImage.SCALE_SMOOTH);
 
        Graphics2D graph = (Graphics2D) thumb.getGraphics();
        graph.drawImage(image, 0, 0, width, height, null);
 
        graph.dispose();
        BufferedOutputStream out = new BufferedOutputStream(
                new FileOutputStream(to));
 
        String imageType = "";
 
        if (from.endsWith(".jpg")) {
            imageType = "jpg";
        } else if (from.endsWith(".png")) {
            imageType = "png";
        } else if (from.endsWith(".bmp")) {
            imageType = "bmp";
        } else {
            imageType = "gif";
 
        }
 
        ImageIO.write(thumb, imageType, out);
        out.close();
 
    }
 
   /* public static void main(String[] args) throws IOException {
        ImageUtil imageUtils = new ImageUtil();
 
        String fromPath = "F:\\test\\temp\\11.jpg";
        String toPath = "F:\\test\\temp\\33"+fromPath.substring(fromPath.lastIndexOf('.'));
        imageUtils.thumbnai(fromPath, toPath, 600, 450);
 */
        /*
         * test createMail
         */
  /*      String mailPath = "E:\\mail.gif";
        String mail = "cuixiang@silomall.com";
        imageUtils.createMail(mail, mailPath);
 */
        /*最好是生成缩略图压缩之后再添加水印
         * test createWatermark
         */
  /*      String waterMarkPath = "E:\\watermark"+toPath.substring(toPath.lastIndexOf('.'));
        imageUtils.createWatermark(toPath, waterMarkPath, mail);
 */
        /*
         * test createCaptcha
         */
 /*       String captchaPath = "E:\\captcha.gif";
        imageUtils.createCaptcha(captchaPath);
 
    }*/
}
