import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Vector2f;

public class WinningBox
{
	private boolean m_alreadyWon = false;
	
	private Image m_flyImage;
	
	private int m_time = 0;
	private int m_currentPosition = 1;
	private int m_winningBoxesReached = 0;
	
	private Rectangle m_boundingRectangle;

	private Vector2f m_currentWorldPosition;
	private Vector2f m_startingPosition;
	
	public WinningBox(Vector2f startPosition)
	{
		m_startingPosition = startPosition;
		m_currentWorldPosition = m_startingPosition.copy();
	}
	
	public void win()
	{
		m_alreadyWon = true;
		m_winningBoxesReached += 1;
		m_time = 0;
	}
	
	public void Initialize() throws SlickException
	{
	
		m_flyImage = new Image("data/flyImage.png");
		m_boundingRectangle = new Rectangle(
				m_startingPosition.getX(),
				m_startingPosition.getY(),
				m_flyImage.getWidth(),
				m_flyImage.getHeight()
				);
	}
	
	public void setNewPosition()
	{
		if (m_currentPosition == 1)
		{
			m_boundingRectangle.setLocation(m_currentWorldPosition);
			m_currentWorldPosition = new Vector2f(230, 10);
			m_boundingRectangle = new Rectangle(
					m_currentWorldPosition.getX(),
					m_currentWorldPosition.getY(),
					m_flyImage.getWidth(),
					m_flyImage.getHeight()
				);
			m_currentPosition = 2;
			m_time = 0;
		}

		if (m_currentPosition == 2 && m_time > 0)
		{
			m_currentPosition = 3;
			m_boundingRectangle.setLocation(m_currentWorldPosition);
			m_currentWorldPosition = new Vector2f(395, 10);
			m_boundingRectangle = new Rectangle(
					m_currentWorldPosition.getX(),
					m_currentWorldPosition.getY(),
					m_flyImage.getWidth(),
					m_flyImage.getHeight()
				);
			m_time = 0;
			
		}
		
		if (m_currentPosition == 3 && m_time > 0)
		{
			m_currentPosition = 4;
			m_boundingRectangle.setLocation(m_currentWorldPosition);
			m_currentWorldPosition = new Vector2f(560, 10);
			m_boundingRectangle = new Rectangle(
					m_currentWorldPosition.getX(),
					m_currentWorldPosition.getY(),
					m_flyImage.getWidth(),
					m_flyImage.getHeight()
				);
			m_time = 0;
		}
		
		if (m_currentPosition == 4 && m_time > 0)
		{
			m_currentPosition = 5;
			m_boundingRectangle.setLocation(m_currentWorldPosition);
			m_currentWorldPosition = new Vector2f(725, 10);
			m_boundingRectangle = new Rectangle(
					m_currentWorldPosition.getX(),
					m_currentWorldPosition.getY(),
					m_flyImage.getWidth(),
					m_flyImage.getHeight()
				);
			m_time = 0;
		}
		
		if (m_currentPosition == 5 && m_time > 0)
		{
			m_currentPosition = 1;
			m_boundingRectangle.setLocation(m_currentWorldPosition);
			m_currentWorldPosition = new Vector2f(65, 10);
			m_boundingRectangle = new Rectangle(
					m_currentWorldPosition.getX(),
					m_currentWorldPosition.getY(),
					m_flyImage.getWidth(),
					m_flyImage.getHeight()
				);
			m_time = 0;
		}
	}
	
	public void Update(int delta)
	{
		
		m_time += delta;
		
		if (m_winningBoxesReached == 0)
		{
			if (m_time / 1000 >= 13)
			{
				setNewPosition();
			}
		}
		
		if (m_winningBoxesReached == 1)
		{
			if (m_time / 1000 >= 10)
			{
				setNewPosition();
			}
		}
		
		if (m_winningBoxesReached == 2)
		{
			if (m_time / 1000 >= 7)
			{
				setNewPosition();
			}
		}
		
		if (m_winningBoxesReached == 3)
		{
			if (m_time / 1000 >= 4)
			{
				setNewPosition();
			}
		}
		
		if (m_winningBoxesReached == 4)
		{
			if (m_time / 1000 >= 2)
			{
				setNewPosition();
			}
		}
		
	}
	
	public Rectangle getBoundingRectangle()
	{
		return m_boundingRectangle;
	}
	
	public void render(Graphics g)
	{
		m_flyImage.draw(m_currentWorldPosition.getX(), m_currentWorldPosition.getY());
	}
}