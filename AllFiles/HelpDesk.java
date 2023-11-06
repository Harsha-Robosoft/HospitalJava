package AllFiles;
import java.util.ArrayList;
import AllFiles.AllDepartments.*;
import AllFiles.AllEnums.*;

public class HelpDesk {
    
    private ArrayList<Patient> opdPatientList = new ArrayList<>();
    private ArrayList<Patient> non_OpdPatientList = new ArrayList<>();

    private int opdPatinetIdCount = 0;
    private int non_opdPatinetIdCount = 0;
    

    public void patientRegistation(){
        System.out.println(":- Patient registration started.");
        // Define values for the patient
        Patient opdPatient01 = new Patient("", "Harsha", 24, GenderTypes.Male, 1234567890, PatientAdmissionType.Opd, Departments.Cardiology);
        Patient opdPatient02 = new Patient("", "Vini", 24, GenderTypes.Male, 1234567800, PatientAdmissionType.Opd, Departments.Neurology);
        Patient opdPatient03 = new Patient("", "Chiru", 24, GenderTypes.Male, 1234567000, PatientAdmissionType.Opd, Departments.Orthopedics);
        Patient nonOpdPatient01 = new Patient("", "Jeegu", 24, GenderTypes.Male, 1234567890, PatientAdmissionType.Non_Opd, Departments.Neurology, 5, 5555, 123);
        Patient nonOpdPatient02 = new Patient("", "Prajju", 24, GenderTypes.Male, 1234567800, PatientAdmissionType.Non_Opd, Departments.Cardiology, 2, 2323, 1);
        
        savepatientDataToAccordingToThereAdmissionType(opdPatient01);
        savepatientDataToAccordingToThereAdmissionType(opdPatient02);
        savepatientDataToAccordingToThereAdmissionType(opdPatient03);
        savepatientDataToAccordingToThereAdmissionType(nonOpdPatient01);
        savepatientDataToAccordingToThereAdmissionType(nonOpdPatient02);

        if (opdPatientList.size() != 0){
            for (Patient patient : opdPatientList) {
                generateIDForPatient(patient);
                System.out.println("@@@@@@@@@");
                System.out.println(":- Patient registration completed and data stored.++++++++");
                System.out.println("");
                System.out.println(":- Sending patient to respective department.");
                sendPatientToRespectiveDepartment(patient, patient.getDepartmentToVisit());
            }
        }else{
            System.out.println("Opd patient list is empty");
        }
        
        if (non_OpdPatientList.size() != 0){
            for (Patient patient : non_OpdPatientList) {
                generateIDForPatient(patient);
                System.out.println(":- Patient registration completed and data stored.++++++++");
                System.out.println("");
                System.out.println(":- Sending patient to respective department.");
                sendPatientToRespectiveDepartment(patient, patient.getDepartmentToVisit());
            }
        }else{
            System.out.println("Non-Opd patient list is empty");
        }
        
    }

    private void savepatientDataToAccordingToThereAdmissionType(Patient patient){
        switch (patient.getAdmissionType()){
            case Opd:
                opdPatientList.add(patient);
            break;
            case Non_Opd:
                if (checkForRoom_BedAvelableForNonOpdPatient(patient.getNumberOfdayToStay())){
                    // Room_Bed is avilable and admit the patient and continue with process
                    non_OpdPatientList.add(patient);
                }else{
                    // Room_Bed is not avilable and handle the edge case
                    System.out.println("Sorry bro please come next day");
                }
            break;
        }
    }

    private boolean checkForRoom_BedAvelableForNonOpdPatient(int numberOfdaysRequestedBypatient){
        return numberOfdaysRequestedBypatient <= 5;
    }

    private void generateIDForPatient(Patient patint){
        switch (patint.getAdmissionType()) {
            case Opd:
            opdPatinetIdCount += 1;
            String idIs = "Opd_ID: " + opdPatinetIdCount;
            patint.setPatientID(idIs);
            break;
            case Non_Opd:
            non_opdPatinetIdCount += 1;
            String idIss = "Non_Opd_ID: " + non_opdPatinetIdCount;
            patint.setPatientID(idIss);
            break;
        }
    }
    
    private void sendPatientToRespectiveDepartment(Patient patientIs, Departments departmentToSend){
         switch (departmentToSend){
            case Cardiology:
                if (patientIs.getAdmissionType() == PatientAdmissionType.Opd){
                    cleanUpFuncOpd(patientIs);
                }else{
                    cleanUpFuncNonOpd(patientIs);
                }
                
            break;
            case Neurology:
                if (patientIs.getAdmissionType() == PatientAdmissionType.Opd){
                    cleanUpFuncOpd(patientIs);
                }else{
                    cleanUpFuncNonOpd(patientIs);
                }
            break;
            case Orthopedics:
                if (patientIs.getAdmissionType() == PatientAdmissionType.Opd){
                    cleanUpFuncOpd(patientIs);
                }else{
                    cleanUpFuncNonOpd(patientIs);
                }
            break;
            case Pediatrics:
                if (patientIs.getAdmissionType() == PatientAdmissionType.Opd){
                    cleanUpFuncOpd(patientIs);
                }else{
                    cleanUpFuncNonOpd(patientIs);
                }
            break;
        }
    }

    private void cleanUpFuncOpd(Patient patient){
        System.out.println(":- Sent patient to respective OPD department which is CARDIOLOGY and also sent the patient file.");
        Patient patientObj =  new CardiologyDep().startPatientCheckup(patient);
        System.out.println(":- Started the payment process.");
        completeThePaymentProcess(patient.getDepartmentToVisit(), patientObj);
    }

    private void cleanUpFuncNonOpd(Patient patient){
        System.out.println(":- Sent patient to respective NON_OPD department which is CARDIOLOGY and also sent the patient file.");
        Patient patientObj =  new CardiologyDep().startPatientCheckup(patient);
        System.out.println(":- Started the payment process.");
        // completeThePaymentProcess(patientIs.getDepartmentToVisit(), patientObj);
        if (checkForInsurenceStatues(patient.getPolicyNnumber())){
            // Insurance plicy is valid and proced with clam amount

            // this if starement is for getting the consult amount
            if (patientObj.getCheckUpDetails().containsKey(patientObj.getDepartmentToVisit())){
                ArrayList<PatientCheckUpDetails> checkUpDetailsArray = patientObj.getCheckUpDetails().get(patientObj.getDepartmentToVisit());
                if (!checkUpDetailsArray.isEmpty()) {
                    PatientCheckUpDetails lastPatientCheckUpDetails = checkUpDetailsArray.get(checkUpDetailsArray.size() - 1);
                    int extraTopay = howMuchExtraAmountNeedToPayByPatient(patientObj.getClamAmmount(), lastPatientCheckUpDetails.getConsultAmount());
                    if (extraTopay == 0 || extraTopay < patientObj.getClamAmmount()){
                        // Bill amount is covered in the insurence clam amount no need to pay extra and payment is completed
                        System.out.println(":- Complete amount is covered under insurence so chill brooo.");
                        completeThePaymentProcess(patientObj.getDepartmentToVisit(), patientObj);
                    }else{
                        // Need to pay extra ammount over insurance clam
                        System.out.println(":- Need to pay a littel extra on top of insurance.");
                        completeThePaymentProcess(patientObj.getDepartmentToVisit(), patientObj);
                    }
                }else{
                    // patient checkup details array is wmpath handle edge case
                }
            }else{
                // patient details dictionay does not has a key handel edge case
            }
        }else{
            // Insurance is not valid handle edge case here
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
                System.out.println("***********************");
            } else {
                System.out.println(":- payment not completed.");
                System.err.println(":- The ArrayList is empty.");
            }
        }
    }

    private boolean checkForInsurenceStatues(int forPolicy){
        return true;
    }

    private int howMuchExtraAmountNeedToPayByPatient(int clamAmmount, int totalBill){
        if (clamAmmount <= totalBill){
            return 0;
        }else{
            return totalBill - clamAmmount;
        }
    }

}
