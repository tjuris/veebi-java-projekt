package ee.itcollege.i377.veebiJavaProjekt;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchGuard
 */
@WebServlet("/searchGuard")
public class SearchGuard extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String name;
	private int age;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchGuard() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			Class.forName("org.hsqldb.jdbcDriver");
			Connection conn = DriverManager.getConnection("jdbc:hsqldb:MyDB");
		    Statement s = conn.createStatement();
		    ResultSet rs;		    
    		
			if (request.getParameterMap().containsKey("name")){
				name = request.getParameter("name");
				if (request.getParameterMap().containsKey("age")){
					age = Integer.parseInt(request.getParameter("age"));
					
					rs = s.executeQuery("SELECT id, name, age FROM guard WHERE name='"+name+"' AND age="+age);
				}else{
					rs = s.executeQuery("SELECT id, name, age FROM guard WHERE name='"+name+"'");
				}
				
			}else{
				if (request.getParameterMap().containsKey("age")){
					age = Integer.parseInt(request.getParameter("age"));
					rs = s.executeQuery("SELECT id, name, age FROM guard WHERE age="+age);
				}else{
					rs = s.executeQuery("SELECT id, name, age FROM guard");
				}
			}
			
			conn.close();
			
			PrintWriter out = response.getWriter();
			out.write("<html><head><title>Otsingutulemus:</title></head><body><table><tr><th>ID</th><th>Nimi</th><th><Vanus></th></tr>");
			
			while(rs.next()) {		        
		        out.write("<tr><td>"+rs.getInt(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getInt(3)+"</td></tr>");			
		    }
		
		out.write("</table></body></html>");
			
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
