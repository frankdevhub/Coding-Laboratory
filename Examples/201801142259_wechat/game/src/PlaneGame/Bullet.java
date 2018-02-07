package PlaneGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class Bullet {
	//坐标x,y  以及高和宽
	private int x;
	private int y;
	private int height;
	private int width;
	//子弹图片
	private Image image;
	//速度
	private int speed;
	//颜色
	private Color color;
	//移动的方向
	private int direction;
	private JPanel panel;
	//定义几个常量，表示移动的具体方向
	public static final int UP=0;
	public static final int DOWN=1;
	
	//绘制泡泡的方法
	public void draw(Graphics g){
		//g.setColor(color);
		g.drawImage(image, x, y, width, height, panel);
	}
	//移动的方法
	public void move(){
		switch (direction) {
		case UP:
			y=y-speed;
			break;
		case DOWN:
			y = y+speed;
			break;
		default:
			break;
		}
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public int getDirection() {
		return direction;
	}
	public void setDirection(int direction) {
		this.direction = direction;
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public Image getImage() {
		return image;
	}
	public void setImage(Image image) {
		this.image = image;
	}
	
	
	
}
