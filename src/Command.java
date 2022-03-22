import java.util.Scanner;

public class Command {
    int[] position = new int[2];

    Command(String info) {
        System.out.println("Mars Rover APP");
        System.out.println("1. First, input your Position");
        System.out.println("1. Then Insert Command Separately " + "(F, " + "B, " + "L, " + "R)");
        System.out.println("2. X for exit");

        Scanner scanner = new Scanner(System.in);
        System.out.print(info + " x: ");
        int dataX = scanner.nextInt();


        System.out.print(info + " y: ");
        int dataY = scanner.nextInt();

        this.position[0] = dataX;
        this.position[1] = dataY;
        Input input = new Input().logicCompass(dataX, dataY);
    }


    public class Input {
        Scanner scanner = new Scanner(System.in);

        public String getInput(String info) {
            System.out.print(info + ": ");
            return scanner.nextLine();
        }

        public void moveInput() {

            label:
            while (true) {
                var input = getInput("Command");
                switch (input) {
                    case "R": {
                        var x = position[0] += 1;
                        var y = position[1];
                        logicCompass(x, y);
                        break;
                    }
                    case "L": {
                        var x = position[0] -= 1;
                        var y = position[1];
                        logicCompass(x, y);
                        break;
                    }
                    case "B": {
                        var x = position[0];
                        var y = position[1] -= 1;
                        logicCompass(x, y);
                        break;
                    }
                    case "F": {
                        var x = position[0];
                        var y = position[1] += 1;
                        logicCompass(x, y);
                        break;
                    }
                    case "X":
                        System.out.println("Exiting App...");
                        break label;
                    default:
                        System.out.println("Please insert command properly!!");
                        break;
                }
            }
        }

        public Input logicCompass(int x, int y) {
            System.out.println("Positon: " + x + "," + y);
            if ((x == 0) && (y > 0)) {
                System.out.println("North");
            }
            if ((x == 0) && (y < 0)) {
                System.out.println("South");
            }
            if ((x < 0) && (y != 0)) {
                System.out.println("West");
            }
            if ((x > 0) && (y != 0)) {
                System.out.println("East");
            }
            if (y == 0) {
                if (x > 0) {
                    System.out.println("East");
                }
                if (x < 0) {
                    System.out.println("West");
                }
                if (x == 0) {
                    System.out.println("Neutral");
                }
            }
            return null;
        }
    }
}
