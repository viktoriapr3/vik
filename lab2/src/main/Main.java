// Пакет для основного класу
package main;

import lab2.House;

public class Main {
    public static void main(String[] args) {
        // Створення масиву будинків
        House[] houses = {
                new House(1, 101, 45.5, 2, 2, "Street A"),
                new House(2, 102, 60.0, 3, 3, "Street B"),
                new House(3, 103, 78.2, 5, 4, "Street C"),
                new House(4, 104, 90.0, 10, 3, "Street D"),
                new House(5, 105, 40.0, 1, 2, "Street E")
        };

        // Виклики методів для виведення інформації
        System.out.println("Квартири з 3 кімнатами:");
        printApartmentsByRoomCount(houses, 3);

        System.out.println("\nКвартири з 3 кімнатами на поверхах від 1 до 5:");
        printApartmentsByRoomCountAndFloorRange(houses, 3, 1, 5);

        System.out.println("\nКвартири з площею більше 50.0 кв.м:");
        printApartmentsByArea(houses, 50.0);
    }

    // Метод для виведення квартир за кількістю кімнат
    public static void printApartmentsByRoomCount(House[] houses, int numberOfRooms) {
        for (House house : houses) {
            if (house.getNumberOfRooms() == numberOfRooms) {
                System.out.println(house);
            }
        }
    }

    // Метод для виведення квартир за кількістю кімнат і поверхами в заданому діапазоні
    public static void printApartmentsByRoomCountAndFloorRange(House[] houses, int numberOfRooms, int minFloor, int maxFloor) {
        for (House house : houses) {
            if (house.getNumberOfRooms() == numberOfRooms && house.getFloor() >= minFloor && house.getFloor() <= maxFloor) {
                System.out.println(house);
            }
        }
    }

    // Метод для виведення квартир за площею, що перевищує задану
    public static void printApartmentsByArea(House[] houses, double area) {
        for (House house : houses) {
            if (house.getArea() > area) {
                System.out.println(house);
            }
        }
    }
}
