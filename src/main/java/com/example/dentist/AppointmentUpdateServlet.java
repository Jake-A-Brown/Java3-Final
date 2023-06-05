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


@WebServlet(name = "AppointmentUpdateServlet", value = "/AppointmentUpdateServlet")
public class AppointmentUpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String DateTime = request.getParameter("Datetime");
        String Patid = request.getParameter("Patientid");
        String Dentid = request.getParameter("Dentid");
        String Proc = request.getParameter("Proccode");

        AppointmentBO Appt =(AppointmentBO) request.getSession().getAttribute("a1");

        Appt.setADatetime(DateTime);
        Appt.setAPatid(Patid);
        Appt.setAtDentid(Dentid);
        Appt.setAprocCode(Proc);

        Appt.UpdateDB(Appt);

        response.sendRedirect("PatientInfo.jsp");
    }
}