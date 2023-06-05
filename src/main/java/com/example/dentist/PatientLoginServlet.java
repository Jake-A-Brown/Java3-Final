package com.example.dentist;

import com.example.dentist.AppointmentBOPack.AppointmentBO;
import com.example.dentist.PatientBOPack.PatientBO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "PatientLoginServlet", value = "/PatientLoginServlet")
public class PatientLoginServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();

        try {
            //variables
            String id, pw;
            id = request.getParameter("puser");
            pw = request.getParameter("ppass");
            System.out.println("pid= " + id);
            System.out.println("pswrd = " + pw);


            PatientBO p1 = new PatientBO();
            p1.selectDB(id);
            System.out.println("patient selected");
//
            if (p1.getPpasswd().equals(pw) && p1.getPid().equals(id)) {
                System.out.println("It is correct login password");
                //putting the customer object in a session

                HttpSession ses1;
                AppointmentBO a1 = new AppointmentBO();
                a1.selectpid(p1.getPid());
                ses1 = request.getSession();
                ses1.setAttribute("p1", p1);
                ses1.setAttribute("a1", a1);
                RequestDispatcher rd = request.getRequestDispatcher("/PatientInfo.jsp");
                rd.forward(request, response);

            } else {
                RequestDispatcher rd = request.getRequestDispatcher("/ErrorPage.jsp");
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
