

public class Users {

	private int REGNUM_START = 1000,age;
	private String name,email,phone,address,gender,gymname;
	private  int id = REGNUM_START;
	
	public Users(String name, String email, String phone, int age, String address, String gender, String gymname) {
		super();
		this.id += 1;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.age = age;
		this.address = address;
		this.gender = gender;
		this.gymname = gymname;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getGymname() {
		return gymname;
	}


	public void setGymname(String gymname) {
		this.gymname = gymname;
	}


	


	
	
}


//inheritance
class Staff extends Users{

	String pass;
	
	public Staff(String name, String email, String phone, int age, String address, String gender, String gymname) {
		super(name, email, phone, age, address, gender, gymname);
	}
	
	public Staff(String name,String pass, String email, String phone, int age, String address, String gender, String gymname) {
		super(name, email, phone, age, address, gender, gymname);
		this.pass = pass;
	}
	

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	
	
	
}