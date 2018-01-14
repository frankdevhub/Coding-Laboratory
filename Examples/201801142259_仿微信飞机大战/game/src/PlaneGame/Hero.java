package PlaneGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class Hero {
	private int x;
	private int y;
	private int width;
	private int height;
	private Image image;
	private int score;
	private int oneEnemyScore;
	//定义英雄的总血滴数
	public static final int ALL_BLOOD =10;
	//英雄当前还有多少血
	private int blood;
	//被击中一次减的血
	private int hitBlood;
	private boolean isFire;
	private JPanel panel;
	//定义关卡
	private int level=1;
	private Font font = null;
	private Image scoreImg;
	public Hero(){
		 font = new Font("宋体",Font.BOLD,20);
	}
	public void draw(Graphics g){
		//绘制英雄的剩余血和得分
		/*g.setColor(Color.WHITE);
		g.fillRect(5, 10, ALL_BLOOD, 10);
		g.setColor(Color.RED);
		g.fillRect(5, 10, this.getBlood(), 10);*/
		//得分
		g.setFont(font);
		g.drawImage(scoreImg, 5, 5, 25, 30, panel);
		g.drawString(this.getScore()+"", 35, 25);
		//g.drawString("第"+this.level+"关", 200, 20);
		g.drawImage(image, x, y, width, height, panel);
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
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public Image getImage() {
		return image;
	}
	public void setImage(Image image) {
		this.image = image;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getOneEnemyScore() {
		return oneEnemyScore;
	}
	public void setOneEnemyScore(int oneEnemyScore) {
		this.oneEnemyScore = oneEnemyScore;
	}
	
	public int getBlood() {
		return blood;
	}
	public void setBlood(int blood) {
		this.blood = blood;
	}
	public int getHitBlood() {
		return hitBlood;
	}
	public void setHitBlood(int hitBlood) {
		this.hitBlood = hitBlood;
	}
	public boolean isFire() {
		return isFire;
	}
	public void setFire(boolean isFire) {
		this.isFire = isFire;
	}
	public JPanel getPanel() {
		return panel;
	}
	public void setPanel(JPanel panel) {
		this.panel = panel;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public Image getScoreImg() {
		return scoreImg;
	}
	public void setScoreImg(Image scoreImg) {
		this.scoreImg = scoreImg;
	}
	
	
	
}
