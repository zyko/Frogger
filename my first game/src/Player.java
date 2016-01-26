import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.geom.Circle;
//import org.newdawn.slick.geom.Circle;
//import org.newdawn.slick.geom.Polygon;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Vector2f;

public class Player {
	
	private Vector2f m_playerPosition;
	private Vector2f m_startingPosition;
	
	private Image m_aliveImage;
	private Image m_deadImage;
	
	private boolean m_alive = true;
	private float m_speed = 150.0f;
	
	private Rectangle m_boundingRectangle;
	private Circle m_boundingCircle;
	
	private Sound m_deathSound;
	private int m_millisPassedSinceDeath = 0;
	
	private int m_time = 0;
	
	private boolean m_win = false;
	private int m_millisPassedSinceWin = 0;
	
	
	
	public Player(Vector2f startPosition)
	{
		m_playerPosition = startPosition;
		m_startingPosition = startPosition.copy();
	}
	
	public void init() throws SlickException
	{
		m_aliveImage = new Image("data/frogImage.png");
		m_deadImage = new Image("data/deathImage.png");
		
		m_boundingRectangle = new Rectangle(
			m_playerPosition.getX(),
			m_playerPosition.getY(),
			m_aliveImage.getWidth(),
			m_aliveImage.getHeight() 
		);
		
		

		Vector2f center = m_playerPosition.add(new Vector2f(m_aliveImage.getWidth() / 2, m_aliveImage.getHeight() / 2));
		m_boundingCircle = new Circle(center.getX(), center.getY(), m_aliveImage.getWidth() / 2);		
		
		
		m_deathSound = new Sound("data/dying.wav");
	}
	
	public void moveAlong (Vector2f delta)
	{
		m_playerPosition.add(delta);
	}
	
	public void die()
	{
		m_alive = false;
		m_deathSound.play();
	}
	
	public void win()
	{
		m_win = true;
		// m_winsound.play();
	}
	
	public boolean isAlive()
	{
		return m_alive;
	}
	
	public void update(int millisPassed, Input input)
	{
		m_time += millisPassed;
		
		if (m_alive && m_time >= 1999)
		{
			float dx,dy;
	    	dx = dy = 0.0f;
	   
	    	if (input.isKeyDown(Input.KEY_RIGHT))
	    	{
	    		dx =  1.0f;
	    		m_aliveImage.setRotation(90);
			}
	    	if (input.isKeyDown(Input.KEY_LEFT))
	    	{
	    		dx = - 1.0f;
	    		m_aliveImage.setRotation(270);
	    	}
	    	if (input.isKeyDown(Input.KEY_UP))
	    	{
	    		dy = - 1.0f;
	    		m_aliveImage.setRotation(0);
			}
	    	if (input.isKeyDown(Input.KEY_DOWN))
		    {
		    	dy =  1.0f;
		    	m_aliveImage.setRotation(180);
		    }
	    	if (input.isKeyDown(Input.KEY_RIGHT) && input.isKeyDown(Input.KEY_DOWN))
	    	{
	    		m_aliveImage.setRotation(135);
	    	}
	    	if (input.isKeyDown(Input.KEY_LEFT) && input.isKeyDown(Input.KEY_DOWN))
	    	{
	    		m_aliveImage.setRotation(225);
	    	}
	    	if (input.isKeyDown(Input.KEY_LEFT) && input.isKeyDown(Input.KEY_UP))
	    	{
	    		m_aliveImage.setRotation(315);
	    	}
	    	if (input.isKeyDown(Input.KEY_RIGHT) && input.isKeyDown(Input.KEY_UP))
	    	{
	    		m_aliveImage.setRotation(45);
	    	}
	    	
	    	Vector2f deltaMove = new Vector2f(dx, dy);
	    	if (deltaMove.length() > 0.01f)
	    		deltaMove.normalise();
	    	deltaMove.scale(m_speed * millisPassed / 1000.0f);
	    	
	    	m_playerPosition.add(deltaMove);
		}
		else
		{
			if (m_win == false)
			{
				m_millisPassedSinceDeath += millisPassed;
			}
			
			if (m_millisPassedSinceDeath > 2000)
			{
				m_aliveImage.setRotation(0);
				m_playerPosition = m_startingPosition.copy();
				m_millisPassedSinceDeath = 0;
				m_alive = true;
			}
		}
		if (m_win)
		{
			m_alive = false;
			m_millisPassedSinceWin += millisPassed;
			
			if (m_millisPassedSinceWin > 2000)
			{
				m_aliveImage.setRotation(0);
				m_playerPosition = m_startingPosition.copy();
				m_millisPassedSinceWin = 0;
				m_win = false;
				m_alive = true;
			}
		}
		
		m_boundingRectangle.setLocation(m_playerPosition);
		m_boundingCircle.setLocation(m_playerPosition);
		
	}
	
	public boolean intersects(DeathItem death)
	{
		Rectangle deathBoundingRectangle = death.getBoundingRectangle();
		
		return deathBoundingRectangle.intersects(m_boundingCircle);
	}
	
	public boolean intersects(Car car)
	{
		Rectangle carBoundingRectangle = car.getBoundingRectangle();
		
		return carBoundingRectangle.intersects(m_boundingCircle);
	}
	
	public boolean intersects(SportsCar sportsCar)
	{
		Rectangle carBoundingRectangle = sportsCar.getBoundingRectangle();
		
		return carBoundingRectangle.intersects(m_boundingCircle);
	}
	
	public boolean intersects(Pickup truck)
	{
		Rectangle carBoundingRectangle = truck.getBoundingRectangle();
		
		return carBoundingRectangle.intersects(m_boundingCircle);
	}
	
	
	public boolean intersects(Water water)
	{
		Rectangle waterBoundingRectangle = water.getBoundingRectangle();
		
		return waterBoundingRectangle.intersects(m_boundingCircle);
	}
	
	public boolean intersects(WoodenBeamS woodenBeamSmall)
	{
		Rectangle woodenBeamSmallBoundingRectangle = woodenBeamSmall.getBoundingRectangle();
		
		return woodenBeamSmallBoundingRectangle.intersects(m_boundingCircle);
	}
	
	public boolean intersects(WoodenBeamM woodenBeamMedium)
	{
		Rectangle woodenBeamMediumBoundingRectangle = woodenBeamMedium.getBoundingRectangle();
		
		return woodenBeamMediumBoundingRectangle.intersects(m_boundingCircle);
	}
	
	public boolean intersects(WoodenBeamL woodenBeamLarge)
	{
		Rectangle woodenBeamLargeBoundingRectangle = woodenBeamLarge.getBoundingRectangle();
		
		return woodenBeamLargeBoundingRectangle.intersects(m_boundingCircle);
	}
	
	public boolean intersects(WinningBox winningBox)
	{
		Rectangle pWinningBox = winningBox.getBoundingRectangle();
		return pWinningBox.intersects(m_boundingCircle);
	}

	public boolean intersects(WinningArea1 area1)
	{
		Rectangle area1Rectangle = area1.getBoundingRectangle();
		
		return area1Rectangle.intersects(m_boundingCircle);
	}
	
	public boolean intersects(WinningArea2 area2)
	{
		Rectangle area2Rectangle = area2.getBoundingRectangle();
		
		return area2Rectangle.intersects(m_boundingCircle);
	}
	
	public boolean intersects(WinningArea3 area3)
	{
		Rectangle area3Rectangle = area3.getBoundingRectangle();
		
		return area3Rectangle.intersects(m_boundingCircle);
	}
	
	public boolean intersects(WinningArea4 area4)
	{
		Rectangle area4Rectangle = area4.getBoundingRectangle();
		
		return area4Rectangle.intersects(m_boundingCircle);
	}
	
	public boolean intersects(WinningArea5 area5)
	{
		Rectangle area5Rectangle = area5.getBoundingRectangle();
		
		return area5Rectangle.intersects(m_boundingCircle);
	}
	
	public boolean intersects(WorldArea worldArea)
	{
		Rectangle worldAreaRectangle = worldArea.getBoundingRectangle();
		
		return worldAreaRectangle.intersects(m_boundingCircle);
	}
	
	public boolean intersects(FreezeItem freezeItem)
	{
		Rectangle freezeItemRectangle = freezeItem.getBoundingRectangle();
		
		return freezeItemRectangle.intersects(m_boundingCircle);
	}
	
	public boolean intersects(LifeItem lifeItem)
	{
		Rectangle lifeItemRectangle = lifeItem.getBoundingRectangle();
		
		return lifeItemRectangle.intersects(m_boundingCircle);
	}


	
	public void render(Graphics g)
	{
		
		if (m_alive)
		{
			m_aliveImage.draw(m_playerPosition.getX(), m_playerPosition.getY());
		}
		else
		{
			if (m_win == false)
			{	
				m_deadImage.draw(m_playerPosition.getX(), m_playerPosition.getY());
			}
		}
	}

}
