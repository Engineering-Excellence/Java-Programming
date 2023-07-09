package edu.kosa.thumb;

import javax.imageio.ImageIO;
import javax.media.jai.JAI;
import javax.media.jai.RenderedOp;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Thumbnail {

    // 썸네일 이미지를 생성하는 메서드
    public static void createImage(String loadFile, String saveFile, String fileExt, int zoom) throws IOException {

        File save = new File(saveFile); // 썸네일 이미지
        // loadFile: 원본 이미지, RenderedOp 객체 생성
        RenderedOp op = JAI.create("loadFile", loadFile);
        // BufferedImage 이미지 객체
        BufferedImage im = op.getAsBufferedImage();

        if (zoom <= 0) zoom = 1;

        int width = im.getWidth() / zoom;
        int height = im.getHeight() / zoom;

        // 메모리에 이미지 공간을 생성
        BufferedImage thumb = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        Graphics2D g2 = thumb.createGraphics();

        // 메모리의 이미지 공간에 원본 이미지를 width, height 크기로 그리기
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(im, 0, 0, width, height, null);    // 실제로 그려주는 부분
        g2.dispose();
        ImageIO.write(thumb, fileExt.toUpperCase(), save);  // 메모리에 그린 이미지를 파일로 저장
    }
}
