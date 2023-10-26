package AllFiles;
import java.util.ArrayList;


public class HelpDesk {
    
    private ArrayList<Patient> opdPatientList = new ArrayList<>();

    private ArrayList<Patient> non_OpdPatientList = new ArrayList<>();

    public void patientRegistation(){
        System.out.println("Patient registration started.++++++++++++++++++++++++++++++++++");
        // Define values for the patient
        String id = "ID";
        String name = "Harsha m";
        int age = 24;
        GenderTypes gender = GenderTypes.Male;
        int contactNum = 1234567890;
        PatientAdmissionType admissionType = PatientAdmissionType.Opd;
        Departments department = Departments.Cardiology;
        // Create a PatientModel object
        Patient patient01 = new Patient(id, name, age, gender, contactNum, admissionType, department);
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
        // System.out.println(patient01.fullName);
        System.out.println("opd patient cout is: " + opdPatientList.size());
        System.out.println("Non_Opd patient cout is: " + non_OpdPatientList.size());
        System.out.println("Patient registration completed. and data stored.++++++++++++++++++++++++++++++++");
        System.out.println("");
        // System.out.println("Asking for Department to Visit.");
    }
    
}
