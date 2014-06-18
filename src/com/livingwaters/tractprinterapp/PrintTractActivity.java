package com.livingwaters.tractprinterapp;

import android.os.Bundle;
import android.app.Activity;
import android.view.Window;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class PrintTractActivity extends Activity {
	LinearLayout mLinearLayout;
	

	  @Override
	protected void onCreate(Bundle savedInstanceState) {
	  super.onCreate(savedInstanceState);
	  requestWindowFeature(Window.FEATURE_NO_TITLE);
	  // Create a LinearLayout in which to add the ImageView
	  mLinearLayout = new LinearLayout(this);

	  // Instantiate an ImageView and define its properties
	  ImageView i = new ImageView(this);
	  i.setImageResource(R.drawable.tract);
	  i.setAdjustViewBounds(true); // set the ImageView bounds to match the Drawable's dimensions

	  // Add the ImageView to the layout and set the layout as the content view
	  mLinearLayout.addView(i);
	  setContentView(mLinearLayout);
	  //Set an AnimationSet for playing the two actions simultaneously.
	  AnimationSet animSet = new AnimationSet(false);
	//First Animation to pull tract down from top
	  TranslateAnimation transAnimation= new TranslateAnimation(85, 85, -800,75);
	//fromXposition- x coordinate from  where animation should start
	//toXPosition- x coordinate at which animation would end
	//fromYPosition- y coordinate from where animation should start.
	//toYPosition- y coordinate at which animation would end.

	//You can also set duration for the animation that means you can set for how long the animation should last:
	transAnimation.setDuration(9900);
	//Second Animation to move tract out of the screen 
	TranslateAnimation outAnimation= new TranslateAnimation(85, 800, 75,75);
	outAnimation.setStartOffset(9999); //Give us some time before next animation starts
	outAnimation.setDuration(2500);
	
	//You can now apply the animation to a view
	animSet.addAnimation(transAnimation);
	animSet.addAnimation(outAnimation);
	i.startAnimation(animSet);
	animSet.setFillAfter(true);
	//TODO: Set timer or popup window alerting user to print another tract and/or exit?
	  }
}
	  
