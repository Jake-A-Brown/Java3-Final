package com.example.dentist.AppointmentBOPack;

import com.example.dentist.PatientBOPack.PatientBO;

import java.sql.*;
/****/

public class AppointmentBO {
    //variables 4
    public String ADatetime, APatid, ADentid, AprocCode;
    public PatientBO patient;
    public boolean hasAppointments;

    //default constructor
    public AppointmentBO() {
        super();
        ADatetime = "";
        APatid = "";
        ADentid = "";
        AprocCode = "";
    }//end default constructor

    //constructor
    public AppointmentBO(String Datetime, String Patid, String Dentid, String ProcCode) {
        super();
        ADatetime = Datetime;
        APatid = Patid;
        ADentid = Dentid;
        AprocCode = ProcCode;
    }//end constructor
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //test code


    public String getADatetime() {
        return ADatetime;
    }

    //get and set methods
    public void setADatetime(String Datetime) {
        ADatetime = Datetime;
    }

    public String getAPatid() {
        return APatid;
    }

    public void setAPatid(String Patid) {
        APatid = Patid;
    }

    public void setAtDentid(String Dentid) {
        ADentid = Dentid;
    }

    public String getADentid() {
        return ADentid;
    }

    public String getAprocCode() {
        return AprocCode;
    }
    //end set and get methods

    public void setAprocCode(String ProcCode) {
        AprocCode = ProcCode;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //display method
    public void ApptBOdisplay() {
        System.out.println("Appointment time ----" + getADatetime());
        System.out.println("Patient ID ----" + getAPatid());
        System.out.println("Dentist ID ----" + getADentid());
        System.out.println("Proc Code ----" + getAprocCode());
        System.out.println("------------------------------------------------------------------");
    }//end display()

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //SelectDB method
    public void selectDB(String Did) {
        //ADatetime = Datetime;
        ADentid=Did;//

        System.out.println("Connecting to the appointmentDB --------------------------");

        try {
            //step 1 Load Driver
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            //Step 2 get a connection
            Connection con1;
            con1 = DriverManager.getConnection("jdbc:ucanaccess://" + "C://Users//loucr//OneDrive//Desktop//Final//Dentist//src//main//java//DentistOfficeACCDB.accdb");
            //Step 3 create statement
            Statement stmt1 = con1.createStatement();
            //step 4 execute sql statement
            String sql1 = "SELECT * FROM Appointments WHERE dentId ='" + getADentid() + "'";
            System.out.println(sql1);
            //step 5 process the data
            ResultSet rs = stmt1.executeQuery(sql1);
            rs.next();
            setADatetime(rs.getString(1));
            setAPatid(rs.getString(2));
            setAtDentid(rs.getString(3));
            setAprocCode(rs.getString(4));

            patient.selectDB(getAPatid());
            System.out.println("This part is running now ....");
            System.out.println(patient.getPid());
            patient.PatientBOdisplay();

            con1.close();//close connection

        } catch (Exception ex1) {
            System.out.println("PP: " + ex1);
        }
    }//end selectDB

    public void selectpid(String id) {
        APatid = id;

        System.out.println("Connecting to the appointmentDB --------------------------");

        try {
            //step 1 Load Driver
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            //Step 2 get a connection
            Connection con1;
            con1 = DriverManager.getConnection("jdbc:ucanaccess://" + "C://Users//loucr//OneDrive//Desktop//Final//Dentist//src//main//java//DentistOfficeACCDB.accdb");
            //Step 3 create statement
            Statement stmt1 = con1.createStatement();
            //step 4 execute sql statement
            String sql1 = "SELECT * FROM Appointments WHERE patId='" + getAPatid() + "'";
            //System.out.println(sql1);
            //step 5 process the data
            ResultSet rs = stmt1.executeQuery(sql1);
            rs.next();
            setADatetime(rs.getString(1));
            setAPatid(rs.getString(2));
            setAtDentid(rs.getString(3));
            setAprocCode(rs.getString(4));

            con1.close();//close connection

        } catch (Exception ex1) {
            System.out.println("PP: " + ex1);
        }
    }//end selectDB()

    public boolean selectpid1(String id) {
        APatid = id;
        boolean hasAppointments = false;

        System.out.println("Connecting to the appointmentDB --------------------------");

        try {
            //step 1 Load Driver
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            //Step 2 get a connection
            Connection con1;
            con1 = DriverManager.getConnection("jdbc:ucanaccess://" + "C://Users//loucr//OneDrive//Desktop//Final//Dentist//src//main//java//DentistOfficeACCDB.accdb");
            //Step 3 create statement
            Statement stmt1 = con1.createStatement();
            //step 4 execute sql statement
            String sql1 = "SELECT COUNT (*) FROM Appointments WHERE patId='" + getAPatid() + "'";
            System.out.println(sql1);
            //step 5 process the data
            ResultSet rs = stmt1.executeQuery(sql1);
            rs.next();
            int count = rs.getInt(1);
            if (count > 0) {
                hasAppointments = true;
            }

            con1.close();//close connection

        } catch (Exception ex1) {
            System.out.println("PP: " + ex1);
        }
        return hasAppointments;
    }//end selectDB()

    //insert DB method
    public void insertDB(String DateTime, String Patid, String Dentid, String ProcCode) {
        ADatetime = DateTime;
        APatid = Patid;
        ADentid = Dentid;
        AprocCode = ProcCode;

        System.out.println("Inserting into DB--------------------------------");

        try {
            //step 1 Load driver
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            //step 2 get connection
            Connection con2 = DriverManager.getConnection("jdbc:ucanaccess://" + "C://Users//loucr//OneDrive//Desktop//Final//Dentist//src//main//java//DentistOfficeACCDB.accdb");
            //step 3 create statement
            String sql2;
            //step 4 execute sql statement
            sql2 = "Insert Into Appointments(apptDateTime, patId, dentId, procCode) VALUES(?,?,?,?)";
            System.out.println("Appointent Data Inserted-------------------------------");
            //step 5 process the data
            PreparedStatement ps1 = con2.prepareStatement(sql2);
            ps1.setString(1, this.getADatetime());
            ps1.setString(2, this.getAPatid());
            ps1.setString(3, this.getADentid());
            ps1.setString(4, this.getAprocCode());


            ps1.executeUpdate();

            con2.close();//close connection
        } catch (Exception ex2) {
            System.out.println("PP: " + ex2);
        }
    }//end insertDB()

    //delete DB method
    public void deleteDB(String patid) {
        APatid = patid;
        System.out.println("Deleting Appointment----------------------------");

        try {
            //step 1 load driver
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            //step 2 get connection
            Connection con3 = DriverManager.getConnection("jdbc:ucanaccess://" + "C://Users//loucr//OneDrive//Desktop//Final//Dentist//src//main//java//DentistOfficeACCDB.accdb");
            //step 3 create a statement
            String sql3;
            //step 4 execute sql statement
            sql3 = "Delete From Appointments Where patId='" + this.getAPatid() + "'";
            System.out.println("Deleted Data from Appointments---------------------------------");
            //step 5 process the data
            PreparedStatement ps2 = con3.prepareStatement(sql3);
            ps2.executeUpdate();

            con3.close();//close connection
        } catch (Exception ex3) {
            System.out.println("PP: " + ex3);
        }
    }//end DeleteDB()

    public void UpdateDB(AppointmentBO appt) {
        System.out.println("Updating Patient----------------------");

        try {
            //step 1 Load Driver
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            //Step 2 get a connection
            Connection con4;
            con4 = DriverManager.getConnection("jdbc:ucanaccess://" + "C://Users//loucr//OneDrive//Desktop//Final//Dentist//src//main//java//DentistOfficeACCDB.accdb");
            //create statement
            String sql3;
            String sql4;
            String sql5;
            String sql6;
            //step 4 execute sql statement
            sql3 = "Update Appoimtments Set apptDateTime='" + this.getADatetime() + "'" + "Where apptDateTime='" + this.getADatetime() + "'";
            sql4 = "Update Appoimtments Set patId='" + this.getAPatid() + "'" + "Where apptDateTime='" + this.getADatetime() + "'";
            sql5 = "Update Appoimtments Set dentId='" + this.getADentid() + "'" + "Where apptDateTime='" + this.getADatetime() + "'";
            sql6 = "Update Appoimtments Set procCode='" + this.getAprocCode() + "'" + "Where apptDateTime='" + this.getADatetime() + "'";
            //step 5 process data
            PreparedStatement ps2 = con4.prepareStatement(sql3);
            PreparedStatement ps3 = con4.prepareStatement(sql4);
            PreparedStatement ps4 = con4.prepareStatement(sql5);
            PreparedStatement ps5 = con4.prepareStatement(sql6);
            ps2.executeUpdate();
            ps3.executeUpdate();
            ps4.executeUpdate();
            ps5.executeUpdate();
            con4.close();
        } catch (Exception ex3) {
            System.out.println("PP: " + ex3);
        }
    }//end Update()

    public static void main(String[] args) {
        AppointmentBO a1 = new AppointmentBO();
        a1.selectpid("A900");
        a1.ApptBOdisplay();
//
//        AppointmentBO a1 = new AppointmentBO();
//        a1.insertDB("May 3, 2010, 1am","A100","D901","P114");
//        a1.ApptBOdisplay();
//
//        AppointmentBO a1 = new AppointmentBO();
//        a1.deleteDB("A100");
    }
}
