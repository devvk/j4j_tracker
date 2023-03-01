package ru.job4j.enumeration;

public class CarService {
    public static void main(String[] args) {
        Status toyota = Status.FINISHED;
        Status volvo = Status.WAITING;
        System.out.println("Status toyota: " + toyota);
        System.out.println("Status volvo: " + volvo);

        Order order = new Order(1, "Mercedes-Benz GLS", Status.IN_WORK);
        System.out.println("Заказ №" + order.getNumber()
                + " на автомобиль: \"" + order.getCar() + "\""
                + ", статус ремонта: \"" + order.getStatus().getInfo() + "\", "
                + "(" + order.getStatus().getMessage() + ")");

        Status[] statuses = Status.values();
        for (Status status : statuses) {
            System.out.println("Название статуса: " + status.name()
                    + ", порядковый номер статуса: " + status.ordinal());
        }

        String accepted = "ACCEPTED";
        Status status = Status.valueOf(accepted);
        System.out.println(status);
        switch (status) {
            case ACCEPTED -> System.out.println("Статус: Автомобиль принят на СТО");
            case IN_WORK -> System.out.println("Статус: Автомобиль в работе");
            case WAITING -> System.out.println("Статус: Автомобиль ожидает запчасти");
            case FINISHED -> System.out.println("Статус: Все работы завершены");
            default -> System.out.println("Статус: не определён!");
        }
    }
}
