package com.example.dentist;

import com.example.dentist.PatientBOPack.PatientBO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "PatientServlet", value = "/PatientServlet")
public class PatientServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();

//        PatientBO p1 = new PatientBO();
//        //p1.selectDB();
//
//        HttpSession ses1;
//        ses1=request.getSession();
//        ses1.setAttribute("p1",p1);
//        RequestDispatcher rd = request.getRequestDispatcher("/NewPatientForm.jsp");
//        rd.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String PFNTextBox = request.getParameter("PFNTextBox");
        String PLNTextBox = request.getParameter("PLNTextBox");
        String PAddyTextBox = request.getParameter("PAddyTextBox");
        String PEmailTextBox = request.getParameter("PEmailTextBox");

        PatientBO p1 = (PatientBO) request.getSession().getAttribute("p1");

        p1.selectDB(p1.getPid());
        p1.setPfn(PFNTextBox);
        p1.setPln(PLNTextBox);
        p1.setPaddy(PAddyTextBox);
        p1.setPemail(PEmailTextBox);

        p1.UpdateDB(p1);

        response.sendRedirect("PatientInfo.jsp");
    }
}
