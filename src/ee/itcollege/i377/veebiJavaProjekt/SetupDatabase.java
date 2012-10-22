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
 * Servlet implementation class SetupDatabase
 */
@WebServlet("/SetupDatabase")
public class SetupDatabase extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SetupDatabase() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		try {
		    Class.forName("org.hsqldb.jdbcDriver");
		    Connection conn = DriverManager.getConnection("jdbc:hsqldb:MyDB");

		    out.println("Using database: " +
		        conn.getMetaData().getDatabaseProductName() + " " +
		        conn.getMetaData().getDatabaseProductVersion() + " at " +
		        conn.getMetaData().getURL());
		    
		    Statement s = conn.createStatement();
		    
		    StringBuilder sb = new StringBuilder();
		    sb.append("CREATE TABLE guard (");
		    sb.append("id IDENTITY, ");
		    sb.append("name VARCHAR(50), ");
		    sb.append("age INT ");
		    sb.append(" ) ");
		    
		    s.execute(sb.toString());
		    
		} catch (Exception e) {
		    out.println("Error: " + e.getMessage());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
