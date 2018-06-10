package jake.friend.domain;

public class userVO {
	
	private int u_seq;
	private String email;
	private String u_name;
	private String pwd;
	private int sex;
	private int age;
	private int height;
	private int weight;
	private int u_status;
	
	
	
	public int getU_seq() {
		return u_seq;
	}



	public void setU_seq(int u_seq) {
		this.u_seq = u_seq;
	}

	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getU_name() {
		return u_name;
	}



	public void setU_name(String u_name) {
		this.u_name = u_name;
	}



	public String getPwd() {
		return pwd;
	}



	public void setPwd(String pwd) {
		this.pwd = pwd;
	}



	public int getSex() {
		return sex;
	}



	public void setSex(int sex) {
		this.sex = sex;
	}



	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}



	public int getHeight() {
		return height;
	}



	public void setHeight(int height) {
		this.height = height;
	}



	public int getWeight() {
		return weight;
	}



	public void setWeight(int weight) {
		this.weight = weight;
	}



	public int getU_status() {
		return u_status;
	}



	public void setU_status(int u_status) {
		this.u_status = u_status;
	}



	@Override
	public String toString() {
		return "userVO [u_seq=" + u_seq + ", email=" + email + ", u_name=" + u_name + ", pwd=" + pwd + ", sex=" + sex
				+ ", age=" + age + ", height=" + height + ", weight=" + weight + ", u_status=" + u_status + "]";
	}

	 

}
