package com.dn.challange.challangeeasybroken.service;
import static org.assertj.core.api.Assertions.assertThat;

import com.dn.challange.challangeeasybroken.services.PropertyService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PropertyServiceTest {
    @Autowired
    private PropertyService service;

    @Test
    public void getProperties() {
        assertThat(service.PageProperty(10).size()).isNotEqualTo(0);
    }
}
