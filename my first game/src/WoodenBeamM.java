import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Vector2f;


public class WoodenBeamM {

	private Image m_beamImage;
	
	private Vector2f m_startingPosition;
	
	private Vector2f m_headingVector;
	
	private Vector2f m_currentWorldPosition;
	
	private float m_totalDistance;
	
	private float m_currentWayPoint;
	
	private boolean m_isGoingFromStartToEnd;
	
	private Rectangle m_boundingRectangle;
	
	private Vector2f m_movingBeamLeft;

	
	public WoodenBeamM(Vector2f startPosition, Vector2f endPosition)
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
	
	public void Initialize() throws SlickException
	{
		m_beamImage = new Image("data/woodenBeamMediumImage.jpg");
		m_boundingRectangle = new Rectangle(
				m_startingPosition.getX(),
				m_startingPosition.getY(),
				m_beamImage.getWidth(),
				m_beamImage.getHeight()
				);
	}
	
	public void Update(int millisPassed)
	{
		float localWayDelta;
		if (m_isGoingFromStartToEnd)
			localWayDelta = 100.0f * millisPassed / 1000.0f;
		else
			localWayDelta = - 100.0f * millisPassed / 1000.0f;
		
		m_currentWayPoint += localWayDelta;
		
		Vector2f localDelta = m_headingVector.copy();
		localDelta.scale(m_currentWayPoint);
		m_currentWorldPosition = m_startingPosition.copy();
		m_currentWorldPosition.add(localDelta);
		
		m_movingBeamLeft = m_headingVector.copy();
		m_movingBeamLeft.scale(localWayDelta);
		
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
	
	public Vector2f getMovingBeamLeft()
	{
		return m_movingBeamLeft;
	}
	
	public void render(Graphics g)
	{
		m_beamImage.draw(m_currentWorldPosition.getX(), m_currentWorldPosition.getY());
	}
	
}
