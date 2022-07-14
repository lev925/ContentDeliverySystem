package org.cds.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Check;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = {"guid"})
@Entity
@Table
@Check(constraints = "start_date < end_date")
public class Target implements Serializable {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID guid;
    @JoinColumn(name = "user_guid")
    @OneToOne(fetch = FetchType.EAGER)
    private User user;
    @JoinColumn(name = "content_guid")
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Content content;
    @Column
    private Page page;
    @Column
    private int priority;
    @Column(name = "start_date")
    private Date startDate;
    @Column(name = "end_date")
    private Date endDate;

}
