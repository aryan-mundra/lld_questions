package service;

import java.util.EnumMap;
import java.util.Map;

import enums.CompartmentClass;
import model.Train;

/**
 * Computes a fare: look up the distance on the train's route, then apply the
 * fare strategy for the chosen class. The class -> strategy mapping lives here
 * in one place (an EnumMap), so picking the right formula at runtime is a fast,
 * clean lookup — no scattered if/else.
 */
public class FareService {
    private final Train train;
    private final Map<CompartmentClass, FareStrategy> fareByClass = new EnumMap<>(CompartmentClass.class);

    public FareService(Train train) {
        this.train = train;
        fareByClass.put(CompartmentClass.SECOND_CLASS, new SecondClassFare());
        fareByClass.put(CompartmentClass.FIRST_CLASS, new FirstClassFare());
        fareByClass.put(CompartmentClass.AC, new AcFare());
    }

    public double fare(String from, String to, CompartmentClass cls) {
        int distance = train.getRoute().distanceBetween(from, to); // km between stations
        FareStrategy strategy = fareByClass.get(cls);              // pick formula for the class
        return strategy.calculate(distance);
    }

    public int distance(String from, String to) {
        return train.getRoute().distanceBetween(from, to);
    }
}
