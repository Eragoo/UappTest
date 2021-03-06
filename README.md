# Uapp Test

## Requirements:

- ✔️ User can create column. <br>
     **POST** request to __api/column__<br>
      
- ✔ User can delete columns.<br>
     **DELETE** request to __api/column/{id}__<br>
     Request also deletes all Task assigned to deleted Column.<Br>There could be another approach - assign Task to some default column or just unassign.<br> 
     
- ✔  User can change the order of the columns relative to each other.<br>
     **PUT** request to __api/column/{id}__ with changed **priority** field
     
- ✔ User can edit task data. <br>
    **PUT** request to __api/task/{id}__
    
- ✔ User can add a new task to a column. <br>
    Specify  **column** field during creation (**POST** request to __api/task__) new __Task__ entity.<br>
    
- ✔ User delete task.<br>
    **DELETE** request to __api/task/{id}__<br>

- ✔ User can move task to another column.<br>
  **PUT** request to __/api/task/{taskId}/move-to-column?columnId={columnId}__ moves Task with id **taskId** to Column with id **columnId**<br>
  
- ✔ User can change task order in the column.<br>
    **PUT** request to __/api/task/{taskId}/change-priority?newPriority={priority}__ with changed **priority** field<br>
    **GET** request to __api/column/{id}/tasks__ returns sorted (by priority field) list of Tasks for that column<br>


## Additional features:

- TaskCommand and ColumnCommand validation.
- Error handling using ControllerAdvice
- Safe delete in Task and Column 

## Tech stack:
    - Spring Boot, Data
    - Hibernate, PostgreSQL, Flyway
    - Gradle, Swagger
    - Lombok
