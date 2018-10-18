package lms;

abstract class User {
    String username;
    String password;
    String Name;
    String Gender;
    int Age;

    public User(String username, String password, String Name, String Gender, int Age) {
        this.username = username;
        this.password = password;
        this.Name = Name;
        this.Gender = Gender;
        this.Age = Age;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public void setAge(int Age) {
        this.Age = Age;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return Name;
    }

    public String getGender() {
        return Gender;
    }

    public int getAge() {
        return Age;
    }
    
}
