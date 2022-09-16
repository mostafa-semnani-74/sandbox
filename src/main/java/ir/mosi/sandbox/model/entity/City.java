package ir.mosi.sandbox.model.entity;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class City implements Serializable {
    private String id;
    private String name;
}
