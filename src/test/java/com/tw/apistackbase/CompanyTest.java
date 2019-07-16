package com.tw.apistackbase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.containsString;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CompanyTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnAllCompany() throws Exception {
//        this.mockMvc.perform(get("/companies")).andDo(print()).andExpect(status().isOk())
//                .andExpect(content().string(containsString("Hello World")));
        this.mockMvc.perform(get("/companies")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().json("[\n" +
                        "    {\n" +
                        "        \"companyName\": \"ccol\",\n" +
                        "        \"employeesNumber\": 200,\n" +
                        "        \"employees\": [\n" +
                        "            {\n" +
                        "                \"id\": 4,\n" +
                        "                \"name\": \"oocl1\",\n" +
                        "                \"age\": 20,\n" +
                        "                \"gender\": \"male\",\n" +
                        "                \"salary\": 6000\n" +
                        "            },\n" +
                        "            {\n" +
                        "                \"id\": 11,\n" +
                        "                \"name\": \"oocl2\",\n" +
                        "                \"age\": 22,\n" +
                        "                \"gender\": \"male\",\n" +
                        "                \"salary\": 6000\n" +
                        "            }\n" +
                        "        ]\n" +
                        "    }\n" +
                        "]"));
    }
    @Test
    public void shouldReturn_a_certain_specific_Company() throws Exception {
        this.mockMvc.perform(get("/companies/1")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().json("{\n" +
                        "    \"companyId\": 1,\n" +
                        "    \"companyName\": \"ccol\",\n" +
                        "    \"employeesNumber\": 200,\n" +
                        "    \"employees\": [\n" +
                        "        {\n" +
                        "            \"id\": 4,\n" +
                        "            \"name\": \"oocl1\",\n" +
                        "            \"age\": 20,\n" +
                        "            \"gender\": \"male\",\n" +
                        "            \"salary\": 6000\n" +
                        "        },\n" +
                        "        {\n" +
                        "            \"id\": 11,\n" +
                        "            \"name\": \"oocl2\",\n" +
                        "            \"age\": 22,\n" +
                        "            \"gender\": \"male\",\n" +
                        "            \"salary\": 6000\n" +
                        "        }\n" +
                        "    ]\n" +
                        "}"));
    }
}
