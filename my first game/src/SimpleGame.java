import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;


public class SimpleGame extends BasicGame
{
	
	private LifeItem m_lifeItem;
	
	private Instructions m_instructions;
	
	private Image m_background;
	private Image m_winningImage;
	private Image m_GameOverImage;
	
	private WinningBox m_winningBoxes[];
				
	private Water m_water;
	
	private Player m_player;

	private int m_time;
	private int m_campingTimer = 0;
	
	private int m_points;
	private int m_lives = 5;
	
	private int WinningBoxesReached = 0;
	
	private DeathItem m_deathitem;
	
	private WorldArea m_worldArea;
	
	private WoodenBeamS m_woodenBeamSmall1;
	private WoodenBeamS m_woodenBeamSmall2;
	private WoodenBeamS m_woodenBeamSmall3;
	
	private WoodenBeamS m_woodenBeamSmall4;
	private WoodenBeamS m_woodenBeamSmall5;
	private WoodenBeamS m_woodenBeamSmall6;
	
	
	private WoodenBeamM m_woodenBeamMedium1;
	private WoodenBeamM m_woodenBeamMedium2;
	private WoodenBeamM m_woodenBeamMedium3;
	
	
	private WoodenBeamL m_woodenBeamLarge1;
	private WoodenBeamL m_woodenBeamLarge2;
	private WoodenBeamL m_woodenBeamLarge3;
	
	
	private Car m_car1;
	private Car m_car2;
	private Car m_car3;
	
	private Car m_car4;
	private Car m_car5;
	private Car m_car6;
	private Car m_car7;
	
	private SportsCar m_sportsCar1;
	private SportsCar m_sportsCar2;
	private SportsCar m_sportsCar3;
	
	private SportsCar m_sportsCar4;
	private SportsCar m_sportsCar5;
	private SportsCar m_sportsCar6;
	private SportsCar m_sportsCar7;
	
	private Pickup m_pickup1;
	private Pickup m_pickup2;
	private Pickup m_pickup3;
	
	private Pickup m_pickup4;
	private Pickup m_pickup5;
	private Pickup m_pickup6;
	private Pickup m_pickup7;
	
	
	private WinningArea1 m_area1;
	private WinningArea2 m_area2;
	private WinningArea3 m_area3;
	private WinningArea4 m_area4;
	private WinningArea5 m_area5;
	
	private FreezeItem m_freezeItem;
	private int m_freeze = 0;
	private int m_millisPassedFreeze;
	
	public SimpleGame()
	{	
		super("Slick2DPath2Glory - SimpleTest");
	}
	
	@Override 
	public void init(GameContainer gc) 
			throws SlickException 
	{
		m_background = new Image("data/backgroundImage.jpg"); 
		m_winningImage = new Image("data/WinningImage.png");
		m_GameOverImage = new Image("data/GameOverImage.png");
		
		m_player = new Player(new Vector2f(400, 550));
		m_water = new Water();
		
		m_instructions = new Instructions();
		
		m_worldArea = new WorldArea();
		
		m_deathitem = new DeathItem(new Vector2f(0, 0));
		m_freezeItem = new FreezeItem(new Vector2f(0, 0));
		m_lifeItem = new LifeItem(new Vector2f(0,0));
		
		m_area1 = new WinningArea1();
		m_area2 = new WinningArea2();
		m_area3 = new WinningArea3();
		m_area4 = new WinningArea4();
		m_area5 = new WinningArea5();
		
		m_winningBoxes = new WinningBox[1];
		m_winningBoxes[0] = new WinningBox(new Vector2f(65, 10));
		
		/*m_WinningBoxes[1] = new WinningBox(200, 500, 50, 50);
		m_WinningBoxes[2] = new WinningBox(300, 500, 50, 50);
		m_WinningBoxes[3] = new WinningBox(400, 500, 50, 50);
		m_WinningBoxes[4] = new WinningBox(500, 500, 50, 50);*/
		

		m_woodenBeamSmall1 = new WoodenBeamS(new Vector2f(800, 185), new Vector2f(-1100, 185));
		m_woodenBeamSmall2 = new WoodenBeamS(new Vector2f(1200, 185), new Vector2f(-700, 185));
		m_woodenBeamSmall3 = new WoodenBeamS(new Vector2f(1600, 185), new Vector2f(-300, 185));
		
		m_woodenBeamSmall4 = new WoodenBeamS(new Vector2f(900, 50), new Vector2f(-300, 50));
		m_woodenBeamSmall5 = new WoodenBeamS(new Vector2f(1100, 50), new Vector2f(-300, 50));
		m_woodenBeamSmall6 = new WoodenBeamS(new Vector2f(1400, 50), new Vector2f(-300, 50));
		
		
		
		m_woodenBeamMedium1 = new WoodenBeamM(new Vector2f(900, 140), new Vector2f(-300, 140));
		m_woodenBeamMedium2 = new WoodenBeamM(new Vector2f(1200, 140), new Vector2f(-400, 140));
		m_woodenBeamMedium3 = new WoodenBeamM(new Vector2f(1600, 140), new Vector2f(-250, 140));
		
		
		m_woodenBeamLarge1 = new WoodenBeamL(new Vector2f(-300, 95), new Vector2f(2200, 95));
		m_woodenBeamLarge2 = new WoodenBeamL(new Vector2f(-850, 95), new Vector2f(1650, 95));
		m_woodenBeamLarge3 = new WoodenBeamL(new Vector2f(-1400, 95), new Vector2f(1100, 95));
		
		
		m_car1 = new Car(new Vector2f(-100, 480), new Vector2f(2700, 480));
		m_car2 = new Car(new Vector2f(-400, 480), new Vector2f(2400, 480));
		m_car3 = new Car(new Vector2f(-690, 480), new Vector2f(2110, 480));
		m_car4 = new Car(new Vector2f(-1000, 480), new Vector2f(1800, 480));
		m_car5 = new Car(new Vector2f(-1350, 480), new Vector2f(1450, 480));
		m_car6 = new Car(new Vector2f(-1700, 480), new Vector2f(1100, 480));
		m_car7 = new Car(new Vector2f(-1980, 480), new Vector2f(820, 480));

		
		m_sportsCar1 = new SportsCar(new Vector2f(900, 400), new Vector2f(-2500, 400));
		m_sportsCar2 = new SportsCar(new Vector2f(1100, 400), new Vector2f(-2300, 400));
		m_sportsCar3 = new SportsCar(new Vector2f(1300, 400), new Vector2f(-2100, 400));
		
		m_sportsCar4 = new SportsCar(new Vector2f(2100, 400), new Vector2f(-1300, 400));
		m_sportsCar5 = new SportsCar(new Vector2f(2300, 400), new Vector2f(-1100, 400));
		m_sportsCar6 = new SportsCar(new Vector2f(2500, 400), new Vector2f(-900, 400));
		m_sportsCar7 = new SportsCar(new Vector2f(3300, 400), new Vector2f(-100, 400));
		
		
		m_pickup1 = new Pickup(new Vector2f(900, 320), new Vector2f(-2500, 320));
		m_pickup2 = new Pickup(new Vector2f(1300, 320), new Vector2f(-2100, 320));
		m_pickup3 = new Pickup(new Vector2f(1700, 320), new Vector2f(-1700, 320));
		
		m_pickup4 = new Pickup(new Vector2f(2100, 320), new Vector2f(-1300, 320));
		m_pickup5 = new Pickup(new Vector2f(2500, 320), new Vector2f(-900, 320));
		m_pickup6 = new Pickup(new Vector2f(2900, 320), new Vector2f(-500, 320));
		m_pickup7 = new Pickup(new Vector2f(3300, 320), new Vector2f(-100, 320));
		
		
		m_woodenBeamSmall1.Initialize();
		m_woodenBeamSmall2.Initialize();
		m_woodenBeamSmall3.Initialize();
		m_woodenBeamSmall4.Initialize();
		m_woodenBeamSmall5.Initialize();
		m_woodenBeamSmall6.Initialize();
		
		m_woodenBeamMedium1.Initialize();
		m_woodenBeamMedium2.Initialize();
		m_woodenBeamMedium3.Initialize();
		
		m_woodenBeamLarge1.Initialize();
		m_woodenBeamLarge2.Initialize();
		m_woodenBeamLarge3.Initialize();
		
		
		m_car1.Initialize();
		m_car2.Initialize();
		m_car3.Initialize();
		
		m_car4.Initialize();
		m_car5.Initialize();
		m_car6.Initialize();
		m_car7.Initialize();
		
		m_sportsCar1.Initialize();
		m_sportsCar2.Initialize();
		m_sportsCar3.Initialize();
		
		m_sportsCar4.Initialize();
		m_sportsCar5.Initialize();
		m_sportsCar6.Initialize();
		m_sportsCar7.Initialize();
		
		m_pickup1.Initialize();
		m_pickup2.Initialize();
		m_pickup3.Initialize();
		
		m_pickup4.Initialize();
		m_pickup5.Initialize();
		m_pickup6.Initialize();
		m_pickup7.Initialize();
		
		m_area1.Initialize();
		m_area2.Initialize();
		m_area3.Initialize();
		m_area4.Initialize();
		m_area5.Initialize();
		
		m_worldArea.Initialize();
		
		m_deathitem.Initialize();
		m_freezeItem.Initialize();
		m_lifeItem.Initialize();
		
		m_water.Initialize();
		m_player.init();
		
		m_instructions.Initialize();
	
		
		for (int i=0; i < m_winningBoxes.length; i++)
		{
			m_winningBoxes[i].Initialize();
			// m_LosingBox[i].Initialize();
		}
		
		//m_LosingBox[int i].Initialize();
			
	} 
	
	@Override 
	public void update(GameContainer gc, int delta) 
			throws SlickException 
	{
		m_player.update(delta, gc.getInput());
		
		m_deathitem.Update(delta);
		m_freezeItem.Update(delta);
		m_lifeItem.Update(delta);
		
		m_winningBoxes[0].Update(delta);
		
		m_instructions.update(delta);
		
    	m_car1.Update(delta);
    	m_car2.Update(delta);
    	m_car3.Update(delta);
    	
    	m_car4.Update(delta);
    	m_car5.Update(delta);
    	m_car6.Update(delta);
    	m_car7.Update(delta);
    	
    	m_pickup1.Update(delta);
    	m_pickup2.Update(delta);
    	m_pickup3.Update(delta);
    	
    	m_pickup4.Update(delta);
    	m_pickup5.Update(delta);
    	m_pickup6.Update(delta);
    	m_pickup7.Update(delta);
    	
    	m_sportsCar1.Update(delta);
    	m_sportsCar2.Update(delta);
    	m_sportsCar3.Update(delta);
    	
    	m_sportsCar4.Update(delta);
    	m_sportsCar5.Update(delta);
    	m_sportsCar6.Update(delta);
    	m_sportsCar7.Update(delta);
    	
    	
    	m_woodenBeamSmall1.Update(delta);
    	m_woodenBeamSmall2.Update(delta);
    	m_woodenBeamSmall3.Update(delta);
    	m_woodenBeamSmall4.Update(delta);
    	m_woodenBeamSmall5.Update(delta);
    	m_woodenBeamSmall6.Update(delta);
    	
    	m_woodenBeamMedium1.Update(delta);
    	m_woodenBeamMedium2.Update(delta);
    	m_woodenBeamMedium3.Update(delta);
    	
    	m_woodenBeamLarge1.Update(delta);
    	m_woodenBeamLarge2.Update(delta);
    	m_woodenBeamLarge3.Update(delta);
    	
    	if (m_player.isAlive() && m_player.intersects(m_car1) | m_player.intersects(m_car2) | m_player.intersects(m_car3)
    			| m_player.intersects(m_car4) | m_player.intersects(m_car5) | m_player.intersects(m_car6) | m_player.intersects(m_car7)
    			
    			| m_player.intersects(m_sportsCar1) | m_player.intersects(m_sportsCar2) | m_player.intersects(m_sportsCar3)
    			| m_player.intersects(m_sportsCar4) | m_player.intersects(m_sportsCar5) | m_player.intersects(m_sportsCar6) | m_player.intersects(m_sportsCar6)
    			
    			| m_player.intersects(m_pickup1) | m_player.intersects(m_pickup2) | m_player.intersects(m_pickup3)
    			| m_player.intersects(m_pickup4) | m_player.intersects(m_pickup5) | m_player.intersects(m_pickup6) | m_player.intersects(m_pickup7)
    		
    			)
    	{
    		m_player.die();
    		m_lives -= 1;
    	}
    	
    	if (m_player.isAlive() && m_player.intersects(m_woodenBeamSmall1) | m_player.intersects(m_woodenBeamSmall2) | m_player.intersects(m_woodenBeamSmall3)
    			| m_player.intersects(m_woodenBeamSmall4) | m_player.intersects(m_woodenBeamSmall5) | m_player.intersects(m_woodenBeamSmall6)
    			)
    	{
    		// brauch ich : 	m_player.alive();	?
    		m_player.moveAlong(m_woodenBeamSmall1.getMovingBeamLeftFast());
    	}
    	
    	if (m_player.isAlive() && m_player.intersects(m_woodenBeamMedium1) | m_player.intersects(m_woodenBeamMedium2) | m_player.intersects(m_woodenBeamMedium3))
    	{
    		m_player.moveAlong(m_woodenBeamMedium1.getMovingBeamLeft());
    	}
    	
    	if (m_player.isAlive() && m_player.intersects(m_woodenBeamLarge1) | m_player.intersects(m_woodenBeamLarge2) | m_player.intersects(m_woodenBeamLarge3))
    	{
    		m_player.moveAlong(m_woodenBeamLarge1.getMovingBeamRight());
    	}
    	
    	for (int i=0; i < m_winningBoxes.length; i++)
    	{
	    	if (m_player.isAlive() && (m_player.intersects(m_winningBoxes[i])))
	    	{
	    		WinningBoxesReached += 1;
	    		m_winningBoxes[i].win();
	    		m_player.win();
	    		
	    		if ((m_time/1000) <=50)
	    			m_points += (2500 - ((m_time/1000) *50));
	    	}
    	}
    	
    	if (m_player.isAlive() && (!(m_player.intersects(m_worldArea))))
    	{
    		m_player.die();
    		m_lives -= 1;
    	}
    	
    	if (m_player.isAlive() && (m_player.intersects(m_area1) && (m_player.intersects(m_area2))))
    	{
    		m_player.die();
    		m_lives -= 1;
    	}
    	
    	if (m_player.isAlive() && (m_player.intersects(m_area2) && (m_player.intersects(m_area3))))
    	{
    		m_player.die();
    		m_lives -= 1;
    	}
    	
    	if (m_player.isAlive() && (m_player.intersects(m_area3) && (m_player.intersects(m_area4))))
    	{
    		m_player.die();
    		m_lives -= 1;
    	}
    	
    	if (m_player.isAlive() && (m_player.intersects(m_area4) && (m_player.intersects(m_area5))))
    	{
    		m_player.die();
    		m_lives -= 1;
    	}
    	
    	if (m_player.isAlive() && (!(m_player.intersects(m_area1) || m_player.intersects(m_area2) || m_player.intersects(m_area3) || m_player.intersects(m_area4)
    			|| m_player.intersects(m_area5))))
    	/*
    	(!(m_player.intersects(m_area1)) || (!(m_player.intersects(m_area2)) || (!(m_player.intersects(m_area3))
    			|| (!(m_player.intersects(m_area4)) || (!(m_player.intersects(m_area5)))))))))*/
    	{
    		m_campingTimer = 0;
    	}
    	
    	if (m_player.intersects(m_area1) || m_player.intersects(m_area2) || m_player.intersects(m_area3) || m_player.intersects(m_area4) || m_player.intersects(m_area5))
    	{
    		m_campingTimer += delta;
    	}
    	
    	if (m_campingTimer / 1000 >= 5)
    	{
    		m_player.die();
    		m_lives -= 1;
    		m_campingTimer = 0;
    	}
    	
    	if (m_player.isAlive() && (m_player.intersects(m_water)) && (!( m_player.intersects(m_woodenBeamSmall1) || m_player.intersects(m_woodenBeamSmall2) || m_player.intersects(m_woodenBeamSmall3)
    			|| m_player.intersects(m_woodenBeamSmall4) || m_player.intersects(m_woodenBeamSmall5) || m_player.intersects(m_woodenBeamSmall6)
    			|| m_player.intersects(m_woodenBeamMedium1) || m_player.intersects(m_woodenBeamMedium2) || m_player.intersects(m_woodenBeamMedium3)
    			|| m_player.intersects(m_woodenBeamLarge1) || m_player.intersects(m_woodenBeamLarge2) || m_player.intersects(m_woodenBeamLarge3)
    			)))
    	{
    		m_player.die();
    		m_lives -= 1;
    	}
    	
    	if (m_player.isAlive() && m_player.intersects(m_deathitem))
    	{
    		if(m_deathitem.getItemStatus() == false)
			{
    			boolean m_itemCollected;
    			m_itemCollected = true;
    		
    		if (m_itemCollected == true)
    		{    			
    				m_deathitem.hideItem();
    				m_deathitem.itemTaken();
    				m_player.die();
    				m_lives -= 1;    			
    				m_itemCollected = false;
    			}
    		}
    	}
    	
    	if (m_player.isAlive() && m_player.intersects(m_lifeItem))
    	{
    		if(m_lifeItem.getItemStatus() == false)
    		{
    			m_lives += 1;
    			m_lifeItem.hideItem();
    			m_lifeItem.itemTaken();
    		}
    	}
    	
    	if (m_player.isAlive() && (m_player.intersects(m_freezeItem)))
    	{
    		if(m_freezeItem.getItemStatus() == false)
    		{
    			m_freeze = 1;
    		}
    	}
    	
    	if (m_freeze == 1)
    	{
    		
    		m_millisPassedFreeze += delta;
    		
    		if (m_millisPassedFreeze < 5000)
    		{
    			m_car1.freeze(delta);
    			m_car2.freeze(delta);
    			m_car3.freeze(delta);
    			m_car4.freeze(delta);
    			m_car5.freeze(delta);
    			m_car6.freeze(delta);
    			m_car7.freeze(delta);
    			
        		m_pickup1.freeze(delta);
        		m_pickup2.freeze(delta);
        		m_pickup3.freeze(delta);
        		m_pickup4.freeze(delta);
        		m_pickup5.freeze(delta);
        		m_pickup6.freeze(delta);
        		m_pickup7.freeze(delta);
        		
        		
        		m_sportsCar1.freeze(delta);
        		m_sportsCar2.freeze(delta);
        		m_sportsCar3.freeze(delta);
        		m_sportsCar4.freeze(delta);
        		m_sportsCar5.freeze(delta);
        		m_sportsCar6.freeze(delta);
        		m_sportsCar7.freeze(delta);
        		
        		m_freezeItem.hideItem();
        		m_freezeItem.itemTaken();
    		
    		}
    		else
    		{
    			m_freeze = 0;
    			m_millisPassedFreeze = 0;
    			
    			m_car1.noFreeze();
    			m_car2.noFreeze();
    			m_car3.noFreeze();
    			
    			m_car4.noFreeze();
    			m_car5.noFreeze();
    			m_car6.noFreeze();
    			m_car7.noFreeze();
    			
    			m_pickup1.noFreeze();
    			m_pickup2.noFreeze();
    			m_pickup3.noFreeze();
    			
    			m_pickup4.noFreeze();
    			m_pickup5.noFreeze();
    			m_pickup6.noFreeze();
    			m_pickup7.noFreeze();
    			
    			m_sportsCar1.noFreeze();
    			m_sportsCar2.noFreeze();
    			m_sportsCar3.noFreeze();
    			
    			m_sportsCar4.noFreeze();
    			m_sportsCar5.noFreeze();
    			m_sportsCar6.noFreeze();
    			m_sportsCar7.noFreeze();
        	}
    	}
    	
    	
    	
    	
    	/*for (int i=0; i < m_LosingBox.length; i++)
    	{
    		if (m_player.intersects(m_LosingBox[i]))
	    	{
	    		m_player.die();
	    	}
    	}*/
    	
    	if (m_player.isAlive() == false)
    	{
    		m_time = 0;
    	}
    		
    	m_time += delta;
	} 
	
	@Override public void render(GameContainer gc, Graphics g) 
			throws SlickException
	{

		// order determines bottom and top image

			m_background.draw(0,0);
			
			m_woodenBeamSmall1.render(g);
			m_woodenBeamSmall2.render(g);
			m_woodenBeamSmall3.render(g);
			m_woodenBeamSmall4.render(g);
			m_woodenBeamSmall5.render(g);
			m_woodenBeamSmall6.render(g);
			
			m_woodenBeamMedium1.render(g);
			m_woodenBeamMedium2.render(g);
			m_woodenBeamMedium3.render(g);
			
			m_woodenBeamLarge1.render(g);
			m_woodenBeamLarge2.render(g);
			m_woodenBeamLarge3.render(g);
			
			m_player.render(g);
			
			m_car1.render(g);
			m_car2.render(g);
			m_car3.render(g);
			
			m_car4.render(g);
			m_car5.render(g);
			m_car6.render(g);
			m_car7.render(g);
			
			m_sportsCar1.render(g);
			m_sportsCar2.render(g);
			m_sportsCar3.render(g);
		
			m_sportsCar4.render(g);
			m_sportsCar5.render(g);
			m_sportsCar6.render(g);
			m_sportsCar7.render(g);
			
			m_pickup1.render(g);
			m_pickup2.render(g);
			m_pickup3.render(g);
		
			m_pickup4.render(g);
			m_pickup5.render(g);
			m_pickup6.render(g);
			m_pickup7.render(g);
			
			m_deathitem.Render(g);
			m_freezeItem.Render(g);
			m_lifeItem.Render(g);
			

			for (int i=0; i < m_winningBoxes.length; i++)
			{
				m_winningBoxes[i].render(g);
			}

		g.drawString("Time : " + m_time/1000 + " seconds", 15, 570);
		g.drawString("Points : " + m_points, 650, 570);
		g.drawString("Lives : " + m_lives, 200, 570);
		g.drawString("Flies eaten : " + WinningBoxesReached, 500, 570);
		
		if (WinningBoxesReached >= 5)
		{
			m_winningImage.draw(0,0);
			g.drawString("You succeeded " + m_points + " points", 285, 500);
		}
		
		if (m_lives <= 0)
    	{
			m_GameOverImage.draw(0,0);
    	}
		
		m_instructions.render(g);
	} 
		
  public static void main(String[] args) 
		  throws SlickException
		  {
        	AppGameContainer app = new AppGameContainer(new SimpleGame());
        	
        	app.setDisplayMode(800, 600, false);
            app.setShowFPS(false);
            app.start();
	      }	
}

