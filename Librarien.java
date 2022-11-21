package pkg_person;

public class Librarien extends person 
{
	private int id;
	private String doj;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDoj() {
		return doj;
	}
	public void setDoj(String doj) {
		this.doj = doj;
	}
	
	@Override
	public String toString() 
	{
		return "Librarien [id=" + id + ", doj=" + doj + ", name=" + name + ", emailId=" + emailId + ", phoneNumber="
				+ phoneNumber + ", address=" + address + ", dob=" + dob + "]";
	}
	
	public Librarien(String name, String emailId, String phoneNumber, String address, String dob, int id, String doj) 
	{
		super(name, emailId, phoneNumber, address, dob);
		this.id = id;
		this.doj = doj;
	}
	
	public Librarien()
	{
		super();
	}
	
	
	
	
    
}











