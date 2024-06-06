package com.jsonread.readingjsoninspringbootapp.modal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@Getter
public class Address {
    private String houseAndStreetName;
    private String city;
    private String country;

    @Override
    public String toString() {
        return "[" +
                "houseAndStreetName='" + houseAndStreetName + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ']';
    }
}
