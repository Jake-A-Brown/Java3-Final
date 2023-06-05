package com.example.dentist.DentistBOPack;


import com.example.dentist.AppointmentBOPack.AppointmentBO;
import com.example.dentist.AppointmentListBOPack.*;

import java.sql.*;

public class DentistBO extends AppointmentListBO {
    public AppointmentListBO aList = new AppointmentListBO();
    //variables 6
    String Did, Dpasswd, Dfn, Dln, Demail, Doffice;

    //Default constructor
    public DentistBO() {
        super();
        Did = "";
        Dpasswd = "";
        Dfn = "";
        Dfn = "";
        Demail = "";
        Doffice = "";
    }//end default constructor

    //Constructor
    public DentistBO(String id, String passwd, String fn, String ln, String email, String office) {
        super();
        Did = id;
        Dpasswd = passwd;
        Dfn = fn;
        Dln = ln;
        Demail = email;
        Doffice = office;
    }//end constructor



    public String getDid() {
        return Did;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //set and get methods
    public void setDid(String id) {
        Did = id;
    }

    public String getDpasswd() {
        return Dpasswd;
    }

    public void setDpasswd(String passwd) {
        Dpasswd = passwd;
    }

    public String getDfn() {
        return Dfn;
    }

    public void setDfn(String fn) {
        Dfn = fn;
    }

    public String getDln() {
        return Dln;
    }

    public void setDln(String ln) {
        Dln = ln;
    }

    public String getDemail() {
        return Demail;
    }

    public void setDemail(String email) {
        Demail = email;
    }

    public String getDoffice() {
        return Doffice;
    }
    //end get set methods
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public void setDoffice(String office) {
        Doffice = office;
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //selectDB method incoming

    //display method incoming
    public void DentistBOdisplay() {
        System.out.println("Dentist ID ----" + getDid());
        System.out.println("Dentist password ----" + getDpasswd());
        System.out.println("Dentist first name ----" + getDfn());
        System.out.println("Dentist last name ----" + getDln());
        System.out.println("Dentist email ----" + getDemail());
        System.out.println("Dentist office # ----" + getDoffice());
        System.out.println("----------------------------------------------------------------");
    }//end display()

    public void selectDB(String id) {
        Did = id;

        //"SELECT apptDateTime FROM Appointments WHERE dentId='" + getDid() + "'";

        System.out.println("Connecting to Dentist Database--------------------------------");

        try {
            //step 1 Load Driver
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            //Step 2 get a connection
            Connection con1;
            con1 = DriverManager.getConnection("jdbc:ucanaccess://" + "C://Users//loucr//OneDrive//Desktop//Final//Dentist//src//main//java//DentistOfficeACCDB.accdb");
            //Step 3 create statement
            Statement stmt1 = con1.createStatement();
            //step 4 execute sql statement
            String sql1 = "SELECT* FROM Dentists WHERE id='" + Did + "'";
            System.out.println(sql1);
            //step 5 process the data
            ResultSet rs = stmt1.executeQuery(sql1);
            rs.next();

            setDid(rs.getString(1));
            setDpasswd(rs.getString(2));
            setDfn(rs.getString(3));
            setDln(rs.getString(4));
            setDemail(rs.getString(5));
            setDoffice(rs.getString(6));

            con1.close();//close connection

        } catch (Exception ex1) {
            System.out.println("PP: " + ex1);
        }
    }//end selectDB()

    public AppointmentListBO getAppt() {
        String ADatetime;
        AppointmentBO a1;

        //"SELECT apptDateTime FROM Appointments WHERE dentId='" + getDid() + "'";

        System.out.println("Connecting to Dentist Database--------------------------------");

        try {
            //step 1 Load Driver
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            //Step 2 get a connection
            Connection con2;
            con2 = DriverManager.getConnection("jdbc:ucanaccess://" + "C://Users//loucr//OneDrive//Desktop//Final//Dentist//src//main//java//DentistOfficeACCDB.accdb");
            //Step 3 create statement
            Statement stmt2 = con2.createStatement();
            //step 4 execute sql statement
            String sql2 = "SELECT * FROM Appointments WHERE dentId='" + getDid() + "'";
            System.out.println(sql2);
            //step 5 process the data
            Statement ps1 = con2.createStatement();
            ResultSet rs2 = stmt2.executeQuery(sql2);
            rs2.next();

            while (rs2.next()) {
              String paId = rs2.getString("patId");
                a1 = new AppointmentBO();
                a1.selectpid(paId);
                aList.addAppt(a1);
                aList.displayAllAppointments();
                //a1.selectDB(ADatetime);
                //aList.addAppt(a1);
            }

            con2.close();//close connection

        } catch (Exception ex1) {
            System.out.println("PP: " + ex1);
        }
        return aList;
    }//end selectappt()

    public void UpdateDB(DentistBO d1) {

        System.out.println("Updating Dentist--------------------");

        try {
            //step 1 Load Driver
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            //Step 2 get a connection
            Connection con3;
            con3 = DriverManager.getConnection("jdbc:ucanaccess://" + "C://Users//loucr//OneDrive//Desktop//Final//Dentist//src//main//java//DentistOfficeACCDB.accdb");
            //create statement
            String sql3;
            String sql4;
            String sql5;
            String sql6;
            //step 4 execute sql statement
            sql3 = "Update Dentists Set firstName='" + this.getDfn() + "'" + "Where id='" + this.getDid() + "'";
            sql4 = "Update Dentists Set lastName='" + this.getDln() + "'" + "Where id='" + this.getDid() + "'";
            sql5 = "Update Dentists Set email='" + this.getDemail() + "'" + "Where id='" + this.getDid() + "'";
            sql6 = "Update Dentists Set office='" + this.getDoffice() + "'" + "Where id='" + this.getDid() + "'";
            //step 5 process data
            PreparedStatement ps2 = con3.prepareStatement(sql3);
            PreparedStatement ps3 = con3.prepareStatement(sql4);
            PreparedStatement ps4 = con3.prepareStatement(sql5);
            PreparedStatement ps5 = con3.prepareStatement(sql6);
            ps2.executeUpdate();
            ps3.executeUpdate();
            ps4.executeUpdate();
            ps5.executeUpdate();
            con3.close();
        } catch (Exception e2) {
            System.out.println("PP: " + e2);
        }
    }
    public static void main(String[] args) {
        DentistBO d1 = new DentistBO();
        d1.selectDB("D201");
        d1.DentistBOdisplay();

         AppointmentListBO allDAppt= d1.getAppt();

        for( int i = 0; i < allDAppt.apptArr.length ; i++){
            if(allDAppt != null)
                 allDAppt.apptArr[i].ApptBOdisplay();
        }



//        DentistBO d1 = new DentistBO();
//        d1.selectDB("D201");
//        d1.setDfn("Frank ");
//        d1.setDln("Martin");
//        d1.setDemail("fm@gmail.com");
//        d1.setDoffice("539");
//        d1.UpdateDB();
    }//fm@gmail.com
    //539
    //Martin
    //Frank
    //frank
    //D201
}
