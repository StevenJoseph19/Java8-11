import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.paumard.model.Person;


public class BuildingBiMap {

    public static void main(String[] args) {
        
        List<Person> persons = new ArrayList<>();
        
        try (
            BufferedReader reader = 
                new BufferedReader(
                    new InputStreamReader(
                        BuildingBiMap.class.getResourceAsStream("people.txt")));

            Stream<String> stream = reader.lines();
        ) {

            stream.map(line -> {
                    String[] s = line.split(" ");
                    Person p = new Person(
                            s[0].trim(), 
                            Integer.parseInt(s[1]), 
                            s[2].trim()
                    );
                    persons.add(p);
                    return p;
                })
                .forEach(System.out::println);
                
            
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
        
        persons.forEach(System.out::println);
        
        Map<Integer, List<Person>> map = 
                persons.stream().collect(
                        Collectors.groupingBy(
                                Person::getAge
                        )
                );
        
        map.forEach((age, list) -> System.out.println(age + " -> " + list));
        
        
    }        
}
