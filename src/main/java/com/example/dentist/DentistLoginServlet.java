package com.example.dentist;

import com.example.dentist.DentistBOPack.DentistBO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DentistLoginServlet", value = "/DentistLoginServlet")
public class DentistLoginServlet extends HttpServlet {
    private Object onClick;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();

        try {
            //variables
            String id, pw;
            id = request.getParameter("DUser");
            pw = request.getParameter("DPsswd");
//            System.out.println("pid= " + id);
//            System.out.println("pswrd = " + pw);


            DentistBO d1 = new DentistBO();
            d1.selectDB(id);
            System.out.println("Dentist selected");
//
            if (d1.getDpasswd().equals(pw) && d1.getDid().equals(id)) {
                System.out.println("It is correct login password");
                //putting the customer object in a session
                HttpSession ses1;
                ses1 = request.getSession();
                ses1.setAttribute("d1", d1);
                RequestDispatcher rd = request.getRequestDispatcher("/DentistInfo.jsp");
                rd.forward(request, response);

            } else {
                RequestDispatcher rd = request.getRequestDispatcher("/DentistErrorPage.jsp");
                rd.forward(request, response);
            }

        } catch (Exception ex1) {
            System.out.println("PP:" + ex1);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
