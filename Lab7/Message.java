import org.json.simple.JSONObject;
import org.json.simple.JSONAware;

import java.util.Random;


public class Message implements JSONAware
{
        String message;
        String user;
        int id;
        int currId = 1;
        private boolean isDeleted = false;
	    private boolean isChanged = false;
        public Message(String text,String userName) {
		this.user = userName;
		this.message = text;
		id = currId++;
	}
        public Message(){
            Random r = new Random();
            user = "User " +Integer.toString(r.nextInt());
            id = currId++;
        }
        public int getId() {return id;}
        public void setId(Integer i) {id = i;}
        public void setUser(String s) {user = s; }
        public void setMessage(String temp) { message = temp;}
        public String getMessage() {return message;}
        public String getUser() {return user;}
        public boolean getDelete() {
		return isDeleted;
	}
        public void setDelete(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
	public void setChange(boolean isChanged) {
		this.isChanged = isChanged;
	}
	public boolean getChange() {
		return isChanged;
	}

	public void deleteMessage() {
		if(isDeleted != true) {
			this.message = "message is deleted.";
			this.setDelete(true);
		}
	}

	public static Message parseMessage(JSONObject obj){
		Message info = new Message();
		if((String)obj.get("user") != null) {
		info.user = (String)obj.get("user");
		}
		info.message = (String)obj.get("message");
		info.id = Integer.parseInt(obj.get("id").toString());
		return info;
	}
	@Override
	public String toJSONString(){
		JSONObject obj = new JSONObject();
		obj.put("user", user);
		obj.put("message",message);
		obj.put("id", id);
		return obj.toString();
	}
	@Override
	public String toString(){
		return user+" : "+message;
	}
	@Override
	public boolean equals(Object obj){
		return (((Message)obj).getId()==id);
	}
            
    
}
