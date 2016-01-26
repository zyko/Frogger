import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;


public class Water 
{
	
	private Rectangle m_boundingRectangle;
	
	
	public Rectangle getBoundingRectangle()
	{
		return m_boundingRectangle;
	}
	
	public void Initialize() 
			throws SlickException {
		m_boundingRectangle = new Rectangle(0, 50, 800, 180);
		/*m_boundingRectangle = new Rectangle(
			m_currentwaterPosition.getX(),
			m_currentwaterPosition.getY(),
			m_waterImage.getWidth(),
			m_waterImage.getHeight()
		);*/
		
	}
	
	
	public void Update()
	{
		
	}
	
	public void render(Graphics g)
	{

	}
	
}

