package ee.itcollege.i377.veebiJavaProjekt;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateGuard
 */
@WebServlet("/updateGuard")
public class UpdateGuard extends HttpServlet {
	private static final long serialVersionUID = 1L;
	   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateGuard() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean nameParam = false, ageParam = false;
		
		if (!request.getParameterMap().containsKey("id")) return;
		if (request.getParameterMap().containsKey("name")) nameParam = true;
		if (request.getParameterMap().containsKey("age")) ageParam = true;		
		
		try {
			Class.forName("org.hsqldb.jdbcDriver");
			Connection conn = DriverManager.getConnection("jdbc:hsqldb:MyDB");
		    Statement s = conn.createStatement();
		    		    
		    String sql = "UPDATE guard SET";
		    if (nameParam) sql += " name = '" + request.getParameter("name") + "'";
		    if (nameParam && ageParam) sql += ",";
		    if (ageParam) sql += " age = " + request.getParameter("age");
		    
		    sql += " WHERE id=" + request.getParameter("id");
		    int result = s.executeUpdate(sql);
		    conn.close();
			
			PrintWriter out = response.getWriter();
			out.write("<html><head><title>Update</title></head><body>"+result+" rida uuendatud</body></html>");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
