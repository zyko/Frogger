import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Vector2f;


public class SportsCar 
{
	private Image m_sportsCarImage;
	
	private Vector2f m_startingPosition;
	private Vector2f m_headingVector;
	private Vector2f m_currentWorldPosition;

	private float m_totalDistance;
	private float m_currentWayPoint;
	
	private boolean m_isGoingFromStartToEnd;
	
	private Rectangle m_boundingRectangle;
	
	public SportsCar(Vector2f startPosition, Vector2f endPosition)
	{
		m_startingPosition = startPosition;
		m_currentWorldPosition = m_startingPosition.copy();
		m_headingVector = endPosition.copy();
		m_headingVector.sub(startPosition);
		m_totalDistance = m_headingVector.length();
		m_headingVector.normalise();
		m_currentWayPoint = 0.0f;
		m_isGoingFromStartToEnd = true;
	}
	
	public Rectangle getBoundingRectangle()
	{
		return m_boundingRectangle;
	}
	
	public void noFreeze()
	{
		m_isGoingFromStartToEnd = true;
	}
	
	public void Initialize() throws SlickException
	{
		m_sportsCarImage = new Image("data/sportsCarImage.png");
		m_boundingRectangle = new Rectangle(
			m_startingPosition.getX(),
			m_startingPosition.getY(),
			m_sportsCarImage.getWidth(),
			m_sportsCarImage.getHeight()
		);
	}
	
	public void freeze(int millisPassed)
	{
		m_isGoingFromStartToEnd = false;
	}
	
	
	
	public void Update(int millisPassed)
	{
		float localWayDelta = 0;
		if (m_isGoingFromStartToEnd)
			localWayDelta = 370.0f * millisPassed / 1000.0f;

		m_currentWayPoint += localWayDelta;
		
		Vector2f localDelta = m_headingVector.copy();
		localDelta.scale(m_currentWayPoint);
		m_currentWorldPosition = m_startingPosition.copy();
		m_currentWorldPosition.add(localDelta);
		
		if (m_currentWayPoint < 0.0f)
		{
			m_currentWayPoint = m_totalDistance;
			m_isGoingFromStartToEnd = true;
		}
		
		if (m_currentWayPoint > m_totalDistance)
		{
			m_currentWayPoint = 0.0f;
			m_isGoingFromStartToEnd = true;
		}
		
		m_boundingRectangle.setLocation(m_currentWorldPosition);
	}
	
	public void render(Graphics g)
	{
		m_sportsCarImage.draw(m_currentWorldPosition.getX(), m_currentWorldPosition.getY());
	}
	
}
