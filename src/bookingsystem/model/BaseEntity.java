package bookingsystem.model;

public abstract class BaseEntity {
    private long id;

    public BaseEntity(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BaseEntity)) return false;

        BaseEntity that = (BaseEntity) o;

        return getId() == that.getId();

    }

    @Override
    public int hashCode() {
        return (int) (getId() ^ (getId() >>> 32));
    }
}
