package com.example.dentist.ProcedureBOPack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ProcedureBO {
    //variables 4
    String ProcCode, ProcName, ProcDesc;
    double Proccost;

    //default constructor
    public ProcedureBO() {
        super();
        ProcCode = "";
        ProcName = "";
        ProcDesc = "";
        Proccost = 0.0;
    }//end default constructor

    //constructor
    public ProcedureBO(String code, String name, String desc, double cost) {
        super();
        ProcCode = code;
        ProcName = name;
        ProcDesc = desc;
        Proccost = cost;
    }//end constructor

    public static void main(String[] args) {
        ProcedureBO pr1 = new ProcedureBO();
        pr1.selectDB("P122");
        pr1.ProcedureBOdisplay();
    }

    public String getProcCode() {
        return ProcCode;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //set get methods
    public void setProcCode(String code) {
        ProcCode = code;
    }

    public String getProcName() {
        return ProcName;
    }

    public void setProcName(String name) {
        ProcName = name;
    }

    public String getProcDesc() {
        return ProcDesc;
    }

    public void setProcDesc(String desc) {
        ProcDesc = desc;
    }

    public double getProccost() {
        return Proccost;
    }
    //eng get set methods
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public void setProccost(double cost) {
        Proccost = cost;
    }

    public void ProcedureBOdisplay() {
        System.out.println("Procedure code ----" + getProcCode());
        System.out.println("Procedure name ----" + getProcName());
        System.out.println("Procedure description ----" + getProcDesc());
        System.out.println("Cost of Procedure ----" + getProccost());
        System.out.println("----------------------------------------------------------------------");
    }//end display()

    public void selectDB(String code) {
        ProcCode = code;

        System.out.println("Connecting to Procedure Database--------------------------------");

        try {
            //step 1 Load Driver
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            //Step 2 get a connection
            Connection con1;
            con1 = DriverManager.getConnection("jdbc:ucanaccess://" + "C://Users//loucr//OneDrive//Desktop//Final//Dentist//src//main//java//DentistOfficeACCDB.accdb");
            //Step 3 create statement
            Statement stmt1 = con1.createStatement();
            //step 4 execute sql statement
            String sql1 = "SELECT * FROM Procedures WHERE procCode='" + ProcCode + "'";
            System.out.println(sql1);
            //step 5 process the data
            ResultSet rs = stmt1.executeQuery(sql1);
            rs.next();

            setProcCode(rs.getString(1));
            setProcName(rs.getString(2));
            setProcDesc(rs.getString(3));
            setProccost(rs.getDouble(4));

            con1.close();//close connection

        } catch (Exception ex1) {
            System.out.println("PP: " + ex1);
        }
    }//end selectDB()
}