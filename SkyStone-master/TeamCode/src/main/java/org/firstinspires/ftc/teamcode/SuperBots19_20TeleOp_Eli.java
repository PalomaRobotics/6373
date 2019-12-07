package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;


@TeleOp(name = "SuperBots19_20TeleOp_Eli",group = "TeleOp")
//@Disabled
public class SuperBots19_20TeleOp_Eli extends OpMode{
    private DcMotor LFD = null;
    private DcMotor RFD = null;
    private DcMotor LBD = null;
    private DcMotor RBD = null;
    private DcMotor pinion = null;
    private DcMotor drawerSlide = null;
    private double dir;
    private double minDir;
    private double maxDir;

    public void init()
    {
        LFD = hardwareMap.get(DcMotor.class,"FL");
        RFD = hardwareMap.get(DcMotor.class,"FR");
        LBD = hardwareMap.get(DcMotor.class,"BL");
        RBD = hardwareMap.get(DcMotor.class,"BR");
        pinion = hardwareMap.get(DcMotor.class,"pinion");
        drawerSlide = hardwareMap.get(DcMotor.class,"drawerSlide");
        dir = drawerSlide.getCurrentPosition();
        minDir = dir ;
        maxDir = dir + 400;

    }
    public void loop()
    {
        // Gets user input from joysticks and moves wheel motors accordingly
        Drive();
        //Move
        MoveClaw();
        //gets input
        MoveLift();
    }
    private void MoveLift()
    {

        if(gamepad1.dpad_up&&dir<maxDir)
        {
            dir+=0.1;
        }
        if(gamepad1.dpad_down&&dir>minDir)
        {
            dir-=0.1;
        }
        drawerSlide.setTargetPosition((int)dir);
        telemetry.addData("dpad up",gamepad1.dpad_up);
        telemetry.addData("dpad down",gamepad1.dpad_down);
        telemetry.addData("dir",dir);
        telemetry.addData("minDir",minDir);
        telemetry.addData("maxDir",maxDir);
        telemetry.update();

    }
    private void MoveClaw()
    {

    }
    private void Drive()
    {


        //get input
        double inx = (double)gamepad1.left_stick_x;
        double iny = (double)gamepad1.left_stick_y;
        double inRotation = (double)gamepad1.right_stick_x;

        //calculate powers
        double[] dirs = HolonomicDrive.RoboMoveXY(inx,iny);
        double[] rotToAdd = HolonomicDrive.RoboRotate(inRotation);

        //average values
        for(int i=0;i<rotToAdd.length;i++)
        {
            dirs[i]=(dirs[i]+rotToAdd[i])/2;
        }
        //decreases power if fine control btn is presses
        if(gamepad1.y)
        {
            for(int i=0;i<dirs.length;i++)
            {
                dirs[i]=dirs[i]/4;
            }
        }


        //set power for motors
        LFD.setPower(dirs[0]);
        RFD.setPower(dirs[1]);
        LBD.setPower(dirs[2]);
        RBD.setPower(dirs[3]);

    }
}
