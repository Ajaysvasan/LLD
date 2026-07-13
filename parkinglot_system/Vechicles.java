public class Vechicles {
    String vechicleType;
    String vechicleNumber;
    String entryTime;

    public Vechicles(String vechicleType, String vechicleNumber, String entryTime) {
        this.vechicleType = vechicleType;
        this.vechicleNumber = vechicleNumber;
        this.entryTime = entryTime;
    }

    public String getRegisterNumber() {
        return this.vechicleNumber;
    }

    public String getVechileType() {
        return this.vechicleType;
    }

    public String getEntryTime() {
        return this.entryTime;
    }
}
