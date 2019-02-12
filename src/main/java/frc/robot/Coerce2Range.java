package frc.robot;

public class Coerce2Range {
    
    public static double coerce2Range(double input, double min, double max)
    {
        double inputMin, inputMax, inputCenter;
        double outputMin, outputMax, outputCenter;
        double scale, result, speed;
        double output;
        
        inputMin = min; 
        inputMax = max;
        
        outputMin = -1;
        outputMax = 1;

         /* Determine the center of the input range and output range */
        inputCenter = Math.abs(inputMax - inputMin) / 2 + inputMin;
        outputCenter = Math.abs(outputMax - outputMin) / 2 + outputMin;

        /* Scale the input range to the output range */
            scale = (outputMax - outputMin) / (inputMax - inputMin);
        /* Apply the transformation */
             result = (input + -inputCenter) * scale + outputCenter;
        /* Constrain to the output range */
            speed = Math.max(Math.min(result, outputMax), outputMin);


        return speed;
    }

}
