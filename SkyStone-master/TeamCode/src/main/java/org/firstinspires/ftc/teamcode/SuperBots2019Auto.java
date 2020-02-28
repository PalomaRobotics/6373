package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
@Autonomous(name="Superbots2019Auto", group = "Autonomous" )
public class SuperBots2019Auto extends LinearOpMode {
    private DcMotor LFD = null;
    private DcMotor RFD = null;
    private DcMotor LBD = null;
    private DcMotor RBD = null;

    int dir1 = 81;//depending on the value of these two variables, the robot will move in the
    int dir2 = 101;//direction of dir1 for a certain time, and dir2 for a certain time.

    /*Before I forget, I am going to use the variable "time" with telemetry to figure out how many
    total times, roughly, that the code runs and I will divide the seconds by the amount of times
    that the code updates the value of time. Time/30= time/s and I can use that for the rest of the
    coding for the time that the wheels will turn in each direction.

    */
    public void runOpMode() {
        LFD = hardwareMap.get(DcMotor.class, "FL");
        RFD = hardwareMap.get(DcMotor.class, "FR");
        LBD = hardwareMap.get(DcMotor.class, "BL");
        RBD = hardwareMap.get(DcMotor.class, "BR");
        int count = 1;
        int count2 = 0;
        int count3 = 0;
        int count4 = 0;
        waitForStart();
        while(opModeIsActive())
        {
            if (count == 1)
            {
                EncoderClass.RunToEncoderDegreeAsync(LFD, EncoderClass.MotorType.NeveRest40, 180, 0.25, false);
                EncoderClass.RunToEncoderDegreeAsync(RFD, EncoderClass.MotorType.NeveRest40, 180, 0.25, false);
                count2 = 1;
            }
            if (count2 == 1)
            {
                EncoderClass.RunToEncoderDegreeAsync(LFD, EncoderClass.MotorType.NeveRest40, -300, 0.25, false);
                EncoderClass.RunToEncoderDegreeAsync(RFD, EncoderClass.MotorType.NeveRest40, -300, 0.25, false);
            }
        }
        /*

        double[] dirs = {0,0,0,0};
        waitForStart();
        while (opModeIsActive() && elapsedTime.seconds() < 10)
        {
            telemetry.addData("time", elapsedTime.seconds());

            while(elapsedTime.seconds()<3)
            {
                dirs = HolonomicDrive.RoboMoveXY(0, -1);
                LFD.setPower(dirs[0]);
                RFD.setPower(dirs[1]);
                LBD.setPower(dirs[2]);
                RBD.setPower(dirs[3]);
            }
        }



        while (elapsedTime.seconds()<3)
        {
            dirs = HolonomicDrive.RoboMoveXY(-1, 0);
            LFD.setPower(dirs[0]);
            RFD.setPower(dirs[1]);
            LBD.setPower(dirs[2]);
            RBD.setPower(dirs[3]);
        }

    */
    }
}
