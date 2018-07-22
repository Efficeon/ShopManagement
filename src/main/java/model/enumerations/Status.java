package model.enumerations;

public enum Status {
    AVALIABLE("Available"),
    ABCENT("Absent"),
    EXPECTED("Expected");

    protected String status;

    Status(String status) {
        this.status = status;
    }

    public static Status fromString(String name) {
        for (Status condition : Status.values()) {
            if (condition.status.equalsIgnoreCase(name)) return condition;
        }
        return AVALIABLE;
    }

    public String toString() {
        return status;
    }

}
