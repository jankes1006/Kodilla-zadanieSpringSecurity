package com.kodilla.factory.domain;

import lombok.Value;

import java.math.BigDecimal;

@Value(staticConstructor = "of")
public class Product {
    String name;
    String description;
    BigDecimal cost;
}
