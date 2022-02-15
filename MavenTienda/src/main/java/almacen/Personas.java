package almacen;

public class Personas {
	private String username;
	private String password;
	
	public Personas(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Personas [username=" + username + ", password=" + password + "]";
	}
	
	public boolean comparar(Personas a) {
		if(this.getUsername().equals(a.getUsername()) && this.getPassword().equals(a.getPassword())) {
			return true;
		}
		return false;
	}
	
}
