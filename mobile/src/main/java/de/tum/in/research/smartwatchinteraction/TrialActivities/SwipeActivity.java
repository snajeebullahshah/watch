package de.tum.in.research.smartwatchinteraction.TrialActivities;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import de.tum.in.research.smartwatchinteraction.R;
import de.tum.in.research.smartwatchinteraction.messaging.MessageThread;

/**
 * Created by janosch on 06.07.15.
 */
public class SwipeActivity extends TrialActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        headingTextView.setText(R.string.swipe_notification);

    }

    public boolean createNotification(View view) {
        // Do not send more notification
        if (!super.createNotification(view)) {
            return false;
        }
        if(mGoogleApiClient.isConnected()) {
            MessageThread t = new MessageThread(mGoogleApiClient, getResources().getString(R.string.swipe_notification), locations[counter]);
            participant.startCounter();
            t.start();
        } else {
            Toast.makeText(this, "Wear not connected", Toast.LENGTH_LONG).show();
        }
        counter++;
        activateForwardButtonIfCounterAboveThree();
        return true;
    }

}
