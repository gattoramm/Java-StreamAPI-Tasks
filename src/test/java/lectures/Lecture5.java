package lectures;

import static org.assertj.core.api.Assertions.assertThat;
import beans.Car;
import beans.Person;
import beans.PersonDTO;
import com.google.common.collect.ImmutableList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import mockdata.MockData;
import org.junit.Test;

public class Lecture5 {
  @Test
  public void understandingFilter() throws Exception {
    ImmutableList<Car> carPredicate = MockData.getCars();

    final Predicate<Car> carPredicate1 = car -> car.getPrice() < 10000;

    List<Car> carsFiltered = carPredicate.stream()
            .filter(carPredicate1)
            .collect(Collectors.toList());

    carsFiltered.forEach(System.out::println);
  }

  @Test
  public void ourFirstMapping() throws Exception {
    // transform from one data type to another
    List<Person> people = MockData.getPeople();
    List<PersonDTO> dtos = people.stream()
            .map(PersonDTO::map)
            .collect(Collectors.toList());

    dtos.forEach(System.out::println);
    assertThat(dtos).hasSize(1000);
  }

  @Test
  public void averageCarPrice() throws Exception {
    // calculate average of car prices
    double average = MockData.getCars().stream()
            .mapToDouble(Car::getPrice)
            .average()
            .orElse(0);
    System.out.println(average);
  }

  @Test
  public void test() throws Exception {
    MockData.getCars().forEach(System.out::println);
  }
}



