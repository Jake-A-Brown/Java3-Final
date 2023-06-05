package com.example.dentist.AppointmentListBOPack;

import com.example.dentist.AppointmentBOPack.AppointmentBO;

public class AppointmentListBO {

    public int count;

    public AppointmentBO[] apptArr;

    public AppointmentListBO() {

        this.apptArr = new AppointmentBO[3];
    }

    public static void main(String[] args) {

    }

    public void addAppt(AppointmentBO a1) {

        this.apptArr[count] = a1;
        count++;
    }

    public void displayApptList() {

        for (int x = 0; x < count; x++) {
            apptArr[x].ApptBOdisplay();
        }
    }

    public AppointmentBO[] displayAllAppointments() {

        AppointmentBO[] result = new AppointmentBO[count];

        for (int i = 0; i < count; i++) {

            result[i] = new AppointmentBO(apptArr[i].getADatetime(), apptArr[i].getAPatid(), apptArr[i].getADentid(), apptArr[i].getAprocCode());
        }
        return result;
    }
}