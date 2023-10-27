import java.util.Dictionary;
import java.util.HashMap;

import AllFiles.*;

enum Departments{
    Orthopedics, Cardiology, Neurology, Pediatrics;
}
class MainFile{
    public static void main(String a[]){
        new Patient().patientCameToHospital();
    }
}