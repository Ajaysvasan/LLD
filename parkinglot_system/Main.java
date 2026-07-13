import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfFloors = sc.nextInt();
        int capacityForBikeSection = sc.nextInt();
        int capacityForCarSection = sc.nextInt();
        int numberOfCarSection = sc.nextInt();
        if (numberOfCarSection > numberOfFloors) {
            System.out.println("Invalid number of car sections");
            sc.close();
            return;
        }
        int numberOfBikeSection = sc.nextInt();

        if (numberOfBikeSection + numberOfCarSection > numberOfFloors) {
            System.out.println("Invalid number of bike sections");

            sc.close();
            return;
        }
        int i = 0, j = 1;
        // i -> i + 1 , j -> 2n + 1
        Parking parkingFloors[] = new Parking[numberOfFloors];
        while (i < numberOfCarSection && j < numberOfBikeSection) {
            Parking bikeParking = new Parking("Bike", capacityForBikeSection, i + 1);
            parkingFloors[i] = bikeParking;
            Parking carParking = new Parking("Car", capacityForCarSection, j + 1);
            parkingFloors[j] = carParking;
            i++;
            j = 2 * j + 1;
        }
        while (i < numberOfBikeSection) {
            Parking bikeParking = new Parking("Bike", capacityForBikeSection, i + 1);
            parkingFloors[i] = bikeParking;
            i++;
        }
        while (j < numberOfCarSection) {
            Parking carParking = new Parking("Car", capacityForCarSection, j + 1);
            parkingFloors[j] = carParking;
            j++;
        }
        // 1 for run
        int choice = 1;
        boolean avaliableFloorsForParking[] = new boolean[numberOfFloors];
        Arrays.fill(avaliableFloorsForParking, true);
        while (choice != 0) {
            String vechicleType = sc.nextLine();
            sc.next();
            String vechicleNumber = sc.nextLine();
            sc.next();
            int isVechicleEntering = sc.nextInt();
            if (isVechicleEntering == 1) {
                String entryTime = sc.nextLine();
                Vechicles vechicle = new Vechicles(vechicleType, vechicleNumber, entryTime);
                for (i = 0; i < numberOfFloors; i++) {
                    Parking floor = parkingFloors[i];
                    if (!floor.park(vechicle)) {
                        avaliableFloorsForParking[i] = false;
                    }
                }
            } else {
                String leavingTime = sc.nextLine();
                double fee;
                for (i = 0; i < numberOfFloors; i++) {
                    Parking floor = parkingFloors[i];
                    fee = floor.leave(vechicleNumber, leavingTime);
                    if (fee != -1.0) {
                        System.out.println("The Fee is : " + fee);
                    }
                }
            }
            sc.next();
            choice = sc.nextInt();
        }
        sc.close();
    }
}
