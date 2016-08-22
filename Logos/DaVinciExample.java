import project1.daVinci;
import project1.DaVinciFactory;

/*
 * Copyright (c) 2016, Tom Tillinghast. All rights reserved.
 * 
 *
 * DaVinciExample -- a class demonstrating a simple example of the daVinci interface.
 */
public class DaVinciExample {
	public static void drawHalfOfMesa(daVinci d) {
	//Someone else can figure out the other half
		
		
		//Clear all graphics and return home
		d.clear();
		d.home();
		d.pendown();
		
		System.out.println("Gimme an M!");
		d.forward(200);		
		d.rotate(135);
		d.forward(100);
		d.rotate(270);
		d.forward(100);
		d.rotate(135);
		d.forward(200);
		d.rotate(270);
		//Move over for the E
		d.penup();
		d.forward(50);
		
		System.out.println("Gimme an E!");
		d.pendown();
		d.forward(80);
		d.backward(80);
		d.rotate(270);
		d.forward(100);
		d.rotate(90);
		d.forward(50);
		d.backward(50);
		d.rotate(270);
		d.forward(100);
		d.rotate(90);
		d.forward(80);

		//Moonwalk
		System.out.println("Good Enough.  Let's Moonwalk!!");
		d.penup();
		for ( int i=0; i<30; i++)
		  d.backward(10);
		d.pendown();
	}

	public static void main(String[] args) {
		daVinci d = DaVinciFactory.createInstance();
		//Default wait time is 500 milliseconds.
		drawHalfOfMesa(d);
		
		System.out.println("Ok.  Faster Now!");
		d.setWait(200);
		drawHalfOfMesa(d);
	}
}

