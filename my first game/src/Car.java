import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Vector2f;


// The car is able to move left and right.
public class Car 
{
	// The image we would like to paint the car with.
	private Image m_carImage;
	// The starting position of the car.
	private Vector2f m_startingPosition;
	// The heading vector of the car.
	private Vector2f m_headingVector;
	// The current position we have in world coordinates.
	private Vector2f m_currentWorldPosition;
	// Distance between start and ending point.
	private float m_totalDistance;
	// Describes the current position of the car in terms of distance between
	// start and ending point.
	private float m_currentWayPoint;
	
	// Flags if we are going from start to end position.
	private boolean m_isGoingFromStartToEnd;
	
	private Rectangle m_boundingRectangle;
	
	public Car(Vector2f startPosition, Vector2f endPosition)
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
		m_carImage = new Image("data/carImage.png");
		m_boundingRectangle = new Rectangle(
			m_startingPosition.getX(),
			m_startingPosition.getY(),
			m_carImage.getWidth(),
			m_carImage.getHeight()
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
			localWayDelta = 215.0f * millisPassed / 1000.0f;

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
		m_carImage.draw(m_currentWorldPosition.getX(), m_currentWorldPosition.getY());
	}
}
