package org.firstinspires.ftc.teamcode.opmodes.auto.big;

import static org.firstinspires.ftc.teamcode.opmodes.auto.AutoPaths.PICKUP1;
import static org.firstinspires.ftc.teamcode.opmodes.auto.AutoPaths.PICKUP2;
import static org.firstinspires.ftc.teamcode.opmodes.auto.AutoPaths.PICKUP3;
import static org.firstinspires.ftc.teamcode.opmodes.auto.AutoPaths.SCORE;
import static org.firstinspires.ftc.teamcode.opmodes.auto.AutoPaths.START;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.sensors.limelight.Limelight;
import org.firstinspires.ftc.teamcode.subsystems.slides.LowerSlide;
import org.firstinspires.ftc.teamcode.subsystems.slides.UpperSlide;
import org.firstinspires.ftc.teamcode.utils.control.ConfigVariables;
import org.firstinspires.ftc.teamcode.utils.hardware.BulkReadManager;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Autonomous(name = "A. Auto Big Triangle", preselectTeleOp = "A. Teleop")
public final class AutoBig extends LinearOpMode {

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