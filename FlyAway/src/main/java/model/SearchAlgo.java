package model;

public class SearchAlgo {
	public static String date;
    public static String day;
    public static String origin;
    public static String destination;
    public static int persons;

    public static String getQuery() {
        return "SELECT * FROM flight WHERE origin = '"+origin+"' AND destination='"
    +destination+"' AND days like '%"+day+"%'";
    }
}
