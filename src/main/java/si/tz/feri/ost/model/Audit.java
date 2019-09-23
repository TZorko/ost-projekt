package si.tz.feri.ost.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.time.LocalDateTime;

@Embeddable
public class Audit {
    @Column(name = "dat_ins")
    private LocalDateTime createdOn;

    @Column(name = "dat_upd")
    private LocalDateTime updatedOn;

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public LocalDateTime getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(LocalDateTime updatedOn) {
        this.updatedOn = updatedOn;
    }
}
