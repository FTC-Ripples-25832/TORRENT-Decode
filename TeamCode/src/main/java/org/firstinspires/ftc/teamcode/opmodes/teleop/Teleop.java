package org.firstinspires.ftc.teamcode.opmodes.teleop;

import static org.firstinspires.ftc.teamcode.opmodes.auto.AutoPaths.SCORE;

import com.qualcomm.hardware.lynx.LynxModule;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.sensors.ColorSensorImpl;
// import org.firstinspires.ftc.teamcode.sensors.limelight.LimeLightImageTools;
import org.firstinspires.ftc.teamcode.sensors.limelight.Limelight;
import org.firstinspires.ftc.teamcode.subsystems.hang.Hanging;
import org.firstinspires.ftc.teamcode.subsystems.slides.LowerSlide;
import org.firstinspires.ftc.teamcode.subsystems.slides.UpperSlide;
import org.firstinspires.ftc.teamcode.utils.ClawController;
import org.firstinspires.ftc.teamcode.utils.GamepadController;
import org.firstinspires.ftc.teamcode.utils.GamepadController.ButtonType;
import org.firstinspires.ftc.teamcode.utils.RobotStateStore;
import org.firstinspires.ftc.teamcode.utils.TelemetryPacket;
import org.firstinspires.ftc.teamcode.utils.control.ConfigVariables;
import org.firstinspires.ftc.teamcode.utils.hardware.BulkReadManager;

import java.util.List;

@TeleOp(group = "TeleOp", name = "A. Teleop")
public class Teleop extends LinearOpMode {

    private static List<LynxModule> allHubs = null;
    private final long starttime = System.currentTimeMillis();

//    private MecanumDrive drive;

    private UpperSlide upSlide;
    private LowerSlide lowSlide;
    private Limelight camera;
    private Hanging hanging;

//    private UpperSlideCommands upslideActions;
//    private LowerSlideCommands lowslideActions;

//    private CommandScheduler scheduler;
    private BulkReadManager bulkReadManager;

//    private FtcDashboard dashboard;
    private long lastDashboardUpdateTime = 0;

    private GamepadController gamepad1Controller;
    private GamepadController gamepad2Controller;

    private ClawController upperClaw;
    private ClawController upperExtendo;
    private ClawController lowerClaw;

    private ColorSensorImpl colorSensor;



    private long loopCount = 0;
    private long lastloop = System.currentTimeMillis();

    @Override
    public void runOpMode() throws InterruptedException {

//        scheduler = CommandScheduler.getInstance();

        initializeSubsystems();

//        dashboard = FtcDashboard.getInstance();
//        Telemetry dashboardTelemetry = dashboard.getTelemetry();
//        mecanumDriveCommand = new MecanumDriveCommand(drive, gamepad1);
//        scheduler.schedule(mecanumDriveCommand);
//        // Schedule loop timing telemetry command
//        scheduler.schedule(new LoopTimeTelemetryCommand());

        while (!isStopRequested() && !opModeIsActive()) {
            TelemetryPacket packet = new TelemetryPacket();
//            scheduler.run(packet);
        }

        waitForStart();

        if (ConfigVariables.General.SINGLE_CONTROLLER_MODE) {
            setupGamepadControlsSingle();
        } else {
            setupGamepadControls();
        }
        setContinuousControls();

        if (isStopRequested())
            return;

        while (opModeIsActive() && !isStopRequested()) {
            loopCount += 1;
            long timestamp = System.currentTimeMillis();
            // PERFORMANCE OPTIMIZATION: Update bulk reads once per loop
            bulkReadManager.updateBulkRead();
//
//            TelemetryPacket packet = new TelemetryPacket();
//            scheduler.run(packet);

//            gamepad1Controller.update();
//            gamepad2Controller.update();

            // update pid in command will cause power error
//            lowSlide.updatePID();
//            upSlide.updatePID();

            // log looptime for checking, when dashboard is not enabled
            if (loopCount % 20 == 0) {
                telemetry.addData("looptimems", (timestamp - lastloop));
                telemetry.addData("avglooptimems", (timestamp - starttime) / (double) loopCount);
                telemetry.update();
            }
            lastloop = timestamp;

            // only send packet if in debug mode
            if (ConfigVariables.General.DEBUG_MODE
                    && timestamp - lastDashboardUpdateTime >= ConfigVariables.General.DASHBOARD_UPDATE_INTERVAL_MS) {
//                packet.put("gamepad1/NoOperationTimems", gamepad1Controller.getNoOperationTime());
//                packet.put("gamepad2/NoOperationTimems", gamepad2Controller.getNoOperationTime());
//                packet.put("colorsensor/caught", colorSensor.caught());
//                packet.put("colorsensor/cantransfer", colorSensor.canTransfer());
//                dashboard.sendTelemetryPacket(packet);
//                lastDashboardUpdateTime = timestamp;
            }

        }
        cleanup();
    }

    private void cleanup() {
//        scheduler.cancelAll();
//        upSlide.stop();
//        lowSlide.stop();
//        scheduler.reset();
    }

    private void initializeSubsystems() {
        // inits here

        // dashboard has LL streaming now
        // only enable limelight forward if in debug mode
        // if(ConfigVariables.General.DEBUG_MODE){
        // LimeLightImageTools llIt = new LimeLightImageTools(camera.limelight);
        // llIt.setDriverStationStreamSource();
        // llIt.forwardAll();
        // }

        // starting pos es
    }

    private void setupGamepadControlsSingle() {

    }

    private void setupGamepadControls() {

    }

    private void setContinuousControls() {

    }

}
