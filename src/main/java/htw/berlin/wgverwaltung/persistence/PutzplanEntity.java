package htw.berlin.wgverwaltung.persistence;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PutzplanEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String taskname;
    private int timeInterval;
    private int effortPoints;
    private Boolean completed;

    protected PutzplanEntity() {
    }

    public PutzplanEntity(String taskname, int timeInterval, int effortPoints) {
        this.taskname = taskname;
        this.timeInterval = timeInterval;
        this.effortPoints = effortPoints;
        this.completed = false;
    }


    public Long getId() {
        return id;
    }

    //Notwendig trotz Generierung?
    public void setId(Long id) {
        this.id = id;
    }

    public String getTaskname() {
        return taskname;
    }

    public void setTaskname(String taskname) {
        this.taskname = taskname;
    }

    public int getTimeInterval() {
        return timeInterval;
    }

    public void setTimeInterval(int timeInterval) {
        this.timeInterval = timeInterval;
    }

    public int getEffortPoints() {
        return effortPoints;
    }

    public void setEffortPoints(int effortPoints) {
        this.effortPoints = effortPoints;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
}
