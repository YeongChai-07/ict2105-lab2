package course.labs.activitylab;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.content.Context;

public class ActivityTwo extends Activity {

	// Use these as keys when you're saving state between reconfigurations
	private static final String RESTART_KEY = "restart";
	private static final String RESUME_KEY = "resume";
	private static final String START_KEY = "start";
	private static final String CREATE_KEY = "create";

	// String for LogCat documentation
	private final static String TAG = "Lab-ActivityTwo";

    Activity currAcvty = this;

	// Lifecycle counters
    private static int lifeCycle_Count = 0;

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
	// named  mTvCreate, mTvRestart, mTvStart, mTvResume.
	// for displaying the current count of each counter variable
    private static TextView mTvCreate;
    private static TextView mTvRestart;
    private static TextView mTvStart;
    private static TextView mTvResume;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_two);

		// TODO: Assign the appropriate TextViews to the TextView variables
		// Hint: Access the TextView by calling Activity's findViewById()
		// textView1 = (TextView) findViewById(R.id.textView1);
        mTvCreate = (TextView)findViewById(R.id.create);
        mTvRestart = (TextView) findViewById(R.id.restart);
        mTvResume = (TextView) findViewById(R.id.resume);
        mTvStart = (TextView) findViewById(R.id.start);
        mCreate +=1;
        displayCounts();



		
		
		
		Button closeButton = (Button) findViewById(R.id.bClose); 
		closeButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				// TODO:
				// This function closes Activity Two
				// Hint: use Context's finish() method
                currAcvty.finish();

				
			
			}
		});

//        Button launchActivityThreeButton = (Button) findViewById(R.id.bLaunchActivityThree);
//        launchActivityThreeButton.setOnClickListener(new OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                // TODO:
//                // Launch Activity Three
//                // Hint: use Context's startActivity() method
//
//                // Create an intent stating which Activity you would like to
//                // start
//
//                // Launch the Activity using the intent
//
//            }
//        });

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

	// Lifecycle callback methods overrides

	@Override
	public void onStart() {
		super.onStart();

		// Emit LogCat message
		Log.i(TAG, "Entered the onStart() method");

		// TODO:
		// Update the appropriate count variable
		// Update the user interface
        mStart+=1;
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

        //LogCat messgaes
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
		// Save counter state information with a collection of key-value pairs
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
		mTvResume.setText("onResume() calls: " + mResume);
		mTvRestart.setText("onRestart() calls: " + mRestart);
	
	}
}