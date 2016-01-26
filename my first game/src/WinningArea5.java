import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;


public class WinningArea5 
{
	
	private Rectangle m_boundingRectangle;
	
	
	public Rectangle getBoundingRectangle()
	{
		return m_boundingRectangle;
	}
	
	public void Initialize() 
			throws SlickException
	{
		m_boundingRectangle = new Rectangle(650, 0, 155, 42);
	}
	
	
	public void Update()
	{
		
	}
	
	public void render(Graphics g)
	{

	}
	
}

