package model;

public class User {
	
	private Integer id;
	private String name;
	private String pass;
	public Integer getId() {
		return id;
	}
	public User() {
	
	}
	public User(String name, String pass) {
		super();
		this.name = name;
		this.pass = pass;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

}
