package br.com.carstore.servlet;

import br.com.carstore.dao.CarDao;
import br.com.carstore.model.Car;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/create-car")
public class CreateCarServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String carName = req.getParameter("name");
        String carColor = req.getParameter("color");

        Car car = new Car(carName, carColor);

        new CarDao().createCar(car);

        CarDao carDao = new CarDao();
        carDao.createCar(car);

        //System.out.println(carName);
        //System.out.println(carColor);

        resp.sendRedirect("/find-all-cars");

    }

}
