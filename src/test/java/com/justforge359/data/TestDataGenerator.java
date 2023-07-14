package com.justforge359.data;

import com.github.javafaker.Faker;

public class TestDataGenerator {

    private static final Faker faker = new Faker();

    public String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            userEmail = faker.internet().emailAddress(),
            userGender = faker.options().option("Other", "Male", "Female"),
            phoneNumber = 8 + faker.phoneNumber().subscriberNumber(9),
            rDay = String.format("%02d", faker.number().numberBetween(1, 28)),
            rMonth = faker.options().option("January", "February", "March",
                    "April", "May", "June", "July", "August",
                    "September", "October", "November", "December"),
            rYear = String.valueOf(faker.number().numberBetween(1900, 2023)),
            subjects = faker.options().option("Maths", "Accounting", "Arts", "Social Studies"),
            hobbies = faker.options().option("Sports", "Reading", "Music"),
            randomPic = faker.options().option("pic1.png", "pic2.png"),
            currentAdd = faker.address().fullAddress(),
            permAdd = faker.address().fullAddress(),
            randomState = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan"),
            randomCity = getRandomCity(randomState);

    public static String getRandomCity(String state) {
        if (state.equals("NCR")) {
            return faker.options().option("Delhi", "Gurgaon", "Noida");
        } else if (state.equals("Uttar Pradesh")) {
            return faker.options().option("Agra", "Lucknow", "Merrut");
        } else if (state.equals("Haryana")) {
            return faker.options().option("Karnal", "Panipat");
        } else if (state.equals("Rajasthan")) {
            return faker.options().option("Jaipur", "Jaiselmer");
        }
        return null;
    }


}
