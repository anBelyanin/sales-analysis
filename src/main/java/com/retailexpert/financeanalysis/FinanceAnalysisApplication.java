package com.retailexpert.financeanalysis;

import com.retailexpert.financeanalysis.db.entity.Actual;
import com.retailexpert.financeanalysis.db.repository.ActualRepository;
import com.retailexpert.financeanalysis.db.repository.ProductRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.After;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Set;

@SpringBootApplication
public class FinanceAnalysisApplication {

    public static void main(String[] args) {
        SpringApplication.run(FinanceAnalysisApplication.class, args);
    }


}
