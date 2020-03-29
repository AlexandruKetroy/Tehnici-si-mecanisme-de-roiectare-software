package utm.tmps;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Client {
    private final long id;
    private String firstName;
    private String lastName;
    private int age;
}
