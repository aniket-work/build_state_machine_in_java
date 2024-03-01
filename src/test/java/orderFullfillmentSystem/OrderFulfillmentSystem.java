package orderFullfillmentSystem;

import java.util.Scanner;

public class OrderFulfillmentSystem {

    private OrderFulfillmentState currentState;

    public static void main(String[] args) {
        new OrderFulfillmentSystem().run();
    }

    private void run() {
        currentState = OrderFulfillmentState.IDLE;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Order Fulfillment System is idle.");

        while (true) {
            System.out.println("+--------------------------------------------+");
            System.out.println("| Enter your action:                          |");
            System.out.println("+--------------------------------------------+");
            System.out.println("| Action                      | Shortcut     |");
            System.out.println("+------------------------------+-------------+");
            System.out.println("| Place Order                  | [p]         |");
            System.out.println("| Order Processed              | [o]         |");
            System.out.println("| Order Packed                 | [a]         |");
            System.out.println("| Cancel Order                 | [c]         |");
            System.out.println("| Order Shipped                | [s]         |");
            System.out.println("| Revert to Previous State     | [r]         |");
            System.out.println("| Quit                         | [q]         |");
            System.out.println("+------------------------------+-------------+");
            System.out.println("Current State: " + currentState);

            String input = scanner.nextLine().trim();

            switch (input.toLowerCase()) {
                case "p":
                    handleEvent(OrderFulfillmentEvent.ORDER_PLACED);
                    break;
                case "o":
                    handleEvent(OrderFulfillmentEvent.ORDER_PROCESSED);
                    break;
                case "a":
                    handleEvent(OrderFulfillmentEvent.ORDER_PACKED);
                    break;
                case "c", "r":
                    revertToPreviousState();
                    break;
                case "s":
                    handleEvent(OrderFulfillmentEvent.ORDER_SHIPPED);
                    break;
                case "q":
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid input. Please try again.");
                    break;
            }
        }
    }



    private void handleEvent(OrderFulfillmentEvent event) {
        switch (currentState) {
            case IDLE:
                if (event == OrderFulfillmentEvent.ORDER_PLACED) {
                    currentState = OrderFulfillmentState.PROCESSING;
                    System.out.println("Order placed. Current State: PROCESSING");
                }
                break;
            case PROCESSING:
                if (event == OrderFulfillmentEvent.ORDER_PROCESSED) {
                    currentState = OrderFulfillmentState.PACKING;
                    System.out.println("Order processed. Current State: PACKING");
                } else if (event == OrderFulfillmentEvent.ORDER_CANCELLED) {
                    currentState = OrderFulfillmentState.IDLE;
                    System.out.println("Order cancelled. Current State: IDLE");
                }
                break;
            case PACKING:
                if (event == OrderFulfillmentEvent.ORDER_PACKED) {
                    currentState = OrderFulfillmentState.SHIPPING;
                    System.out.println("Order packed. Current State: SHIPPING");
                }
                break;
            case SHIPPING:
                if (event == OrderFulfillmentEvent.ORDER_SHIPPED) {
                    currentState = OrderFulfillmentState.COMPLETED;
                    System.out.println("Order shipped. Current State: COMPLETED");
                }
                break;
            default:
                System.out.println("Invalid state.");
                break;
        }
    }

    private void revertToPreviousState() {
        switch (currentState) {
            case PROCESSING:
            case PACKING:
            case SHIPPING:
                currentState = OrderFulfillmentState.IDLE;
                System.out.println("Reverted to previous state: IDLE");
                break;
            default:
                System.out.println("Cannot revert from current state.");
                break;
        }
    }
}
