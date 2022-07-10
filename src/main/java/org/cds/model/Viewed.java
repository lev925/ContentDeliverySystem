package org.cds.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
@Table
public class Viewed implements Serializable {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID guid;
    @JoinColumn(name = "user_guid")
    @OneToOne(cascade = CascadeType.ALL)
    private User user;
    @JoinColumn(name = "content_guid")
    @ManyToOne(fetch = FetchType.LAZY)
    private Content content;
}
