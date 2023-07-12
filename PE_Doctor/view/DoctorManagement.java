package practicalExam.Doctor.view;

import practicalExam.Doctor.model.DoctorList;
import practicalExam.Doctor.utils.Validator;

public final class DoctorManagement extends Menu<String>{
    private static String[] options = {
            "Add new doctor",
            "Update ",
            "Delete ",
            "Search doctor",
            "Sort list all doctor",
            "Exit"
    };
    private DoctorList doctorList;
    public DoctorManagement(){
    }

    public DoctorManagement(String title, String[] options, DoctorList doctorList) {
        super(title, options);
        this.doctorList = doctorList;
    }

    @Override
    public void execute(int choice) {
        switch (choice) {
            case 1 -> {
                try {
                    this.doctorList.addNewDoctor();
                } catch (Exception ex) {
                    System.err.println("A problem occured: " + ex);
                }
            }
            case 2 -> doctorList.updateDoctor();
            case 3 -> doctorList.deleteDoctor();
            case 4 -> this.search();
            case 5 -> this.doctorList.listAllDoctor();
            case 6 -> {
                this.stop();
            }
        }
    }
    private void search() {
        String[] searchOptions = {
                "Find by code",
                "Find by name",
                "Find by spec",
                "Find by avai",
                "Return"
        };
        new Menu<String>("Doctor Searching", searchOptions) {
            @Override
            public void execute(int choice) {
                switch (choice) {
                    case 1 -> {
                        String code = Validator.getString("Enter doctor code (st. ID B0000): ", "[docDOC][\\d]{4}");
                        doctorList.listAllDoctor(doctorList.searchDoctor(p -> p.getCode().equalsIgnoreCase(code)));
                    }

                    case 2 -> {
                        String name = Validator.getString("Enter Book Title: ");
                        doctorList.listAllDoctor(doctorList.searchDoctor(p -> p.getName().equalsIgnoreCase(name)));
                    }

                    case 3 -> {
                        String spec = Validator.getString("Enter Author: ");
                        doctorList.listAllDoctor(doctorList.searchDoctor(p->p.getSpecialization().equalsIgnoreCase(spec)));
                    }

                    case 4 -> {
                        int avai = Validator.getInt("Enter avai: ", 1900, Integer.MAX_VALUE);
                        doctorList.listAllDoctor(doctorList.searchDoctor(p -> p.getAvailability() == avai));

                    }
                    default -> {
                        this.stop();
                    }
                }
            }
        }.run();
    }
    public static void main(String[] args) {
        new DoctorManagement("Doctor Management", options, new DoctorList()).run();
    }
}
