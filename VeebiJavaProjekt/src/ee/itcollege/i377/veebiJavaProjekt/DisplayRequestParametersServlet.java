package ee.itcollege.i377.veebiJavaProjekt;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DisplayRequestParametersServlet
 */
@WebServlet("/DisplayRequestParametersServlet")
public class DisplayRequestParametersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Enumeration<String> paramNames = request.getParameterNames();
		PrintWriter out = response.getWriter();
		String nextParam;
		String newline = System.getProperty("line.separator");
		while (paramNames.hasMoreElements() ){
			nextParam = paramNames.nextElement().toString();
			out.write(nextParam);
			out.write(" : ");
			out.write(request.getParameter(nextParam));
			out.write(newline);
		}
	}

}
