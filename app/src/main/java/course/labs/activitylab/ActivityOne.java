package course.labs.activitylab;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ActivityOne extends Activity {

	// Use these as keys when you're saving state between reconfigurations
	private static final String RESTART_KEY = "restart";
	private static final String RESUME_KEY = "resume";
	private static final String START_KEY = "start";
	private static final String CREATE_KEY = "create";

	// String for LogCat documentation
	private final static String TAG = "Lab-ActivityOne";
    private final Context currContext = this;

	// Lifecycle counters

	// TODO:
	// Create variables named
	// mCreate, mRestart, mStart and mResume
	// to count calls to onCreate(), onRestart(), onStart() and
	// onResume(). These variables should not be defined as static.
    private int mCreate = 0;
    private int mStart = 0;
    private int mRestart = 0;
    private int mResume = 0;

	// You will need to increment these variables' values when their
	// corresponding lifecycle methods get called.

	// TODO: Create variables for each of the TextViews
	// named mTvCreate, mTvRestart, mTvStart, mTvResume.
	// for displaying the current count of each counter variable

    private static TextView mTvCreate = null;
    private static TextView mTvRestart = null;
    private static TextView mTvStart = null;
    private static TextView mTvResume = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_one);

		// TODO: Assign the appropriate TextViews to the TextView variables
		// Hint: Access the TextView by calling Activity's findViewById()
        // textView1 = (TextView) findViewById(R.id.textView1);

        mTvCreate = (TextView) findViewById(R.id.create);
        mTvRestart = (TextView) findViewById(R.id.restart);
        mTvResume = (TextView) findViewById(R.id.resume);
        mTvStart = (TextView) findViewById(R.id.start);

        mCreate+=1;

        displayCounts();

		Button launchActivityTwoButton = (Button) findViewById(R.id.bLaunchActivityTwo);
		launchActivityTwoButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO:
				// Launch Activity Two
                //Intent launchTwo = new Intent
				// Hint: use Context's startActivity() method

				// Create an intent stating which Activity you would like to
				// start

                //Intent to_AcvtyTwo = new Intent(v.getContext(), ActivityTwo.class);
				Intent to_AcvtyTwo = new Intent(currContext,ActivityTwo.class);

				// Launch the Activity using the intent
                currContext.startActivity(to_AcvtyTwo);
			}
		});

		// Has previous state been saved?
		if (savedInstanceState != null) {

			// TODO:
			// Restore value of counters from saved state
			// Only need 4 lines of code, one for every count variable
			
			mCreate = savedInstanceState.getInt(CREATE_KEY);
			mRestart = savedInstanceState.getInt(RESTART_KEY);
			mResume = savedInstanceState.getInt(RESUME_KEY);
			mStart = savedInstanceState.getInt(START_KEY);

		}

		// Emit LogCat message
		Log.i(TAG, "Entered the onCreate() method");

		// TODO:
		// Update the appropriate count variable
		// Update the user interface via the displayCounts() method

	}

	// Lifecycle callback overrides

	@Override
	public void onStart() {
		super.onStart();

		// Emit LogCat message
		Log.i(TAG, "Entered the onStart() method");

		// TODO:
		// Update the appropriate count variable
		// Update the user interface
        mStart +=1;

        displayCounts();

	}

	@Override
	public void onResume() {
		super.onResume();

		// Emit LogCat message
		Log.i(TAG, "Entered the onResume() method");

		// TODO:
		// Update the appropriate count variable
		// Update the user interface
        mResume+=1;
        displayCounts();

	}

    // TODO:
    // Override the onPause() callback here
    // call the superclass onPause()
    // Uncomment and e mit the LogCat Message with the following line
    // Log.i(TAG, "Entered the onPause() method");
    @Override
    public void onPause()
    {
        super.onPause();

        //Logcat Messages
        Log.i(TAG, "Entered the onPause() method");
    }

    // TODO:
    // Override the onStop() callback here
    // call the superclass onStop()
    // Uncomment and e mit the LogCat Message with the following line
    // Log.i(TAG, "Entered the onPause() method");
    @Override
    public void onStop()
    {
        super.onStop();

        //LogCat messgaes
        Log.i(TAG, "Entered the onStop() method");
    }


	@Override
	public void onRestart() {
		super.onRestart();

		// Emit LogCat message
		Log.i(TAG, "Entered the onRestart() method");

		// TODO:
		// Update the appropriate count variable
		// Update the user interface
        mRestart+=1;
        displayCounts();

	}

	@Override
	public void onDestroy() {
		super.onDestroy();

		// Emit LogCat message
		Log.i(TAG, "Entered the onDestroy() method");
	}

	@Override
	public void onSaveInstanceState(Bundle savedInstanceState) {
		// TODO:
		// Save state information with a collection of key-value pairs
		// 4 lines of code, one for every count variable
		
		savedInstanceState.putInt(CREATE_KEY,mCreate);
		savedInstanceState.putInt(RESTART_KEY, mRestart);
		savedInstanceState.putInt(RESUME_KEY, mResume);
		savedInstanceState.putInt(START_KEY, mStart);
		
		super.onSaveInstanceState(savedInstanceState);
	}

	// Updates the displayed counters
	// This method expects that the counters and TextView variables use the
	// names specified above
	public void displayCounts() {

        mTvCreate.setText("onCreate() calls: " + mCreate);
        mTvStart.setText("onStart() calls: " + mStart);
        mTvRestart.setText("onRestart() calls: " + mRestart);
        mTvResume.setText("onResume() calls: " + mResume);

	}
}