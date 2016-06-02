package org.usfirst.frc.team578.robot.camera;

import org.usfirst.frc.team578.robot.Robot;
import org.usfirst.frc.team578.robot.RobotMap;

import com.ni.vision.NIVision;
import com.ni.vision.NIVision.Image;

import edu.wpi.first.wpilibj.CameraServer;

/** Graciously borrowed from team 955. **/

public class CameraFeeds {
	private int camForward;
	private int camBackward;
	private int curCam;
	private Image frame;
	private CameraServer server;
	private boolean cameraFail = false;

	public CameraFeeds() {

		try {
			// Get camera ids by supplying camera name ex 'cam0', found on
			// roborio
			// web interface
			camForward = NIVision.IMAQdxOpenCamera(RobotMap.camNameForward, NIVision.IMAQdxCameraControlMode.CameraControlModeController);
			camBackward = NIVision.IMAQdxOpenCamera(RobotMap.camNameBackward, NIVision.IMAQdxCameraControlMode.CameraControlModeController);
			curCam = camForward;
			// Img that will contain camera img
			frame = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);
			// Server that we'll give the img to
			server = CameraServer.getInstance();
			server.setQuality(RobotMap.imgQuality);
		} catch (Exception e) {
			cameraFail = true;
		}
	}

	public void init() {
		if (cameraFail) {
			return;
		}

		try {
			changeCam(camForward);
		} catch (Exception e) {
			cameraFail = true;
		}
	}

	public void run() {
		if (cameraFail) {
			return;
		}

		try {
			if (Robot.oi.getForwardCamera())
				changeCam(camForward);

			if (Robot.oi.getBackwardCamera())
				changeCam(camBackward);

			updateCam();
		} catch (Exception e) {
			cameraFail = true;
		}
	}

	/**
	 * Stop aka close camera stream
	 */
	public void end() {
		if (cameraFail) {
			return;
		}

		try {
			NIVision.IMAQdxStopAcquisition(curCam);
		} catch (Exception e) {
			cameraFail = true;
		}
	}

	/**
	 * Change the camera to get imgs from to a different one
	 * 
	 * @param newId
	 *            for camera
	 */
	public void changeCam(int newId) {

		if (cameraFail) {
			return;
		}

		try {
			NIVision.IMAQdxStopAcquisition(curCam);
			NIVision.IMAQdxConfigureGrab(newId);
			NIVision.IMAQdxStartAcquisition(newId);
			curCam = newId;
		} catch (Exception e) {
			cameraFail = true;
		}
	}

	/**
	 * Get the img from current camera and give it to the server
	 */
	public void updateCam() {

		if (cameraFail) {
			return;
		}

		try {
			NIVision.IMAQdxGrab(curCam, frame, 1);
			server.setImage(frame);
		} catch (Exception e) {
			cameraFail = true;
		}
	}
}