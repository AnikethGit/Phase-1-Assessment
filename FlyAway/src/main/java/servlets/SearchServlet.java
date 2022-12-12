package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.SearchAlgo;

public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @Override
    public void service (HttpServletRequest req, HttpServletResponse resp) throws IOException {
        SearchAlgo.date = req.getParameter("date");
        SearchAlgo.origin = req.getParameter("origin");
        SearchAlgo.destination = req.getParameter("destination");
        SearchAlgo.persons = Integer.parseInt(req.getParameter("persons"));

        if (SearchAlgo.date.equals("")) {
            PrintWriter out = resp.getWriter();
            out.println("Please enter a valid date");
        }
        else {
            SearchAlgo.day = getDay(SearchAlgo.date);
            resp.sendRedirect("search_results.jsp");
        }
    }

    public String getDay(String dateInp) {
        LocalDate dt = LocalDate.parse(dateInp);
        return dt.getDayOfWeek().toString();
    }
}
