package Practice.src.warmup;

import java.util.*;

public class TaskManager {

    Map<Integer, Task> taskIdToTaskMap = new HashMap<>();

    PriorityQueue<Task> priorityQueue = new PriorityQueue<>((task1, task2) -> {
        // Compare based on the third element in reverse (descending)
        int thirdComparison = Integer.compare(task2.getPriority(), task1.getPriority());
        if (thirdComparison != 0) {
            return thirdComparison; // If third elements are not equal, use this result
        }
        // If third elements are the same, compare the second elements in reverse (descending)
        return Integer.compare(task2.getTaskId(), task1.getTaskId());
    });


    public static void main(String[] args) {

        List<List<Integer>> tasks = new ArrayList<>(
                Arrays.asList(
                        Arrays.asList(3,12,4)
                )
        );
        TaskManager taskManager = new TaskManager(tasks);
//        taskManager.add(4, 104, 5);
        taskManager.edit(12, 27);
        taskManager.edit(12, 33);
        int ans1 = taskManager.execTop();
        System.out.println(ans1);
//        taskManager.rmv(101);
//        taskManager.add(5, 105, 15);
        int ans2 = taskManager.execTop();
        System.out.println(ans2);
        int ans3 = taskManager.execTop();
        System.out.println(ans3);
    }

    public TaskManager(List<List<Integer>> tasks) {

        for (List<Integer> task : tasks) {
            Integer taskId = task.get(1);
            Task taskObj = createTask(task);
            taskIdToTaskMap.put(taskId, taskObj);
            priorityQueue.add(taskObj);
        }
    }

    public Task createTask(List<Integer> task) {
        return new Task(task.get(0), task.get(1), task.get(2));
    }

    public Task createTask(Integer userId, Integer taskId, Integer priority) {
        return new Task(userId, taskId, priority);
    }

    public void add(int userId, int taskId, int priority) {

        Task taskObj = createTask(userId, taskId, priority);
        taskIdToTaskMap.put(taskId, taskObj);
        priorityQueue.add(taskObj);
    }

    public void edit(int taskId, int newPriority) {

        Task oldTask = taskIdToTaskMap.get(taskId);
        Task updatedTask = createTask(oldTask.getUserId(), oldTask.getTaskId(), newPriority);
        taskIdToTaskMap.put(taskId, updatedTask);
        priorityQueue.add(updatedTask);
    }

    public void rmv(int taskId) {
        taskIdToTaskMap.remove(taskId);
    }

    public int execTop() {

        while (!priorityQueue.isEmpty()) {
            Task task = priorityQueue.poll();
            int taskId = task.getTaskId();
            int userId = task.getUserId();
            if (taskIdToTaskMap.containsKey(taskId) && taskIdToTaskMap.get(taskId) == task) {
                rmv(taskId);
                return userId;
            }
        }
        return -1;
    }

    class Task {

        private Integer userId;

        private Integer taskId;
 
        private Integer priority;

        public Task(Integer userId, Integer taskId, Integer priority) {
            this.userId = userId;
            this.taskId = taskId;
            this.priority = priority;
        }

        public Integer getUserId() {
            return userId;
        }

        public void setUserId(Integer userId) {
            this.userId = userId;
        }

        public Integer getTaskId() {
            return taskId;
        }

        public void setTaskId(Integer taskId) {
            this.taskId = taskId;
        }

        public Integer getPriority() {
            return priority;
        }

        public void setPriority(Integer priority) {
            this.priority = priority;
        }
    }
}
