package practicalExam.Doctor.model;

public final class Doctor implements Comparable<Doctor> {
    protected String code;
    protected String name;
    protected String specialization;
    protected int availability;

    public Doctor() {
        this.code = this.name = this.specialization  = "";
        this.availability = 0;
    }

    public Doctor(String code, String name, String specialization, int availability) {
            this.setCode(code);
            this.setName(name);
            this.setSpecialization(specialization);
            this.setAvailability(availability);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        if (code != null && !code.isEmpty() && !code.isBlank()) {
            this.code = code.replaceAll("\\s+", " ").trim().toUpperCase();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && !name.isEmpty() && !name.isBlank()) {
            this.name = name.replaceAll("\\s+", " ").trim();
        }
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        if (specialization != null && !specialization.isEmpty() && !specialization.isBlank()) {
            this.specialization = specialization.replaceAll("\\s+", " ").trim();
        };
    }

    public int getAvailability() {
        return availability;
    }

    public void setAvailability(int availability) {
            this.availability = availability;
    }

    @Override
    public String toString() {
        return "Doctor{"+ this.code + " - " + this.name + " - " + this.specialization + " - " + this.availability + "}";
    }
    @Override
    public int compareTo(Doctor o) {
        return 0;
    }
}
