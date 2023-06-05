package com.example.dentist.PatientBOPack;

import com.example.dentist.AppointmentBOPack.AppointmentBO;
import com.example.dentist.AppointmentListBOPack.AppointmentListBO;

import java.sql.*;

public class PatientBO {
    public AppointmentBO apt;
    //variables 7
    String Pid, Ppasswd, Pfn, Pln, Paddy, Pemail, Pinsco;
    public AppointmentListBO aList = new AppointmentListBO();


    //default constructor
    public PatientBO() {
        super();
        Pid = "";
        Ppasswd = "";
        Pfn = "";
        Pln = "";
        Paddy = "";
        Pemail = "";
        Pinsco = "";
        apt = new AppointmentBO();
    }//default constructor

    //Constructor
    public PatientBO(String id, String passwd, String fn, String ln, String addy, String email, String insco) {
        super();
        Pid = id;
        Ppasswd = passwd;
        Pfn = fn;
        Pln = ln;
        Paddy = addy;
        Pemail = email;
        Pinsco = insco;
        apt = new AppointmentBO();
    }//end constructor


    public String getPid() {
        return Pid;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //set and get methods
    public void setPid(String id) {
        Pid = id;
    }

    public String getPpasswd() {
        return Ppasswd;
    }

    public void setPpasswd(String passwd) {
        Ppasswd = passwd;
    }

    public String getPfn() {
        return Pfn;
    }

    public void setPfn(String fn) {
        Pfn = fn;
    }

    public String getPln() {
        return Pln;
    }

    public void setPln(String ln) {
        Pln = ln;
    }

    public String getPaddy() {
        return Paddy;
    }

    public void setPaddy(String addy) {
        Paddy = addy;
    }

    public String getPemail() {
        return Pemail;
    }

    public void setPemail(String email) {
        Pemail = email;
    }

    public String getPinsco() {
        return Pinsco;
    }
    //end get set methods
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public void setPinsco(String insco) {
        Pinsco = insco;
    }

    //dsiplay method
    public void PatientBOdisplay() {
        System.out.println("Patient ID ----" + getPid());
        System.out.println("Patient password ----" + getPpasswd());
        System.out.println("Patient first name ----" + getPfn());
        System.out.println("Patient last name ----" + getPln());
        System.out.println("Patient address ----" + getPaddy());
        System.out.println("Patient email ----" + getPemail());
        System.out.println("Patient insurance company ----" + getPinsco());
        System.out.println("----------------------------------------------------------------");
    }//display()

    //selectDB method
    public void selectDB(String id) {
        Pid = id;

        System.out.println("Connecting to Patient Database--------------------------------");

        try {
            //step 1 Load Driver
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            //Step 2 get a connection
            Connection con1;
            con1 = DriverManager.getConnection("jdbc:ucanaccess://" + "C://Users//loucr//OneDrive//Desktop//Final//Dentist//src//main//java//DentistOfficeACCDB.accdb");
            //Step 3 create statement
            Statement stmt1 = con1.createStatement();
            //step 4 execute sql statement
            String sql1 = "Select * FROM Patients WHERE patId='" + Pid + "'";
            System.out.println(sql1);
            //step 5 process the data
            ResultSet rs = stmt1.executeQuery(sql1);
            rs.next();


            setPid(rs.getString(1));
            setPpasswd(rs.getString(2));
            setPfn(rs.getString(3));
            setPln(rs.getString(4));
            setPaddy(rs.getString(5));
            setPemail(rs.getString(6));
            setPinsco(rs.getString(7));

            apt.selectpid(Pid);
            apt.ApptBOdisplay();

            con1.close();//close connection

        } catch (Exception ex1) {
            System.out.println("PP: " + ex1);
        }
    }//end selectDB()

    //insertDB()
    public void insertDB(String id, String passwd, String fn, String ln, String addy, String email, String insco) {
        Pid = id;
        Ppasswd = passwd;
        Pfn = fn;
        Pln = ln;
        Paddy = addy;
        Pemail = email;
        Pinsco = insco;

        System.out.println("Inserting to Patient Database--------------------------------");

        try {
            //step 1 Load Driver
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            //Step 2 get a connection
            Connection con2;
            con2 = DriverManager.getConnection("jdbc:ucanaccess://" + "C://Users//loucr//OneDrive//Desktop//Final//Dentist//src//main//java//DentistOfficeACCDB.accdb");
            //create statement
            String sql2;
            //step 4 execute sql statement
            sql2 = "INSERT INTO Patients(patId, passwd, firstName, lastName, addr, email, insCo)" + "VALUES(?,?,?,?,?,?,?)";

            System.out.println("Data Inserted--------------------------------------");

            //step 5 process the data
            PreparedStatement ps1 = con2.prepareStatement(sql2);
            ps1.setString(1, getPid());
            ps1.setString(2, getPpasswd());
            ps1.setString(3, getPfn());
            ps1.setString(4, getPln());
            ps1.setString(5, getPaddy());
            ps1.setString(6, getPemail());
            ps1.setString(7, getPinsco());

            ps1.executeUpdate();

            con2.close();//close connection
        } catch (Exception ex2) {
            System.out.println("PP:" + ex2);
        }
    }//end insertDB()

    //UpdateDB()
    public void UpdateDB(PatientBO p1) {
        System.out.println("Updating Patient----------------------");

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
            sql3 = "Update Patients Set firstName='" + this.getPfn() + "'" + "Where patId='" + this.getPid() + "'";
            sql4 = "Update Patients Set lastName='" + this.getPln() + "'" + "Where patId='" + this.getPid() + "'";
            sql5 = "Update Patients Set addr='" + this.getPaddy() + "'" + "Where patId='" + this.getPid() + "'";
            sql6 = "Update Patients Set email='" + this.getPemail() + "'" + "Where patId='" + this.getPid() + "'";
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
        } catch (Exception ex3) {
            System.out.println("PP: " + ex3);
        }
    }//end Update()

    public void deleteDB(String id) {
        System.out.println("Deleting a Patient-------------------------");

        try {
            //step 1 Load Driver
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            //Step 2 get a connection
            Connection con4;
            con4 = DriverManager.getConnection("jdbc:ucanaccess://" + "C://Users//loucr//OneDrive//Desktop//Final//Dentist//src//main//java//DentistOfficeACCDB.accdb");
            //step 3 create statement
            String sql7;
            //step 4 execute sql statement
            sql7 = "Delete From Patients Where patId='" + this.getPid() + "'";
            System.out.println("deleted a patient--------------------------");
            //step 5 process data
            PreparedStatement ps6 = con4.prepareStatement(sql7);
            ps6.executeUpdate();

            con4.close();//close connnection
        } catch (Exception ex4) {
            System.out.println("PP: " + ex4);
        }

    }

    public static void main(String[] args) {
        //selectDB test

        PatientBO p1 = new PatientBO();
        p1.selectDB("A900");
        p1.PatientBOdisplay();

//        PatientBO p1 = new PatientBO();
//        p1.selectDB("A900");
//
//        p1.PatientBOdisplay();

        //insertDB test

//        PatientBO p2 = new PatientBO();
//        p2.insertDB(" ", " ", "Jakey", "Brown", "123 elm st", "123@gmail.com", " ");
//        p2.PatientBOdisplay();

//        PatientBO p1 = new PatientBO();
//        p1.insertDB("", "", "", "", "", "", "");
//        p1.PatientBOdisplay();

//        PatientBO p2 = new PatientBO();
//        p2.selectDB("B101");
//        p2.deleteDB("");
//        p2.PatientBOdisplay();
    }

}
