import Mindera.mindswap.ToDoList.ToDoList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        ToDoList toDoList = new ToDoList("ListaCompras");

        toDoList.addTask("Compras", "batatas", true, 10);
        toDoList.addTask("Vender", "Pao", false, 2);
        toDoList.addTask("Correr", "correr", false, 5);
        toDoList.addTask("Estudar", "estudar", false, 3);


        //   System.out.println(toDoList);

        //toDoList.remove("Compras");
        //  toDoList.getNextTask();
        // System.out.println(toDoList);

        // toDoList.getAllTasks();

        //toDoList.getIncompleteTasks();

        //   toDoList.markTaskCompleted("Vender");
        toDoList.getAllTasks();
        toDoList.remove("Correr");
        System.out.println(" ");
        toDoList.getAllTasks();


        toDoList.markTaskIncompleted("Compras");
        // toDoList.getNextTask();

    }
}