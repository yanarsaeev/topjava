package ru.javawebinar.topjava.repository.inmemory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.repository.MealRepository;
import ru.javawebinar.topjava.util.MealsUtil;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class InMemoryMealRepository implements MealRepository {
    private static final Logger log = LoggerFactory.getLogger(InMemoryMealRepository.class);
    private final Map<Integer, List<Meal>> mealsMap = new ConcurrentHashMap<>();
    private final AtomicInteger counter = new AtomicInteger(0);

    {
        MealsUtil.meals.forEach(this::save);
    }

    @Override
    public Meal save(Meal meal) {
        log.info("Save {}", meal);
        if (meal.isNew()) {
            meal.setId(counter.incrementAndGet());
            mealsMap.put(meal.getId(), new ArrayList<>(Collections.singletonList(meal)));
            return meal;
        }

        return meal;
    }

    @Override
    public boolean delete(int id, int userId) {
        log.info("Delete {} userId={}", id, userId);
        List<Meal> meals = mealsMap.get(userId);
        return meals.removeIf(meal -> meal.getId().equals(id));
    }

    @Override
    public Meal get(int id, int userId) {
        log.info("Get");
        return mealsMap.get(userId).get(id);
    }

    @Override
    public Collection<Meal> getAll(int userId) {
        log.info("getAll");
        List<Meal> mealList = mealsMap.get(userId);
        mealList.sort(Comparator.comparing(Meal::getDateTime));
        return null;
    }
}

