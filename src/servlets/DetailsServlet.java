package servlets;

import db.City;
import db.DBUtil;
import db.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value = "/details")
public class DetailsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        Long id = Long.parseLong(request.getParameter("id"));
        Student student = DBUtil.getStudent(id);

        ArrayList<City> cities = DBUtil.getAllCities();
        request.setAttribute("qalalar", cities);

        request.setAttribute("oqushylar", student);
        request.getRequestDispatcher("/details.jsp").forward(request, response);

    }

}
