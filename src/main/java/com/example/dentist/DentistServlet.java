package com.example.dentist;

import com.example.dentist.DentistBOPack.DentistBO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "DentistServlet", value = "/DentistServlet")
public class DentistServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String dfntext = request.getParameter("dfntext");
        String dlastname = request.getParameter("dlastname");
        String demail = request.getParameter("demail");
        String dofficenum = request.getParameter("dofficenum");

        DentistBO d1 = (DentistBO) request.getSession().getAttribute("d1");

        d1.selectDB(d1.getDid());
        d1.setDfn(dfntext);
        d1.setDln(dlastname);
        d1.setDemail(demail);
        d1.setDoffice(dofficenum);

        d1.UpdateDB(d1);

        response.sendRedirect("DentistInfo.jsp");
    }
}
