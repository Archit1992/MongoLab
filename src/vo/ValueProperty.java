package vo;

import org.bson.types.ObjectId;

public class ValueProperty {

	private String firstName;
	private String lastName;
	private ObjectId objId;
	
	
	// getter and setter for all the value properties.
	
	public ObjectId getObjId() {
		return objId;
	}
	public void setObjId(ObjectId objId) {
		this.objId = objId;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
