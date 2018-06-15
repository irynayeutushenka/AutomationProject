package business_objects;

public enum TestClients {

    CLIENT_5003(5003, "testclientclone3", "Test Client Clone 3"),
    CLIENT_5012(5012, "testclient5012", "Test Client Happy"),
    CLIENT_5021(5021, "testclient5021", "Test Client AT Nominator");

    private final int id;
    private final String name;
    private final String configAppName;

    TestClients(int id, String name, String configAppName) {
        this.id = id;
        this.name = name;
        this.configAppName = configAppName;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getConfigAppName() {
        return configAppName;
    }
}
