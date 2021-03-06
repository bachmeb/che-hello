import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;

public class DukesPinApplet extends Applet implements ItemListener {
	
	DukesPin myDuke;
	String action;
	Checkbox showPin;
	Graphics g;
	
	public void init(){
		Choice actionList = new Choice();
		actionList.add("wave");
		actionList.add("think");
		actionList.add("write");
		
		//add the applet, itself, as an item listener to the Choice actionList
		actionList.addItemListener(this);
		//add the Choice to the applet, so that it is displayed on the UI
		add(actionList);
		
		//make a new DukesPin, which is-a Dukes by extension
		myDuke=new DukesPin();
		//get the String actionImage from the new Duke and assign it to the action attribute of this applet
		action = myDuke.getActionImage();
		
		//make a new checkbox
		Checkbox changeMood = new Checkbox("Angry", myDuke.isAngry());
		//add the checkbox to the applet
		add(changeMood);
		//add this applet as an item listener to the Checkbox object
		changeMood.addItemListener(this);
		
		//make another Checkbox
		showPin = new Checkbox("ShowPin");
		//add the checkbox to the applet
		add(showPin);
		//add the applet to the Checkbox as a listener
		showPin.addItemListener(this);
		
	}
	
	public void paint(Graphics g){
		//make the Graphics object given to the paint method an attribute of the applet
		this.g = g;
		//make an image
		Image actionChoice = getImage(getDocumentBase(), action);
		//draw some stuff on the graphics object
		g.drawString(myDuke.getAction(),10,165);
		g.drawString(myDuke.getMessage(),10, 180);
		g.drawImage(actionChoice, 20, 50, Color.white, this);
		
		g.drawString(myDuke.getAngryMessage(),  110,  140);
		//call the makePin() method if the showingPin attribute of the Duke is true
		if (myDuke.isShowingPin()) makePin();
		else clearPin();
		
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ItemListener#itemStateChanged(java.awt.event.ItemEvent)
	 */
	public void itemStateChanged(ItemEvent evt){
		//this method will get called by any of the objects to which this applet has been added as a listener
		//use a series of ifs and an else to decide which object sent the event and then decide what to do
		if (evt.getItem().toString() == "Angry")
		{
			//if the Checkbox object sending the event was called "Angry" when it was created 
			//call the setMood method of the Duke
			myDuke.setMood();
			//if the Duke isn't angry, set the state of the Checkbox object to false
			if (!myDuke.isAngry()) showPin.setState(false);		
		}
		else if (evt.getItem().toString() == "ShowPin")
		{
			myDuke.switchShowingPin();
			if(showPin.getState() && !myDuke.isAngry()) showPin.setState(false);
		}
		else
		{
			//if neither the Angry Choice object nor the ShowPin Choice object sent the event
			//then it was the Choice list
			//cast the selectable item from the event into a Choice, and get the selected index of the choice
			int which = ((Choice)evt.getItemSelectable()).getSelectedIndex();
			switch (which){
			case 0: action= myDuke.wave(); break;
			case 1: action= myDuke.think(); break;
			case 2: action= myDuke.write(); break;
			}
			
		}
		//repaint the applet
		repaint();
	}
	
	private void clearPin() {
		// change the pen color
		g.setColor(Color.white);
		// fill an oval the same shape as the pin
		g.fillOval(120, 50, 80, 80);
		
	}

	private void makePin() {
		//
		PinImages images = new PinImages();
		//make pin
		g.setColor(Color.red);
		g.fillOval(120, 50, 80, 80);
		//put something in Pin
		g.setColor(Color.white);
		g.drawString("I", 155, 70);
		images.drawHeart(g, Color.pink, 145, 75, 25);
		g.setColor(Color.white);
		g.drawString("Duke!", 145, 120);
		
		
	}

}
