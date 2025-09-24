package org.firstinspires.ftc.teamcode.opmodes.auto.big;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.sensors.limelight.Limelight;
import org.firstinspires.ftc.teamcode.utils.hardware.BulkReadManager;

@Autonomous(name = "B. Auto Small Triangle", preselectTeleOp = "A. Teleop")
public final class AutoSmall extends LinearOpMode {

        // declare
        private BulkReadManager bulkReadManager;

        private Limelight camera;

        // helper functions or repeated funcs go here

        @Override
        public void runOpMode() throws InterruptedException {
                // Initialize BulkReadManager for performance optimization
                bulkReadManager = new BulkReadManager(hardwareMap);

                // Initialize subsystems

                // Initialize command factories


                camera = new Limelight();
                camera.initialize(hardwareMap);
                camera.cameraStart();

                // DISABLED FOR PERFORMANCE: Limelight processing adds ms per loop
                // LimeLightImageTools llIt = new LimeLightImageTools(camera.limelight);
                // llIt.setDriverStationStreamSource();
                // llIt.forwardAll();
                // FtcDashboard.getInstance().startCameraStream(llIt.getStreamSource(), 10);

                // Initialize drive with starting pose


                // Start position


                // Driver Station choose stuff, use Marrow

                waitForStart();

                if (isStopRequested())
                        return;

                // Full autonomous sequence
        }
}