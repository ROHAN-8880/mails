package com.outlook.mails.controller;

import com.outlook.mails.model.MisData;
import com.outlook.mails.service.MisDataService;
import org.apache.hc.client5.http.auth.AuthScope;
import org.apache.hc.client5.http.auth.CredentialsProvider;
import org.apache.hc.client5.http.auth.UsernamePasswordCredentials;
import org.apache.hc.client5.http.impl.auth.BasicCredentialsProvider;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.core5.http.io.entity.EntityUtils;import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



import javax.sql.DataSource;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Controller
@CrossOrigin
public class MisDataController {

    private static final String FILE_URL = "http://192.168.1.6/scan/krn/ROHAN/EMAIL-DATA.exl"; // Update with actual server path
    private static final String USERNAME = "Administrator";
    private static final String PASSWORD = "Welcome@1";

    @Autowired
    private MisDataService misDataService;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private DataSource dataSource;

    private Object AuthScope;

    @GetMapping("/ShowMis")
    public String showForm(Model model){
        model.addAttribute("misData", new MisData());
        return "Mis.html";
    }

    @PostMapping("/MisSave")
    public String saveData(@ModelAttribute MisData misData, Model model){
        misDataService.saveMisData(misData);
        model.addAttribute("misData", new MisData());
        return "/Mis.html";
    }

    //READ THE TEXT RENDER IN THE TABLE
    @GetMapping("/view-Tables")
    public String fetchFile(Model model) {
        List<String[]> rows = new ArrayList<>();
        String fileType = "text/csv/exl";

        try {
            CredentialsProvider provider = new BasicCredentialsProvider();
            ((BasicCredentialsProvider) provider).setCredentials( new AuthScope(null, -1), new UsernamePasswordCredentials(USERNAME, PASSWORD.toCharArray()));

            try (CloseableHttpClient client = HttpClients.custom().setDefaultCredentialsProvider(provider).build()) {
                HttpGet request = new HttpGet(FILE_URL);
                try (CloseableHttpResponse response = client.execute(request)) {
                    String content = EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);
                    BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), StandardCharsets.UTF_8));
                    String line;
                    while ((line = reader.readLine()) != null) {
                        rows.add(line.split(","));
                    }
                }
            }
        } catch (Exception e) {
            model.addAttribute("message", "Error fetching file: " + e.getMessage());
            return "Tables";
        }

        model.addAttribute("fileType", fileType);
        model.addAttribute("rows", rows);
        return "Tables";
    }
}
