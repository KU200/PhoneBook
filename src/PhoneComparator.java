import java.util.Comparator;

class PhoneComparator implements Comparator<Phone>{
    @Override
    public int compare(Phone o1, Phone o2) {
        return o1.getName().compareTo(o2.getName());
    }
}