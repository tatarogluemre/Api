package pojos;

public class DummyDataPojo {

//     "employee_name": "Ali Can",
//             "employee_salary": 111111,
//             "employee_age": 23,
//             "profile_image": "Perfect image"


    private String employee_name;
    private Integer employee_salary;
    private Integer employee_age;
    private String profil_image;

    public DummyDataPojo() {
    }

    public DummyDataPojo(String employee_name, Integer employee_salary, Integer employee_age, String profil_image) {
        this.employee_name = employee_name;
        this.employee_salary = employee_salary;
        this.employee_age = employee_age;
        this.profil_image = profil_image;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    public Integer getEmployee_salary() {
        return employee_salary;
    }

    public void setEmployee_salary(Integer employee_salary) {
        this.employee_salary = employee_salary;
    }

    public Integer getEmployee_age() {
        return employee_age;
    }

    public void setEmployee_age(Integer employee_age) {
        this.employee_age = employee_age;
    }

    public String getProfil_image() {
        return profil_image;
    }

    public void setProfil_image(String profil_image) {
        this.profil_image = profil_image;
    }

    @Override
    public String toString() {
        return "DummyDataPojo{" +
                "employee_name='" + employee_name + '\'' +
                ", employee_salary=" + employee_salary +
                ", employee_age=" + employee_age +
                ", profil_image='" + profil_image + '\'' +
                '}';
    }
}
