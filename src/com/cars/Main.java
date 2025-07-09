package com.cars;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;
import java.time.*;

public class Main {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        ArrayList<Car> cars = new ArrayList<Car>();
        System.out.println("Before you begin, enter your name:");
        String user = scanner.nextLine();
        System.out.println(user +", welcome to vehicle registration");
        System.out.println("1. Capture vehicle details. \n"+
                           "2. View vehicle report.\n"+
                            "3. Exit.");

        int menuOption = scanner.nextInt();

        while(menuOption == 1 || menuOption == 2){

            if(menuOption==1){
                Car obj = new Car();
                int year;
                int mileage;
                String make;
                String model;
                String plateNum = "";
                String vin;

                System.out.println("Enter make");
                make = scanner.next();

                System.out.println("Enter model");
                model = scanner.next();

                System.out.println("Enter vin number");
                vin = scanner.next();
                while(!(vin.length() ==17)){
                    System.out.println("Enter vin number that is exactly 17 characters long");
                    vin = scanner.next();
                }

                System.out.println("Please enter 1. for old format license plate number and 2. for new format plate number");
                int plateChoice = scanner.nextInt();
                if(plateChoice == 1){
                    System.out.println("Enter plate number e.g. AAA555GP");
                    plateNum = scanner.next();
                }
                else if(plateChoice == 2){
                    System.out.println("Enter plate number e.g. AA33BBGP");
                    plateNum = scanner.next();
                }

                System.out.println("Enter mileage");
                mileage = scanner.nextInt();

                System.out.println("Enter year");
                year = scanner.nextInt();

                obj.setMake(make);
                obj.setModel(model);
                obj.setPlateNumber(plateNum);
                obj.setVin(vin);
                obj.setYear(year);
                obj.setMileage(mileage);

                cars.add(obj);
            }
            else if(menuOption == 2){
                if(cars.isEmpty()){
                    System.out.println("There are no cars captured");
                }
                else{
                    System.out.println("************************************\n"+
                            "VEHICLE REPORT\n" +
                            "************************************");

                    for(Car carObject: cars){
                        System.out.println("MAKE: "+carObject.getMake() +
                                "\n MODEL: "+carObject.getModel()+
                                "\n VIN NUMBER: "+carObject.getVin()+
                                "\n PLATE NUMBER: "+carObject.getPlateNumber()+
                                "\n MILEAGE: "+ carObject.getMileage()+
                                "\nYEAR: "+ carObject.getYear());
                    }
                }
            }

            System.out.println("1. Capture vehicle details. \n"+
                    "2. View vehicle report.\n"+
                    "3. Exit.");
            menuOption = scanner.nextInt();
        }
        System.out.println("Thank you for using the app "+ user+". Till next time");
    }
}
