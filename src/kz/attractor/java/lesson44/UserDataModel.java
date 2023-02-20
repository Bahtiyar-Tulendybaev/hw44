package kz.attractor.java.lesson44;

import java.util.ArrayList;
import java.util.List;

public class UserDataModel {
    private User user = new User("Apache", "FreeMarker");
    private List<User> customers = new ArrayList<>();


    public UserDataModel() {
        customers.add(new User("John Doe","Celestial Bodies","1 раз"));
        customers.add(new User("Alex Jackson", "The Overstory","3 раз"));
        customers.add(new User("James Jack", "Cheque book","2 раз"));
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    public List<User> getCustomers() {
        return customers;
    }

    public void setCustomers(List<User> customers) {
        this.customers = customers;
    }

    public static class User {
        private String name;
        private String tookRead;
        private String alreadyTook;

        public User(String name) {
            this.name = name;
        }

        public User(String name, String tookRead) {
            this.name = name;
            this.tookRead = tookRead;
        }

        public User(String name, String tookRead, String alreadyTook) {
            this.name = name;
            this.tookRead = tookRead;
            this.alreadyTook = alreadyTook;
        }
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getTookRead() {
            return tookRead;
        }

        public void setTookRead(String tookRead) {
            this.tookRead = tookRead;
        }

        public String getAlreadyTook() {
            return alreadyTook;
        }

        public void setAlreadyTook(String alreadyTook) {
            this.alreadyTook = alreadyTook;
        }
    }

}