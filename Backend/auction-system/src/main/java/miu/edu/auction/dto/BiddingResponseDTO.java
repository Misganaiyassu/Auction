package miu.edu.auction.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import miu.edu.auction.domain.Product;
import miu.edu.auction.domain.User;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;

@Data
public class BiddingResponseDTO {
    private String id;
    private CustomerDTO customer; // customer only
    private double amount;

    private String status = "Running"; // Closed

    private LocalDateTime createdOn;
}
