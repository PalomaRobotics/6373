package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

import java.util.Base64;

@TeleOp(name = "Superbots2019Teleop", group = "TeleOp")
public class SuperBots2019 extends OpMode {
    private Servo servo180Lift = null;
    private Servo servo180Claw = null;
    private DcMotor LFD = null;
    private DcMotor RFD = null;
    private DcMotor LBD = null;
    private DcMotor RBD = null;
    private DcMotor drawerSlide = null;
    private DcMotor pinion = null;
    private DcMotor base = null;
    private int countPinion;
    private int countSlide;
    double MINDIRPINION;
    double MAXDIRPINION;
    double MINDIRSLIDE;
    double MAXDIRSLIDE;
    int g2LB;
    int g2RB;
    int g2RT;
    int g2LT;
    double servoLocation = 0.60;

    public void init() {
        servo180Claw = hardwareMap.servo.get("HalfServoClaw");
        servo180Lift = hardwareMap.servo.get("HalfServoLift");
        LFD = hardwareMap.get(DcMotor.class, "FL");
        RFD = hardwareMap.get(DcMotor.class, "FR");
        LBD = hardwareMap.get(DcMotor.class, "BL");
        RBD = hardwareMap.get(DcMotor.class, "BR");
        base = hardwareMap.get(DcMotor.class, "Base");
        drawerSlide = hardwareMap.get(DcMotor.class, "drawerSlide");
        pinion = hardwareMap.get(DcMotor.class, "pinion");
        drawerSlide.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        pinion.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        servo180Lift.setPosition(servoLocation);
        base.setDirection(DcMotor.Direction.REVERSE);
        countPinion = 0;
        countSlide= 0;
        g2LB = 0;
        g2RB = 0;
        g2RT = 0;
        g2LT = 0;

        MINDIRPINION = pinion.getCurrentPosition();
        MAXDIRPINION = pinion.getCurrentPosition()+1000; //1000
        MINDIRSLIDE = drawerSlide.getCurrentPosition();
        MAXDIRSLIDE = drawerSlide.getCurrentPosition()+1200; //1200
    }

    public void loop() {


        //get input
        double inx = (double) gamepad1.left_stick_x;
        double iny = (double) gamepad1.left_stick_y;
        double inRotation = (double) gamepad1.right_stick_x;

        //calculate powers
        double[] dirs = HolonomicDrive.RoboMoveXY(inx, iny);
        double[] rotToAdd = HolonomicDrive.RoboRotate(inRotation);

        for (int i = 0; i < rotToAdd.length; i++) {
            dirs[i] = (dirs[i]*.5 + rotToAdd[i]*2);
        }
        double highestvalue = 0;
        int highestindex = 0;

        //
        //max speed while maintaining ratio
        //

        //find index of highest value
        for (int i = 0; i < 4; i++) {
            if (Math.abs(dirs[i]) > highestvalue) {
                highestvalue = Math.abs(dirs[i]);
            }
        }
        //make highest value 1 and change others accordingly
        if (highestvalue != 0) {
            for (int i = 0; i < 4; i++) {
                dirs[i] = dirs[i] / highestvalue;
            }
        }



        LFD.setPower(dirs[0] * (1 - (gamepad1.left_trigger * .9))); //scale joysticks by 90% of the amount of the left trigger
        RFD.setPower(dirs[1] * (1 - (gamepad1.left_trigger * .9)));
        LBD.setPower(dirs[2] * (1 - (gamepad1.left_trigger * .9)));
        RBD.setPower(dirs[3] * (1 - (gamepad1.left_trigger * .9)));

        if (((gamepad2.right_trigger > 0.4)&&countPinion<5)&& g2RT == 0) //if you push the right stick down it will lower the lift....
        {
            EncoderClass.RunToEncoderDegreeAsync(pinion, EncoderClass.MotorType.NeveRest60, 60, 0.65, false);
            countPinion++;
            g2RT = 1;
        }
        if ((g2RT == 1)&&(gamepad2.right_trigger < 0.4))
        {
           g2RT = 0;
        }
        if (((gamepad2.left_trigger > 0.4)&&countPinion>0)&& g2LT == 0) //if you push the right stick down it will lower the lift....
        {
            EncoderClass.RunToEncoderDegreeAsync(pinion, EncoderClass.MotorType.NeveRest60, -60, 0.65, false);
            countPinion--;
            g2LT = 1;
        }
        if ((g2LT == 1)&&(gamepad2.left_trigger < 0.4))
        {
            g2LT = 0;
        }
        if (((gamepad2.right_bumper)&&countSlide<7)&& g2RB == 0) //if you push the right stick down it will lower the lift....
        {
            EncoderClass.RunToEncoderDegreeAsync(drawerSlide, EncoderClass.MotorType.NeveRest40, 60, 0.65, false);
            countSlide++;
            g2RB = 1;
        }
        if ((g2RB == 1)&&(!(gamepad2.right_bumper)))
        {
            g2RB = 0;
        }
        if (((gamepad2.left_bumper&&countSlide>0))&& g2LB == 0) //if you push the right stick down it will lower the lift....
        {
            EncoderClass.RunToEncoderDegreeAsync(drawerSlide, EncoderClass.MotorType.NeveRest40, -60, 0.65, false);
            countSlide --;
            g2LB = 1;
        }
        if ((g2LB == 1)&&(!(gamepad2.left_bumper)))
        {
            g2LB = 0;
        }

        if (gamepad2.dpad_down) {
            EncoderClass.RunToEncoderDegreeAsync(drawerSlide, EncoderClass.MotorType.NeveRest40, -countSlide*60, 0.50, false);
        }

        if (gamepad2.dpad_left) {
            EncoderClass.RunToEncoderDegreeAsync(pinion, EncoderClass.MotorType.NeveRest60, -countPinion*60, 0.60, false);
        }

        if (gamepad1.a) {
            base.setPower(0.06);
        }
        if (gamepad1.b) {
            base.setPower(-.06);
        }
        if (!(gamepad1.a) && !(gamepad1.b)) {
            base.setPower(0);
        }

        //double servoLocation = servo180Lift.getPosition();

        if(gamepad2.y && servoLocation  < .73)
        {
            servoLocation += 0.01;
            servo180Lift.setPosition(servoLocation);
        }

        if(gamepad2.a && servoLocation > 0)
        {
            servoLocation -= 0.01;
            servo180Lift.setPosition(servoLocation);
        }

        //servo180Lift.setPosition(servoLocation);
        if (gamepad2.dpad_up)
        {
            servo180Claw.setPosition(0.39);
        }
        if (gamepad2.x) {
            servo180Claw.setPosition(0.42);
        }
        if (gamepad2.b) {
            servo180Claw.setPosition(0.0); //setPosition is for 180 servos. value of 0 is starting position
        }

        telemetry.addData("left Y", gamepad2.left_stick_y);
        telemetry.addData("right Y", gamepad2.right_stick_y);
        telemetry.update();
    }
}
/*
---GOALS FOR THE FIRST WEEKEND OF NOVEMBER 2019:
-Planning to make the arm work with a second controller because the amount of controls for the
driver of the robot to manage wouldn't be very efficient in a small time period with the stress.

--As of Saturday at 5:46 pm, I have added code to (hopefully) make the arm work with one controller
and still working on making the servos work the correct way and not break the claw.
-Trying to figure out how the joystick can be programmed to make the arm work, instead of using plain
values to make it more realistic in a competitive atmosphere.
-If I can figure that out, then I will make the controllers independent from each other so that
one person can drive the robot and the other can operate the arm so it is more manageable.
-For now I will make the code work with the code already set here and then modify it later on with
two controllers if it works well.

--Sunday, 8:08 am, went to sleep and woke up with a realization that the servo might not have been set
at its starting point == and that is probably why it wasnt working properly yesterday.
--Planning to mount the motor with a second motor mount onto the base that makes the pinion work.
-I realized that the motor is not supported properly and I need to make sure that it isn't a mechanical
issue.
- Going to go test code to get the servo for the claw to open and close to work, trial and error
is my best option.
- I am going to figure out what the minimum and maximum value that the servo can go to with this
claw's design.

--Sunday 8:23 am, Tested the code for the servo and found that setting it to a position of .20
makes it go to its 36 degree mark and that is right about in the middle of the servo's turning area.
- Going to continue to try and find the minimum and maximum values now that I have that information.
PS: The code I am currently doing is for the servo that opens and closes the claw and not the one that
makes it rotate up and down.
-Min:0
-Max:

--Sunday 1:27 pm, Took apart the claw after quickly realizing that when the servo was put on the claw,
it was not at the starting position of the area it can turn through (0-180 degrees) so I took the servo
off the claw and coded it to start at 0 degrees when the claw is at its most open point.

--Monday 8:49 AM, as of now the weekend is over and various things got done.
1. Claw was taken apart and put back together with the servo in the proper starting position.
2. The claw needs to have values inputted in order for the robot to properly grab blocks, but it should
work properly when it's servo is replaced.
3. The servo that rotates the claw up and down needs to be replaced, or the wire needs to be fixed.
4. The wheels still need the updated holonomic code to work properly.
5. The pinion motor needs a second mount so that it will hold it in the correct position and not
be set at an angle. (I believe this is the reason that it has not been working properly.
6. I plan to drill holes in the base to put wires under the robot's arm and then go up to the motor
controller on the right side of the robot.
7. The robot now requires two drivers to work properly, I did this because there were too many controls
for one person to manage, so now one person will drive and the other person will use the arm.
8. I haven't tested the new code for the arm yet, I made it so that it should work with the joysticks
on gamepad 2.
9. I need some help figuring out why the claw's servos don't work independently, and do the same thing
when I have them both powered.






---Weekend of November 8-11
*/