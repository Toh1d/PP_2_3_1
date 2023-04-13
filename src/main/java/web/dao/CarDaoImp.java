package web.dao;

import org.springframework.stereotype.Repository;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CarDaoImp implements CarDao {
    private static int CARS_COUNT;
    private List<Car> carsList;


    {
        carsList = new ArrayList<>();

        carsList.add(new Car(++CARS_COUNT, "BMW", "X6"));
        carsList.add(new Car(++CARS_COUNT, "Mercedes", "e200"));
        carsList.add(new Car(++CARS_COUNT, "Ford", "Focus"));
        carsList.add(new Car(++CARS_COUNT, "Range Rover", "SVR"));
        carsList.add(new Car(++CARS_COUNT, "Lamborgini", "Urus"));
    }

    @Override
    public List<Car> getCarsList(int count) {
        return carsList.stream().limit(count >= 0 && count <= 5 ? count : Integer.MAX_VALUE).toList();
    }
}
