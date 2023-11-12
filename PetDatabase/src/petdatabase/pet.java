
package petdatabase;

/**
 *
 * @author Abdisalan
 */
public class pet implements Serializable {
    int ID;
    String petName;
    int age;

    public pet() {
    }

    public pet(String petName, int age) {
        this.petName = petName;
        this.age = age;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }
    
}
