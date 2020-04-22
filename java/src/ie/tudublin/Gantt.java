package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class Gantt extends PApplet
{	
	public ArrayList<Task> tasks = new ArrayList<Task>();

	public void settings()
	{
		size(800, 600);
	}

	public void setup() 
	{
		loadTasks();
		printTasks();
		colorMode(HSB);
	}

	public void loadTasks()
	{
		Table t = loadTable("tasks.csv", "header");
		for (TableRow row:t.rows()){
			Task task = new Task(row);
			tasks.add(task);
		}
	}

	public void printTasks()
	{
		for(Task t:tasks){
			System.out.println(t);
		}
	}
	
	public void mousePressed()
	{
		println("Mouse pressed");	
	}

	public void mouseDragged()
	{
		println("Mouse dragged");
	}

	public void displayTasks(){
		float gap = 19;
		float x = width*.25f;
		float y = 50;
		float x1 = x;
		float numLines = 30;
		float tasksX = 20;
		float tasksY = height *.25f;
		float tasksGap = 50;
		
		for (int i=0; i<numLines; i++){
			//map(x,0,width,width*.25f, width-10);
			text(i+1,x,y-20);
			line(x,y,x1,height-10);

			x += gap;
			x1 += gap;
		}

			//tried to display all the tasks by using the array but couldnt get it to work
			
			// for (Task t:tasks){
			// 	text(t,tasksX,tasksY);
			// 	tasksY += tasksGap;
			// }
			
			//Displaying tasks Manually

			text("Research",tasksX,tasksY);
			text("Design",tasksX,tasksY+tasksGap);
			text("Phase 1",tasksX,tasksY+tasksGap*2);
			text("Phase 2",tasksX,tasksY+tasksGap*3);
			text("Phase 3",tasksX,tasksY+tasksGap*4);
			text("Testing",tasksX,tasksY+tasksGap*5);
			text("Evaluation",tasksX,tasksY+tasksGap*6);
			text("Release",tasksX,tasksY+tasksGap*7);

			float length = 50;
			float drop = 20;
			float rectX = width *.25f;
			//Display rectangles

			
			rect(rectX,tasksY, length, drop);
			rect(rectX+length,tasksY+tasksGap, length, drop);
			rect(rectX+length*2,tasksY+tasksGap*2, length, drop);
			rect(rectX+length*3,tasksY+tasksGap*3, length, drop);
			rect(rectX+length*4,tasksY+tasksGap*4, length, drop);
			rect(rectX+length*5,tasksY+tasksGap*5, length, drop);
			rect(rectX+length*6,tasksY+tasksGap*6, length, drop);
			rect(rectX+length*7,tasksY+tasksGap*7, length, drop);
			
	}
	
	
	
	public void draw()
	{			
		background(0);
		stroke(255);
		displayTasks();
	}
}
