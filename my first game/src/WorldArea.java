import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;


public class WorldArea 
{
	
	private Rectangle m_boundingRectangle;
	
	
	public Rectangle getBoundingRectangle()
	{
		return m_boundingRectangle;
	}
	
	public void Initialize() 
			throws SlickException
	{
		m_boundingRectangle = new Rectangle(0, 0, 800, 600);
	}
	
	
	public void Update()
	{
		
	}
	
	public void render(Graphics g)
	{
		g.draw(m_boundingRectangle);
	}
	
}

