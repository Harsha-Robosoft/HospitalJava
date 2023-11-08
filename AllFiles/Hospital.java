package AllFiles;

public class Hospital {
    

    public void contactHelpDeskForPatientRegistration(){
        System.out.println(":- Patient came to hospital and Contacted the helpdesk for registration.");
        new HelpDesk().patientRegistation();
    }
}
