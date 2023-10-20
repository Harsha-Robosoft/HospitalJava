package AllFiles;
import Models.*;

public class HelpDesk {
    
    private PatientModel opdPatientList[];
    private int opdPatientCount; 

    private PatientModel non_OpdPatientList[];
    private int non_OpdPatientCount; 

    public void patientRegistation(){
        System.out.println("Patient registration started.++++++++++++++++++++++++++++++++++");
        
        // Define values for the patient
        String firstName = "John";
        String lastName = "Doe";
        int age = 30;
        PatientModel.GenderTypes gender = PatientModel.GenderTypes.Male; // Access the GenderTypes enum
        int contactNum = 1234567890;
        PatientModel.PatientAdmissionType admissionType = PatientModel.PatientAdmissionType.Opd; // Access the AdmissionType enum

        // Create a PatientModel object
        PatientModel patient01 = new PatientModel(firstName, lastName, age, gender, contactNum, admissionType);
        switch (admissionType){
            case Opd:
            if (opdPatientCount < opdPatientList.length) {
                opdPatientList[opdPatientCount] = patient01;
                opdPatientCount++;
            } else {
                System.out.println("OPD patient list is full.");
            }
            break;
            case Non_Opd:
            if (non_OpdPatientCount < non_OpdPatientList.length) {
                non_OpdPatientList[opdPatientCount] = patient01;
                non_OpdPatientCount++;
            } else {
                System.out.println("OPD patient list is full.");
            }
            break;
        }

        System.out.println("patient is registered and type od patient is " + admissionType);
        System.out.println("patient detsails is " + patient01);
        System.out.println("opd patient cout is: " + opdPatientCount);
        System.out.println("Non_Opd patient cout is: " + non_OpdPatientCount);
        System.out.println("++++++++++++++++++++++++++++++++");
    }
    
}
