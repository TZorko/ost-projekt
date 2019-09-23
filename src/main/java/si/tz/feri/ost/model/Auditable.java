package si.tz.feri.ost.model;

public interface Auditable {
    public Audit getAudit();
    void setAudit(Audit audit);
}
