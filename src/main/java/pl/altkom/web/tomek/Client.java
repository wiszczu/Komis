package pl.altkom.web.tomek;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

public class Client {
    private String name;
    private String surname;
    private int age;
    private String region;
    private String gender;

    public Client() {

    }

//    public Client(HttpServletRequest request) {
//        this.name = request.getParameter("name");
//        this.surname = request.getParameter("surname");
//        this.age = request.getParameter("age");
//        this.region = request.getParameter("region");
//        this.gender = request.getParameter("gender");
//    }

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
