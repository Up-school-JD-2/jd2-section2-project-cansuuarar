package smartPhoneApplication;

import java.io.Serializable;

public class App implements Serializable{

	private String name;
	private String version;
	private double size;
	
	

	public App(String name, String version, double size) {
		super();
		this.name = name;
		this.version = version;
		this.size = size;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public double getSize() {
		return size;
	}

	public void setSize(double size) {
		this.size = size;
	}

}
