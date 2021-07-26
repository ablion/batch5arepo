package elearningproject.module;

public class feedback {
private long user_id;
private String name;
private String email;
private long f_id;
private String feedback;
public feedback() {
	super();
	// TODO Auto-generated constructor stub
}
public feedback(long user_id, String name, String email, long f_id, String feedback) {
	super();
	this.user_id = user_id;
	this.name = name;
	this.email = email;
	this.f_id = f_id;
	this.feedback = feedback;
}
public long getUser_id() {
	return user_id;
}
public void setUser_id(long user_id) {
	this.user_id = user_id;
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
public long getF_id() {
	return f_id;
}
public void setF_id(long f_id) {
	this.f_id = f_id;
}
public String getFeedback() {
	return feedback;
}
public void setFeedback(String feedback) {
	this.feedback = feedback;
}
@Override
public String toString() {
	return "feedback [user_id=" + user_id + ", name=" + name + ", email=" + email + ", f_id=" + f_id + ", feedback="
			+ feedback + "]";
}

}
