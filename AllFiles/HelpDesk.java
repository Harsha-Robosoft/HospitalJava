package AllFiles;
import java.util.ArrayList;
import AllFiles.AllDepartments.*;

public class HelpDesk {
    
    private ArrayList<Patient> opdPatientList = new ArrayList<>();
    private ArrayList<Patient> non_OpdPatientList = new ArrayList<>();

    private int opdPatinetIdCount = 0;
    private int non_opdPatinetIdCount = 0;
    

    public void patientRegistation(){
        System.out.println(":- Patient registration started.");
        // Define values for the patient
        String id = "";
        String name = "Harsha m";
        int age = 24;
        GenderTypes gender = GenderTypes.Male;
        int contactNum = 1234567890;
        PatientAdmissionType admissionType = PatientAdmissionType.Opd;
        switch (admissionType) {
            case Opd:
            opdPatinetIdCount += 1;
            id = "Opd_ID: " + opdPatinetIdCount;
            break;
            case Non_Opd:
            non_opdPatinetIdCount += 1;
            id = "Non_Opd_ID: " + non_opdPatinetIdCount;
            break;
        }
        Departments department = Departments.Cardiology;
        // Create a PatientModel object
        Patient patient01 = new Patient(id, name, age, gender, contactNum, admissionType, department);
        switch (admissionType){
            case Opd:
                opdPatientList.add(patient01);
            break;
            case Non_Opd:
                non_OpdPatientList.add(patient01);
            break;
        }
        System.out.println(":- Patient registration completed and data stored.++++++++");
        System.out.println("");
        System.out.println(":- Sending patient to respective department.");
        sendPatientToRespectiveDepartment(patient01, department);
    }
    
    private void sendPatientToRespectiveDepartment(Patient patientIs, Departments departmentToSend){
         switch (departmentToSend){
            case Cardiology:
                System.out.println(":- Sent patient to respective department which is CARDIOLOGY and also sent the patient file.");
                Patient patientObj =  new CardiologyDep().startPatientCheckup(patientIs);
                Departments checkDepartment = Departments.Cardiology;
                System.out.println(":- Started the payment process.");
                completeThePaymentProcess(checkDepartment, patientObj);
            break;
            case Neurology:
                System.out.println(":- Sent patient to respective department which is NEWUROLOGY and also sent the patient file.");
                Patient patientObj01 = new NeurologyDep().startPatientCheckup(patientIs);
                Departments checkDepartment01 = Departments.Neurology;
                System.out.println(":- Started the payment process.");
                completeThePaymentProcess(checkDepartment01, patientObj01);
            break;
            case Orthopedics:
                System.out.println(":- Sent patient to respective department which is ORTHOPEDICS and also sent the patient file.");
                Patient patientObj02 = new OrthopedicDep().startPatientCheckup(patientIs);
                Departments checkDepartment02 = Departments.Orthopedics;
                System.out.println(":- Started the payment process.");
                completeThePaymentProcess(checkDepartment02, patientObj02);
            break;
            case Pediatrics:
                System.out.println(":- Sent patient to respective department which is PEDIATRICS and also sent the patient file.");
                Patient patientObj03 = new PediatricsDep().startPatientCheckup(patientIs);
                Departments checkDepartment03 = Departments.Pediatrics;
                System.out.println(":- tarted the payment process.");
                completeThePaymentProcess(checkDepartment03, patientObj03);
            break;
        }
    }

    private void completeThePaymentProcess(Departments whichDepartmentVisited,Patient patientObjectFromdepartment){
        if (patientObjectFromdepartment.getCheckUpDetails().containsKey(whichDepartmentVisited)){
            ArrayList<PatientCheckUpDetails> checkUpDetailsArray = patientObjectFromdepartment.getCheckUpDetails().get(whichDepartmentVisited);
            if (!checkUpDetailsArray.isEmpty()) {
                PatientCheckUpDetails lastPatientCheckUpDetails = checkUpDetailsArray.get(checkUpDetailsArray.size() - 1);
                lastPatientCheckUpDetails.setAmountPaied(true);
                // Here the patient object in the opd patient array is autometically updated with checkup details to check look into below commented lines
                // for (Patient pat : opdPatientList) {
                //     if (pat.getPatientID() == patientObj.getPatientID()){
                //         if (pat.getCheckUpDetails().containsKey(checkDepartment)){
                //             ArrayList<PatientCheckUpDetails> test = pat.getCheckUpDetails().get(checkDepartment);
                //             PatientCheckUpDetails pa = test.get(test.size() - 1);
                //             System.out.println("909090" + pa);
                //         }
                //     }
                // }
                System.out.println(":- payment completed.");
                System.err.println("////////// " + whichDepartmentVisited + " //////////");
                System.out.println("");

                System.out.println("----------- Complete patientDetails ------------ \n" + patientObjectFromdepartment);

            } else {
                System.out.println(":- payment not completed.");
                System.err.println(":- The ArrayList is empty.");
            }
        }
    }
}
