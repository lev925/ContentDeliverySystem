package org.cds.model;

import com.vladmihalcea.hibernate.type.json.JsonStringType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.DatabaseMetaData;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@TypeDef(name = "json", typeClass = JsonStringType.class)
@Table(name = "content")
public class Content implements Serializable {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID guid;
    @Type(type = "json")
    @Column(name = "data", columnDefinition = "json")
    private DataContent data;
}
