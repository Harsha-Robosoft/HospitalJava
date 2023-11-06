package AllFiles.AllDepartments;
import java.util.ArrayList;
import java.util.HashMap;

import AllFiles.Patient;
import AllFiles.PatientCheckUpDetails;
import AllFiles.AllEnums.*;

public class OrthopedicDep {
    
    public Patient startPatientCheckup(Patient patientIs){
        if (patientIs.getAdmissionType() == PatientAdmissionType.Opd){
            System.out.println(patientIs.getAdmissionType());
            String prescription = "all is well OrthopedicDep";
            int consultAmount = 100;
            PatientCheckUpDetails detailsIs = new PatientCheckUpDetails(patientIs.getDepartmentToVisit(), prescription, consultAmount);
            HashMap<Departments, ArrayList<PatientCheckUpDetails>> dataa = new HashMap<>();
            ArrayList<PatientCheckUpDetails> testArray = new ArrayList<>();
            testArray.add(detailsIs);
            dataa.put(patientIs.getDepartmentToVisit(), testArray);
            patientIs.setCheckUpDetails(dataa);
            return patientIs;
        }else{
            System.out.println(patientIs.getAdmissionType());
            String prescription = "all is well Non_Opd OrthopedicDep";
            int consultAmount = 100;
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
