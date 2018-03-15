public class Phone {
    private String number;
    private String name;

    public String getNumber() {
        return number;
    }

    public void setNumber(String num) {
        number = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String n) {
        name = n;
    }

    public String toString() {
        return
                name + '\'' + "   " + number + '\'';
    }
}
