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
 * Servlet implementation class GenerateGuards
 */
@WebServlet("/generateGuards")
public class GenerateGuards extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int count;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GenerateGuards() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		count = Integer.parseInt(request.getParameter("count"));
		PrintWriter out = response.getWriter();
		out.write("<html><head><title>Loo uued valvurid</title></head><body><form method='post' action='generateGuards'>");
		for (int i=0; i<count; i++){
			out.write("<pre>Name: </pre><input type='text' name='name"+ i +"'/><pre>Age: </pre><input type='text' name='age"+ i +"'/>");
		}
		out.write("<br/><br/><input type='submit' value='Create' /></form></body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Class.forName("org.hsqldb.jdbcDriver");
			Connection conn = DriverManager.getConnection("jdbc:hsqldb:GuardDB", "sa", "");
			PrintWriter out = response.getWriter();
			Statement statement = conn.createStatement();
			
			StringBuilder sb = new StringBuilder();
			
			for (int i=0; i<count; i++){
				sb.append("insert into guard values ('");
				sb.append(i);
				sb.append("', '");
				sb.append(request.getParameter("name"+i));
				out.write(request.getParameter("name"+i));
				sb.append("', ");
				sb.append(request.getParameter("age"+i));
				sb.append(")");
			}
			statement.execute(sb.toString());
			

			//statement.execute("insert into guard values ("1", 'Pille', 30");
		}
		catch (Exception e) {
			e.printStackTrace();
		} 

	}

}
