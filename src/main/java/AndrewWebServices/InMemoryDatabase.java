package AndrewWebServices;

import java.util.HashMap;
import java.util.Map;

public class InMemoryDatabase {
    private Map<String, String> userTable = new HashMap<>();

    public void addUser(String username, String password) {
        userTable.put(username, password);
    }

    public boolean authenticate(String username, String password) {
        return userTable.containsKey(username) && userTable.get(username).equals(password);
    }
}
