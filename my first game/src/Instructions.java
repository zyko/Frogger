import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;


public class Instructions {

	
	private Image m_instruction;
	
	private int time;
	private boolean m_instructionShowing;
	
	public void Initialize() 
			throws SlickException {
		m_instruction = new Image("data/instructionImage.png");
		m_instructionShowing = false;
		
	}
	
	public boolean startBildschirm()
	{
		return m_instructionShowing;
	}
	
	
	public void update(int delta)
	{
		
		time += delta;
		m_instructionShowing = time > 0 && time < 6000;
	}
	
	public void render(Graphics g)
	{
		if (m_instructionShowing)
		{
			m_instruction.draw(200, 155);
		}
		
	}
	
	
	
}
