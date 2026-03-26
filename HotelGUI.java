import javax.swing.*;

class Hotel {

    // Room availability
    static int luxuryDouble = 10;
    static int deluxeDouble = 20;
    static int luxurySingle = 10;
    static int deluxeSingle = 20;

    // Food prices
    static final int SANDWICH = 50;
    static final int PASTA = 60;
    static final int NOODLES = 70;
    static final int COKE = 30;

    // ROOM AVAILABILITY
    static void availability(int type){

        String msg;

        switch(type){
            case 1 -> msg = "Luxury Double Rooms Available : " + luxuryDouble;
            case 2 -> msg = "Deluxe Double Rooms Available : " + deluxeDouble;
            case 3 -> msg = "Luxury Single Rooms Available : " + luxurySingle;
            case 4 -> msg = "Deluxe Single Rooms Available : " + deluxeSingle;
            default -> msg = "Invalid Room Type";
        }

        JOptionPane.showMessageDialog(
                null,
                msg,
                "Room Availability",
                JOptionPane.INFORMATION_MESSAGE
        );
    }


    // ROOM BOOKING
    static void bookroom(int type){

        try {

            if(!isRoomAvailable(type)){
                JOptionPane.showMessageDialog(
                        null,
                        "No rooms available for this category",
                        "Booking Failed",
                        JOptionPane.WARNING_MESSAGE
                );
                return;
            }

            String name = JOptionPane.showInputDialog("Enter Customer Name");
            String contact = JOptionPane.showInputDialog("Enter Contact Number");

            int room = Integer.parseInt(
                    JOptionPane.showInputDialog("Enter Room Number")
            );

            decreaseRoom(type);

            JOptionPane.showMessageDialog(
                    null,
                    "Room Booked Successfully\n\n"
                            + "Customer : " + name + "\n"
                            + "Room No : " + room + "\n"
                            + "Contact : " + contact,
                    "Booking Confirmed",
                    JOptionPane.INFORMATION_MESSAGE
            );

        } catch(Exception e){

            JOptionPane.showMessageDialog(
                    null,
                    "Booking Failed\nInvalid Input",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }


    // FOOD ORDERING
    static void orderFood(){

        try {

            String menu =
                    "Food Menu\n\n" +
                    "1. Sandwich - ₹50\n" +
                    "2. Pasta - ₹60\n" +
                    "3. Noodles - ₹70\n" +
                    "4. Coke - ₹30";

            int item = Integer.parseInt(
                    JOptionPane.showInputDialog(menu + "\n\nEnter Item Number")
            );

            int qty = Integer.parseInt(
                    JOptionPane.showInputDialog("Enter Quantity")
            );

            int price = getPrice(item);

            int total = price * qty;

            JOptionPane.showMessageDialog(
                    null,
                    "Order Placed Successfully\n\nTotal Bill : ₹" + total,
                    "Food Order",
                    JOptionPane.INFORMATION_MESSAGE
            );

        } catch(Exception e){

            JOptionPane.showMessageDialog(
                    null,
                    "Invalid Order",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }


    // CHECKOUT
    static void checkout(){

        JOptionPane.showMessageDialog(
                null,
                "Checkout Successful\nRoom is now available.",
                "Checkout",
                JOptionPane.INFORMATION_MESSAGE
        );
    }


    // PRICE GETTER
    private static int getPrice(int item){

        return switch(item){
            case 1 -> SANDWICH;
            case 2 -> PASTA;
            case 3 -> NOODLES;
            case 4 -> COKE;
            default -> 0;
        };
    }


    // CHECK ROOM AVAILABLE
    private static boolean isRoomAvailable(int type){

        return switch(type){
            case 1 -> luxuryDouble > 0;
            case 2 -> deluxeDouble > 0;
            case 3 -> luxurySingle > 0;
            case 4 -> deluxeSingle > 0;
            default -> false;
        };
    }


    // DECREASE ROOM COUNT
    private static void decreaseRoom(int type){

        switch(type){
            case 1 -> luxuryDouble--;
            case 2 -> deluxeDouble--;
            case 3 -> luxurySingle--;
            case 4 -> deluxeSingle--;
        }
    }
}