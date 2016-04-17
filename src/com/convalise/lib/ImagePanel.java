

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImagePanel extends GradientPanel {

	private BufferedImage BackgroundImg;
	private int PosX;
	private int PosY;
	private int ID;

	private boolean isImageVisible;

	public ImagePanel() {
		this.BackgroundImg = null;
		this.PosX = 0;
		this.PosY = 0;
		this.ID = 0;
	}

	public ImagePanel(File ImgFile) {
		this(ImgFile, 0, 0);
		this.ID = 0;
	}

	public ImagePanel(File ImgFile, int PosX, int PosY) {
		try {
			this.BackgroundImg = ImageIO.read(ImgFile);
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
		}
		this.PosX = PosX;
		this.PosY = PosY;
		this.ID = 0;
	}

	public ImagePanel(ImagePanel Panel) {
		this.BackgroundImg = Panel.getImageBackground();
		this.PosX = Panel.getImagePosX();
		this.PosY = Panel.getImagePosY();
		this.ID = 0;
	}

	public void setImageBackground(File ImgFile) {
		try {
			this.BackgroundImg = ImageIO.read(ImgFile);
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public void setImagePosition(int PosX, int PosY) {
		this.PosX = PosX;
		this.PosX = PosY;
	}

	public void setImageID(int ID) {
		this.ID = ID;
	}

	public void setImageVisible(boolean isImageVisible) {
		this.isImageVisible = isImageVisible;
	}

	public BufferedImage getImageBackground() {
		return this.BackgroundImg;
	}

	public int getImagePosX() {
		return this.PosX;
	}

	public int getImagePosY() {
		return this.PosY;
	}

	public int getImageID() {
		return this.ID;
	}

	public boolean isImageVisible() {
		return this.isImageVisible;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2D = (Graphics2D) g.create();

		if(BackgroundImg!=null && isImageVisible)
			g2D.drawImage(BackgroundImg, PosX, PosY, null);

		g2D.dispose();

	}

}