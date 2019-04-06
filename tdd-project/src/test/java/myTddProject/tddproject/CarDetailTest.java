package myTddProject.tddproject;


import myTddProject.tddproject.model.Car;
import org.junit.Test;
import org.junit.runner.RunWith;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;


import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest()
public class CarDetailTest {

    @Autowired
    private TestRestTemplate restTemplate;
    @Test
    public void getCarDetails() throws Exception{
        // arrange
        //act
      ResponseEntity<Car> response = restTemplate.getForEntity
              ("/car/camry", Car.class);



        //assert

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody().getName()).isEqualTo("Camry");
        assertThat(response.getBody().getType()).isEqualTo("white");

    }
}
