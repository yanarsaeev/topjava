package ru.javawebinar.topjava.service;

import org.springframework.stereotype.Service;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.repository.MealRepository;
import ru.javawebinar.topjava.util.ValidationUtil;

import java.util.Collection;

@Service
public class MealService {

    private final MealRepository repository;

    public MealService(MealRepository repository) {
        this.repository = repository;
    }

    public Meal create(Meal meal, int userId) {
        return repository.save(meal);
    }

    public void delete(int id, int userId) {
        ValidationUtil.checkNotFound(repository.get(id, userId), id);
    }

    public void update(Meal meal, int userId) {
        ValidationUtil.checkNotFound(repository.save(meal), meal.getId());
    }

    public Collection<Meal> getAll(int userId) {
        return repository.getAll(userId);
    }
}