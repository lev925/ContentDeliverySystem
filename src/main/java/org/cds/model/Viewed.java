package org.cds.model;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(uniqueConstraints = { @UniqueConstraint(name = "UniqueViewed", columnNames = { "user_guid", "content_guid" }) })
public class Viewed implements Serializable {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID guid;
    @JoinColumn(name = "user_guid")
    @OneToOne(cascade = CascadeType.ALL)
    private User user;
    @JoinColumn(name = "content_guid")
    @ManyToOne(fetch = FetchType.EAGER)
    private Content content;
}
