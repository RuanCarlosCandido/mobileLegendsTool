package org.services;

import java.util.Scanner;

import org.apache.log4j.LogManager;
import org.controllers.HeroController;

public class HeroSelectionService {
    private static final org.apache.log4j.Logger LOGGER = LogManager.getLogger(HeroSelectionService.class);
    private final Scanner scanner;
    private final HeroController heroController;

    public HeroSelectionService(Scanner scanner) {
        this.scanner = scanner;
        this.heroController = new HeroController();
    }

    public void selectHeroes() {
        int i = 0;
        while (i < 5) {
            try {
                System.out.printf("Enter the name of hero number %d: ", i + 1);
                String heroName = scanner.next().toLowerCase();

                heroController.addPickedHero(heroName);
                heroController.calculateCounters();
                heroController.printCounters();
                i++;
            } catch (Exception e) {
                LOGGER.error("Invalid hero, please try again.");
            }
        }
    }
}
