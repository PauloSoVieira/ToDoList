package Mindera.mindswap.ToDoList;


import java.util.Iterator;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;

public class ToDoList {
    Queue<ToDoItem> todoItemQueue = new PriorityQueue<>();
    private String name;

    public ToDoList(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void addTask(String taskName, String description, boolean isCompleted, int priorityLevel) {
        todoItemQueue.add(new ToDoItem(taskName, description, isCompleted, priorityLevel));


    }


    public void remove(String task) {


        Iterator<ToDoItem> iterator = todoItemQueue.iterator();

        try {
            while (iterator.hasNext()) {
                ToDoItem item = iterator.next();
                if (item.getTaskName().equals(task)) {
                    todoItemQueue.remove(item);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        //    todoItemQueue.removeIf(toDo -> toDo.taskName.equals(task));
    }

    public void getNextTask() {
        Iterator<ToDoItem> item = todoItemQueue.iterator();

        try {
            System.out.println(item.next());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        //  System.out.println(todoItemQueue.peek());
    }


    public void getAllTasks() {
        Iterator<ToDoItem> item = todoItemQueue.iterator();


        try {
            while (item.hasNext()) {
                System.out.println(item.next());

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    public void getIncompleteTasks() {

        Iterator<ToDoItem> iterator = todoItemQueue.iterator();

        try {
            while (iterator.hasNext()) {
                ToDoItem todo = iterator.next();
                if (!todo.isCompleted) {
                    System.out.println(todo);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }



    /*
        for (ToDoItem todo : todoItemQueue) {
            if (!todo.isCompleted) {
                System.out.println(todo);
            }
        }*/
    }

    public void getCompleteTasks() {
        Iterator<ToDoItem> iterator = todoItemQueue.iterator();

        try {
            while (iterator.hasNext()) {
                ToDoItem item = iterator.next();
                if (item.isCompleted()) {
                    System.out.println(item);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


   /*

        for (ToDoItem todo : todoItemQueue) {
            if (todo.isCompleted) {
                System.out.println(todo);
            }
        } */
    }

    public void markTaskCompleted(String task) {


        Iterator<ToDoItem> iterator = todoItemQueue.iterator();


        try {
            while (iterator.hasNext()) {
                ToDoItem item = iterator.next();
                if (item.getTaskName().equals(task)) {
                    item.setCompleted(true);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


     /*
        for (ToDoItem item : todoItemQueue) {
            if (item.taskName.equals(task)) {
                item.setCompleted(true);
            }
        }

      */
    }

    public void markTaskIncompleted(String task) {
        Iterator<ToDoItem> iterator = todoItemQueue.iterator();

        try {
            while (iterator.hasNext()) {
                ToDoItem item = iterator.next();
                if (item.getTaskName().equals(task)) {
                    item.setCompleted(false);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


/*
        for (ToDoItem item : todoItemQueue) {
            if (item.taskName.equals(task)) {
                item.setCompleted(false);
            }
        }

 */
    }

    @Override
    public String toString() {
        return "ToDoList{" +
                "name='" + name + '\'' +
                ", todoItemQueue=" + todoItemQueue +
                '}';
    }


    public static class ToDoItem implements Comparable<ToDoItem> {
        private final String taskName;
        private final String description;
        private final int priorityLevel;
        private boolean isCompleted;


        public ToDoItem(String taskName, String description, boolean isCompleted, int priorityLevel) {
            this.taskName = taskName;
            this.description = description;
            this.isCompleted = isCompleted;
            this.priorityLevel = priorityLevel;
        }


        public String getTaskName() {
            return taskName;
        }

        public String getDescription() {
            return description;
        }

        public boolean isCompleted() {
            return isCompleted;
        }

        public void setCompleted(boolean completed) {
            isCompleted = completed;
        }

        public int getPriorityLevel() {
            return priorityLevel;
        }

        public void markComplete() {
            isCompleted = true;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ToDoItem toDoItem = (ToDoItem) o;
            return isCompleted == toDoItem.isCompleted && priorityLevel == toDoItem.priorityLevel && Objects.equals(taskName, toDoItem.taskName) && Objects.equals(description, toDoItem.description);
        }

        @Override
        public int hashCode() {
            return Objects.hash(taskName, description, isCompleted, priorityLevel);
        }

        @Override
        public String toString() {
            return
                    "taskName='" + taskName + '\'' +
                            ", description='" + description + '\'' +
                            ", isCompleted=" + isCompleted +
                            ", priorityLevel=" + priorityLevel +
                            '}';
        }

        @Override
        public int compareTo(ToDoItem toDoItem) {
            if (this.getPriorityLevel() < toDoItem.getPriorityLevel()) {
                return -1;
            }
            if (this.getPriorityLevel() == toDoItem.getPriorityLevel()) {
                return 0;
            }
            return 1;
        }
    }

}
