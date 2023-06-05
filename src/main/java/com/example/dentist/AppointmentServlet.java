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


@WebServlet(name = "AppointmentServlet", value = "/AppointmentServlet")
public class AppointmentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();

        String id = request.getParameter("Pid");
        AppointmentBO a2 = new AppointmentBO();
        boolean hasAppointments = a2.selectpid1(id);

        HttpSession ses2;
        ses2 = request.getSession();
        ses2.setAttribute("a2", a2);

        RequestDispatcher rd;
        if (hasAppointments) {
            rd = request.getRequestDispatcher("/PatientInfo.jsp");
        }else if(!hasAppointments)        {
            rd = request.getRequestDispatcher("/NewPatientForm.jsp");
        }else{
            rd = request.getRequestDispatcher("/PatientLogin.jsp");
        }
        rd.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Get the form data from the request
        String id = request.getParameter("IdTextBox");
        String passwd = request.getParameter("PsswdTextBox");
        String firstName = request.getParameter("FNTextBox");
        String lastName = request.getParameter("LNTextBox");
        String address = request.getParameter("AddyTextBox");
        String email = request.getParameter("EmailTextBox");
        String insCo = request.getParameter("InsCoTextBox");

        // Create a new instance of the PatientBO class and set the data
        PatientBO patient = new PatientBO();
        patient.setPid(id);
        patient.setPpasswd(passwd);
        patient.setPfn(firstName);
        patient.setPln(lastName);
        patient.setPaddy(address);
        patient.setPemail(email);
        patient.setPinsco(insCo);

        // Call the insertDB method to insert the data into the database
        patient.insertDB(id, passwd, firstName, lastName, address, email, insCo);

        // Redirect the user to a confirmation page
        response.sendRedirect("Appointment.jsp");
    }
}
