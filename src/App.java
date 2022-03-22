public class App {

    public static void main(String[] args) {
        Command position = new Command("Position");
        Command.Input movePosition = position.new Input(); //Access for Inner Class from Command Class
        movePosition.moveInput();

    }

}

