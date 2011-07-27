package org.demo;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

/**
 * Simple {@link Activity} that demonstrates the use of frame animation to 
 * perform simple animation. When running the example, click on the rocket to
 * start the animation. Click on it again to stop the animation.  
 * 
 * @author Kah
 */
public class AnimationActivity extends Activity {
	
	/**
	 * Click listener that will start and stop the animation of the arrow.
	 */
	private final OnClickListener trigger = new OnClickListener() {

		@Override
		public void onClick(View v) {
			
			final AnimationDrawable animation = (AnimationDrawable) arrowView.getDrawable();
			
			if (arrowView.getVisibility() != View.VISIBLE) {
				arrowView.setVisibility(View.VISIBLE);
			}

			if (animation.isRunning()) {
				animation.stop();
			} else {
				animation.start();
			}
		}
	};
	
	private ImageView arrowView;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rocket);
        arrowView = (ImageView) findViewById(R.id.uparrowImage);
        
        registerView(R.id.rocketImage);
        registerView(R.id.uparrowImage);
    }
    
	/**
	 * Sets up the click listener for the view with the provided id so that the
	 * flash is triggered when the view is clicked.
	 * 
	 * @param viewId
	 *            the id of the view to set up the listener on
	 */
	private void registerView(int viewId) {
		View view = findViewById(viewId);
		view.setClickable(true);
		view.setOnClickListener(trigger);
	}
}