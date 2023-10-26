package AllFiles;


enum GenderTypes{
    Male,Female,Other;
}

enum PatientAdmissionType{
    Opd,Non_Opd;
}

enum Departments{
    Orthipedics, Cardiology, Neurology, Pediatrics;
}

public class Patient {


    private String fullName;
    private String firstName;
    private String lastName;
    private int age;
    private GenderTypes gender;
    private int contectNumber;
    private PatientAdmissionType admissionType;
    private Departments doctor_departmentToVisit = null; 


    public Patient(){

    }
    
    public Patient(String firstName,String lastName,int age,GenderTypes gender, int contactNum,PatientAdmissionType admissionType){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.contectNumber = contactNum;
        this.admissionType = admissionType;
        this.fullName = firstName + " " + lastName;
    }

    public String toString() {
        return "Patient data: " + firstName + " " + lastName + ", " + age + " " + gender + " " + contectNumber + " " + admissionType ;
    }

    public void patientCameToHospital(){
        System.out.println("Patient Came to hospital.===========");
        new Hospital().contactHelpDeskForPatientRegistration();
    }
    

}


class Non_OpdPatient extends Patient{
    private PatientInsuranceDetail insurencDetail;
    private int numberOfdayToStay;
    private PatientInsuranceDetail insuranceDetail;
    public Non_OpdPatient(String firstName, String lastName, int age, GenderTypes gender, int contactNum,
            PatientAdmissionType admissionType, PatientInsuranceDetail insuranceDetail, int numberOfdayToStay) {
        super(firstName, lastName, age, gender, contactNum, admissionType);
        this.insurencDetail = insuranceDetail;
        this.numberOfdayToStay = numberOfdayToStay;
    }
}

class PatientInsuranceDetail{
    private int insurancePolicyNnumber;
    private int clamAmmount;
}