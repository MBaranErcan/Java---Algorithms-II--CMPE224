package nil;

class Customer {
    private int registrationYear;
    private String customerID;
    private int reservationStart;
    private int reservationDays;
    private String bookTitle;

    public Customer(int registrationYear, String customerID, int reservationStart, int reservationDays, String bookTitle) {
        this.registrationYear = registrationYear;
        this.customerID = customerID;
        this.reservationStart = reservationStart;
        this.reservationDays = reservationDays;
        this.bookTitle = bookTitle;
    }

    public int getRegistrationYear() {
        return registrationYear;
    }

    public String getCustomerID() {
        return customerID;
    }

    public int getReservationStart() {
        return reservationStart;
    }

    public int getReservationDays() {
        return reservationDays;
    }

    public String getBookTitle() {
        return bookTitle;
    }
}