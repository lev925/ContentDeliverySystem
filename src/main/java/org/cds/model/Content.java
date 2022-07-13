package org.cds.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table
public class Content implements Serializable {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID guid;
    @Column(columnDefinition = "text", unique=true)
    private String data;
}
