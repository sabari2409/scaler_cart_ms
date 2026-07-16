package com.scaler.cart.assignmnts.controller;


import com.scaler.cart.assignments.controller.AmazonProductController;
import com.scaler.cart.assignments.models.other_assignments.AmazonProduct;
import com.scaler.cart.assignments.services.IProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(AmazonProductController.class)
public class AmazonProductControllerMvcTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private IProductService amazonProductService;

    @Test
    void testSearchProductByName() throws Exception {
        // Prepare test data
        AmazonProduct amazonProduct = new AmazonProduct();
        amazonProduct.setProduct_title("iPhone");
        List<AmazonProduct> products = Collections.singletonList(amazonProduct);

        when(amazonProductService.getProductByName("Phone")).thenReturn(products);

        mockMvc.perform(get("/amazon/search")
                        .param("query", "Phone")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0]").exists())
                .andExpect(jsonPath("$[0].product_title").value("iPhone"));
    }

    @Test
    void testGetProductsByCategoryId() throws Exception {
        // Prepare test data
        AmazonProduct amazonProduct = new AmazonProduct();
        amazonProduct.setProduct_title("macbook");
        List<AmazonProduct> products = Collections.singletonList(amazonProduct);

        when(amazonProductService.getProductByCategoryId("2478868012")).thenReturn(products);

        // Perform the GET request and verify the response
        mockMvc.perform(get("/amazon/products-by-category")
                        .param("categoryid", "2478868012")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0]").exists())
                .andExpect(jsonPath("$[0].product_title").value("macbook"));;
    }
}
