import java.util.Random;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Vector2f;

public class FreezeItem {
	
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
	private int randomposX;
	private int randomposY;
	
	public FreezeItem(Vector2f startPosition)
	{
		m_startingPosition = startPosition;
		
	}
	
	public void Initialize()throws SlickException
	{
		m_powerPicture = new Image("data/freezeItemImage.png");
		m_boundingRectangle = new Rectangle(
			m_startingPosition.getX(),
			m_startingPosition.getY(),
			m_powerPicture.getWidth(),
			m_powerPicture.getHeight()
		);

	}
	public void Update(int delta)
	{ 
		
		timer += delta ;
		
		m_wasitemvis = m_itemvis;
		m_wasitemvis2 = m_itemvis2;
		m_wasitemvis3 = m_itemvis3;
		
		
		m_itemvis = (timer > 9000) && ( timer < 12000);
		m_itemvis2 = ( timer > 20000) && ( timer < 30000);
		m_itemvis3 = (timer > 35000) && ( timer < 45000);
		
		if(!((timer > 5000) && ( timer < 15000) || ( timer > 20000) && ( timer < 30000) || (timer > 35000) && ( timer < 45000)))
		{
			m_itemtaken = false;
		}
		
		
		if(((m_itemvis && (!m_wasitemvis))||((m_itemvis2 && (!m_wasitemvis2))||((m_itemvis3 && (!m_wasitemvis3))))))
		{
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
		m_itemHidden = false;
		m_powerPicture.draw(m_startingPosition.getX(), m_startingPosition.getY());
		}
		
		else
		{
			hideItem();
		}
	}
}

