package AllFiles.AllDepartments;
import java.util.ArrayList;
import java.util.HashMap;

import AllFiles.Patient;
import AllFiles.PatientCheckUpDetails;
import AllFiles.AllEnums.Departments;
import AllFiles.AllEnums.PatientAdmissionType;


public class CardiologyDep {

    public Patient startPatientCheckup(Patient patientIs) {
        if (patientIs.getAdmissionType() == PatientAdmissionType.Opd){
            String prescription = "all is well CardiologyDep";
            int consultAmount = 100;
            PatientCheckUpDetails detailsIs = new PatientCheckUpDetails(patientIs.getDepartmentToVisit(), prescription, consultAmount);
            HashMap<Departments, ArrayList<PatientCheckUpDetails>> dataa = new HashMap<>();
            ArrayList<PatientCheckUpDetails> testArray = new ArrayList<>();
            testArray.add(detailsIs);
            dataa.put(patientIs.getDepartmentToVisit(), testArray);
            patientIs.setCheckUpDetails(dataa);
            return patientIs;   
        }else{
            String prescription = "all is well Non_Opd CardiologyDep";
            int consultAmount = 0;
            PatientCheckUpDetails detailsIs = new PatientCheckUpDetails(patientIs.getDepartmentToVisit(), prescription, consultAmount);
            HashMap<Departments, ArrayList<PatientCheckUpDetails>> dataa = new HashMap<>();
            ArrayList<PatientCheckUpDetails> testArray = new ArrayList<>();
            testArray.add(detailsIs);
            dataa.put(patientIs.getDepartmentToVisit(), testArray);
            patientIs.setCheckUpDetails(dataa);
            return patientIs;
        }
        
    }

}
