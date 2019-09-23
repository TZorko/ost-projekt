package si.tz.feri.ost.model;

public class Test {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;


    public Test(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Testing - " + name;
    }
}
