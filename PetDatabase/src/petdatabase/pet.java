
package petdatabase;

/**
 *
 * @author Abdisalan
 */
public class pet {
    int ID;
    String name;
    int age;

    public pet() {
    }

    public pet(int ID, String name, int age) {
        this.ID = ID;
        this.name = name;
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
    
}
