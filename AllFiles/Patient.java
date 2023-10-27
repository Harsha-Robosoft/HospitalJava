package AllFiles;

import java.util.HashMap;

enum GenderTypes{
    Male,Female,Other;
}

enum PatientAdmissionType{
    Opd,Non_Opd;
}

enum Departments{
    Orthopedics, Cardiology, Neurology, Pediatrics;
}

public class Patient {

    private String patientID;
    private String fullName;
    private int age;
    private GenderTypes gender;
    private int contectNumber;
    private PatientAdmissionType admissionType;
    private Departments departmentToVisit; 
    private int numberOfdayToStay;
    private int policyNnumber;
    private int clamAmmount;
    private HashMap<String, PatientCheckUpDetails[]> checkUpDetails = new HashMap<>();


    public HashMap<String, PatientCheckUpDetails[]> getCheckUpDetails() {
        return checkUpDetails;
    }
    public void setCheckUpDetails(HashMap<String, PatientCheckUpDetails[]> checkUpDetails) {
        this.checkUpDetails = checkUpDetails;
    }

    
    public String getPatientID() {return patientID; }
    public String getFullName() {return fullName;}
    public int getAge() {return age;}
    public GenderTypes getGender() {return gender;}
    public int getContectNumber() {return contectNumber;}
    public PatientAdmissionType getAdmissionType() {return admissionType;}
    public Departments getDepartmentToVisit() {return departmentToVisit;}
    public int getNumberOfdayToStay() {return numberOfdayToStay;}
    public int getPolicyNnumber() {return policyNnumber;}
    public int getClamAmmount() {return clamAmmount;}


    public Patient(){

    }
    
    public Patient(String patientId,String name,int age,GenderTypes gender, int contactNum,PatientAdmissionType admissionType,Departments departmentToVisit){
        this.patientID = patientId;
        this.fullName = name;
        this.age = age;
        this.gender = gender;
        this.contectNumber = contactNum;
        this.admissionType = admissionType;
        this.departmentToVisit = departmentToVisit;
    }

    public Patient(String patientId,String name,int age,GenderTypes gender, int contactNum,PatientAdmissionType admissionType,Departments departmentToVisit, int numberOfDaysToStay, int policyNum, int clamAmount){
        this.patientID = patientId;
        this.fullName = name;
        this.age = age;
        this.gender = gender;
        this.contectNumber = contactNum;
        this.admissionType = admissionType;
        this.departmentToVisit = departmentToVisit;
        this.numberOfdayToStay = numberOfDaysToStay;
        this.policyNnumber = policyNum;
        this.clamAmmount = clamAmount;
    }

    public void patientCameToHospital(){
        System.out.println("Patient Came to hospital.===========");
        new Hospital().contactHelpDeskForPatientRegistration();
    }

}


class PatientCheckUpDetails{
    private Patient patientDetails = null;
    private Departments departmentVisited;
    private String prescription;
    private int consultAmount;
    private boolean paidConsultingAmmount = false;

    public PatientCheckUpDetails(){

    }

    public PatientCheckUpDetails(Departments departmentVisited, String prescription, int consultAmount){
        this.departmentVisited = departmentVisited;
        this.prescription = prescription;
        this.consultAmount = consultAmount;
    }

    public Departments getDepartmentVisited() {return departmentVisited;}
    public String getPrescription() {return prescription;}
    public int getConsultAmount() {return consultAmount;}
    public boolean isPaidConsultingAmmount() {return paidConsultingAmmount;}
    public void setPaidConsultingAmmount(boolean paidConsultingAmmount) {this.paidConsultingAmmount = paidConsultingAmmount;}
    
    

}