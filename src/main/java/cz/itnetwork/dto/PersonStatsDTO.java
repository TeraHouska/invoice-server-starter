package cz.itnetwork.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonStatsDTO {
    private long personId;
    private String personName;
    private long revenue;
}
