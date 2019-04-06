package myTddProject.tddproject;

import myTddProject.tddproject.model.Car;
import myTddProject.tddproject.service.CarService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest
public class ControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CarService carService;
    @Test
    public void shouldReturnCar() throws Exception {
         given(carService.getCarDetails(anyString ())).willReturn(new Car("Tikish","Camry"));
        mockMvc.perform(MockMvcRequestBuilders.get("/car/camry"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("name").value("camry"))
                .andExpect(jsonPath("type").value("white"));

    }

}
