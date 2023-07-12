package practicalExam.Doctor.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Predicate;

import practicalExam.Doctor.utils.Validator;
public final class DoctorList extends ArrayList<Doctor> {
    public DoctorList() {
        super();
    }
    public void addNewDoctor() {
        if (this.size() >= 100) {
            System.out.println("The list can only hold 100 doctors and is full.");
        }
        System.out.println("Add new doctor");
        System.out.println("--------------------------------");

        String newDoctorCode = null;
        String newDoctorName = null;
        String newDoctorSpec = null;
        int newDoctorAvai = 0;

        while (true) {
            newDoctorCode = Validator.getString("Enter doctor code (st. ID D01): ", "[dD][\\d]{2}");
            if (!this.isBookIDDuplicated(newDoctorCode)) {
                break;
            }
        }
        newDoctorName = Validator.getString("Enter doctor name: ");
        newDoctorSpec = Validator.getString("Enter doctor specialization: ");
        newDoctorAvai = Validator.getInt("Enter doctor availability: ", 1, Integer.MAX_VALUE);

        this.add(new Doctor(newDoctorCode,newDoctorName,newDoctorSpec,newDoctorAvai));
    }
    private boolean isBookIDDuplicated(String code) {
        code = code.trim().toUpperCase();

        for (Doctor doctor : this) {
            if (doctor.getCode().equalsIgnoreCase(code)) {
                return true;
            }
        }
        return false;
    }
    public ArrayList<Doctor> searchDoctor(Predicate<Doctor> predicate) {
        ArrayList<Doctor> list = new ArrayList<>();
        for (Doctor doctor : this) {
            if (predicate.test(doctor)) {
                list.add(doctor);
            }
        }
        if (list.isEmpty()) {
            System.err.println("Can not not found.");
        }

        return list;
    }
    public void listAllDoctor() {
        this.listAllDoctor(this);
    }
    public void listAllDoctor(ArrayList<Doctor> list) {
        int total = list.size();
        if (total <= 0) {
            System.err.println("Sorry. Nothing to print.");
            return;
        }

        Collections.sort(list);
        System.out.println("List all doctor");
        System.out.println("--------------------------------");

        for (var doctor : list) {
            System.out.println(doctor);
        }
        System.out.println("--------------------------------");
        System.out.println("Total: " + total + " doctor.");
    }
    public int searchID(String code) {
        for (Doctor doctor : this) {
            if (doctor.getCode().equals(code)) {
                return this.indexOf(doctor);
            }
        }
        return -1;
    }
    public void updateDoctor() {
        System.out.println("------UPDATE DOCTOR------");
        if (this.isEmpty()) {
            System.out.println("No Student");
            return;
        }
        String code = Validator.getString("Enter doctor code (st. ID D00): ", "[dD][\\d]{2}");
        int index = searchID(code);
        if (index == -1) {
            System.out.println("Code not found");
            return;
        }
        String name = Validator.getString("Enter Doctor Name: ");
        String specialization = Validator.getString("Enter Doctor specialization: ");
        int availability = Validator.getInt("Enter Doctor availability", 1, Integer.MAX_VALUE);
        this.get(index).setName(name);
        this.get(index).setSpecialization(specialization);
        this.get(index).setAvailability(availability);
        System.out.println("Update succesfully");
    }

    public void deleteDoctor() {
        System.out.println("------REMOVE DOCTOR------");
        if (this.isEmpty()) {
            System.out.println("No Student");
            return;
        }
        String code = Validator.getString("Enter doctor code (st. ID D00): ", "[dD][\\d]{2}");
        int index = searchID(code);
        for (Doctor doctor : this) {
            if (doctor.getCode().equals(code)) {
                this.indexOf(doctor);
            }
        }
        if (index == -1) {
            System.out.println("Code not found");
            return;
        }
        this.remove(index);
        System.out.println("Remove succesfully");
    }

}
