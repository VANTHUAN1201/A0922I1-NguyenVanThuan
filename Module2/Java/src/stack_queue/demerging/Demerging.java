package stack_queue.demerging;

public class Demerging {
    private String name;
    private boolean gender;
    private String date;
    public Demerging() {
    }
    public Demerging(String name, boolean gender, String date) {
        this.name = name;
        this.gender = gender;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Demerging{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                ", date='" + date + '\'' +
                '}';
    }
}
