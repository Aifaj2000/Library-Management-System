package pkg_exception;

public class StudentNotFoundException extends Exception 
{
	private static final long serialVersionUID = 1L;
	
	public StudentNotFoundException()
	{
		
	}

	@Override
	public String toString() {
		return "StudentNotFountException []";
	}
	

}
