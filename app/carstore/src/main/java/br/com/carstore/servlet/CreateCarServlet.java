package br.com.carstore.servlet;

import br.com.carstore.dao.CarDao;
import br.com.carstore.model.Car;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/create-car")
public class CreateCarServlet extends HttpServlet {

    @java.lang.Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String carName = req.getParameter("name");
        String carColor = req.getParameter("color");

        Car car = new Car();
        car.setName(carName);
        car.setColor(carColor);

        CarDao carDao = new CarDao();
        carDao.createCar(car);

        //System.out.println(carName);
        //System.out.println(carColor);

        req.getRequestDispatcher("index.html").forward(req, resp);

    }

}
