package br.com.carstore.dao;

import br.com.carstore.model.Car;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


public class CarDao {

    public void createCar(Car car) {

        String SQL = "INSERT INTO CAR (NAME, COLOR) VALUES (?, ?)";

        try {

            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa","sa");

            System.out.println("success in database connection");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, car.getName());
            preparedStatement.setString(2, car.getColor());

            preparedStatement.execute();

            System.out.println("success in insert car");

            //connection.close();

        } catch (Exception e) {

            System.out.println("fail in database connection" + e.getMessage());

        }

    }

    public List<Car> findAllCars(){

        String SQL = "SELECT * FROM CAR";

        try {

            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");

            System.out.println("success in database connection");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            ResultSet resultSet = preparedStatement.executeQuery();

            List<Car> cars = new ArrayList<>();

            while (resultSet.next()) {

                String carName = resultSet.getString("name");

                Car car = new Car(carName);

                cars.add(car);

            }

            System.out.println("success in select * car");

            connection.close();

            return cars;

        } catch (Exception e) {
            System.out.println("Falha ao consultar os carros na tabela CAR" + e.getMessage());

            return Collections.emptyList();

        }

    }


}
