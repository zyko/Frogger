import java.util.Random;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Vector2f;

public class DeathItem {
	
	private Rectangle m_boundingRectangle;
	private Image m_powerPicture;
	private Vector2f m_startingPosition;
	private boolean m_itemvis;
	private boolean m_itemvis2;
	private boolean m_wasitemvis;
	private boolean m_wasitemvis2;
	private boolean m_itemvis3;
	private boolean m_itemvis4;
	private boolean m_wasitemvis3;
	private boolean m_itemtaken;
	private boolean m_itemHidden;
	private int timer;
	
	private int random;
	
	private int randomposX;
	private int randomposY;
	
	public DeathItem(Vector2f startPosition)
	{
		m_startingPosition = startPosition;
		
	}
	
	public void Initialize()throws SlickException
	{
		m_powerPicture = new Image("data/redGemImage.png");
		m_boundingRectangle = new Rectangle(
			m_startingPosition.getX(),
			m_startingPosition.getY(),
			m_powerPicture.getWidth(),
			m_powerPicture.getHeight()
		);

	}
	public void Update(int delta)
	{ 
		
		Random generator = new Random();
		
		timer += delta ;
		
		m_wasitemvis = m_itemvis;
		m_wasitemvis2 = m_itemvis2;
		m_wasitemvis3 = m_itemvis3;
		
		
		m_itemvis = (timer > 10000) && ( timer < 15000);
		m_itemvis2 = ( timer > 23000) && ( timer < 27000);
		m_itemvis3 = (timer > 35000) && ( timer < 55000);
		
		if(!((timer > 5000) && ( timer < 15000) || ( timer > 20000) && ( timer < 30000) || (timer > 35000) && ( timer < 45000)))
		{
			m_itemtaken = false;
		}
		
		
		if(((m_itemvis && (!m_wasitemvis))||((m_itemvis2 && (!m_wasitemvis2))||((m_itemvis3 && (!m_wasitemvis3))))))
		{
			random = generator.nextInt(2) + 2;
			setNewLocation();
		}
		
		m_boundingRectangle.setLocation(m_startingPosition);
	}
	
	public Rectangle getBoundingRectangle()
	{
		return m_boundingRectangle;
	}
	
	public void setNewLocation()
	{
		Random generator = new Random();
    	randomposX = generator.nextInt(700) + 50;
    	randomposY = generator.nextInt(270) + 300;
    	m_startingPosition = new Vector2f(randomposX, randomposY);
	}
	public void itemTaken()
	{
		m_itemtaken = true;
	}
	
	public void hideItem()
	{
		m_itemHidden = true;
	}
	public boolean getItemStatus()
	{
		return m_itemHidden;
	}


	public void Render(Graphics g)
	{
		if ((m_itemvis || m_itemvis2 ||  m_itemvis3 ||  m_itemvis4) && ((!m_itemtaken)))
		{
			if(random > 2 && random <= 4)
			{
				m_itemHidden = false;
				m_powerPicture.draw(m_startingPosition.getX(), m_startingPosition.getY());
			}
		}
		else
		{
			hideItem();
		}
	}
}





