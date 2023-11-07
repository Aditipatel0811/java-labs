class airlinedetails{
    private String name;
    private String flightname;
    private double fare;

    public airlinedetails(){
        name="";
        flightname="";
        fare=0;
    }

    public airlinedetails(String name,String flightname,double fare){
        this.name=name;
        this.flightname=flightname;
        this.fare=fare;
    }

    public void flightfaredetails(){
        System.out.println("Passenger Name: "+name);
        System.out.println("Flight Name: "+flightname);
        System.out.println("flight Price: "+fare);
    }

    public void flightfaredetails(int seats){
        System.out.println("Passenger Name: "+name);
        System.out.println("Flight Name: "+flightname);
        System.out.println("flight Price: "+fare);
        System.out.println("Total Seats: "+seats);
    }

    public void flightfaredetails(double businessclassfare){
        System.out.println("Passenger Name: "+name);
        System.out.println("Flight Name: "+flightname);
        System.out.println("flight Price: "+fare);
        System.out.println("upgrade Fare(Business Class): "+businessclassfare);
    }

}

public class airline{
    public static void main(String[] args){
        airlinedetails ticket1 = new airlinedetails("Adhish","6E001",5000);
        airlinedetails ticket2 = new airlinedetails("jagriti","6E002",6000);
        airlinedetails ticket3 = new airlinedetails("Ansh","6E001",8000);

        ticket1.flightfaredetails();
        System.out.println();

        ticket2.flightfaredetails(26);
        System.out.println();

        ticket3.flightfaredetails(9000.00);
        System.out.println();

    }
}