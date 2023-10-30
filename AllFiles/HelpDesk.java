package AllFiles;
import java.util.ArrayList;
import AllFiles.AllDepartments.*;

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

        sendPatientToRespectiveDepartment(patient01, department);

        System.out.println("opd patient cout is: " + opdPatientList.size());
        System.out.println("Non_Opd patient cout is: " + non_OpdPatientList.size());
        System.out.println("Patient registration completed. and data stored.++++++++++++++++++++++++++++++++");
        System.out.println("");
    }
    
    private void sendPatientToRespectiveDepartment(Patient patientIs, Departments departmentToSend){
         switch (departmentToSend){
            case Cardiology:
               Patient patientObj =  new CardiologyDep().startPatientCheckup(patientIs);
               Departments checkDepartment = Departments.Cardiology;
               if (patientObj.getCheckUpDetails().containsKey(checkDepartment)){
                System.err.println("the key is: " + checkDepartment);
                ArrayList<PatientCheckUpDetails> checkUpDetailsArray = patientObj.getCheckUpDetails().get(checkDepartment);
                if (!checkUpDetailsArray.isEmpty()) {
                    PatientCheckUpDetails lastPatientCheckUpDetails = checkUpDetailsArray.get(checkUpDetailsArray.size() - 1);
                    lastPatientCheckUpDetails.setAmountPaied(true);
                    
                    Patient patientToRemoveFromArray = null;

                    for (Patient pat : opdPatientList) {
                        if (pat.getPatientID() == patientObj.getPatientID()){
                            patientToRemoveFromArray = pat;
                        }
                    }

                    // check here whether the correct patient object is removed or not

                    opdPatientList.remove(patientToRemoveFromArray);
                    opdPatientList.add(patientObj);



                    Patient teting = opdPatientList.get(opdPatientList.size() - 1);
                    if (teting.getCheckUpDetails().containsKey(checkDepartment)){
                        PatientCheckUpDetails lastData = checkUpDetailsArray.get(checkUpDetailsArray.size() - 1);
                        System.err.println("test print: " + lastData);
                    }
                } else {
                    System.err.println("The ArrayList is empty.");
                }
               }
               System.err.println("CARDIOLOGY //////////");
            break;
            case Neurology:
                Patient patientObj01 = new NeurologyDep().startPatientCheckup(patientIs);
                Departments checkDepartment01 = Departments.Neurology;
               if (patientObj01.getCheckUpDetails().containsKey(checkDepartment01)){
                System.err.println("the key is: " + checkDepartment01);
                ArrayList<PatientCheckUpDetails> checkUpDetailsArray = patientObj01.getCheckUpDetails().get(checkDepartment01);
                if (!checkUpDetailsArray.isEmpty()) {
                    PatientCheckUpDetails lastPatientCheckUpDetails = checkUpDetailsArray.get(checkUpDetailsArray.size() - 1);
                    System.err.println("pstient latent checkupdetails from NEWUROLOGY departmet: " + lastPatientCheckUpDetails);
                } else {
                    System.err.println("The ArrayList is empty.");
                }
               }
               System.err.println("NEWUROLOGY //////////");
                break;
            case Orthopedics:
                Patient patientObj02 = new OrthopedicDep().startPatientCheckup(patientIs);
                Departments checkDepartment02 = Departments.Orthopedics;
               if (patientObj02.getCheckUpDetails().containsKey(checkDepartment02)){
                System.err.println("the key is: " + checkDepartment02);
                ArrayList<PatientCheckUpDetails> checkUpDetailsArray = patientObj02.getCheckUpDetails().get(checkDepartment02);
                if (!checkUpDetailsArray.isEmpty()) {
                    PatientCheckUpDetails lastPatientCheckUpDetails = checkUpDetailsArray.get(checkUpDetailsArray.size() - 1);
                    System.err.println("pstient latent checkupdetails from ORTHOPEDICS departmet: " + lastPatientCheckUpDetails);
                } else {
                    System.err.println("The ArrayList is empty.");
                }
               }
               System.err.println("ORTHOPEDICS //////////");
                break;
            case Pediatrics:
                Patient patientObj03 = new PediatricsDep().startPatientCheckup(patientIs);
                Departments checkDepartment03 = Departments.Pediatrics;
               if (patientObj03.getCheckUpDetails().containsKey(checkDepartment03)){
                System.err.println("the key is: " + checkDepartment03);
                ArrayList<PatientCheckUpDetails> checkUpDetailsArray = patientObj03.getCheckUpDetails().get(checkDepartment03);
                if (!checkUpDetailsArray.isEmpty()) {
                    PatientCheckUpDetails lastPatientCheckUpDetails = checkUpDetailsArray.get(checkUpDetailsArray.size() - 1);
                    System.err.println("pstient latent checkupdetails from PEDIATRICS departmet: " + lastPatientCheckUpDetails);
                } else {
                    System.err.println("The ArrayList is empty.");
                }
               }
               System.err.println("PEDIATRICS //////////");
                break;
        }
    }

}
