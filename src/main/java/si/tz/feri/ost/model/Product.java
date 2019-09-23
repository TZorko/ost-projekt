package si.tz.feri.ost.model;

import com.sun.javafx.beans.IDProperty;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity(name="product")
@Table(name="products")
@EntityListeners(AuditListener.class)
public class Product implements Auditable {


    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(nullable=false)
    private String name;

    @Column(length=2000)
    private String description;

    private byte[] pict;

    private BigDecimal price;

    @Override
    public Audit getAudit() {
        return audit;
    }

    @Embedded
    private Audit audit;

    @Override
    public void setAudit(Audit audit) {
        this.audit = audit;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String desc) {
        this.description = desc;
    }

    public byte[] getPict() {
        return pict;
    }

    public void setPict(byte[] pict) {
        this.pict = pict;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }
}
