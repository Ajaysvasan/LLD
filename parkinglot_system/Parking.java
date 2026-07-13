public class Parking {
    // Bike or Car
    String vechiletype;
    int cap;
    boolean isFull;
    int floorNumber;
    boolean avaliableSlots[];
    Vechicles slots[];
    static int feePerHour = 30;

    public Parking(String section, int cap, int floorNumber) {
        this.vechiletype = section;
        this.cap = cap;
        this.isFull = false;
        this.floorNumber = floorNumber;
        this.avaliableSlots = new boolean[this.cap];
        this.slots = new Vechicles[this.cap];
    }

    private int convertTime(String t) {
        // hh : mm : ss
        // 01 : 34 : 56
        int hours = Integer.parseInt(t.substring(0, 1));
        int mins = Integer.parseInt(t.substring(3, 4));
        int seconds = Integer.parseInt(t.substring(5, 6));
        return hours * 3600 + mins * 60 + seconds;
    }

    private int getVechicleSlot(String vechicleNumer) {
        for (int i = 0; i < this.cap; i++) {
            if (vechicleNumer.equals(slots[i].getRegisterNumber())) {
                return i;
            }
        }
        return -1;
    }

    private int getAvaliableParkingSlot() {
        for (int i = 0; i < this.cap; i++) {
            if (avaliableSlots[i]) {
                return i;
            }
        }
        return -1;
    }

    public boolean park(Vechicles vechicle) {
        if (vechicle.getVechileType() == this.vechiletype) {
            return false;
        }
        int parkingSlot = getAvaliableParkingSlot();
        if (parkingSlot == -1) {
            this.isFull = true;
            return false;
        }
        avaliableSlots[parkingSlot] = true;
        return true;
    }

    public double leave(String vechicleNumer, String leavingTime) {
        int vechicleSlotNumber = getVechicleSlot(vechicleNumer);
        if (vechicleSlotNumber == -1) {
            return -1.0;
        }
        Vechicles vechicle = slots[vechicleSlotNumber];
        int spentTime = convertTime(leavingTime) - convertTime(vechicle.getEntryTime());
        double fee = spentTime * (30 / 3600);
        avaliableSlots[vechicleSlotNumber] = true;
        return fee;
    }

}
