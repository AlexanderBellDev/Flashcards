import java.util.Arrays;

class Employee {
    protected String name;
    protected String email;
    protected int experience;

    public Employee(String name, String email, int experience) {
        this.name = name;
        this.email = email;
        this.experience = experience;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getExperience() {
        return experience;
    }

    // write fields

    // write constructor

    // write getters
}

class Developer extends Employee {
    String mainLanguage;
    String[] skills;
    // write fields

    public Developer(String name, String email, int experience, String mainLanguage, String[] skills) {
        super(name, email, experience);
        this.mainLanguage = mainLanguage;
        this.skills = skills;
    }

    public String getMainLanguage() {
        return mainLanguage;
    }

    public String[] getSkills() {
        return skills;
    }


    // write constructor

    // write getters
}

class DataAnalyst extends Employee {
    boolean phd;
    String[] methods;

    public DataAnalyst(String name, String email, int experience, boolean phd, String[] methods) {
        super(name, email, experience);
        this.phd = phd;
        if (methods == null) {
            this.methods = new String[0];
        } else {
            this.methods = Arrays.copyOf(methods, methods.length);
        }
    }

    public boolean isPhd() {
        return phd;
    }

    public String[] getMethods() {
        return methods;
    }

    // write fields

    // write constructor

    // write getters
}