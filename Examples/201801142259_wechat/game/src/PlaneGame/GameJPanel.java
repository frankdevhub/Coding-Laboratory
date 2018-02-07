package PlaneGame;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class GameJPanel  extends JPanel implements MouseListener,
	MouseMotionListener,Runnable,KeyListener{
	//被控制小球
	private Hero hero;
	//英雄发射的子弹
	private List<Bullet> heroBullets;
	//英雄发射子弹的图片
	private Image heroBulletImage;
	//定义一个集合，用来保持下落的敌机
	private List<Enemy> enemys;
	private List<Enemy> deadEnemys;
	//定义下落泡泡的数量
	private int num;
	private Random ran = new Random();
	//定义背景图
	private Image imgBg;
	//定义背景图左上角Y轴的坐标
	private int bgY;
	
	//是否通关
	private boolean pass;
	private Image enemyImage;
	private Image scoreImage;
	private GameJPanel panel;
	public GameJPanel(){
		hero = new Hero();
		scoreImage = new ImageIcon("img/score.png").getImage();
		hero.setX(100);
		hero.setY(500);
		hero.setWidth(60);
		hero.setHeight(60);
		hero.setFire(false);
		hero.setBlood(Hero.ALL_BLOOD);
		hero.setHitBlood(5);
		hero.setOneEnemyScore(1000);
		hero.setPanel(this);
		hero.setScoreImg(scoreImage);
		hero.setImage(new ImageIcon("img/plane.png").getImage());
		//设置关卡
		hero.setLevel(1);
		heroBullets = new ArrayList<Bullet>();
		heroBulletImage = new ImageIcon("img/fire.png").getImage();
		enemys = new ArrayList<Enemy>();
		deadEnemys = new ArrayList<Enemy>();
		num = 10;
		enemyImage = new ImageIcon("img/enemyPlane.png").getImage();
		for (int j = 0; j < num; j++) {
			Enemy b2 = new Enemy();
			b2.setWidth(50);
			b2.setHeight(50);
			b2.setX(ran.nextInt(400));
			b2.setY(-ran.nextInt(640));
			b2.setDirection(Enemy.DOWN);
			b2.setType("L");
			b2.setSpeed(2);
			b2.setImage(enemyImage);
			b2.setPanel(this);
			enemys.add(b2);
		}
		imgBg =new ImageIcon("img/background.png").getImage();
		bgY = -700;
	}
	public void restart(){
		hero.setX(100);
		hero.setY(500);
		hero.setFire(false);
		hero.setScore(0);
		hero.setBlood(Hero.ALL_BLOOD);
		hero.setScoreImg(scoreImage);
		enemys.clear();
		deadEnemys.clear();
		Image image = new ImageIcon("img/enemyPlane.png").getImage();
		for (int j = 0; j < num; j++) {
			Enemy b2 = new Enemy();
			b2.setWidth(50);
			b2.setHeight(50);
			b2.setX(ran.nextInt(380)+5);
			b2.setY(-ran.nextInt(640));
			b2.setDirection(Enemy.DOWN);
			b2.setType("L");
			b2.setSpeed(4);
			b2.setImage(image);
			//测试是不是可以执行
			b2.setPanel(this);
			enemys.add(b2);
		}
		//System.out.println("enemys.size()======"+enemys.size());
		repaint();
	}
	public void paint(Graphics g){
		super.paint(g);
		//this.setBackground(Color.BLACK);
		//g.drawImage(imgBg, 0, bgY, 430, 640, this);
		g.drawImage(imgBg, 0, bgY,430,1340,this);
		//绘制英雄机的子弹
		for (int i = 0; i < heroBullets.size(); i++) {
			heroBullets.get(i).draw(g);
		}
		//绘制正常的敌机
		for (int j = 0; j < enemys.size(); j++) {
			enemys.get(j).draw(g);
		}
		//绘制爆炸的敌机
		for (int k = 0; k < deadEnemys.size(); k++) {
			deadEnemys.get(k).draw(g);
		}
		//绘制英雄机、得分、血点数、关卡
		hero.draw(g);
		if(hero.getBlood()<=0){
			hero.setFire(false);
			Font font = new Font("宋体",Font.BOLD,36);
			g.setFont(font);
			g.drawString("Game Over!", 60, 260);
			//g.drawString("按F1重新开始!", 60, 360);
		}
		if(pass){
			Font font = new Font("宋体",Font.BOLD,36);
			g.setFont(font);
			g.drawString("恭喜您通关了!", 60, 260);
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		hero.setFire(true);
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		hero.setFire(false);
	}
	@Override
	public void mousePressed(MouseEvent e) {
		hero.setFire(true);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		hero.setFire(false);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if(hero.getBlood()>0&&!pass){
			hero.setFire(true);
			hero.setX((int) (e.getPoint().getX()-hero.getWidth()/2.0));
			hero.setY((int) (e.getPoint().getY()-hero.getHeight()/2.0));
			repaint();
		}
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		if(hero.getBlood()>0&&!pass){
			hero.setFire(true);
			hero.setX((int) (e.getPoint().getX()-hero.getWidth()/2.0));
			hero.setY((int) (e.getPoint().getY()-hero.getHeight()/2.0));
			repaint();
		}
	}
	/*//判断上升子弹和敌机是否发生碰撞
	public boolean  isHit(Enemy e,Bullet bullet){
		boolean isHit = false;
    	//敌机的中心坐标
    	int ex1 = e.getX()+e.getWidth()/2;
    	int ey1 = e.getY()+e.getHeight()/2;
    	//若干敌机的中心（心脏）碰到子弹，表示敌机被击中
    	if(ex1>bullet.getX()&&ex1<bullet.getX()+bullet.getWidth()
    			&&ey1>bullet.getY()&&ey1<bullet.getY()+bullet.getHeight()){
    		isHit = true;
    	}
    	return isHit;
	}*/
	//判断上升子弹和敌机是否发生碰撞
		public boolean  isHit(Enemy bullet,Bullet e){
			boolean isHit = false;
	    	//子弹的中心坐标
	    	int ex1 = e.getX()+e.getWidth()/2;
	    	int ey1 = e.getY()+e.getHeight()/2;
	    	//若干敌机的中心（心脏）碰到子弹，表示敌机被击中
	    	if(ex1>bullet.getX()&&ex1<bullet.getX()+bullet.getWidth()
	    			&&ey1>bullet.getY()&&ey1<bullet.getY()+bullet.getHeight()){
	    		isHit = true;
	    	}
	    	return isHit;
		}
	//判断英雄机和敌机是否发生碰撞
	public boolean  isHit(Enemy e,Hero h){
		boolean isHit = false;
    	//英雄机的中心坐标
    	int hx1 = h.getX()+h.getWidth()/2;
    	int hy1 = h.getY()+h.getHeight()/2;
    	//若干敌机的中心（心脏）碰到子弹，表示敌机被击中
    	if(hx1>e.getX()&&hx1<e.getX()+e.getWidth()
    			&&hy1>e.getY()&&hy1<e.getY()+e.getHeight()){
    		isHit = true;
    	}
    	return isHit;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		int count = 0;
		int bgCount = 0;
		while(hero.getBlood()>0&&!pass){
			for (int i = 0; i < deadEnemys.size(); i++) {
				deadEnemys.remove(i);
			}
			//deadEnemys.removeAll(deadEnemys);
			if(hero.isFire()&&count%25==0){
				Bullet bullet = new Bullet();
				//bullet.setColor(Color.RED);
				bullet.setWidth(10);
				bullet.setHeight(15);
				bullet.setX(hero.getX()+hero.getWidth()/2-bullet.getWidth()/2);
				bullet.setY(hero.getY());
				bullet.setSpeed(20);
				bullet.setImage(heroBulletImage);
				bullet.setPanel(this);
				bullet.setDirection(Bullet.UP);
				heroBullets.add(bullet);
			}
			
			//移动英雄发射的子弹,并且删除移动到窗体外的
			for (int i = 0; i < heroBullets.size(); i++) {
				Bullet b1 = heroBullets.get(i);
				if(b1.getY()<=-b1.getHeight()){
					heroBullets.remove(i);
				}else{
					b1.move();
				}
			}
			for (int m = 0; m < enemys.size(); m++) {
				Enemy enemy = enemys.get(m);
				if(enemy.getY()>=640){
					enemy.setY(-enemy.getHeight());
					enemy.setX(ran.nextInt(425)+5);
					
				}else{
					enemy.move();
				}
			}
			//处理碰撞问题
			for (int k = 0; k < enemys.size(); k++) {
				Enemy enemy = enemys.get(k);
				//敌机和英雄机碰撞处理
				if(isHit(enemy, hero)){
					hero.setBlood(hero.getBlood()-hero.getHitBlood());
					Enemy deadEnemy = new Enemy();
					deadEnemy.setType("D");
					deadEnemy.setX(enemy.getX());
					deadEnemy.setY(enemy.getY());
					deadEnemy.setWidth(enemy.getWidth());
					deadEnemy.setHeight(enemy.getHeight());
					deadEnemys.add(deadEnemy);
					
					enemy.setY(-enemy.getHeight());
					enemy.setX(ran.nextInt(425)+5);
				}
				//敌机和子弹碰撞处理
				for (int n = 0; n < heroBullets.size(); n++) {
					if(isHit(enemy, heroBullets.get(n))){
						heroBullets.remove(n);
						Enemy deadEnemy = new Enemy();
						deadEnemy.setType("D");
						deadEnemy.setX(enemy.getX());
						deadEnemy.setY(enemy.getY());
						deadEnemy.setWidth(enemy.getWidth());
						deadEnemy.setHeight(enemy.getHeight());
						deadEnemys.add(deadEnemy);
						
						enemy.setY(-enemy.getHeight());
						enemy.setX(ran.nextInt(425)+5);
						hero.setScore(hero.getScore()+hero.getOneEnemyScore());
					}
				}
			}
			//背景图向下移动
			if(bgY<0){
				if(bgCount%5==0){
					bgY++;
				}
			}else{
				hero.setLevel(hero.getLevel()+1);
				//敌机速度在原来的基础上加1
				for (int i = 0; i < enemys.size(); i++) {
					enemys.get(i).setSpeed(enemys.get(i).getSpeed()+1);
				}
				bgY=-720;
				if(hero.getLevel()==2){
					imgBg = new ImageIcon("img/background.png").getImage();
				}else if(hero.getLevel()==3){
					imgBg = new ImageIcon("img/background.png").getImage();
				}else{
					//通关
					pass = true;
				}
			}
			bgCount++;
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			count++;
			repaint();
		}
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println(e.getKeyCode());
		if(e.getKeyCode()==KeyEvent.VK_F1){
			//重新开始
			hero.setBlood(Hero.ALL_BLOOD);
			hero.setScore(0);
			hero.setLevel(1);
			//初始化敌机
			for (int j = 0; j < num; j++) {
				Enemy b2 = enemys.get(j);
				b2.setX(ran.nextInt(425)+5);
				b2.setY(-ran.nextInt(640));
				b2.setSpeed(4);
			}
			//清理子弹
			new Thread(panel).start();
		}else if(e.getKeyCode()==KeyEvent.VK_UP){
			hero.setY(hero.getY()-3);
			repaint();
		}else if(e.getKeyCode()==KeyEvent.VK_RIGHT){
			hero.setX(hero.getX()+3);
			repaint();
		}else if(e.getKeyCode()==KeyEvent.VK_DOWN){
			hero.setY(hero.getY()+3);
			repaint();
		}else if(e.getKeyCode()==KeyEvent.VK_LEFT){
			hero.setX(hero.getX()-3);
			repaint();
		}
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	public GameJPanel getPanel() {
		return panel;
	}
	public void setPanel(GameJPanel panel) {
		this.panel = panel;
	}
	

}

