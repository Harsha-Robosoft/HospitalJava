package AllFiles.AllDepartments;
import java.util.ArrayList;
import java.util.HashMap;

import AllFiles.Patient;
import AllFiles.PatientCheckUpDetails;

// enum Departments{
//     Orthopedics, Cardiology, Neurology, Pediatrics;
// }

public class CardiologyDep {

    public Patient startPatientCheckup(Patient patientIs) {
        System.out.println("hi01");
        System.out.println(patientIs.getAdmissionType());
        String prescription = "all is well";
        int consultAmount = 100;
        PatientCheckUpDetails detailsIs = new PatientCheckUpDetails(patientIs.getDepartmentToVisit(), prescription, consultAmount);
        HashMap<Departments, ArrayList<PatientCheckUpDetails>> dataa = new HashMap<>();
        ArrayList<PatientCheckUpDetails> testArray = new ArrayList<>();
        testArray.add(detailsIs);
        dataa.put(patientIs.getDepartmentToVisit(), testArray);

        patientIs.setCheckUpDetails(dataa);

        return patientIs; // Return the patientIs object
    }

}
