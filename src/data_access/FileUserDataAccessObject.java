package data_access;

import entity.User;
import entity.UserFactory;
import use_case.login.LoginUserDataAccessInterface;
import use_case.register.RegisterUserDataAccessInterface;

import java.io.*;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class FileUserDataAccessObject implements RegisterUserDataAccessInterface,
        LoginUserDataAccessInterface {

    private final File csvFile;

    private final Map<String, Integer> headers = new LinkedHashMap<>();

    private final Map<String, User> accounts = new HashMap<>();
    private final Map<Integer, User> accountsID = new HashMap<>();

    private UserFactory userFactory;

    public FileUserDataAccessObject(String csvPath, UserFactory userFactory) throws IOException {
        this.userFactory = userFactory;

        csvFile = new File(csvPath);
        headers.put("userID", 0);
        headers.put("username", 1);
        headers.put("password", 2);
        headers.put("location", 3);
        // Add creation time?
        headers.put("creation_time", 4);

        if (csvFile.length() == 0) {
            save();
        } else {

            try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
                String header = reader.readLine();

                //Add creation_time?
                assert header.equals("userID, username, password, location, creation_time");

                String row;
                while ((row = reader.readLine()) != null) {
                    String[] col = row.split(",");
                    int userID = Integer.parseInt(col[headers.get("userID")]);
                    String username = String.valueOf(col[headers.get("username")]);
                    String password = String.valueOf(col[headers.get("password")]);
                    String location = String.valueOf(col[headers.get("location")]);
                    String creationTimeText = String.valueOf(col[headers.get("creation_time")]);
                    LocalDateTime ldt = LocalDateTime.parse(creationTimeText);

                    User user = userFactory.create(userID, username, password, location, ldt);
                    accounts.put(username, user);
                    accountsID.put(userID, user);
                }
            }
        }
    }

    @Override
    public void save(User user) {
        accounts.put(user.getUsername(), user);
        this.save();
    }

    @Override
    public User get(String username) {
        return accounts.get(username);
    }

    private void save() {
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(csvFile));
            writer.write(String.join(",", headers.keySet()));
            writer.newLine();

            for (User user : accounts.values()) {
                String line = String.format("%s,%s,%s,%s,%s",
                        user.getUserID(), user.getUsername(),
                        user.getPassword(), user.getLocation(),
                        user.getCreationTime());
                        // add creation time?
                writer.write(line);
                writer.newLine();
            }

            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * Return whether a user exists with username identifier.
     * @param identifier the username to check.
     * @return whether a user exists with username identifier
     */
    @Override
    public boolean existsByName(String identifier) {
        return accounts.containsKey(identifier);
    }

    @Override
    public boolean existsByID(int identifier) {
        return accounts.containsValue(identifier);
    }

    /**
     * Return whether a userID exists with username identifier.
     * @param userID the userID to check.
     */
    @Override
    public boolean duplicatedID(int userID) {
        return accountsID.containsKey(userID);
    }
}
