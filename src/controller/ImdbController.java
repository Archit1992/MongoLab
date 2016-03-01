package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.bson.types.ObjectId;

import com.mongodb.DBObject;

import dao.DatabaseProperty;
import vo.ValueProperty;

/**
 * Servlet implementation class ImdbController
 */
@WebServlet("/ImdbController")
public class ImdbController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ImdbController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		String flag = request.getParameter("flag");			// get the flag name is 

		DatabaseProperty dataObj = new DatabaseProperty();  // Database Property Object.
		ValueProperty voObj= new ValueProperty();           // Value Property Object. 
		HttpSession session = request.getSession();         // create a session. 
		
		if (flag.equals("search")) {

			List<DBObject> list= dataObj.search();          // List data shouuld be <DBObject>
			session.setAttribute("searchList", list);       // Put list into the Session.
			response.sendRedirect(request.getContextPath() + "/search.jsp");  // redirects to the search.jsp
		}
		if(flag.equals("edit")){
			
			ObjectId userId=new ObjectId(request.getParameter("id"));  // get the ObjectId 
			voObj.setObjId(userId); 								   // set the ObjectId
			
			List<DBObject> list= dataObj.edit(voObj);				   // invock the edit method and get data in List<DBObject>.	
			System.out.println(list.toString());
			
			session.setAttribute("editList", list);					   // set the value into the session.
 			response.sendRedirect(request.getContextPath()+"/edit.jsp");   // redirects to the edit.jsp page.
		}
		if(flag.equals("delete")){
			
			ObjectId userId=new ObjectId(request.getParameter("id"));   // get the ObjectId.
			voObj.setObjId(userId);										// set the ObjectId.
			
			dataObj.delete(voObj);										// invock the Delete method.	
			response.sendRedirect(request.getContextPath() + "/ImdbController?flag=search");   // redirects to the ImdbController.
			
		}
		
	} // end of the GEt method.

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String flag = request.getParameter("flag");						
		String firstName = request.getParameter("firstName");			// get the first name from the link.
		String lastName = request.getParameter("lastName");				// get the last name from the link.

		DatabaseProperty dataObj = new DatabaseProperty();  			// create an object of the Database Property.
		ValueProperty voObj=new ValueProperty();						// create an object of the Value Property.
		
		if (flag.equals("insert")) {									// if the flag is insert.
			
			voObj.setFirstName(firstName);								// set the Firstname Property.
			voObj.setLastName(lastName);								// set the Lastname Property.	
			
			dataObj.insert(voObj);										// invock the insert DB method.	
			response.sendRedirect(request.getContextPath() + "/ImdbController?flag=search");   // redirects to the Imbdcontroller.
		}
		if (flag.equals("update")) {									// if the flag is the update.
			
			ObjectId userId=new ObjectId(request.getParameter("id"));   // set the objectId.
			
			voObj.setObjId(userId);										// set the objectId.	
			voObj.setFirstName(firstName);								// set the firstName.	
			voObj.setLastName(lastName);								// set the lastName.
			
			dataObj.update(voObj);										// invock the DB update method.
			response.sendRedirect(request.getContextPath() + "/ImdbController?flag=search");  // invock the Imdbcontroller.
		}

	}// end of the POST method.

} // end of the Program.
