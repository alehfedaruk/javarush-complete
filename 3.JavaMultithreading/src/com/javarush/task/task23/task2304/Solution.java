package com.javarush.task.task23.task2304;

/*
Inner 3
*/
public class Solution {

//    private List<Task> tasks;
//    private List<String> names;
//
//    private DbDataProvider taskDataProvider = new TaskDataProvider();
//    private DbDataProvider nameDataProvider = new NameDataProvider();
//
//    public void refresh() {
//        Map taskCriteria = MockView.getFakeTaskCriteria();
//        taskDataProvider.refreshAllData(taskCriteria);
//
//        Map nameCriteria = MockView.getFakeNameCriteria();
//        nameDataProvider.refreshAllData(nameCriteria);
//    }
//
//    private interface DbDataProvider<T> {
//        void refreshAllData(Map criteria);
//    }
//
//    class Task {
//    }

    public static void main(String[] args) {
        String string = "myWorldmymyMY";
        int c = (string.length() - string.replace("my", "").length()) / "my".length();
        System.out.println(c);
    }
}
