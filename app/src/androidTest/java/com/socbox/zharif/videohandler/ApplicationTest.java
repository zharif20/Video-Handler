package com.socbox.zharif.videohandler;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.media.AudioManager;
import android.test.ActivityInstrumentationTestCase2;
import android.test.UiThreadTest;
import android.test.suitebuilder.annotation.SmallTest;
import android.view.SurfaceView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

/**
 *
 * 
 * Claritas: ‘Clarity through innovation’
 *
 * Unit Test Script
 *
 * Project: SocBox
 *
 * Module: VideoHandler
 *
 * Test Script Name: ApplicationTest.java
 *
 * Associated Code File Name: VideoHandler.java
 *
 * Description: This class tests the functionality of the streaming the video and the
 * requirements found in the User Stories and Design Specification.
 *
 * Initial Authors: Muhammad Zharif Hadi
 *                  Davide Reteif
 *
 * Change History:
 * Version: 0.1
 *
 * Author: Muhammad Zharif Hadi
 *
 *
 * Change: Created original version
 *
 * Date: 20/03/15
 *
 * User Story Traceability:
 *
 * Tag(s): D/VMF – Entire Module
 *
 * Requirements in not covered by test script:
 * D/VMF/01-17/01:
 *
 * Justification: Not able to be unit tested. HMI testing complete
 *
 *
 *
 */

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ActivityInstrumentationTestCase2<callVideoHandler> {
    public Activity activity;

    public ApplicationTest() {
        super(callVideoHandler.class);
    }

    protected void setUp() throws Exception {
        super.setUp();
        setActivityInitialTouchMode(false);
        activity = getActivity();
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }

    @SmallTest
    public void testVidURL(){
        final String   vidUrl = "http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4";

        VideoHandler videoHandler = new VideoHandler(activity, vidUrl);

        assertEquals(vidUrl, videoHandler.vidUrl);
    }

    @UiThreadTest
    public void testButton(){
//        assertNotNull(activity);

        final String   vidUrl = "http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4";

        VideoHandler videoHandler = new VideoHandler(activity, vidUrl);

        videoHandler.playMedia = (ImageButton)this.activity.findViewById(R.id.buttonPlay);

        videoHandler.stopMedia = (ImageButton)this.activity.findViewById(R.id.buttonStop);

        videoHandler.muteMedia = (ImageButton)this.activity.findViewById(R.id.buttonMute);

        videoHandler.fullscreenMedia = (ImageButton)this.activity.findViewById(R.id.buttonFullScreen);

        videoHandler.seekBar = (SeekBar)this.activity.findViewById(R.id.seekBarMedia);

        videoHandler.currentTimeLabel = (TextView)this.activity.findViewById(R.id.currentTime);

        videoHandler.totalTimeLabel = (TextView)this.activity.findViewById(R.id.totalTime);

        assertNotNull(videoHandler.playMedia);
        assertNotNull(videoHandler.stopMedia);
        assertNotNull(videoHandler.muteMedia);
        assertNotNull(videoHandler.fullscreenMedia);
        assertNotNull(videoHandler.seekBar);
        assertNotNull(videoHandler.currentTimeLabel);
        assertNotNull(videoHandler.totalTimeLabel);
    }

//    @UiThreadTest
//    public void testPlayPauseButtonFunctionality(){
//        final String   vidUrl = "http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4";
//
//        VideoHandler videoHandler = new VideoHandler(activity, vidUrl);
//
//        videoHandler.playMedia = (ImageButton)this.activity.findViewById(R.id.buttonPlay);
//
//        videoHandler.mPlayer.start();
//
//        videoHandler.setPlayPause();
//
//        videoHandler.playMedia.performClick();
//        assertEquals(false, videoHandler.mPlayer.isPlaying());
//    }

//    @UiThreadTest
//    public void testReplayButtonFunctionality(){
//        VideoHandler videoHandler = new VideoHandler(activity);
//
//        videoHandler.stopMedia = (ImageButton)this.activity.findViewById(R.id.buttonStop);
//
//        videoHandler.mPlayer.stop();
//        videoHandler.mPlayer.start();
//
//        videoHandler.stopMedia.performClick();
//        assertEquals(videoHandler.mPlayer.isPlaying(), videoHandler.deletePlayer());
//
//    }

//    @UiThreadTest
//    public void testDragOnProgressBar(){
//        VideoHandler videoHandler = new VideoHandler(activity);
//
//        videoHandler.seekBar = (SeekBar)this.activity.findViewById(R.id.seekBarMedia);
//
//        this.activity.setProgress(100);
//
//        videoHandler.seekBar.
//
//
//    }

    @UiThreadTest
    public void testFullscreenButtonFunctionality(){
        final String   vidUrl = "http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4";

        VideoHandler videoHandler = new VideoHandler(activity, vidUrl);

        videoHandler.fullscreenMedia = (ImageButton)this.activity.findViewById(R.id.buttonFullScreen);

        this.activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        videoHandler.fullscreenMedia.performClick();
        assertEquals(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE, this.activity.getChangingConfigurations());

    }

//    @UiThreadTest
//    public void testMuteButtonFunctionality(){
//        final String   vidUrl = "http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4";
//
//        VideoHandler videoHandler = new VideoHandler(activity, vidUrl);
//
//        videoHandler.muteMedia = (ImageButton)this.activity.findViewById(R.id.buttonMute);
//        videoHandler.audioManager = (AudioManager)this.activity.getSystemService(Context.AUDIO_SERVICE);
//
//        videoHandler.audioManager.setStreamMute(AudioManager.STREAM_MUSIC,false);
//
//        videoHandler.muteMedia.performClick();
//        assertEquals(true, videoHandler.audioManager.getStreamVolume(AudioManager.STREAM_MUSIC) == 0);
//
//    }

//    @UiThreadTest
//    public void testControlVisibility() {
//        final String   vidUrl = "http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4";
//
//        VideoHandler videoHandler = new VideoHandler(activity, vidUrl);
//
//        videoHandler.surfaceView = (SurfaceView) this.activity.findViewById(R.id.surface);
//        videoHandler.container = (RelativeLayout)this.activity.findViewById(R.id.mainRelativeLayout);
//
//        videoHandler.container.setVisibility(View.VISIBLE);
//
//        videoHandler.surfaceView.performClick();
//        assertEquals(View.GONE, videoHandler.container.getVisibility());
//    }

}
