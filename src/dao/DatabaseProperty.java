package dao;

import java.util.List;

import javax.swing.DropMode;

import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

import vo.ValueProperty;

public class DatabaseProperty {
	
	private static List<DBObject> list=null;
	
	public void insert(ValueProperty voObj) {
		// TODO Auto-generated method stub

		MongoClientURI uri = new MongoClientURI("mongodb://<dbuser>:<dbpassword>@ds<dbport>.mlab.com:<dbport>/<dbname>");
		MongoClient client = new MongoClient(uri); // MongoClient connected with the specified URI.

		@SuppressWarnings("deprecation")
		DB db = client.getDB(uri.getDatabase()); // Database Object created.

		DBCollection ImdbRegister = db.getCollection("imdbCollection"); // ImdbRegister collection created.
		
		BasicDBObject register = new BasicDBObject();
		
		register.put("First Name", voObj.getFirstName());
		register.put("Last Name", voObj.getLastName());
		
		ImdbRegister.insert(register); // MongoDb insert query executed.
		

	}

	public List<DBObject> search() {
		
		// TODO Auto-generated method stub
		MongoClientURI uri = new MongoClientURI("mongodb://<dbuser>:<dbpassword>@ds<dbport>.mlab.com:<dbport>/<dbname>");
		MongoClient client = new MongoClient(uri); // MongoClient connected with the specified URI.

		@SuppressWarnings("deprecation")
		DB db = client.getDB(uri.getDatabase()); // Database Object created.

		DBCollection ImdbRegister = db.getCollection("imdbCollection"); // ImdbRegister collection created.

		DBCursor cursor=ImdbRegister.find(); // MongoDb search query executed.
		
		list=cursor.toArray();
		
		return list;
	}

	public List<DBObject> edit(ValueProperty voObj) {
		// TODO Auto-generated method stub
		
		MongoClientURI uri = new MongoClientURI("mongodb://<dbuser>:<dbpassword>@ds<dbport>.mlab.com:<dbport>/<dbname>");
		MongoClient client = new MongoClient(uri); // MongoClient connected with the specified URI.

		@SuppressWarnings("deprecation")
		DB db = client.getDB(uri.getDatabase()); // Database Object created.
		
		DBCollection ImdbRegister = db.getCollection("imdbCollection"); // ImdbRegister collection created.

		
		
		BasicDBObject objid= new BasicDBObject();
		BasicDBObject query= new BasicDBObject();
		
		
		System.out.println("QUERY MADE=========================");
		objid.put("$oid", voObj.getObjId().toString());
		
		ObjectId id=new ObjectId(voObj.getObjId().toString());
		
		System.out.println("Query part 1: "+objid.toString());
		
		query.put("_id", id);
		
		System.out.println("Query final part : "+query.toString());
		
		DBCursor cursor=ImdbRegister.find(query); // MongoDb specific search query executed.
		
		list=cursor.toArray();
		
		return list;
		
	}

	public void update(ValueProperty voObj) {
		// TODO Auto-generated method stub
		MongoClientURI uri = new MongoClientURI("mongodb://<dbuser>:<dbpassword>@ds<dbport>.mlab.com:<dbport>/<dbname>");
		MongoClient client = new MongoClient(uri); // MongoClient connected with the specified URI.

		@SuppressWarnings("deprecation")
		DB db = client.getDB(uri.getDatabase()); // Database Object created.

		DBCollection ImdbRegister = db.getCollection("imdbCollection"); // ImdbRegister collection created.
		
		BasicDBObject register = new BasicDBObject();
		
		register.put("First Name", voObj.getFirstName());
		register.put("Last Name", voObj.getLastName());
		
		// update part
		BasicDBObject set=new BasicDBObject();
		set.put("$set", register);
		
		// from DB part query.
		BasicDBObject fromDb= new BasicDBObject();
		ObjectId id=new ObjectId(voObj.getObjId().toString());
		
		fromDb.put("_id", id);
		
		// Actual query.
		ImdbRegister.update(fromDb,set); // MongoDb update query.
		
		
	}

	public void delete(ValueProperty voObj) {
		// TODO Auto-generated method stub
		
		MongoClientURI uri = new MongoClientURI("mongodb://<dbuser>:<dbpassword>@ds<dbport>.mlab.com:<dbport>/<dbname>");
		MongoClient client = new MongoClient(uri); // MongoClient connected with the specified URI.

		@SuppressWarnings("deprecation")
		DB db = client.getDB(uri.getDatabase()); // Database Object created.

		DBCollection ImdbRegister = db.getCollection("imdbCollection"); // ImdbRegister collection created.

		BasicDBObject fromDb= new BasicDBObject();
		ObjectId id=new ObjectId(voObj.getObjId().toString());
		fromDb.put("_id", id);
		
		ImdbRegister.remove(fromDb);
		
		
	}

}
