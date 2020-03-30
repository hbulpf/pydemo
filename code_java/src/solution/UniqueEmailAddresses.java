package solution;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddresses {

    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String email : emails) {
            set.add(make(email));
        }
        return set.size();
    }

    private String make(String email) {
        int index = email.indexOf("@");
        String host = email.substring(index + 1);
        String name = email.substring(0, index);
        int index2 = name.indexOf("+");
        if (index2 >= 0) {
            name = name.substring(0, index2);
        }
        name = name.replaceAll(".", "");
        return name + "@" + host;
    }
}
