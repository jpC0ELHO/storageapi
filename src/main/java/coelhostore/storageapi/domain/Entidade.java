package coelhostore.storageapi.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;
import tools.jackson.databind.PropertyNamingStrategies;
import tools.jackson.databind.annotation.JsonDeserialize;
import tools.jackson.databind.annotation.JsonNaming;
import tools.jackson.databind.annotation.JsonSerialize;
import tools.jackson.databind.ext.javatime.deser.LocalDateDeserializer;
import tools.jackson.databind.ext.javatime.ser.LocalDateSerializer;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
@Getter
@Setter
@MappedSuperclass
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class )
public abstract class Entidade implements Serializable {
    @Serial
    private static final long SerialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;
    @LastModifiedBy
    private String lastModifiedBy;
    @CreatedBy
    private String createdBy;
    @CreatedDate
    @Temporal(TemporalType.DATE)
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd/MM/yyyy HH:mm:ss")
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss" )
    private LocalDateTime createdAt;
    @LastModifiedDate
    @Temporal(TemporalType.DATE)
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd/MM/yyyy HH:mm:ss")
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss" )
    private LocalDateTime updateAt;
}
