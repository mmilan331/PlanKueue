package com.PlanKueue.springbootPlanKueue.models;

import java.time.Instant;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

//Events + outside Tasks
@Entity
@Table(name = "PlanKueue_Item")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    /*
     * FYI:
     * 
     * @Getter and @Setter are functions of the Lombok library which allows us to
     * avoid having to write the getter and setter for every variable.
     * Instead what his does is it acts as a boiletplate which lets us avoid
     * writting giant ammounts of code for each setter and getter without
     * sacrificing functionality, making it easier to work with and maintain in the
     * long run.
     */

    /* Stores the ID if the task */
    @Getter
    @Setter
    private Long id;

    /* Stores the description of the task */
    @Getter
    @Setter
    @NotBlank(message = "Description cannot be empty")
    private String description;

    /* Stores wether or not a task was completed, Default is false */
    @Getter
    @Setter
    private boolean complete;

    /* Fetches the due date for the assignment */
    @Getter
    @Setter
    private String dueDate;

    /* Fetches a note if it was added to the task */
    @Getter
    @Setter
    private String taskNote;

    // empty default constructor
    public Event() {

    }

    /**
     * Creates a new instance of the {@code PlanKueueItem} class with the specified
     * description of the task or event.
     * 
     * @param description the description of the plan kueue item
     * 
     *                    Initializes the following fields:
     *                    - {@link #complete} to false
     *                    - {@link #createdDate} to the current date and time
     *                    - {@link #modifiedDate} to the current date and time
     *                    - {@link #dueDate} to an empty string
     *                    - {@link #assignmentPoints} to 0.0
     *                    - {@link #taskNote} to an empty string
     */
    public Event(String description) {

        this.description = description;
        this.complete = false;
        this.dueDate = "";

        this.taskNote = "";

    }

    @Override
    public String toString() {
        return String.format(
                "PlanKueueItem{id='%d', description = '%s', complete = '%s', dueDate = %s}",
                id, description, complete, dueDate);
    }

}
