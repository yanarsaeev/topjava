package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import ru.javawebinar.topjava.model.MealTo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

public class MealServlet extends HttpServlet {
    private static final Logger log = getLogger(MealServlet.class);
    List<MealTo> list = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.debug("redirect to meals");
        list.add(new MealTo(LocalDateTime.of(2020, Month.JANUARY, 30, 10, 0), "Завтрак", 500, true));
        list.add(new MealTo(LocalDateTime.of(2020, Month.JANUARY, 28, 13, 0), "Eating", 1000, false));
        list.add(new MealTo(LocalDateTime.of(2020, Month.JANUARY, 29, 14, 0), "Lunch", 900, true));

        System.out.println("Meals size: " + list.size());
        req.setAttribute("meals", list);
        req.getRequestDispatcher("meals.jsp").forward(req, resp);
    }
}
