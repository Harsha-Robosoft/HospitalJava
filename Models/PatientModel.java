package Models;
public class PatientModel {

    public enum GenderTypes{
        Male,Female,Other;
    }

    public enum PatientAdmissionType{
        Opd,Non_Opd;
    }

    private String fullName;
    private String firstName;
    private String lastName;
    private int age;
    private GenderTypes gender;
    private int contectNumber;
    private PatientAdmissionType admissionType;
    
    public PatientModel(String firstName,String lastName,int age,GenderTypes gender, int contactNum,PatientAdmissionType admissionType){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.contectNumber = contactNum;
        this.admissionType = admissionType;
    }

}

class Non_OpdPatientDetail extends PatientModel{
    private PatientInsuranceDetail insurencDetail;
    private int numberOfdayToStay;
    private PatientInsuranceDetail insuranceDetail;
    public Non_OpdPatientDetail(String firstName, String lastName, int age, GenderTypes gender, int contactNum,
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
