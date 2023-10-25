package AllFiles;
import java.util.ArrayList;

import Models.*;

public class HelpDesk {
    
    private ArrayList<PatientModel> opdPatientList = new ArrayList<>();

    private ArrayList<PatientModel> non_OpdPatientList = new ArrayList<>();

    public void patientRegistation(){
        System.out.println("Patient registration started.++++++++++++++++++++++++++++++++++");
        
        // Define values for the patient
        String firstName = "Harsha";
        String lastName = "M";
        int age = 24;
        PatientModel.GenderTypes gender = PatientModel.GenderTypes.Male;
        int contactNum = 1234567890;
        PatientModel.PatientAdmissionType admissionType = PatientModel.PatientAdmissionType.Non_Opd;

        // Create a PatientModel object
        PatientModel patient01 = new PatientModel(firstName, lastName, age, gender, contactNum, admissionType);
        switch (admissionType){
            case Opd:
                opdPatientList.add(patient01);
                System.out.println("added to opd patient array");
            break;
            case Non_Opd:
                non_OpdPatientList.add(patient01);
                System.out.println("added to non_opd patient array");
            break;
        }

        System.out.println(patient01);
        System.out.println("opd patient cout is: " + opdPatientList.size());
        System.out.println("Non_Opd patient cout is: " + non_OpdPatientList.size());
        System.out.println("++++++++++++++++++++++++++++++++");
        System.out.println("");
    }
    
}
