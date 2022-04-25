package academy.springboot.domain;

import nonapi.io.github.classgraph.json.Id;

import java.util.Date;

public class BillToPay {
    @Id
    public String id;

    public String description;
    public Date dueDate;
    public float value;

}
