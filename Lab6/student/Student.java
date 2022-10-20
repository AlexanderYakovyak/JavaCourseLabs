package student;
public class Student {
    int id;
    String name;
    String surname;
    String patronymic;
    String birth_date;
    String address;
    String phone_number;
    String faculty;
    String year;
    String group;

    Student(int id, String name, String surname, String patronymic, String birth_date,
            String address, String phone_number, String faculty, String year, String group){

        this.id = id;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.birth_date = birth_date;
        this.address = address;
        this.phone_number = phone_number;
        this.faculty = faculty;
        this.year = year;
        this.group = group;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(String birth_date) {
        this.birth_date = birth_date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", birth_date='" + birth_date + '\'' +
                ", address='" + address + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", faculty='" + faculty + '\'' +
                ", year='" + year + '\'' +
                ", group='" + group + '\'' +
                '}';
    }

    public static Student[] toList(int n, Student ... students){
        Student[] array = new Student[n];
        for(int i=0; i<n; ++i){
            array[i] = students[i];
        }

        return array;
    }

}
