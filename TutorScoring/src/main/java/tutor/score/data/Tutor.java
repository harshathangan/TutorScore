package tutor.score.data;

public class Tutor {

    private String tutorId;
    private String name;
    private String email;

    public Tutor(String tutorId, String name, String email) {
        this.tutorId = tutorId;
        this.name = name;
        this.email = email;
    }

    public String getTutorId() {
        return tutorId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
