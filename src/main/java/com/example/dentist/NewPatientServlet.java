package com.example.dentist;

import com.example.dentist.AppointmentBOPack.AppointmentBO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "NewPatientServlet", value = "/NewPatientServlet")
public class NewPatientServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String DateTime = request.getParameter("DateTime");
        String Patid = request.getParameter("PatientId");
        String Dentid = request.getParameter("DentId");
        String Proc = request.getParameter("ProcCode");

        AppointmentBO Appt = new AppointmentBO();

        Appt.setADatetime(DateTime);
        Appt.setAPatid(Patid);
        Appt.setAtDentid(Dentid);
        Appt.setAprocCode(Proc);

        Appt.insertDB(DateTime, Patid, Dentid, Proc);

        response.sendRedirect("PatientLogin.jsp");
    }
}
